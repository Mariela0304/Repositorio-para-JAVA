package bonilla.mariela.bl;

import bonilla.mariela.bl.*;

import java.time.LocalDate;

public class Moderador extends Usuario{
    private boolean moderadorExistente = false;

    public Moderador() {
        super();
    }

    public Moderador(String tipoUsuario, String nombre, String identificacion,
                     LocalDate fechaNacimiento, int edad, String correo, String contrasenna) {
        super(tipoUsuario, nombre, identificacion, fechaNacimiento, edad, correo, contrasenna);

    }

    public boolean isModeradorExistente() {
        return moderadorExistente;
    }

    public void setModeradorExistente(boolean moderadorExistente) {
        this.moderadorExistente = moderadorExistente;
    }

    @Override
    public String toString() {
        return "-------- MODERADOR: -------------------------------------------\n" +
                "\n Nombre: " + nombre +
                "\n Identificación: " + identificacion +
                "\n Fecha de nacimiento: " + fechaNacimiento +
                "\n Edad: " + edad +
                "\n Correo electrónico: " + correo +
                "\n Contrasenna: " + contrasenna  + //no es correcto que se pueda imprimir la contrasenna, sin embargo,
                //                                         la agrego para comprobar que se imprime de manera
                //                                          correcta.
                "\n\n-------------------------------------------------------------\n\n";
    }
}
