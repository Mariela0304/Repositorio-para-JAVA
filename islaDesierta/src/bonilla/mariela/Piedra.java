package bonilla.mariela;

public class Piedra implements  Eatable, Element{
    private String nombre;

    public Piedra() {
    }

    public Piedra(String nombre) {
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
        return "Piedra{" +
                "nombre='" + nombre + '\'' +
                '}';
    }

    public String eat() {

        return "Pude comerlo";
    }
}
