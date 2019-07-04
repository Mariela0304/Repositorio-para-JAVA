package bonilla.mariela.bl;

import java.time.LocalDate;

public class Profesor extends Persona{

    private String tipoContrato;
    private LocalDate fechaContrato;

    public Profesor() {
        super();

    }

    public Profesor(String nombre, String apellido, String identificacion, String tipoContrato, LocalDate fechaContrato) {
        super(nombre, apellido, identificacion);
        this.tipoContrato = tipoContrato;
        this.fechaContrato = fechaContrato;
    }

    public String getTipoContrato() {
        return tipoContrato;
    }

    public void setTipoContrato(String tipoContrato) {
        this.tipoContrato = tipoContrato;
    }

    public LocalDate getFechaContrato() {
        return fechaContrato;
    }

    public void setFechaContrato(LocalDate fechaContrato) {
        this.fechaContrato = fechaContrato;
    }

    @Override
    public String toString() {
        return "---------------Profesor:------------------\n" +
                " Nombre: " + nombre +
                "\n Apellido: " + apellido +
                "\n Identificacion: " + identificacion +
                "\n Tipo de contrato: " + tipoContrato  +
                "\n Fecha del contrato: " + fechaContrato +
                "--------------------------------------------";
    }
}
