import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class GestorProductos {
    private final Map<Integer, Producto> productos = new LinkedHashMap<>();


    public void crear(Producto producto) {
        if (productos.containsKey(producto.getId())) {
            throw new IllegalArgumentException("Ya existe un producto con id " + producto.getId() + ".");
        }
        productos.put(producto.getId(), producto);
    }


    public Producto buscar(int id) throws ProductoNoEncontradoException {
        Producto p = productos.get(id);
        if (p == null) {
            throw new ProductoNoEncontradoException(id);
        }
        return p;
    }


    public List<Producto> listar() {
        return new ArrayList<>(productos.values());
    }


    public void actualizar(int id, String nombre, double precio, int cantidad)
            throws ProductoNoEncontradoException {
        Producto p = buscar(id);
        p.setNombre(nombre);
        p.setPrecio(precio);
        p.setCantidad(cantidad);
    }


    public void eliminar(int id) throws ProductoNoEncontradoException {
        if (productos.remove(id) == null) {
            throw new ProductoNoEncontradoException(id);
        }
    }


    public void cargarTodos(List<Producto> cargados) {
        productos.clear();
        for (Producto p : cargados) {
            productos.put(p.getId(), p);
        }
    }
}