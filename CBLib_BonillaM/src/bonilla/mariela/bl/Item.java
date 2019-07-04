package bonilla.mariela.bl;

import java.time.LocalDate;

public class Item {
    private int id;
    private String nombre;
    private String descripcion;
    private String estado;
    private LocalDate fechaCompra;
    private LocalDate antiguedad;

    /*
    Constructor por defecto
     */

    public Item() {

    }

    /*
    Constructor que recibe todos los parámetros
     */

    public Item(int id, String nombre, String descripcion, String estado, LocalDate fechaCompra, LocalDate antiguedad) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
        this.fechaCompra = fechaCompra;
        this.antiguedad = antiguedad;
    }

    /*
    Metodos de get
     */


    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public LocalDate getFechaCompra() {
        return fechaCompra;
    }

    public LocalDate getAntiguedad() {
        return antiguedad;
    }


    /*
    Metodos de set
     */

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setFechaCompra(LocalDate fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public void setAntiguedad(LocalDate antiguedad) {
        this.antiguedad = antiguedad;
    }

    @Override
    public String toString() {
        return "-------- ÍTEM: -------------------------------------------\n" +
                "\n Nombre de ítem: " + nombre +
                "\n Descripción: " + descripcion +
                "\n Estado: " + estado +
                "\n Fecha de compra: " + fechaCompra +
                "\n Antigüedad: " + antiguedad +
                "\n\n-------------------------------------------------------------\n\n";
    }
}
