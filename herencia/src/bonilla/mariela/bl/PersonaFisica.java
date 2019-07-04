package bonilla.mariela.bl;


public class PersonaFisica extends Persona {

    private String correo;

    public PersonaFisica() {
        super();//palabra reservada, que llama al constructor de una superclase
    }

    public PersonaFisica(String nombre, String apellido, int edad, String id, String correo) {

        super(nombre, apellido,id, edad);
        this.correo = correo;

    }



    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }


    @Override
    public String toString() {
        return "Persona Fisica = {" +
                "Nombre: '" + nombre + '\'' +
                ", Apellido: '" + apellido + '\'' +
                ", Id: '" + id + '\'' +
                ", Edad: '" + edad +  '\'' +
                ", Correo: '" + correo + '\'' +
                '}';
    }
}
