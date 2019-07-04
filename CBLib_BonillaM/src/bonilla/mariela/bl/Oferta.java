package bonilla.mariela.bl;

public class Oferta {
    private int id;
    private Coleccionista nomOferente;
    private double puntuacion;
    private double precio;

    /*
    Constructor por defecto
     */

    public Oferta() {

    }

    /*
    Constructor que recibirá un id, la puntuacion del oferente y el precio a ofrecer
     */

    public Oferta(int id, double puntuacion, double precio) {
        this.id = id;
        this.puntuacion = puntuacion;
        this.precio = precio;
    }

    /*
    Constructor que recibirá un id, el nombre del oferente de tipo Coleccionista,
     la puntuación del oferente y el precio a ofrecer
     */

    public Oferta(int id, Coleccionista nomOferente, double puntuacion, double precio) {
        this.id = id;
        this.nomOferente = nomOferente;
        this.puntuacion = puntuacion;
        this.precio = precio;
    }

    /*
    Métodos que van a contener los gets
     */

    public int getId() {
        return id;
    }

    public Coleccionista getNomOferente() {
        return nomOferente;
    }

    public double getPuntuacion() {
        return puntuacion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNomOferente(Coleccionista nomOferente) {
        this.nomOferente = nomOferente;
    }

    public void setPuntuacion(double puntuacion) {
        this.puntuacion = puntuacion;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /*
    Método toString de la clase Oferta
     */

    @Override
    public String toString() {
        return "------ OFERTA: -------------------------\n" +
                "\n Nombre de oferente: " + nomOferente.toString() +
                "\n Puntuación: " + nomOferente.getPuntuacion() +
                "\n Precio a ofrecer: " + precio +
                "\n\n----------------------------------------\n\n";
    }
}
