package bonilla.mariela.bl;

public class Persona {
    protected String nombre;
    protected String apellidos;
    protected String correo;
    protected String direccion;
    protected String identificacion;
    protected int telefono;

    public Persona() {

    }

    public Persona (String nombre, String apellidos, String correo, String direccion, String identificacion, int telefono) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.direccion = direccion;
        this.identificacion = identificacion;
        this.telefono = telefono;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "\n------------ PERSONA: ---------------------------------\n\n" +
                "\n Nombre: " + nombre +
                "\n Apellidos: " + apellidos +
                "\n Correo: " + correo +
                "\n Dirección: " + direccion +
                "\n Identificación: " + identificacion +
                "\n Teléfono: " + telefono +
                "\n\n-----------------------------------------------------------\n\n";
    }
}
