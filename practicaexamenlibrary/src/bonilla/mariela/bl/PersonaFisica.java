package bonilla.mariela.bl;

public class PersonaFisica extends Proveedor {

    private String apellidos;

    public PersonaFisica() {
        super();
    }

    public PersonaFisica(String tipoPersona, String tipoProveedor, String nombre, String apellidos, String identificacion, String direccion, String telefono) {
        super(tipoPersona, nombre, identificacion, direccion, telefono, tipoProveedor);
        this.apellidos = apellidos;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }


    @Override
    public String toString() {
        return  "======= PERSONA FÍSICA: =========================\n\n" +
                "\n Tipo de persona: " + tipoPersona +
                "\n Tipo de proveedor" + tipoProveedor +
                "\n Nombre: " + nombre +
                "\n Apellidos: " + apellidos +
                "\n Identificación: " + identificacion +
                "\n Dirección: " + direccion +
                "\n Teléfono: " + telefono +
                "\n\n=========================================\n\n";



    }
}
