package bonilla.mariela.bl;

import java.util.ArrayList;

public class Propiedad {

    protected int codigo;
    protected double valor;
    protected String direccion;
    protected String patio;
    protected int cantHab;
    protected String cochera;
    protected int cantVehiculos;


    public Propiedad() {

    }

    public Propiedad(int codigo, double valor, String direccion, String patio, int cantHab, String cochera, int cantVehiculos) {
        this.codigo = codigo;
        this.valor = valor;
        this.direccion = direccion;
        this.patio = patio;
        this.cantHab = cantHab;
        this.cochera = cochera;
        this.cantVehiculos = cantVehiculos;
    }


    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPatio() {
        return patio;
    }

    public void setPatio(String patio) {
        this.patio = patio;
    }

    public int getCantHab() {
        return cantHab;
    }

    public void setCantHab(int cantHab) {
        this.cantHab = cantHab;
    }

    public String getCochera() {
        return cochera;
    }

    public void setCochera(String cochera) {
        this.cochera = cochera;
    }

    public int getCantVehiculos() {
        return cantVehiculos;
    }

    public void setCantVehiculos(int cantVehiculos) {
        this.cantVehiculos = cantVehiculos;
    }


    @Override
    public String toString() {
        return "\n------------ PROPIEDAD: ---------------------------------\n\n" +
                "\n Código: " + codigo +
                "\n Valor de alquiler: " + valor +
                "\n Dirección: " + direccion +
                "\n Patio: " + patio +
                "\n Cantidad de habitaciones: " + cantHab +
                "\n Cochera: " + cochera  +
                "\n Cantidad de vehículos: " + cantVehiculos +
                "\n\n-----------------------------------------------------------\n\n";
    }
}
