# CONFIG
**FULL_NAME:** Sofía Mendoza  
**GITHUB_USER:** sofia-mendoza

---

# Actividad Semana 02 - Clases, Objetos y Aliasing

## Parte A: Ejecución en Terminal

Comandos ejecutados en la terminal para compilar y ejecutar el programa:

```bash
# Compilación de los archivos .java
javac Libro.java MainLibro.java

# Ejecución de la clase principal
java MainLibro
```
## Parte B: Explicación Teórica
1. Aliasing de Referencias
   El aliasing se presenta cuando dos variables de tipo referencia (en este caso libro1 y otro) apuntan exactamente al mismo objeto en la memoria Heap.

Al ejecutar Libro otro = libro1;, no se realiza un duplicado del objeto, sino que se comparte la dirección de memoria. Por esta razón, cualquier modificación realizada a través de otro altera el objeto real, haciendo que libro1 también refleje el cambio.

2. Manejo de NullPointerException
   ¿Por qué ocurre?: Esta excepción se lanza cuando el sistema intenta invocar un método o consultar un atributo desde una variable cuyo valor es null (es decir, no apunta a ninguna dirección de memoria).

Prevención: Se evita validando el estado del objeto previo a su uso mediante la verificación if (referencia != null). Si la variable no tiene asignado un objeto real, la llamada al método se omite de forma segura.