package bonilla.mariela.bl;

public class ClienteFisico extends Cliente {
    private String apellido;
    private String correo;
    private String telefono;
    private int codigo;

    public ClienteFisico() {
        super();
    }

    public ClienteFisico(String tipoUsuario, String tipoCliente, String nombre,  String apellido,
                         String identificacion, int codigo,String correo, String direccion,
                         String telefono, boolean estado ) {

        super(tipoUsuario, tipoCliente, nombre, identificacion, direccion, estado);
        this.apellido = apellido;
        this.correo = correo;
        this.telefono = telefono;
        this.codigo = codigo;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }




    @Override
    public String toString() {
        return "\n========== CLIENTE FÍSICO: ================================\n" +
                "\n Tipo de usuario:" + tipoUsuario +
                "\n Tipo de cliente: " + tipoCliente +
                "\n Nombre: " + nombre +
                "\n Apellido: " + apellido +
                "\n Identificación: " + identificacion +
                "\n Código: " + codigo +
                "\n Correo: " + correo +
                "\n Dirección: " + direccion +
                "\n Teléfono: " + telefono +
                "\n Dirección: " + direccion +
                "\n Estado: " + estado +
                "\n\n===========================================================\n\n";
    }


}
