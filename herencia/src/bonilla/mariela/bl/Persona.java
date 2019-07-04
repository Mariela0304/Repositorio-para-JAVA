package bonilla.mariela.bl;

public class Persona {

    protected String nombre;
    protected String apellido;
    protected String id;
    protected int edad;


    public Persona() {

    }

    public Persona (String pid, String pnombre, String papellido, int pedad) {
        this.id = pid;
        this.nombre = pnombre;
        this.apellido = papellido;
        this.edad = pedad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Persona = {" +
                "Nombre: '" + nombre + '\'' +
                ", Apellido: '" + apellido + '\'' +
                ", Id: '" + id + '\'' +
                ", Edad: '" + edad + '\'' +
        '}';
    }


}
