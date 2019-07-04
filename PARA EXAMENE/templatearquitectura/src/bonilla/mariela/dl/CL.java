package bonilla.mariela.dl;

import bonilla.mariela.bl.*;
import java.util.TreeMap;


public class CL {

    private TreeMap<String, Usuario> usuarios;
    private TreeMap<String, Parqueo> parqueos;
    private TreeMap<Integer, Espacio> espacios;

    public CL() {
        usuarios = new TreeMap<>();
        parqueos = new TreeMap<>();
        espacios = new TreeMap<>();

    }
    public void registroUsuario(Usuario tmpUsuario){
        usuarios.put(tmpUsuario.getIdentificacion(), tmpUsuario);

    }

    public void registroParqueo(Parqueo tmpParqueo) {
        parqueos.put(tmpParqueo.getNombre(), tmpParqueo);
    }

    public void registroEspacio(Espacio tmpEspacio) {
        espacios.put(tmpEspacio.getNumEspacio(), tmpEspacio);
    }

    public TreeMap<String, Usuario> getUsuarios() {
        return usuarios;
    }

    public TreeMap<String, Parqueo> getParqueos() {
        return parqueos;
    }

    public TreeMap<Integer, Espacio> getEspacios() {
        return espacios;
    }

    public boolean validarIdentificacion(String identificacion) {
        boolean repetido = false;
        for (Usuario obj : getUsuarios().values()) {
            if (obj.getIdentificacion().equals(identificacion)) {
                repetido = true;
            }
        }
        return repetido;
    }

    public boolean validarNumEspacio(int numEspacio) {
        boolean repetido = false;
        for (Espacio obj : getEspacios().values()) {
            if (obj.getNumEspacio() == numEspacio) {
                repetido = true;
            }
        }
        return repetido;
    }


    public boolean validarCantEspacios(int cantEspacios) {
        boolean noAceptado = false;
        for (Parqueo obj : getParqueos().values()) {
            if (obj.getCantEspacios() < cantEspacios) {
                noAceptado = true;
            }
        }
        return noAceptado;


    }
}
