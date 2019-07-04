package bonilla.mariela.bl;

import java.time.LocalDate;

public class CuentaAhorroProgramado extends Cuenta{
    CuentaCorriente cuentaCorriente;

    public CuentaAhorroProgramado() {
        super();
    }

    public CuentaAhorroProgramado(String tipoCuenta, LocalDate fechaApertura, double saldo, int numero) {
        super(tipoCuenta, fechaApertura, saldo, numero);
    }

    public CuentaAhorroProgramado(String tipoCuenta, LocalDate fechaApertura, double saldo, int numero,
                                  CuentaCorriente cuentaCorriente) {
        super(tipoCuenta, fechaApertura, saldo, numero);
        this.cuentaCorriente = cuentaCorriente;
    }



    public CuentaCorriente getCuenta() {
        return cuentaCorriente;
    }

    public void setCuenta(CuentaCorriente cuenta) {
        this.cuentaCorriente = cuenta;
    }



    @Override
    public String toString() {
        return "\n\n======== Cuenta de ahorro programado: ===================" +
                "\n Saldo de cuenta: ₡" + saldo +
                "\n Número de cuenta de ahorro programado: " + numero +
                "\n Número de la cuenta corriente asociada: " + cuentaCorriente.getNumero() +
                "\n Fecha de apertura de cuenta: " + fechaApertura +
                "\n==============================================================";
    }

    /*
  @Mariela Bonilla
   */
    public double depositar(double monto) {
        saldo = saldo + monto;
        return saldo;
    }

    /*
    @Lenner Hurtado
    */
    public double retirar(double monto){
        saldo = saldo - monto;
        return saldo;
    }
}