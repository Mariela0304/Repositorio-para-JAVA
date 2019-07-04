package bonilla.mariela.tl;

import bonilla.mariela.bl.Cliente;
import bonilla.mariela.bl.Organizacion;
import bonilla.mariela.bl.Persona;
import bonilla.mariela.bl.PersonaFisica;
import bonilla.mariela.dl.CL;

public class Controller {


    private CL logica;

    public Controller() {
        logica = new CL();
    }

    public void registrarOrganizacion(String identificacion, String nombre, String direccion, String
                                      telefono, String representante) {
        String tipoPersona = "Proveedor";
        String tipoProveedor = "Organización";
        Organizacion tmpOrganizacion = new Organizacion(tipoPersona, tipoProveedor, identificacion, nombre, direccion, telefono, representante);
        logica.registrarPersona(tmpOrganizacion);
    }

    public void registrarPersonaFisica(String identificacion, String nombre, String apellidos,
                                       String direccion, String telefono) {
        String tipoPersona = "Proveedor";
        String tipoProveedor = "Persona Física";
        PersonaFisica tmpPersonaFisica = new PersonaFisica(tipoPersona, tipoProveedor, identificacion, nombre, apellidos, direccion, telefono);
        logica.registrarPersona(tmpPersonaFisica);
    }

    public void registrarClientes(String identificacion, String nombre, String apellidos, String correo, String provincia,
                                  String canton, String distrito, String direccion, String telefono) {
        String tipoPersona = "Cliente";
        Cliente tmpCliente = new Cliente(tipoPersona, nombre, apellidos, identificacion, correo, provincia, canton, distrito, direccion, telefono);
        logica.registrarPersona(tmpCliente);
    }


    public String [] imprimirListaProveedores() {
        String [] lista = new String[logica.getPersonas().size()];

        int cont = 0;

        for (Persona dato: logica.getPersonas().values() ) {
            if (dato.getTipoPersona().equals("Proveedor")) {
                lista[cont] = dato.toString();
            }
            cont++;
        }
        return lista;
    }


    public String [] imprimirListaClientes() {
        String [] lista = new String[logica.getPersonas().size()];

        int cont = 0;

        for (Persona dato: logica.getPersonas().values() ) {
            if (dato.getTipoPersona().equals("Cliente")) {
                lista[cont] = dato.toString();
            }
            cont++;
        }
        return lista;
    }
}
