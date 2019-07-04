package bonilla.mariela.bl;

import java.time.LocalDate;

public class Material {

    protected String idSignatura;
    protected LocalDate fechaCompra;
    protected boolean restriccion;
    protected String tema;

    public Material() {

    }

    public Material(String idSignatura, LocalDate fechaCompra, boolean restriccion, String tema) {
        this.idSignatura = idSignatura;
        this.fechaCompra = fechaCompra;
        this.restriccion = restriccion;
        this.tema = tema;
    }

    public String getIdSignatura() {
        return idSignatura;
    }

    public void setIdSignatura(String idSignatura) {
        this.idSignatura = idSignatura;
    }

    public LocalDate getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(LocalDate fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public boolean isRestriccion() {
        return restriccion;
    }

    public void setRestriccion(boolean restriccion) {
        this.restriccion = restriccion;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    @Override
    public String toString() {
        return "Material {" +
                " Signatura '" + idSignatura +
                ", Fecha de compra: " + fechaCompra +
                ", restricción: " + restriccion +
                ", Tema: " + tema +
                '}';
    }
}
