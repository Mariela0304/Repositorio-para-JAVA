package bonilla.mariela.bl;

import java.time.LocalDate;

public class Texto extends Material {


    private String titulo;
    private String autor;
    private LocalDate fechaPublicacion;
    private int cantPaginas;
    private String idioma;

    public Texto() {
        super();
    }

    public Texto(String idSignatura, LocalDate fechaCompra, boolean restriccion, String tema, String titulo, String autor, LocalDate fechaPublicacion, int cantPaginas, String idioma) {
        super(idSignatura, fechaCompra,restriccion, tema);
        this.titulo = titulo;
        this.autor = autor;
        this.fechaPublicacion = fechaPublicacion;
        this.cantPaginas = cantPaginas;
        this.idioma = idioma;
    }
}
