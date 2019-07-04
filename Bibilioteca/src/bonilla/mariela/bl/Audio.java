package bonilla.mariela.bl;

import java.time.LocalDate;

public class Audio extends Material {

    private String formato;
    private  int duracion;
    private String idioma;

    public Audio() {

    }

    public Audio(String idSignatura, LocalDate fechaCompra, boolean restriccion, String tema, String formato, int duracion, String idioma) {
        super(idSignatura, fechaCompra, restriccion, tema);
        this.formato = formato;
        this.duracion = duracion;
        this.idioma = idioma;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    @Override
    public String toString() {
        return "Audio{" +
                " Signatura:" + idSignatura +
                ", Fecha de compra: " + fechaCompra +
                ", Restricción: " + restriccion +
                ", Tema: " + tema +
                ", Formato: " + formato +
                ", Duración: " + duracion +
                ", Idioma: " + idioma +
                '}';
    }
}
