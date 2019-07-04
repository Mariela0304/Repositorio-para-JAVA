package bonilla.mariela.bl  ;

public class Inquilino extends Persona{
    private String genero;

    public Inquilino() {

    }

    public Inquilino(String nombre, String apellidos, String correo, String direccion, String identificacion, int telefono, String genero) {
        super(nombre, apellidos, correo, direccion, identificacion, telefono);
        this.genero = genero;
    }



    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "\n------------ INQUILINO: ---------------------------------\n\n" +
                "\n Nombre: " + nombre +
                "\n Apellidos: " + apellidos +
                "\n Correo: " + correo +
                "\n Dirección: " + direccion +
                "\n Identificación: " + identificacion +
                "\n Teléfono: " + telefono +
                "\n Género: " + genero +
                "\n\n-----------------------------------------------------------\n\n";
    }




}
