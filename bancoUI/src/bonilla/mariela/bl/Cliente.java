package bonilla.mariela.bl;

import java.util.ArrayList;

public class Cliente {
    private String nombre;
    private String cedula;
    private String direccion;

    /*Se crea el nuevo atributo de arraylist de cuentas
    *  @Mariela Bonilla
    29/03/2019*/

    private ArrayList<Cuenta> cuentas;

    public Cliente() {
    }

    public Cliente(String nombre, String cedula, String direccion) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.direccion = direccion;
        cuentas = new ArrayList<>();
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public ArrayList<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(Cuenta cuenta) {
        cuentas.add(cuenta);
    }

    @Override
    public String toString() {
        return "======= Cliente: ===================" +
                "\n Nombre de cliente: " + nombre +
                "\n Número de cédula: " + cedula +
                "\n Dirección: " + direccion +
                "\n Cuentas: " + cuentas.toString() +
                "\n\n===================================";
    }
}
