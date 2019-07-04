package bonilla.mariela.bl;

public class Cliente extends Usuario{
    protected String tipoCliente;
    protected String direccion;
    protected boolean estado;

    public Cliente() {
        super();
    }

    public Cliente(String tipoUsuario, String tipoCliente, String nombre, String identificacion,
                    String direccion, boolean estado) {
        super(tipoUsuario, nombre, identificacion);
        this.tipoCliente = tipoCliente;
        this.direccion = direccion;
        this.estado = estado;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }


    @Override
    public String toString() {
        return "\n========== CLIENTE: ================================\n" +
                "\n Tipo de usuario:" + tipoUsuario +
                "\n Tipo de cliente: " + tipoCliente +
                "\n Nombre: " + nombre +
                "\n Identificación: " + identificacion +
                "\n Dirección: " + direccion +
                "\n Estado: " + estado +
                "\n\n===========================================================\n\n";
    }



}
