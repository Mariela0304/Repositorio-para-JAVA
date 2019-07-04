package bonilla.mariela.bl;

public class Cliente extends Persona{

    private String apellidos;
    private String correo;
    private String provincia;
    private String canton;
    private String distrito;

    public Cliente() {
        super();
    }

    public Cliente(String tipoPersona, String nombre, String apellidos, String identificacion, String correo, String provincia, String canton, String distrito, String direccion, String telefono) {
        super(tipoPersona, nombre, identificacion, direccion, telefono);
        this.apellidos = apellidos;
        this.correo = correo;
        this.provincia = provincia;
        this.canton = canton;
        this.distrito = distrito;
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

    @Override
    public String toString() {
        return  "=============== CLIENTE: =========================\n\n" +
                "\n Tipo de persona: " + tipoPersona +
                "\n Nombre: " + nombre +
                "\n Apellidos: " + apellidos +
                "\n Identificación: " + identificacion +
                "\n Correo electrónico: " + correo +
                "\n Provincia: " + provincia +
                "\n Cantón: " + canton +
                "\n Distrito: " + distrito +
                "\n Dirección: " + direccion +
                "\n Teléfono: " + telefono +
                "\n\n=========================================\n\n";


    }
}
