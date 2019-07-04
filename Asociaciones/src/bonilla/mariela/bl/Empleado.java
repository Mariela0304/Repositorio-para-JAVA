package bonilla.mariela.bl;

public class Empleado {
    private String nombre;
    private String cedula;
    private Banco lugarTrabajo;


    public Empleado() {
    }


    public Empleado(String nombre, String cedula) {
        this.nombre = nombre;
        this.cedula = cedula;
    }

    public Empleado(String nombre, String cedula, Banco lugarTrabajo) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.lugarTrabajo = lugarTrabajo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "Nombre: '" + nombre + '\'' +
                ", Cédula: '" + cedula + '\'' +
                ", Lugar de trabajo: " + lugarTrabajo.toString() +
                '}';
    }

    public Banco getLugarTrabajo() {
        return lugarTrabajo;
    }

    public void setLugarTrabajo(Banco lugarTrabajo) {
        this.lugarTrabajo = lugarTrabajo;
    }
}
