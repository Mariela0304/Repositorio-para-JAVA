package bonilla.mariela.bl;

import bonilla.mariela.bl.*;

import java.time.LocalDate;
import java.util.Arrays;

public class Vendedor extends Usuario {
    private double puntuacion;
    private String provincia;
    private String canton;
    private String distrito;
    private String direccion;

    public Vendedor() {
        super();
    }

    public Vendedor(String tipoUsuario, String nombre, String identificacion, LocalDate fechaNacimiento,
                    int edad, String correo,
                    String contrasenna, double puntuacion, String provincia,
                    String canton, String distrito, String direccion) {
        super(tipoUsuario, nombre, identificacion, fechaNacimiento, edad, correo, contrasenna);
        this.puntuacion = puntuacion;
        this.provincia = provincia;
        this.canton = canton;
        this.distrito = distrito;
        this.direccion = direccion;
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

    @Override
    public String toString() {
        return  "-------- VENDEDOR: -------------------------------------------\n" +
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
                "\n Puntuación: "+ puntuacion +
                "\n\n-------------------------------------------------------------\n\n";
    }
}
