package bonilla.mariela.bl;

import java.time.LocalDate;

public abstract class Cuenta {
    protected String tipoCuenta;
    protected LocalDate fechaApertura; /*Nuevo atributo de la clase cuenta*/
    protected double saldo;
    protected int numero;

    public Cuenta() {
    }

    public Cuenta(String tipoCuenta, LocalDate fechaApertura,double saldo, int numero) {
        this.tipoCuenta = tipoCuenta;
        this.fechaApertura = fechaApertura;
        this.saldo = saldo;
        this.numero = numero;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public LocalDate getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(LocalDate fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }


    @Override
    public String toString() {
        return "\n========= Cuenta: ===================" +
                "\n Fecha de apertura de cuenta: " + fechaApertura +
                "\n Saldo: " + saldo +
                "\n Número de cuenta: " + numero +
                "\n=====================================";
    }

    /*
    @Mariela Bonilla
     */


    public abstract double depositar(double monto);

    /*
    @Lenner Hurtado
     */

    public abstract double retirar(double monto);


}
