package bonilla.mariela.bl;

import javafx.beans.property.*;

public class Curso {
    private  SimpleStringProperty codigo;
    private  SimpleStringProperty nombre;
    private SimpleIntegerProperty creditos;

    public Curso() {

    }

    public Curso(String codigo, String nombre, int creditos) {
        this.codigo = new SimpleStringProperty(codigo);
        this.nombre = new SimpleStringProperty(nombre);
        this.creditos = new SimpleIntegerProperty(creditos);
    }

    public String getCodigo() {
        return codigo.get();
    }


    public String getNombre() {
        return nombre.get();
    }

    public int getCreditos() {
        return creditos.get();
    }



    public void setCodigo(String pcodigo) {
        codigo.set(pcodigo);
    }
    public void setNombre(String pnombre) {
       nombre.set(pnombre);
    }
    public void setCreditos(int pcreditos) {
       creditos.setValue(pcreditos);
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


