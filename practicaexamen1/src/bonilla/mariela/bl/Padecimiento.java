package bonilla.mariela.bl;

public class Padecimiento {


    private String id;
    private String nombre;
    private String descripcion;

    public Padecimiento() {

    }

    public Padecimiento(String id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "========== : ================================" +
                "\n IdPadecimiento" + id +
                "\n Nombre: " + nombre +
                "\n Descrpción" + descripcion +
                "===========================================================";
    }
}
