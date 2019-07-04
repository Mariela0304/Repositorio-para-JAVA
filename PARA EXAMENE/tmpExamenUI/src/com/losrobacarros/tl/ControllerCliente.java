package com.losrobacarros.tl;

import com.losrobacarros.bl.dao.DaoFactory;
import com.losrobacarros.bl.espacio.Espacio;
import com.losrobacarros.bl.espacio.IEspacioDao;
import com.losrobacarros.bl.parqueo.IParqueoDao;
import com.losrobacarros.bl.parqueo.InfoParqueo;
import com.losrobacarros.bl.usuario.cliente.Cliente;
import com.losrobacarros.bl.usuario.cliente.ClienteFisico;
import com.losrobacarros.bl.usuario.cliente.ClienteJuridico;
import com.losrobacarros.bl.usuario.cliente.IClienteDao;

import java.sql.SQLException;
import java.util.ArrayList;

public class ControllerCliente  extends Controller {

    public ControllerCliente() {
    }

    public boolean registrarClienteFisico(String nombre, String apellido, String identificacion,
                                          String correo, String direccion, String telefono, boolean estado){
        boolean correcto = false;

        InfoParqueo parqueo = new InfoParqueo();

        try {
            DaoFactory factory = DaoFactory.getDaoFactory(DaoFactory.SQLSERVER);
            IClienteDao dao = factory.getClienteDao();
            correcto = dao.registrarClienteFisico(nombre, apellido, identificacion, correo, direccion,telefono,
                    estado,  parqueo.getNombre());

        }catch (SQLException e) {
            System.out.println(e.getErrorCode());
            System.out.println(e.getMessage());
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return correcto;

    }


    public boolean registrarClienteJuridico(String nombre, String identificacion,String direccion,
                                         boolean estado) {
        boolean correcto = false;

        InfoParqueo parqueo = new InfoParqueo();

        try {
            DaoFactory factory = DaoFactory.getDaoFactory(DaoFactory.SQLSERVER);
            IClienteDao dao = factory.getClienteDao();
            correcto = dao.registrarClienteJuridico(nombre,  identificacion, direccion,
                    estado,  parqueo.getNombre());

        }catch (SQLException e) {
            System.out.println(e.getErrorCode());
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return correcto;
    }


    public boolean modificarClienteFisico(String [] clienteFisico){
        boolean correcto = false;

        InfoParqueo parqueo = new InfoParqueo();
        boolean estado = false;
        if (clienteFisico[6].equals("activo")) {
            estado = true;
        }
        try {
            DaoFactory factory = DaoFactory.getDaoFactory(DaoFactory.SQLSERVER);
            IClienteDao dao = factory.getClienteDao();
            correcto = dao.modificarClienteFisico(clienteFisico[0], clienteFisico[1], clienteFisico[2],
                    clienteFisico[3], clienteFisico[5],clienteFisico[4],
                    estado,  parqueo.getNombre());

        }catch (SQLException e) {
            System.out.println(e.getErrorCode());
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return correcto;

    }


    public boolean modificarClienteJuridico(String[] clienteJuridico) {
        boolean correcto = false;

        InfoParqueo parqueo = new InfoParqueo();
        boolean estado = false;
        if (clienteJuridico[4].equals("activo")) {
            estado = true;
        }

        try {
            DaoFactory factory = DaoFactory.getDaoFactory(DaoFactory.SQLSERVER);
            IClienteDao dao = factory.getClienteDao();
            correcto = dao.modificarClienteJuridico(clienteJuridico[0], clienteJuridico[1], clienteJuridico[2],
                    estado,  parqueo.getNombre());

        }catch (SQLException e) {
            System.out.println(e.getErrorCode());
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return correcto;
    }


    public ArrayList<String> listaClientes() {
        ArrayList<String> listaClientes = new ArrayList<>();
        try {
            DaoFactory factory = DaoFactory.getDaoFactory(DaoFactory.SQLSERVER);
            IClienteDao dao = factory.getClienteDao();
            for (Cliente dato: dao.listarClientes().values()) {
                listaClientes.add(dato.toString());
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

        return listaClientes;

    }


    public String[] obtenerDatosClienteFisico(String identificacion) {
        String [] lista = new String[7];
        String estado = "inactivo";
        try {
            DaoFactory factory = DaoFactory.getDaoFactory(DaoFactory.SQLSERVER);
            IClienteDao dao = factory.getClienteDao();
            for (ClienteFisico dato: dao.obtenerClienteFisico(identificacion)) {

                if (dato.getEstado()) {
                    estado = "activo";
                }

                lista[0] = dato.getNombre();
                lista[1] = dato.getApellido();
                lista[2] = dato.getIdentificacion();
                lista[3] = dato.getCorreo();
                lista[4] = dato.getTelefono();
                lista[5] = dato.getDireccion();
                lista[6] = estado;

            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return lista;
    }


    public String[] obtenerDatosClienteJuridico(String identificacion) {
        String [] lista = new String[4];
        String estado = "inactivo";
        try {
            DaoFactory factory = DaoFactory.getDaoFactory(DaoFactory.SQLSERVER);
            IClienteDao dao = factory.getClienteDao();
            for (ClienteJuridico dato: dao.obtenerClienteJuridico(identificacion)) {

                if (dato.getEstado()) {
                    estado = "activo";
                }

                lista[0] = dato.getNombre();
                lista[1] = dato.getIdentificacion();
                lista[2] = dato.getDireccion();
                lista[3] = estado;

            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return lista;
    }

}
