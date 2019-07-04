package cr.ac.ucenfotec.bl;

import java.util.ArrayList;
import java.time.LocalDate;
import cr.ac.ucenfotec.dl.CL;


public class Cuenta {
    private int numCuenta;
    private double saldo;
    private LocalDate fechaCreacion;
    private String duenno;


    public Cuenta () {

    }

    public Cuenta( String pduenno, double pmonto, int pnumCuenta) {
        this.saldo = pmonto;
        this.duenno = pduenno;
        this.numCuenta = pnumCuenta;
    }


    public Cuenta(double saldo, String duenno) {
        this.saldo = saldo;
        this.duenno = duenno;
    }



    public int getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(int numCuenta) {
        this.numCuenta = numCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getDuenno() {
        return duenno;
    }

    public void setDuenno(String duenno) {
        this.duenno = duenno;
    }

    public void depositar(double monto) {
        //aumentar el saldo, siempre que no sea negativo

        if (monto > 0) {
            saldo = monto + saldo;
        }

    }

    public void retirar(double monto) {
        //validar que el monto a sacar no se mayor al saldo
        if (monto <= saldo) {
            saldo = saldo - monto;
        }


    }


    @Override
    public String toString() {
        return "Cuenta" +
                "\nNúmero de cuenta: " + numCuenta +
                "\nFecha creacion: "+ fechaCreacion+
                "\nSaldo: " + saldo +
                "\nDueño: " + duenno + '\n'
                ;
    }


}

