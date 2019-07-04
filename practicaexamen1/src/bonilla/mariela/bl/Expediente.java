package bonilla.mariela.bl;

import java.time.LocalDate;
import java.util.Arrays;

public class Expediente {
    private String id;
    private String numSeguro;
    private LocalDate fechaNacimiento;
    private String tipoSangre;
    private String[] padecimientos;

    public Expediente() {

    }

    public Expediente(String id, String numSeguro, LocalDate fechaNacimiento, String tipoSangre, String[] padecimientos) {
        this.id = id;
        this.numSeguro = numSeguro;
        this.fechaNacimiento = fechaNacimiento;
        this.tipoSangre = tipoSangre;
        this.padecimientos = padecimientos;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumSeguro() {
        return numSeguro;
    }

    public void setNumSeguro(String numSeguro) {
        this.numSeguro = numSeguro;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTipoSangre() {
        return tipoSangre;
    }

    public void setTipoSangre(String tipoSangre) {
        this.tipoSangre = tipoSangre;
    }

    public String[] getPadecimientos() {
        return padecimientos;
    }

    public void setPadecimientos(String[] padecimientos) {
        this.padecimientos = padecimientos;
    }

    @Override
    public String toString() {
        return "\n====== EXPEDIENTE: ==================================\n\n" +
                "\n IdExpediente" + id +
                "\n Número del seguro social del paciente: " + numSeguro +
                "\n Fecha de nacimiento del paciente" + fechaNacimiento +
                "\n Tipo de sangre: " + tipoSangre +
                "\n Padecimientos: " + Arrays.toString(padecimientos) +
                "\n\n=================================================\n\n";

    }
}

