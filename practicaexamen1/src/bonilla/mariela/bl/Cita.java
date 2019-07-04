package bonilla.mariela.bl;

import java.time.LocalDate;

public class Cita {
    private String id;
    private LocalDate fechaCita;
    private String paciente;
    private String medico;
    private String descripcion;
    private String resultado;

    public Cita() {

    }

    public Cita(String id, LocalDate fechaCita, String paciente, String medico, String descripcion, String resultado) {
        this.id = id;
        this.fechaCita = fechaCita;
        this.paciente = paciente;
        this.medico = medico;
        this.descripcion = descripcion;
        this.resultado = resultado;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(LocalDate fechaCita) {
        this.fechaCita = fechaCita;
    }

    public String getPaciente() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    public String getMedico() {
        return medico;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    @Override
    public String toString() {
        return "\n====== CITA: ==================================\n\n" +
                "\n IdCita" + id +
                "\n Fecha de la cita: " + fechaCita +
                "\n Paciente atendido" + paciente +
                "\n Médico que atendió: " + medico +
                "\n Descripción de cita: " + descripcion +
                "\n Resultado de cita: " + resultado +
                "\n\n=================================================\n\n";

    }
}
