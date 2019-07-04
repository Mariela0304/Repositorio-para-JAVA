package bonilla.mariela.bl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

public class Subasta {
    private int id;
    private LocalDate fechaVencimiento;
    private LocalDateTime tiempoFaltante;
    private Item [] itemsSubastados;
    private Usuario nomVendedor;
    private double puntuacion;
    private double precioMinimo;
    private boolean coleccionista;
    private String [] infoColeccionista;

    /*
    Constructor por defecto
     */

    public Subasta() {

    }

    /*
    Contructor qur va a recibir el id, la fecha de vencimiento, el tiempo faltante,la puntuación
    el precio mínimo y un booleano que definirá si es o no un usuario coleccionista
     */

    public Subasta(int id, LocalDate fechaVencimiento, LocalDateTime tiempoFaltante,
                   double puntuacion, double precioMinimo, boolean coleccionista) {
        this.id = id;
        this.fechaVencimiento = fechaVencimiento;
        this.tiempoFaltante = tiempoFaltante;
        this.puntuacion = puntuacion;
        this.precioMinimo = precioMinimo;
        this.coleccionista = coleccionista;
    }

     /*
    Contructor qur va a recibir el id, la fecha de vencimiento, el tiempo faltante,la puntuación
    el precio mínimo, un arreglo que recibe toda la información del colecccionista,
     en caso de que el subastador sea coleccionista y un booleano que definirá
     si es o no un usuario coleccionista
     */

    public Subasta(int id, LocalDate fechaVencimiento, LocalDateTime tiempoFaltante, double puntuacion,
                   double precioMinimo, String[] infoColeccionista, boolean coleccionista) {
        this.id = id;
        this.fechaVencimiento = fechaVencimiento;
        this.tiempoFaltante = tiempoFaltante;
        this.puntuacion = puntuacion;
        this.precioMinimo = precioMinimo;
        this.coleccionista = coleccionista;
        this.infoColeccionista = infoColeccionista;
    }

      /*
    Contructor qur va a recibir el id, la fecha de vencimiento, el tiempo faltante, un arreglo que va
    a almacenar los items que se van a subastar, la puntuación, el precio mínimo,
     un arreglo que recibe toda la información del coleccionista,
     en caso de que el subastador sea coleccionista y un booleano que definirá
     si es o no un usuario coleccionista
     */

    public Subasta(int id, LocalDate fechaVencimiento, LocalDateTime tiempoFaltante, Item[] itemsSubastados,
                   double puntuacion, double precioMinimo, String[] infoColeccionista,  boolean coleccionista) {
        this.id = id;
        this.fechaVencimiento = fechaVencimiento;
        this.tiempoFaltante = tiempoFaltante;
        this.itemsSubastados = itemsSubastados;
        this.puntuacion = puntuacion;
        this.precioMinimo = precioMinimo;
        this.coleccionista = coleccionista;
        this.infoColeccionista = infoColeccionista;
    }

    /*
    Contructor qur va a recibir el id, la fecha de vencimiento, el tiempo faltante, un arreglo
     que va almacenar los items subastados, el nombre del vendedor de tipo Usuario, la puntuación
    el precio mínimo y un booleano que definirá si es o no un usuario coleccionista
     */

    public Subasta(int id, LocalDate fechaVencimiento, LocalDateTime tiempoFaltante,
                   Item[] itemsSubastados, Usuario nomVendedor,
                   double puntuacion, double precioMinimo, boolean coleccionista) {
        this.id = id;
        this.fechaVencimiento = fechaVencimiento;
        this.tiempoFaltante = tiempoFaltante;
        this.itemsSubastados = itemsSubastados;
        this.nomVendedor = nomVendedor;
        this.puntuacion = puntuacion;
        this.precioMinimo = precioMinimo;
        this.coleccionista = coleccionista;
    }

     /*
    Contructor qur va a recibir el id, la fecha de vencimiento, el tiempo faltante, un arreglo
     que va almacenar los items subastados, el nombre del vendedor de tipo Usuario, la puntuación
    el precio mínimo, un arreglo que va a almacenar la información del coleccionista,
     en caso de que el subastador sea coleccionista y un booleano que definirá
     si es o no un usuario coleccionista
     */

    public Subasta(int id, LocalDate fechaVencimiento, LocalDateTime tiempoFaltante,
                   Item [] itemsSubastados, Usuario nomVendedor, double puntuacion,
                   double precioMinimo, String [] infoColeccionista, boolean coleccionista) {
        this.id = id;
        this.fechaVencimiento = fechaVencimiento;
        this.tiempoFaltante = tiempoFaltante;
        this.itemsSubastados = itemsSubastados;
        this.nomVendedor = nomVendedor;
        this.puntuacion = puntuacion;
        this.precioMinimo = precioMinimo;
        this.infoColeccionista = infoColeccionista;
        this.coleccionista = coleccionista;
    }


    /*
    Metodos get
     */

    public int getId() {
        return id;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public LocalDateTime getTiempoFaltante() {
        return tiempoFaltante;
    }

    public Item[] getItemsSubastados() {
        return itemsSubastados;
    }

    public Usuario getNomVendedor() {
        return nomVendedor;
    }

    public double getPuntuacion() {
        return puntuacion;
    }

    public double getPrecioMinimo() {
        return precioMinimo;
    }



    public String[] getInfoColeccionista() {
        return infoColeccionista;
    }

    public boolean getColeccionista() {
        return coleccionista;
    }

    /*
    Metodos set
     */

    public void setId(int id) {
        this.id = id;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public void setTiempoFaltante(LocalDateTime tiempoFaltante) {
        this.tiempoFaltante = tiempoFaltante;
    }

    public void setItemsSubastados(Item [] itemsSubastados) {
        this.itemsSubastados = itemsSubastados;
    }

    public void setNomVendedor(Usuario nomVendedor) {
        this.nomVendedor = nomVendedor;
    }

    public void setPuntuacion(double puntuacion) {
        this.puntuacion = puntuacion;
    }

    public void setPrecioMinimo(double precioMinimo) {
        this.precioMinimo = precioMinimo;
    }

    public void setInfoColeccionista(String [] infoColeccionista) {
        this.infoColeccionista = infoColeccionista;
    }

    public void setColeccionista(boolean coleccionista) {
        this.coleccionista = coleccionista;
    }

    @Override
    public String toString() {
        return "-------- SUBASTA: ----------------------------------\n" +
                "\n Fecha de vencimiento: " + fechaVencimiento +
                "\n Tiempo restante:" + tiempoFaltante +
                "\n Ítems en subasta: " + Arrays.toString(itemsSubastados) +
                "\n Nombre del vendedor" + nomVendedor +
                "\n Puntuación del vendedor: " + puntuacion +
                "\n Precio mínimo de ítems: " + precioMinimo +
                "\n ¿Es coleccionista?  " + coleccionista +
                "\n" + infoColeccionista.toString() +
                "\n\n------------------------------------------------------\n\n";
    }
}
