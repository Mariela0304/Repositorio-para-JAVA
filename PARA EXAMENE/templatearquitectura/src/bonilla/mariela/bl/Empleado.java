package bonilla.mariela.bl;

import bonilla.mariela.bl.*;

public class Empleado extends Usuario {
    private String nombreUsuario;
    private String contrasenna;
    private int numEmpleado;
    private String apellido;
    private int horaEntrada;
    private int horaSalida;

    public Empleado() {
        super();
    }

    public Empleado(String tipoUsuario, String nombre, String apellido, String identificacion,
                    int numEmpleado, String nombreUsuario, String contrasenna,
                      int horaEntrada, int horaSalida) {
        super(tipoUsuario, nombre, identificacion);
        this.nombreUsuario = nombreUsuario;
        this.contrasenna = contrasenna;
        this.numEmpleado = numEmpleado;
        this.apellido = apellido;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasenna() {
        return contrasenna;
    }

    public void setContrasenna(String contrasenna) {
        this.contrasenna = contrasenna;
    }

    public int getNumEmpleado() {
        return numEmpleado;
    }

    public void setNumEmpleado(int numEmpleado) {
        this.numEmpleado = numEmpleado;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(int horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public int getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(int horaSalida) {
        this.horaSalida = horaSalida;
    }

    @Override
    public String toString() {
        return "\n========== EMPLEADO: ================================\n" +
                "\n Tipo de usuario:" + tipoUsuario +
                "\n Nombre: " + nombre +
                "\n Apellido: " + apellido +
                "\n Identificación: " + identificacion +
                "\n Número de empleado: " + numEmpleado +
                "\n Nombre de usuario: " + nombreUsuario +
                "\n Contraseña: " + contrasenna +
                "\n Hora de entrada: " + horaEntrada +
                "\n Hora de salida: " + horaSalida +
                "\n\n===========================================================\n\n";
    }



}
