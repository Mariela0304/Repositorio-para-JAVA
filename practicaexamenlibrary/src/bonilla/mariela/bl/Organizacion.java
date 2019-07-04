package bonilla.mariela.bl;

public class Organizacion extends Proveedor {

    private String representante;


    public Organizacion() {
        super();
    }

    public Organizacion(String tipoPersona,String tipoProveedor, String nombre, String identificacion, String direccion, String telefono, String representante) {
        super(tipoPersona, nombre, identificacion, direccion, telefono, tipoProveedor);
        this.representante = representante;
    }

    public String getRepresentante() {
        return representante;
    }

    public void setRepresentante(String representante) {
        this.representante = representante;
    }

    @Override
    public String toString() {
        return "========= ORGANIZACIÓN: =========================\n\n" +
                "\n Tipo de persona: " + tipoPersona +
                "\n Tipo de proveedor" + tipoProveedor +
                "\n Nombre: " + nombre +
                "\n Identificación: " + identificacion +
                "\n Dirección: " + direccion +
                "\n Teléfono: " + telefono +
                "\n Representante: " + representante +
                "\n\n=========================================\n\n";

    }
}
