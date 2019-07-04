package bonilla.mariela.bl;

import java.time.LocalDate;

public class PersonaJuridica extends Persona{
    private String representante;
    private LocalDate fechaCreacion;

    public PersonaJuridica() {

    }

    public PersonaJuridica(String nombre, String apellido, String id, String representante, LocalDate fechaCreacion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.id = id;
        this.representante = representante;
        this.fechaCreacion = fechaCreacion;
    }


    public String getRepresentante() {
        return representante;
    }

    public void setRepresentante(String representante) {
        this.representante = representante;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    @Override //se susbcribe el metodo de toString de Object;
    public String toString() {
        return "Persona Juridica = {" +
                "Nombre: '" + nombre + '\'' +
                ", Apellido: '" + apellido + '\'' +
                ", Id: '" + id + '\'' +
                ", Representante: '" + representante + '\'' +
                ", FechaCreacion: '" + fechaCreacion +'\''+
        '}';
    }
}
