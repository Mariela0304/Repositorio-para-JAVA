package cr.ac.ucenfotec;

public class Persona {
    String nombre;
    String apellido;
    String cedula;


    public Persona() {
    }

    public Persona(String nombre, String apellido, String cedula) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    @Override
    public String toString() {
        return "==== Persona: ===============\n" +
                "\n Nombre: " + nombre +
                "\n Apellido: " + apellido  +
                "\n Cédula: " + cedula +
                "\n\n=============================\n\n";
    }
}
