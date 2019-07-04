package bonilla.mariela.bl;

import bonilla.mariela.bl.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class Coleccionista extends Usuario{
    private double puntuacion;
    private String provincia;
    private String canton;
    private String distrito;
    private String direccion;
    private String [] intereses;
    private String [] items;


    /*
    Constructor por defecto
     */

    public Coleccionista() {
        super();
    }
    /*
    Constructor que recibe todos los parámetros
     */

    public Coleccionista(String tipoUsuario, String nombre, String identificacion, LocalDate fechaNacimiento,
                         int edad, String correo, String contrasenna, double puntuacion,
                         String provincia,
                         String canton, String distrito, String direccion, String[] intereses,
                         String[] items) {
        super(tipoUsuario, nombre, identificacion, fechaNacimiento, edad, correo, contrasenna);
        this.puntuacion = puntuacion;
        this.provincia = provincia;
        this.canton = canton;
        this.distrito = distrito;
        this.direccion = direccion;
        this.intereses = intereses;
        this.items = items;
    }



    public double getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(double puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCanton() {
        return canton;
    }

    public void setCanton(String canton) {
        this.canton = canton;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String[] getIntereses() {
        return intereses;
    }

    public void setIntereses(String[] intereses) {
        this.intereses = intereses;
    }

    public String[] getItems() {
        return items;
    }

    public void setItems(String[] items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "-------- COLECCIONISTA: -------------------------------------------\n" +
                "\n Nombre: " + nombre +
                "\n Identificación: " + identificacion +
                "\n Fecha de nacimiento: " + fechaNacimiento +
                "\n Edad: " + edad +
                "\n Correo electrónico: " + correo +
                "\n Contrasenna: " + contrasenna  + //no es correcto que se pueda imprimir la contrasenna, sin embargo,
                //                                         la agrego para comprobar que se imprime de manera
                //                                          correcta.
                "\n Provincia: " + provincia +
                "\n Cantón: " + canton +
                "\n Distrito: " + distrito +
                "\n Dirección exacta: " + direccion +
                "\n Interéses: " + Arrays.toString(intereses) +
                "\n Ítems: " + Arrays.toString(items) +
                "\n\n------------------------------------------------------------\n\n";
    }
}
