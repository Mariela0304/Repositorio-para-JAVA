package bonilla.mariela.bl;

public class Usuario {

    protected String tipoUsuario;
    protected String nombre;
    protected String identificacion;

    public Usuario() {

    }

    public Usuario(String tipoUsuario, String nombre, String identificacion) {
        this.tipoUsuario = tipoUsuario;
        this.nombre = nombre;
        this.identificacion = identificacion;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    @Override
    public String toString() {
        return "\nUsuario\n{" +
                "\ntipoUsuario='" + tipoUsuario + '\'' +
                ",\n nombre='" + nombre + '\'' +
                ",\n identificacion='" + identificacion + '\'' +
                '}'+"\n\n";
    }
}
