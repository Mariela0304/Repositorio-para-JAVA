package bonilla.mariela.bl;

public class Estudiante extends Persona {

    private String carrera;
    private int creditosActuales;

    public Estudiante() {
        super();
    }

    public Estudiante(String nombre, String apellido, String identificacion, String carrera, int creditosActuales) {
        super(nombre, apellido, identificacion);
        this.carrera = carrera;
        this.creditosActuales = creditosActuales;
    }


    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public int getCreditosActuales() {
        return creditosActuales;
    }

    public void setCreditosActuales(int creditosActuales) {
        this.creditosActuales = creditosActuales;
    }

    @Override
    public String toString() {
        return "------------------Estudiante:------------------ \n" +
                " Nombre: " + nombre +
                "\n Apellido: " + apellido +
                "\n Número del carné: " + identificacion +
                "\n Carrera: " + carrera +
                "\n Créditos del cuatrimestre actual: " + creditosActuales+
                "------------------------------------------------";
    }
}
