package bonilla.mariela.bl;

public class Computador {
    private String serie;
    private String marca;
    private Empleado responsable;

    public Computador() {

    }

    public Computador(String serie, String marca) {
        this.serie = serie;
        this.marca = marca;
    }

    public Computador(String serie, String marca, Empleado responsable) {
        this.serie = serie;
        this.marca = marca;
        this.responsable = responsable;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public String toString() {
        return "Computador{" +
                "serie='" + serie + '\'' +
                ", marca='" + marca + '\'' +
                ", responsable=" + responsable.toString() +
                '}';
    }

    public Empleado getResponsable() {
        return responsable;
    }

    public void setResponsable(Empleado responsable) {
        this.responsable = responsable;
    }
}

