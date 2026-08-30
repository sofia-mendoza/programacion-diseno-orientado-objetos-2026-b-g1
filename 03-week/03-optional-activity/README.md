# CONFIG
**FULL_NAME:** Sofía Mendoza  
**GITHUB_USER:** sofia-mendoza

---

# Actividad Semana 03 - Encapsulación y Protección de Invariantes

## Parte A: Ejecución en Terminal

Comandos ejecutados para compilar y ejecutar el programa:

```bash
# Compilar las clases de la semana 03
javac Ejercicio.java MainEjercicio.java

# Ejecutar el programa principal
java MainEjercicio
```

## Parte B: Justificación de Diseño y Encapsulación
¿Por qué NO se expuso un método setSaldo()?
Protección de la Invariante del Dominio: Si expusiéramos un método mutador genérico como setSaldo(double saldo), cualquier parte externa del programa podría modificar directamente el valor a cifras arbitrarias o inválidas (por ejemplo: cuenta.setSaldo(-500)). Esto violaría la regla fundamental (invariante) de que el saldo de una cuenta jamás debe ser negativo.

Uso de Operaciones de Dominio Explícitas: El saldo de una cuenta bancaria real no se "asigna" directamente, sino que cambia a través de operaciones de negocio legítimas como consignar() y retirar(). Al encapsular las modificaciones dentro de estas operaciones, la propia clase CuentaBancaria valida y garantiza la integridad de su estado interno antes de aplicar cualquier cambio.

Atributo id de Solo Lectura: El atributo id se declaró como private final y solo posee un método getId(). Esto asegura que una vez creada la cuenta, su identificador sea inmutable y no pueda ser alterado intencionalmente o por error durante el ciclo de vida de la aplicación.