package bonilla.mariela.bl;

public class Empleado {

    private String nombre;
    private String cedula;

    public Empleado() {

    }

    public Empleado(String nombre, String cedula) {
        this.nombre = nombre;
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + nombre + '\'' +
                ", cedula='" + cedula + '\'' +
                '}';
    }
}
