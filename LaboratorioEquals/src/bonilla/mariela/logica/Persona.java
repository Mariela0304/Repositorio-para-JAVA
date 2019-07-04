package bonilla.mariela.logica;

import java.util.Objects;

public class Persona {
   protected String cedula;
   protected String nombre;
   protected String apellidos;

    public Persona() {
    }

    public Persona(String cedula, String nombre, String apellidos) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "cedula='" + cedula + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object otherObject) {

        if (this == otherObject) return true;

        if (otherObject == null) return false;

        if (getClass() != otherObject.getClass()) return false;

        Persona other = (Persona) otherObject;

        return Objects.equals(cedula, other.getCedula());
    }
}
