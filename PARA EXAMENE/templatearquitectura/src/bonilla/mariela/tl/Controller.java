package bonilla.mariela.tl;

import bonilla.mariela.dl.*;
import bonilla.mariela.bl.*;

public class Controller {
    private CL logica;

    public Controller() {
        logica = new CL();
    }
    /*
    Método que permite registrar
    */

    public void registrarEmpleado(String tipoUsuario, String nombre, String apellido, String identificacion, int numEmpleado, String nombreUsuario,
                                  String contrasenna, int horaEntrada,
                                  int horaSalida) {

        Empleado tmpEmpleado;
        tmpEmpleado = new Empleado(tipoUsuario, nombre, apellido, identificacion, numEmpleado, nombreUsuario, contrasenna,
                horaEntrada, horaSalida);

        logica.registroUsuario(tmpEmpleado);

    }


    public void registrarClienteFisico(String tipoUsuario, String tipoCliente, String nombre, String apellido, String identificacion,
                                       String correo, int codigo,
                                        String direccion,String telefono, boolean estado){
    ClienteFisico tmpFisico;
        tmpFisico = new ClienteFisico(tipoUsuario, tipoCliente, nombre, apellido, identificacion,codigo,correo,
                direccion, telefono, estado);

        logica.registroUsuario(tmpFisico);

    }
    public void registrarClienteJuridico(String tipoUsuario, String tipoCliente, String nombre, String identificacion,String direccion,
                                         boolean estado, int codigoCliente) {
        ClienteJuridico tmpjuridico;

        tmpjuridico = new ClienteJuridico(tipoUsuario, tipoCliente, nombre, identificacion,
                direccion, estado, codigoCliente);

        logica.registroUsuario(tmpjuridico);

    }

    public void registrarParqueo(String nombre, String direccion, int cantEspacios) {
        Parqueo tmpParqueo;

        tmpParqueo = new Parqueo(nombre, direccion, cantEspacios);

        logica.registroParqueo(tmpParqueo);

    }


    public void registrarEspacio(String tipoVehiculo, int numero, boolean ocupado) {
        Espacio tmpEspacio;

        tmpEspacio = new Espacio(tipoVehiculo, numero, ocupado);

        logica.registroEspacio(tmpEspacio);

    }


    /*
    Retorna las colecciones de la capa lógica
     */
    public String[] listaEmpleados() {
        String[] lista = new String[logica.getUsuarios().size()];
        int cont = 0;

        for (Usuario dato : logica.getUsuarios().values()) {
            if (dato.getTipoUsuario().equals("Empleado")) {
                lista[cont] = dato.toString();
            }
        }

        return lista;

    }

    public String[] listaClientes() {
        String[] lista = new String[logica.getUsuarios().size()];
        int cont = 0;

        for (Usuario dato : logica.getUsuarios().values()) {
            if (dato.getTipoUsuario().equals("Cliente")) {
                lista[cont] = dato.toString();
            }
        }

        return lista;

    }



    public String[] listaParqueos() {
        String[] lista = new String[logica.getParqueos().size()];
        int cont = 0;

        for (Parqueo dato : logica.getParqueos().values()) {
            lista[cont] = dato.toString();
        }

        return lista;
    }

    public String[] listaEspacios() {
        String[] lista = new String[logica.getEspacios().size()];
        int cont = 0;

        for (Espacio dato : logica.getEspacios().values()) {
            lista[cont] = dato.toString();
        }

        return lista;
    }

    /*
    Metodos para validar datos repetidos
     */

    public boolean validarIdentificacion(String identificacion) {
        boolean repetido = false;
        repetido = logica.validarIdentificacion(identificacion);
        return repetido;
    }

    public boolean validarNumEspacio(int numEspacio) {
        boolean repetido = false;
        repetido = logica.validarNumEspacio(numEspacio);
        return repetido;
    }


    public boolean validarCantidadEspacios(int cantEspacios){
        boolean noAceptado;
        noAceptado = logica.validarCantEspacios(cantEspacios);
        return noAceptado;
    }



}
