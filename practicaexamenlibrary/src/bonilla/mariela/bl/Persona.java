package bonilla.mariela.bl;

public class Persona {

    protected String tipoPersona;
    protected String nombre;
    protected String identificacion;
    protected String direccion;
    protected String telefono;

    public Persona() {

    }

    public Persona(String tipoPersona, String nombre, String identificacion, String direccion, String telefono) {
        this.tipoPersona = tipoPersona;
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public String getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(String tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "========= PERSONA: =========================\n\n" +
                "\n Tipo de persona: " + tipoPersona +
                "\n Nombre: " + nombre +
                "\n Identificación: " + identificacion +
                "\n Dirección: " + direccion +
                "\n Teléfono: " + telefono +
                "\n\n=========================================\n\n";


    }
}
