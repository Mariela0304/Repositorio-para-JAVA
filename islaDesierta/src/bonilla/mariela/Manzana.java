package bonilla.mariela;

public class Manzana implements  Element, Eatable{

    private String nombre;

    public Manzana() {

    }

    public Manzana(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Manzana{" +
                "nombre='" + nombre + '\'' +
                '}';
    }

    public String eat() {

        return "Pude comerlo";
    }
}
