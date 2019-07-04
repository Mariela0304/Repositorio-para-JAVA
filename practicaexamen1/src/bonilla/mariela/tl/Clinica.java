package bonilla.mariela.tl;

import bonilla.mariela.bl.*;
import bonilla.mariela.dl.CL;

import java.time.LocalDate;

public class Clinica {
    private CL logica;

    public Clinica() {
        logica = new CL();
    }

    public boolean validarCredenciales(String pcodigo, String pclave) {
        boolean repetido = false;
        repetido = logica.validarCredenciales(pcodigo, pclave);
        return repetido;
    }

//Metodo que toma la informacion que viene de la UI y la guarda tanto en la lista de laboratorio de la CL
    public void registrarPaciente(String tipoUsuario, String numSeguro, String nombre, String email, String direccion, String telefono, String clave){
        Paciente tmpPaciente;

        tmpPaciente = new Paciente(tipoUsuario, nombre, email, clave, numSeguro, direccion, telefono);
        logica.registrarPaciente(tmpPaciente);
    }


    public void registrarMedico(String tipoUsuario, String codigo, String nombre, String email, String clave, String especialidad){
        Medico tmpMedico;

        tmpMedico = new Medico(tipoUsuario,codigo, nombre, email, clave, especialidad);
        logica.registrarMedico(tmpMedico);
    }

    public void registrarCita(String id, LocalDate fecha, String paciente, String medico, String descripcion, String resultado){
        Cita tmpCita;

        tmpCita = new Cita(id, fecha, paciente, medico, descripcion, resultado);
        logica.registrarCita(tmpCita);
    }

    public void registrarExpediente(String id, String numSeguro, LocalDate fechaNacimiento, String tipoSangre, String [] padecimientos){
        Expediente tmpExpediente;

        tmpExpediente = new Expediente(id, numSeguro, fechaNacimiento, tipoSangre, padecimientos);
        logica.registrarExpediente(tmpExpediente);
    }

    public void registrarPadecimiento(String id, String nombre, String descripcion){
        Padecimiento tmpPadecimiento;

        tmpPadecimiento = new Padecimiento(id, nombre, descripcion);
        logica.registrarPadecimiento(tmpPadecimiento);
    }

    public String [] imprimirListaCitas() {
        String [] lista = new String[logica.getCitas().size()];
        int cont = 0;

        for (Cita dato : logica.getCitas().values()) {
            lista[cont] = dato.toString();
            cont++;
        }
        return lista;
    }

    public String [] imprimirListaPacientes() {
        String [] lista = new String[logica.getUsuarios().size()];
        int cont = 0;


        for (Usuario dato : logica.getUsuarios().values()) {
            if (dato.getTipoUsuario().equals("Paciente")) {
               lista[cont] = dato.toString();
            }
            cont++;
        }
        return lista;
    }

    public String [] imprimirListaExpedientes() {
        String [] lista = new String[logica.getExpedientes().size()];
        int cont = 0;

        for (Expediente dato : logica.getExpedientes().values()) {
            lista[cont] = dato.toString();
            cont++;
        }
        return lista;
    }

    public String [] imprimirListaPadecimientos() {
        String [] lista = new String[logica.getPadecimientos().size()];
        int cont = 0;

        for (Padecimiento dato : logica.getPadecimientos().values()) {
            lista[cont] = dato.toString();
            cont++;
        }
        return lista;
    }

    public boolean validarNumero(String ppnumero) {
        return logica.validarNumeros(ppnumero);
    }

}
