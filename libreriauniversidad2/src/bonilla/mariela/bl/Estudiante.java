package bonilla.mariela.bl;


import javafx.beans.property.*;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Estudiante {
    private SimpleStringProperty id;
    private SimpleStringProperty nombre;
    private SimpleStringProperty apellido;
    private SimpleStringProperty identificacion;
    private SimpleStringProperty edad;

    public Estudiante(String id, String nombre, String apellido, String identificacion, String pedad) {
        this.id = new SimpleStringProperty(id);
        this.nombre = new SimpleStringProperty(nombre);
        this.apellido = new SimpleStringProperty(apellido);
        this.identificacion = new SimpleStringProperty(identificacion);
        this.edad = new SimpleStringProperty(pedad);
    }

    public Estudiante() {
    }

    //método para acceso para obtener información

    public String getId() {
        return id.get();
    }

    public String getNombre() {
        return nombre.get();
    }

    public String getApellido() {
        return apellido.get(
        );
    }

    public String getIdentificacion() {
        return identificacion.get();
    }

    public String getEdad() {
        return edad.get();
    }

    //método para acceso para modificar la información

    public void setId(String pid) {
        this.id.set(pid);
    }

    public void setNombre(String pnombre) {
        nombre.set(pnombre);
    }

    public void setApellido(String papellido) {
        apellido.set(papellido);
    }

    public void setIdentificacion(String pidentificacion) {
        identificacion.set(pidentificacion);
    }

    public void setEdad(String pedad) {
        edad.set(pedad);
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", identificacion='" + identificacion + '\'' +
                ", edad=" + edad +
                '}';
    }


}
