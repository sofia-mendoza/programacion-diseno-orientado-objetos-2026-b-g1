# Semana 14 — CRUD robusto con persistencia (Corte 3)

CRUD de `Producto` usando un `Map<Integer, Producto>`, con excepción propia
y persistencia en CSV aislada en un repositorio.

## Exceptions & persistence

The application uses a custom checked exception, `ProductoNoEncontradoException`, to signal that a product does not exist in a clear and typed way. The `GestorProductos` class throws it whenever a product is searched, updated or deleted with an id that is not in the collection. Because it is a checked exception, the compiler forces the caller to handle that case instead of ignoring it. Invalid data, such as an empty name, a negative price or a duplicated id, is rejected with an `IllegalArgumentException`. All file access is isolated in `ProductoRepositorio`, which follows the Single Responsibility Principle: it only knows how to save and load the CSV file, while `GestorProductos` only manages the collection in memory. The repository declares `throws IOException` and uses try-with-resources so that files are always closed, even when an error happens. If a CSV line is corrupted, the repository wraps the parsing error in an `IOException` with the line number, so the problem is easy to locate. This separation makes the code easier to test and maintain, because the storage format could change without touching the CRUD logic.