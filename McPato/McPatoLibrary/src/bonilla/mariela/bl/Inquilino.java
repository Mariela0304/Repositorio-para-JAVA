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
        return "Inquilino{" +
                " Nombre: " + nombre +
                ", Apellidos: " + apellidos +
                ", Correo: " + correo +
                ", Dirección: " + direccion +
                ", Identificación: " + identificacion +
                ", Teléfono: " + telefono +
                ", Género: " + genero +
                '}';
    }


}
