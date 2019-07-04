package bonilla.mariela.bl;

import javafx.beans.property.*;

public class Carrera {
    private SimpleStringProperty codigo;
    private SimpleStringProperty nombre;
    private SimpleBooleanProperty acreditada;

    public Carrera() {

    }

    public Carrera(String codigo, String nombre, boolean acreditada) {
        this.codigo = new SimpleStringProperty(codigo);
        this.nombre = new SimpleStringProperty(nombre);
        this.acreditada = new SimpleBooleanProperty(acreditada);
    }

    public String getCodigo() {
        return codigo.get();
    }

    public String getNombre() {
        return nombre.get();
    }

    public boolean getAcreditada() {
        return acreditada.get();
    }



    public void setCodigo(String pcodigo) {
        codigo.set(pcodigo);
    }

    public void setNombre(String pnombre) {
        nombre.set(pnombre);
    }

    public void setAcreditada(boolean pacreditada) {
        acreditada.set(pacreditada);
    }

    @Override
    public String toString() {
        return "Carrera{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", acreditada=" + acreditada +
                '}';
    }
}
