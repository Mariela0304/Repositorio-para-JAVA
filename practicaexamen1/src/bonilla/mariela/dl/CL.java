package bonilla.mariela.dl;

import bonilla.mariela.bl.*;

import java.util.ArrayList;
import java.util.TreeMap;

public class CL {

    private String codigoMedico = "ABC123";
    private String clave = "123";

    //Variable de tipo TreeMap que almacena la info de los labs
    private TreeMap<String, Usuario> usuarios;
    private TreeMap<String, Cita> citas;
    private TreeMap<String, Expediente> expedientes;
    private TreeMap<String, Padecimiento> padecimientos;


    //Controlador que inicializa las listas
    public CL() {

        this.usuarios = new TreeMap<>();
    }

    //metodo que registra el laboratorio en la lista de labs
    public void registrarPaciente(Paciente pPac) {
        usuarios.put(pPac.getNumSeguroSocial(), pPac);
    }

    public void registrarMedico(Medico pMed) {
        usuarios.put(pMed.getCodigo(), pMed);
    }

    public void registrarCita(Cita pCita) {
        citas.put(pCita.getId(), pCita);
    }


    public void registrarExpediente(Expediente pExp) {
        expedientes.put(pExp.getId(), pExp);
    }

    public void registrarPadecimiento(Padecimiento pPad) {
        padecimientos.put(pPad.getId(), pPad);
    }


    public TreeMap<String, Usuario> getUsuarios() {
        return usuarios;
    }




    public TreeMap<String, Cita> getCitas() {
        return citas;
    }

    public TreeMap<String, Expediente> getExpedientes() {
        return expedientes;
    }

    public TreeMap<String, Padecimiento> getPadecimientos() {
        return padecimientos;
    }

    public boolean validarCredenciales(String pcodigo, String pclave) {
       boolean validado = false;

       if (pcodigo.equals(codigoMedico)) {
           if (pclave.equals(clave)) {
             validado = true;
           } else if(!pclave.equals(clave)) {
               validado = false;
           }
       } else if (pcodigo.equals(codigoMedico)) {
           validado = false;
       }
       return validado;
    }

    public boolean validarNumeros(String pnumero) {
        try {
            Integer.parseInt(pnumero); /*Va a validar que el dato "pnumero" sólo contenga números,
                                        si esto es cierto, dice que va a devolver un "true", diciendo
                                        que es un valor numérico*/
            return true;
        } catch (NumberFormatException nfe){  /*Aquí dice que si se encuentra al menos un valor NO numérico
                                                va a devolver un estado de "falso"*/
            return false;
        }
    }

}
