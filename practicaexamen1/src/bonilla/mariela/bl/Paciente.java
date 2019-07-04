package bonilla.mariela.bl;

public class Paciente extends Usuario{
    private String numSeguroSocial;
    private String direccion;
    private String telefono;

    public Paciente() {
        super();
    }

    public Paciente(String tipoUsuario, String nombreCompleto, String email, String clave, String numSeguroSocial, String direccion, String telefono) {
        super(tipoUsuario, nombreCompleto, email, clave);
        this.numSeguroSocial = numSeguroSocial;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public String getNumSeguroSocial() {
        return numSeguroSocial;
    }

    public void setNumSeguroSocial(String numSeguroSocial) {
        this.numSeguroSocial = numSeguroSocial;
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
        return "\n====== PACIENTE: ==================================\n" +
                "\n Número del seguro social: " + numSeguroSocial +
                "\n Nombre completo: " + nombreCompleto +
                "\n Email: " + email +
                "\n Dirección: " + direccion +
                "\n Teléfono: " + telefono +
                "\n\n=================================================\n\n";
    }
}

