package bonilla.mariela.bl;

public class Estudiante {
    private String nombre;
    private String apellido;
    private String identificacion;
    private int edad;

    public Estudiante() {
    }

    public Estudiante(String nombre, String apellido, String identificacion, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.identificacion = identificacion;
        this.edad = edad;
    }

    //método para acceso para obtener información
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public int getEdad() {
        return edad;
    }

    //método para acceso para modificar la información
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", identificacion='" + identificacion + '\'' +
                ", edad=" + edad +
                '}';
    }
}
