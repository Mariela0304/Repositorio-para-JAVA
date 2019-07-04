package bonilla.mariela.bl;

public class Proveedor extends Persona{

    protected String tipoProveedor;

    public Proveedor() {
        super();
    }

    public Proveedor(String tipoPersona, String nombre, String identificacion, String direccion, String telefono, String tipoProveedor) {
        super(tipoPersona, nombre, identificacion, direccion, telefono);
        this.tipoProveedor = tipoProveedor;
    }

    public String getTipoProveedor() {
        return tipoProveedor;
    }

    public void setTipoProveedor(String tipoProveedor) {
        this.tipoProveedor = tipoProveedor;
    }


    @Override
    public String toString() {
        return  "========= PROVEEDOR: =========================\n\n" +
                "\n Tipo de persona: " + tipoPersona +
                "\n Tipo de proveedor" + tipoProveedor +
                "\n Nombre: " + nombre +
                "\n Identificación: " + identificacion +
                "\n Dirección: " + direccion +
                "\n Teléfono: " + telefono +
                "\n\n=========================================\n\n";



    }
}
