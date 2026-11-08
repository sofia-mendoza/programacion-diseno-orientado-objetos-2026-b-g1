import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ProductoRepositorio {
    private static final String ENCABEZADO = "id,nombre,precio,cantidad";
    private final Path archivo;

    public ProductoRepositorio(Path archivo) {
        this.archivo = archivo;
    }

    public void guardar(Collection<Producto> productos) throws IOException {
        Path carpeta = archivo.getParent();
        if (carpeta != null) {
            Files.createDirectories(carpeta);
        }
        try (BufferedWriter out = Files.newBufferedWriter(archivo)) {
            out.write(ENCABEZADO);
            out.newLine();
            for (Producto p : productos) {
                out.write(p.getId() + "," + p.getNombre() + ","
                        + p.getPrecio() + "," + p.getCantidad());
                out.newLine();
            }
        }
    }

    public List<Producto> cargar() throws IOException {
        List<Producto> resultado = new ArrayList<>();
        if (!Files.exists(archivo)) {
            return resultado;
        }
        try (BufferedReader in = Files.newBufferedReader(archivo)) {
            String linea = in.readLine();
            int numero = 1;
            while ((linea = in.readLine()) != null) {
                numero++;
                if (linea.isBlank()) continue;
                String[] c = linea.split(",");
                try {
                    if (c.length != 4) {
                        throw new IllegalArgumentException("se esperaban 4 columnas");
                    }
                    resultado.add(new Producto(
                            Integer.parseInt(c[0].trim()),
                            c[1],
                            Double.parseDouble(c[2].trim()),
                            Integer.parseInt(c[3].trim())));
                } catch (IllegalArgumentException e) {
                    throw new IOException("Línea " + numero + " inválida en "
                            + archivo + ": " + e.getMessage(), e);
                }
            }
        }
        return resultado;
    }
}