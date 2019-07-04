package cr.ac.ucenfotec;

import java.time.LocalDate;

public class Cuenta {
    public static double tasa;
    protected int numero;
    protected double monto;

    public Cuenta() {
    }

    public Cuenta(int numero, double monto) {
        this.monto = monto;
        this.numero = numero;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Cuenta{" +
                "monto=" + monto +
                ", numero=" + numero +
                ", tasa: " + tasa+
                '}';
    }
}
