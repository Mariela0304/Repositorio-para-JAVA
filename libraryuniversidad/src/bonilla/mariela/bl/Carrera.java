package bonilla.mariela.bl;

public class Carrera {
    private String codigo;
    private String nombre;
    private boolean acreditada;

    public Carrera() {

    }

    public Carrera(String codigo, String nombre, boolean acreditada) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.acreditada = acreditada;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public boolean getAcreditada() {
        return acreditada;
    }

    public void setAcreditada(boolean acreditada) {
        this.acreditada = acreditada;
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
