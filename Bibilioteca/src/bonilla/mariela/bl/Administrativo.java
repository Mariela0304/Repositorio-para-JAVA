package bonilla.mariela.bl;

public class Administrativo extends Persona{
    private String tipoNombramiento;
    private int cantHoras;

    public Administrativo() {
        super();
    }

    public Administrativo(String nombre, String apellido, String identificacion, String tipoNombramiento, int cantHoras) {
        super(nombre, apellido, identificacion);
        this.tipoNombramiento = tipoNombramiento;
        this.cantHoras = cantHoras;
    }

    public String getTipoNombramiento() {
        return tipoNombramiento;
    }

    public void setTipoNombramiento(String tipoNombramiento) {
        this.tipoNombramiento = tipoNombramiento;
    }

    public int getCantHoras() {
        return cantHoras;
    }

    public void setCantHoras(int cantHoras) {
        this.cantHoras = cantHoras;
    }

    @Override
    public String toString() {
        return "Administrativo{" +
                " Nombre: " + nombre +
                ", Apellido: " + apellido +
                ", Identificación: " + identificacion +
                ", Tipo de nombramiento: " + tipoNombramiento +
                ", Cantidad de horas semanalas: " + cantHoras +
                '}';
    }
}
