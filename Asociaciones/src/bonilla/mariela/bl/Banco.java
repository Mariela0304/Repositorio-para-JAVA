package bonilla.mariela.bl;

public class Banco {
    private String nombre;
    private String direccion;


    public Banco() {
    }

    public Banco(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Banco{" +
                " Nombre: '" + nombre + '\'' +
                ", Dirección: '" + direccion + '\'' +
                '}';
    }
}
