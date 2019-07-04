package bonilla.mariela;

public class Grillo implements Eatable, Element {
    private String nombre;

    public Grillo() {
    }

    public Grillo(String nombre) {
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
        return "Grillo{" +
                "nombre='" + nombre + '\'' +
                '}';
    }


    public String eat() {

        return "Precaución elemento no comestible";

    }
}
