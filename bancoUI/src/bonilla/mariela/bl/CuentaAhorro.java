package bonilla.mariela.bl;

import java.time.LocalDate;

public class CuentaAhorro extends Cuenta{

    public static double tasaInteres;

    public CuentaAhorro() {
        super();
    }

    public CuentaAhorro(String tipoCuenta, LocalDate fechaApertura, double saldo, int numero) {
        super(tipoCuenta, fechaApertura, saldo, numero);

    }

    @Override
    public String toString() {
        return "\n\n=========== Cuenta de ahorro: =============" +
                "\n Saldo de cuenta: ₡"+saldo +
                "\n Número de cuenta: " + numero +
                "\n Fecha de apertura de cuenta: " + fechaApertura +
                "\n Tasa de interes: " + tasaInteres +
                "\n Interes por mes: ₡"+calcularInteresMensual() +
                "\n=============================================";
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

    public double calcularInteresMensual()
    {
        return ( saldo * tasaInteres / 12)/100;
    }


}
