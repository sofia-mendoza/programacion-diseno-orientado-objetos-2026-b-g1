/*
 * CONFIG
 * FULL_NAME: Sofía Mendoza
 * GITHUB_USER: sofia-mendoza
 */

public class MainEjercicio {
    public static void main(String[] args) {
        System.out.println("=== CREACIÓN DE CUENTA BANCARIA ===");
        Ejercicio cuenta = new Ejercicio("CTA-1001", 500.0);
        System.out.println("Cuenta ID: " + cuenta.getId());
        System.out.println("Saldo inicial: $" + cuenta.getSaldo());

        System.out.println("\n=== 1. PRUEBAS CON OPERACIONES VÁLIDAS ===");
        cuenta.consignar(200.0);
        cuenta.retirar(150.0);

        System.out.println("\n=== 2. PRUEBAS PARA DEMOSTRAR PROTECCIÓN DE LA INVARIANTE ===");
        System.out.println("Intento 1: Consignar un monto negativo (-50.0)");
        cuenta.consignar(-50.0);

        System.out.println("\nIntento 2: Retirar más dinero del saldo disponible (Retirar $1000.0 con saldo $" + cuenta.getSaldo() + ")");
        cuenta.retirar(1000.0);

        System.out.println("\nIntento 3: Retirar un monto negativo (-100.0)");
        cuenta.retirar(-100.0);

        System.out.println("\n=== SALDO FINAL DE LA CUENTA ===");
        System.out.println("Saldo final protegido: $" + cuenta.getSaldo());
    }
}