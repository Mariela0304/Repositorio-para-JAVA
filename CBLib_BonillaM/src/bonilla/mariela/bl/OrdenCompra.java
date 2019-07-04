package bonilla.mariela.bl;

import java.time.LocalDate;
import java.util.Arrays;

public class OrdenCompra {
    private int id;
    private Coleccionista nomGanador;
    private LocalDate fechaOrden;
    private String [] detalleItems;
    private double precioTotal;

    /*
    Contructor por defecto
     */

    public OrdenCompra() {

    }

    /*
    Contructor que recibirá un id, la fecha de la orden, un arreglo donde se almacenará el detalle
    de los items y el precio total de los artículos
     */

    public OrdenCompra(int id, LocalDate fechaOrden, String[] detalleItems, double precioTotal) {
        this.id = id;
        this.fechaOrden = fechaOrden;
        this.detalleItems = detalleItems;
        this.precioTotal = precioTotal;
    }

        /*
    Contructor que recibirá un id, la fecha de la orden, el nombre del ganador de tipo
     Coleccionista, un arreglo donde se almacenará el detalle
    de los items y el precio total de los artículos
     */


    public OrdenCompra(int id, Coleccionista nomGanador, LocalDate fechaOrden,
                       String[] detalleItems, double precioTotal) {
        this.id = id;
        this.nomGanador = nomGanador;
        this.fechaOrden = fechaOrden;
        this.detalleItems = detalleItems;
        this.precioTotal = precioTotal;
    }


    /*
    Métodos que van a contener los gets
     */

    public int getId() {
        return id;
    }

    public Coleccionista getNomGanador() {
        return nomGanador;
    }


    public LocalDate getFechaOrden() {
        return fechaOrden;
    }


    public String[] getDetalleItems() {
        return detalleItems;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    /*
    Métodos que contendrán los métodos sets
     */

    public void setId(int id) {
        this.id = id;
    }

    public void setNomGanador(Coleccionista nomGanador) {
        this.nomGanador = nomGanador;
    }

    public void setFechaOrden(LocalDate fechaOrden) {
        this.fechaOrden = fechaOrden;
    }

    public void setDetalleItems(String[] detalleItems) {
        this.detalleItems = detalleItems;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }


    /*
    Método toString de la OrdenCompra
     */

    @Override
    public String toString() {
        return "------- ORDEN DE COMPRA: --------------------------\n" +
                "\n Nombre de ganador: " + nomGanador.toString() +
                "\n Fecha de orden de compra: " + fechaOrden +
                "\n Detalle de ítems: " + Arrays.toString(detalleItems) +
                "\n Precio total de compra: " + precioTotal +
                "\n\n---------------------------------------------------\n\n";
    }
}
