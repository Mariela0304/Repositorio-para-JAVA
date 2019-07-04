package bonilla.mariela.bl;

public class ClienteJuridico extends Cliente {

    private int codigoCliente;

    public ClienteJuridico() {
        super();
    }


    public ClienteJuridico(String tipoUsuario, String tipoCliente, String nombre, String identificacion, String direccion, boolean estado, int codigoCliente) {
        super(tipoUsuario, tipoCliente, nombre, identificacion, direccion, estado);
        this.codigoCliente = codigoCliente;
    }

    public int getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(int codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    @Override
    public String toString() {
        return "\n========== CLIENTE JURÍDICO: ================================\n" +
                "\n Tipo de usuario:" + tipoUsuario +
                "\n Tipo de cliente: " + tipoCliente +
                "\n Nombre: " + nombre +
                "\n Identificación: " + identificacion +
                "\n Dirección: " + direccion +
                "\n Dirección: " + direccion +
                "\n Estado: " + estado +
                "\n Código de cliente: " + codigoCliente +
                "\n\n===========================================================\n\n";
    }
}

