package bonilla.mariela.bl;

import java.util.ArrayList;

public class Cliente {
    private String nombre;
    private String cedula;
    private ArrayList<Cuenta> cuentas = new ArrayList<>();

    public Cliente() {
    }

    public Cliente(String nombre, String cedula) {
        this.nombre = nombre;
        this.cedula = cedula;
    }


    public Cliente(String nombre, String cedula, ArrayList<Cuenta> cuentas) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.cuentas = cuentas;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public ArrayList<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(ArrayList<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }
}
