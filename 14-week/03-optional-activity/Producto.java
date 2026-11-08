public class Producto {
    private final int id;
    private String nombre;
    private double precio;
    private int cantidad;

    public Producto(int id, String nombre, double precio, int cantidad) {
        if (id <= 0) {
            throw new IllegalArgumentException("El id debe ser mayor que 0.");
        }
        this.id = id;
        setNombre(nombre);
        setPrecio(precio);
        setCantidad(cantidad);
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public int getCantidad() { return cantidad; }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        if (nombre.contains(",") || nombre.contains("\n")) {
            throw new IllegalArgumentException("El nombre no puede contener comas ni saltos de línea (formato CSV).");
        }
        this.nombre = nombre.trim();
    }

    public void setPrecio(double precio) {
        if (precio < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo.");
        }
        this.precio = precio;
    }

    public void setCantidad(int cantidad) {
        if (cantidad < 0) {
            throw new IllegalArgumentException("La cantidad no puede ser negativa.");
        }
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return String.format("Producto{id=%d, nombre='%s', precio=%.2f, cantidad=%d}",
                id, nombre, precio, cantidad);
    }
}