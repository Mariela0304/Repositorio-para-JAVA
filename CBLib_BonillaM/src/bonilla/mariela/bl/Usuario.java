package bonilla.mariela.bl;

import java.time.LocalDate;

public class Usuario {
    protected String tipoUsuario;
    protected String nombre;
    protected String identificacion;
    protected LocalDate fechaNacimiento;
    protected int edad;
    protected String correo;
    protected String contrasenna;

    public Usuario() {

    }

    public Usuario(String tipoUsuario, String nombre, String identificacion, LocalDate fechaNacimiento, int edad, String correo, String contrasenna) {
        this.tipoUsuario = tipoUsuario;
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.fechaNacimiento = fechaNacimiento;
        this.edad = edad;
        this.correo = correo;
        this.contrasenna = contrasenna;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getEdad() {
        return edad;
    }

    public String getCorreo() {
        return correo;
    }

    public String getContrasenna() {
        return contrasenna;
    }




    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setContrasenna(String contrasenna) {
        this.contrasenna = contrasenna;
    }




    @Override
    public String toString() {
        return "-------- USUARIO: -------------------------------------------\n" +
                "\n Nombre: " + nombre +
                "\n Identificación: " + identificacion +
                "\n Fecha de nacimiento: " + fechaNacimiento +
                "\n Edad: " + edad +
                "\n Correo electrónico: " + correo +
                "\n Contraseña: " + contrasenna  + //no es correcto que se pueda imprimir la contrasenna, sin embargo,
                //                                         la agrego para comprobar que se imprime de manera
                //                                          correcta.
                "\n\n-------------------------------------------------------------\n\n";
    }
}
