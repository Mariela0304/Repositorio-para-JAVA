package bonilla.mariela.bl;

public class Proveedor extends Persona{

    private String area;

    public Proveedor() {

    }

    public Proveedor(String nombre, String apellidos, String correo, String direccion, String identificacion, int telefono, String area) {
        super(nombre, apellidos, correo, direccion, identificacion, telefono);
        this.area = area;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "\n------------ PROVEEDOR: ---------------------------------\n\n" +
                "\n Nombre:" + nombre +
                "\n Apellidos: " + apellidos +
                "\n Correo: " + correo +
                "\n Dirección: " + direccion +
                "\n Identificación: " + identificacion +
                "\n Teléfono: " + telefono +
                "\n Área de trabajo: " + area +
                "\n\n-----------------------------------------------------------\n\n";


    }
}
