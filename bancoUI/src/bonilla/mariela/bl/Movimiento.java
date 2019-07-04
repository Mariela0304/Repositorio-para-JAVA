package bonilla.mariela.bl;

import java.time.LocalDate;

/*Se crea la nueva relación de tipo clase que se llama movimiento con sus atributos
* del tipo de movimiento que va a ser de tipo depósito o retiro, un atributo de fecha del movimiento ,
* un atributo de descripción del movimiento y el atributo que va a definir el monto*/

public class Movimiento {
    private String tipoMovimiento;
    private LocalDate fecha;
    private String descripcion;
    private double monto;

    public Movimiento() {

    }

    public Movimiento(String tipoMovimiento, LocalDate fecha, String descripcion, double monto) {
        this.tipoMovimiento = tipoMovimiento;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.monto = monto;
    }


    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }


    @Override
    public String toString() {
        return "\n\n======= Movimiento: ===================" +
                "\n Tipo de movimiento: " + tipoMovimiento +
                "\n Fecha de movimiento: " + fecha +
                "\n Descripción: " + descripcion +
                "\n Monto: " + monto +
                "\n========================================";
    }
}
