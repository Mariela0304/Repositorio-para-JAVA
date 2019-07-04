package bonilla.mariela.bl;

public class Usuario {
    protected String tipoUsuario;
    protected String nombreCompleto;
    protected String email;
    protected String clave;


    public Usuario() {

    }

    public Usuario(String tipoUsuario, String nombreCompleto, String email, String clave) {
        this.tipoUsuario = tipoUsuario;
        this.nombreCompleto = nombreCompleto;
        this.email = email;
        this.clave = clave;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    @Override
    public String toString() {
        return "\n====== USUARIO: ==================================\n\n" +
                "\n Nombre completo: " + nombreCompleto +
                "\n Email: " + email +
                "\n\n=================================================\n\n";
    }
}
