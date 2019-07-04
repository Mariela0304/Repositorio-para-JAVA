package bonilla.mariela;

import java.util.ArrayList;

public class Libreria {
    private String id;
    private String nombre;
    private String direccion;
    private ArrayList<Libro> libros;

    public Libreria() {
    }

    public Libreria(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
        libros = new ArrayList<>();
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public ArrayList<Libro> getLibros() {
        return libros;
    }

    public void ingresarLibro(Libro tmpLibro) {
        libros.add(tmpLibro);
    }

    @Override
    public String toString() {
        return "Libreria{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", libros=" + libros.toString() +
                '}';
    }
}
