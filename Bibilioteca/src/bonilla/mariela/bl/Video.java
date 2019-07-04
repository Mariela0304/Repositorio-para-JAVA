package bonilla.mariela.bl;

import java.time.LocalDate;

public class Video extends Material{

    private String formato;
    private  int duracion;
    private String idioma;
    private String director;

    public Video() {

    }

    public Video(String idSignatura, LocalDate fechaCompra, boolean restriccion, String tema, String formato, int duracion, String idioma, String director) {
        super(idSignatura, fechaCompra, restriccion, tema);
        this.formato = formato;
        this.duracion = duracion;
        this.idioma = idioma;
        this.director = director;
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

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public String toString() {
        return "Video{" +
                "Signatura: " + idSignatura +
                ", Fecha de compra: " + fechaCompra +
                ", Restricción: " + restriccion +
                ", Tema: " + tema +
                ", Formato: " + formato +
                ", Duración: " + duracion +
                ", Idioma: " + idioma +
                ", Director: " + director +
                '}';
    }
}
