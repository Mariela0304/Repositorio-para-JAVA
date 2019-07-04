package bonilla.mariela.bl;

public class Persona {
    protected String nombre;
    protected String apellido;
    protected String identificacion;

    public Persona() {

    }

    public Persona(String nombre, String apellido, String identificacion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.identificacion = identificacion;
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

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    @Override
    public String toString() {
        return "-----------------Persona------------------------- \n\n" +
                " Nombre: " + nombre +
                "\n Apellido: " + apellido +
                "\n Identificación: " + identificacion +
                "\n\n--------------------------------------------------";
    }
}
