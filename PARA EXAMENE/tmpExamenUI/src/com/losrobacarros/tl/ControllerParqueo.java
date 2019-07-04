package com.losrobacarros.tl;

import com.losrobacarros.accesobd.Conector;
import com.losrobacarros.bl.dao.DaoFactory;
import com.losrobacarros.bl.parqueo.IParqueoDao;
import com.losrobacarros.bl.parqueo.Parqueo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.TreeMap;

public class ControllerParqueo  extends Controller  {

    public ControllerParqueo() {
    }

    public boolean registrarParqueo(String nombre, String direccion, int cantEspacios) {

        boolean correcto = false;

        try {
            DaoFactory factory = DaoFactory.getDaoFactory(DaoFactory.SQLSERVER);
            IParqueoDao dao = factory.getParqueoDao();
            correcto = dao.registrarParqueo(nombre, direccion, cantEspacios);

        }catch (SQLException e) {
            System.out.println(e.getErrorCode());
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return correcto;
    }


    public boolean modificarParqueo(String [] parqueo) {
        boolean correcto = false;
        try {
            DaoFactory factory = DaoFactory.getDaoFactory(DaoFactory.SQLSERVER);
            IParqueoDao dao = factory.getParqueoDao();
            correcto = dao.modificarParqueo(parqueo[0], parqueo[1], Integer.parseInt(parqueo[2]));

        }catch (SQLException e) {
            System.out.println(e.getErrorCode());
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return correcto;
    }

    public ArrayList<String> listaParqueos() {
        ArrayList<String> lista = new ArrayList<>();

        try {
            DaoFactory factory = DaoFactory.getDaoFactory(DaoFactory.SQLSERVER);
            IParqueoDao dao = factory.getParqueoDao();
            for (Parqueo dato: dao.listarParqueos().values() ) {
                lista.add(dato.toString());
            }
        }catch (SQLException e) {
            System.out.println(e.getErrorCode());
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }

    public String[] obtenerDatosParqueo() {
        String [] lista = new String[3];

        try {
            DaoFactory factory = DaoFactory.getDaoFactory(DaoFactory.SQLSERVER);
            IParqueoDao dao = factory.getParqueoDao();
            for (Parqueo dato: dao.listarParqueos().values() ) {
                lista[0] = dato.getNombre();
                lista[1] = dato.getDireccion();
                lista[2] = Integer.toString(dato.getCantEspacios());
            }
        }catch (SQLException e) {
            System.out.println(e.getErrorCode());
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }


    public boolean validarCantidadEspacios(int cantEspacios){
        boolean noAceptado = false;
        try {
            DaoFactory factory = DaoFactory.getDaoFactory(DaoFactory.SQLSERVER);
            IParqueoDao dao = factory.getParqueoDao();

            noAceptado = dao.validarCantEspacios(cantEspacios);

        }catch (SQLException e) {
            System.out.println(e.getErrorCode());
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return noAceptado;
    }



    public boolean espaciosPermitidos(int cantEspacios) {
        boolean permitidos = false;
        if (cantEspacios<=560) {
            permitidos = true;
        }
        return permitidos;
    }


    public boolean validarExistenciaParqueo() {
        boolean registrado = false;
        try {
            DaoFactory factory = DaoFactory.getDaoFactory(DaoFactory.SQLSERVER);
            IParqueoDao dao = factory.getParqueoDao();

            registrado = dao.validarExistenciaParqueo();

        }catch (SQLException e) {
            System.out.println(e.getErrorCode());
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return registrado;
    }






}
