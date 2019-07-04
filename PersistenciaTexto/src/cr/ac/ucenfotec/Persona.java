package cr.ac.ucenfotec;

public class Persona {
    private String nombre;
    private String primerApellido;
    private String segundoApellido;

    public Persona() {
    }

    public Persona(String nombre, String primerApellido, String segundoApellido) {
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    @Override
    public String toString() {
        return "\n============ Persona: ==================\n" +
                "Nombre: " + nombre +
                "\nPrimer Apellido: " + primerApellido +
                "\nSegundo Apellido: " + segundoApellido +
                "\n========================================\n";
    }
}
