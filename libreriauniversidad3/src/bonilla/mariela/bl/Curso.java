package bonilla.mariela.bl;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Curso {
    private  String codigo;
    private  String nombre;
    private Integer creditos;

    public Curso() {

    }

    public Curso(String codigo, String nombre, Integer creditos) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.creditos = creditos;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getCreditos() {
        return creditos;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCreditos(Integer creditos) {
        this.creditos = creditos;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", creditos=" + creditos +
                '}';
    }
}


