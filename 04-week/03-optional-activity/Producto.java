/*
 * CONFIG
 * FULL_NAME: Sofía Mendoza
 * GITHUB_USER: sofia-mendoza
 */public class Producto {
    // 1. Encapsulamiento y modificador final para codigo (solo lectura)
    private final String codigo;
    private String nombre;
    private double precio;
    private int stock;

    // 2. Constructor completo con validaciones (precio >= 0, stock >= 0)
    public Producto(String codigo, String nombre, double precio, int stock) {
        if (precio < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo.");
        }
        if (stock < 0) {
            throw new IllegalArgumentException("El stock no puede ser negativo.");
        }
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    // 2. Constructor que delega al completo mediante this()
    public Producto(String codigo, String nombre) {
        this(codigo, nombre, 0.0, 0); // Asigna precio y stock en 0 por defecto
    }

    // Getters y Setters respetando que 'codigo' es final (sin setCodigo)
    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        if (precio < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo.");
        }
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        if (stock < 0) {
            throw new IllegalArgumentException("El stock no puede ser negativo.");
        }
        this.stock = stock;
    }

    // 3. Sobrescribir toString() con @Override para salida legible
    @Override
    public String toString() {
        return "Producto{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", stock=" + stock +
                '}';
    }

    // 4. Implementación de equals() por 'codigo' sin usar java.util.Objects
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Producto otro = (Producto) o;
        if (this.codigo == null) {
            return otro.codigo == null;
        }
        return this.codigo.equals(otro.codigo);
    }

    // 4. Implementación de hashCode() en coherencia con equals()
    @Override
    public int hashCode() {
        return (this.codigo != null) ? this.codigo.hashCode() : 0;
    }
}

