public class CuentaBancaria {
    private String numeroCuenta;
    private String titular;
    private double saldo;

    public CuentaBancaria(String numeroCuenta, String titular, double saldo) {
        if (saldo < (double)0.0F) {
            throw new IllegalArgumentException("El saldo no puede ser negativo");
        } else {
            this.numeroCuenta = numeroCuenta;
            this.titular = titular;
            this.saldo = saldo;
        }
    }

    public CuentaBancaria(String numeroCuenta, String titular) {
        this(numeroCuenta, titular, (double)0.0F);
    }

    public void depositar(double monto) {
        if (monto <= (double)0.0F) {
            throw new IllegalArgumentException("El monto a depositar debe ser mayor que 0.");
        } else {
            this.saldo += monto;
        }
    }

    public void retirar(double monto) {
        if (monto <= (double)0.0F) {
            throw new IllegalArgumentException("El monto a retirar debe ser mayor que 0.");
        } else if (monto > this.saldo) {
            throw new IllegalArgumentException("Fondos insuficientes.");
        } else {
            this.saldo -= monto;
        }
    }

    public String toString() {
        return "CuentaBancaria{numeroCuenta='" + this.numeroCuenta + "', titular='" + this.titular + "', saldo=" + this.saldo + "}";
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (!(o instanceof Ejercicio)) {
            return false;
        } else {
            Ejercicio otra = (Ejercicio)o;
            return this.numeroCuenta.equals(otra.numeroCuenta);
        }
    }

    public int hashCode() {
        return this.numeroCuenta.hashCode();
    }
}
