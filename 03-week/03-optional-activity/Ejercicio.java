/*
 * CONFIG
 * FULL_NAME: Sofía Mendoza
 * GITHUB_USER: sofia-mendoza
 */

public class Ejercicio {
    // Atributos privados para cumplir con la encapsulación
    private final String id; // Atributo de solo lectura (inmutable tras crearse)
    private double saldo;    // Invariante protegida: saldo >= 0

    // Constructor que asigna el ID y un saldo inicial válido
    public Ejercicio(String id, double saldoInicial) {
        this.id = id;
        if (saldoInicial >= 0) {
            this.saldo = saldoInicial;
        } else {
            this.saldo = 0; // Garantiza que no inicie con saldo negativo
        }
    }

    // Métodos Getters (Solo lectura)
    public String getId() {
        return this.id;
    }

    public double getSaldo() {
        return this.saldo;
    }

    // Operación de dominio: Consignar dinero
    public void consignar(double monto) {
        if (monto > 0) {
            this.saldo += monto;
            System.out.println("Consignación exitosa: +$" + monto + " | Nuevo Saldo: $" + this.saldo);
        } else {
            System.out.println("Error al consignar: El monto debe ser mayor a 0.");
        }
    }

    // Operación de dominio: Retirar dinero
    public boolean retirar(double monto) {
        if (monto > 0 && monto <= this.saldo) {
            this.saldo -= monto;
            System.out.println("Retiro exitoso: -$" + monto + " | Nuevo Saldo: $" + this.saldo);
            return true;
        } else {
            System.out.println("Error al retirar: Monto inválido o fondos insuficientes.");
            return false;
        }
    }
}