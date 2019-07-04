package bonilla.mariela.logica;

import java.time.LocalDate;

public class Paciente extends Persona {
    private Medico doctor;
    private LocalDate fechaIngreso;

    public Paciente() {
        super();
    }


    public Paciente(String cedula, String nombre, String apellidos, Medico doctor, LocalDate fechaIngreso) {
        super(cedula, nombre, apellidos);
        this.doctor = doctor;
        this.fechaIngreso = fechaIngreso;
    }


    public Medico getDoctor() {
        return doctor;
    }

    public void setDoctor(Medico doctor) {
        this.doctor = doctor;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    @Override
    public String toString() {
        return "Paciente{" +
               super.toString() + " " +
                ", doctor=" + doctor +
                ", fechaIngreso=" + fechaIngreso +

                '}';
    }
}
