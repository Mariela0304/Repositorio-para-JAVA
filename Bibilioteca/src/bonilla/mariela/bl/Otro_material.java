package bonilla.mariela.bl;

import java.time.LocalDate;

public class Otro_material extends Material {
    private String descripcion;


    public Otro_material() {

    }

    public Otro_material(String idSignatura, LocalDate fechaCompra, boolean restriccion, String tema, String descripcion) {
        super(idSignatura, fechaCompra, restriccion, tema);
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Otro_material {" +
                " Signatura:" + idSignatura +
                ", Fecha de compra: " + fechaCompra +
                ", Restricción: " + restriccion +
                ", Tema: " + tema +
                ", Descripción del material: " + descripcion +
                '}';
    }
}
