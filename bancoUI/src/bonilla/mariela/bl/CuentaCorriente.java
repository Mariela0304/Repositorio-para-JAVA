package bonilla.mariela.bl;

import java.time.LocalDate;

public class CuentaCorriente extends Cuenta{


    public CuentaCorriente() {
    }

    public CuentaCorriente(String tipoCuenta, LocalDate fechaApertura, double saldo, int numero) {
        super(tipoCuenta, fechaApertura, saldo, numero);
    }

    @Override
    public String toString() {
        return "\n\n========= Cuenta corriente: ============" +
                "\n Saldo de cuenta: ₡" + saldo +
                "\n Número de cuenta: " + numero +
                "\n Fecha de apertura de cuenta: " + fechaApertura +
                "\n========================================";
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