package bonilla.mariela.bl;


import javafx.beans.property.SimpleStringProperty;

public class Estudiante {
    private String id;
    private String nombre;
    private String apellido;
    private String identificacion;
    private String edad;

    public Estudiante(String id, String nombre, String apellido, String identificacion, String pedad) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.identificacion = identificacion;
        this.edad = pedad;
    }

    public Estudiante() {
    }

    //método para acceso para obtener información

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public String getEdad() {
        return edad;
    }

    //método para acceso para modificar la información


    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String pnombre) {
        this.nombre = pnombre;
    }

    public void setApellido(String papellido) {
        this.apellido = papellido;

    }

    public void setIdentificacion(String pidentificacion) {
        this.identificacion = pidentificacion;

    }

    public void setEdad(String pedad) {
        this.edad = pedad;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", identificación='" + identificacion + '\'' +
                ", edad=" + edad +
                '}';
    }


}
