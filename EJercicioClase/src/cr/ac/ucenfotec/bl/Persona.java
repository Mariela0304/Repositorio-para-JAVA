package cr.ac.ucenfotec.bl;



public class Persona {
    private String nombre;
    private String direccion;
    private String identificacion;


    public Persona() {


    }

    public Persona( String pnombre, String pidentificacion) {
        this.nombre = pnombre;
        this.identificacion = pidentificacion;
    }

    //Se llama sobreescritura = es cuando una clase tiene un metodo con la misma firma del padre
    //cuando una clase que le pasa por encima del metodo del padre
    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", identificacion='" + identificacion + '\'' +
                '}';
    }
}
