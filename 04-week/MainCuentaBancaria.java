import java.io.PrintStream;

public class MainCuentaBancaria {
    public MainCuentaBancaria() {
    }

    public static void main(String[] args) {
        CuentaBancaria cuenta1 = new CuentaBancaria("001", "Sofía", (double)100000.0F);
        System.out.println(cuenta1);
        cuenta1.depositar((double)50000.0F);
        System.out.println(cuenta1);

        try {
            cuenta1.depositar((double)-10000.0F);
        } catch (IllegalArgumentException e) {
            System.out.println("Depósito inválido rechazado: " + e.getMessage());
        }

        cuenta1.retirar((double)30000.0F);
        System.out.println(cuenta1);

        try {
            cuenta1.retirar((double)200000.0F);
        } catch (IllegalArgumentException e) {
            System.out.println("Retiro inválido rechazado: " + e.getMessage());
        }

        try {
            new CuentaBancaria("003", "Carlos", (double)-50000.0F);
        } catch (IllegalArgumentException e) {
            System.out.println("Cuenta inválida rechazada: " + e.getMessage());
        }

        CuentaBancaria cuenta2 = new CuentaBancaria("001", "Sofía", (double)500000.0F);
        PrintStream var10000 = System.out;
        boolean var10001 = cuenta1.equals(cuenta2);
        var10000.println("¿cuenta1 y cuenta2 son iguales? " + var10001);
        CuentaBancaria cuenta3 = new CuentaBancaria("002", "Sofía", (double)500000.0F);
        var10000 = System.out;
        var10001 = cuenta1.equals(cuenta3);
        var10000.println("¿cuenta1 y cuenta3 son iguales? " + var10001);
    }
}
