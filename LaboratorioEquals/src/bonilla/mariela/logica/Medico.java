package bonilla.mariela.logica;

public class Medico extends Persona{
    private String codigoColegio;
    private String especialidad;

    public Medico() {
        super();
    }

    public Medico(String cedula, String nombre, String apellidos, String codigoColegio, String especialidad) {
        super(cedula, nombre, apellidos);
        this.codigoColegio = codigoColegio;
        this.especialidad = especialidad;
    }

    public String getCodigoColegio() {
        return codigoColegio;
    }

    public void setCodigoColegio(String codigoColegio) {
        this.codigoColegio = codigoColegio;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }


    @Override
    public String toString() {
        return "Medico{" + super.toString() + " " +
                "codigoColegio='" + codigoColegio + '\'' +
                ", especialidad='" + especialidad + '\'' +
                '}';
    }
}
