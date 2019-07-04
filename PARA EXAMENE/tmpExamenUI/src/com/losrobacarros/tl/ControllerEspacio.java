package com.losrobacarros.tl;

import com.losrobacarros.bl.dao.DaoFactory;
import com.losrobacarros.bl.espacio.Espacio;
import com.losrobacarros.bl.espacio.IEspacioDao;
import com.losrobacarros.bl.parqueo.IParqueoDao;
import com.losrobacarros.bl.parqueo.InfoParqueo;
import com.losrobacarros.bl.parqueo.Parqueo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.TreeMap;

public class ControllerEspacio  extends Controller {

    public ControllerEspacio() {
    }

    public boolean registrarEspacio(String tipoVehiculo, int numero) {

        InfoParqueo infoParqueo = new InfoParqueo();
        boolean correcto = false;
        try {
            DaoFactory factory = DaoFactory.getDaoFactory(DaoFactory.SQLSERVER);
            IEspacioDao dao = factory.getEspacioDao();
            correcto = dao.registrarEspacio(tipoVehiculo, numero, infoParqueo.getNombre());

        }catch (SQLException e) {
            System.out.println(e.getErrorCode());
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return correcto;
    }


    public boolean modificarEspacio(String[] espacio) {
        InfoParqueo infoParqueo = new InfoParqueo();
        boolean correcto = false;

        try {
            DaoFactory factory = DaoFactory.getDaoFactory(DaoFactory.SQLSERVER);
            IEspacioDao dao = factory.getEspacioDao();
                correcto=dao.modificarEspacio(espacio[0], Integer.parseInt(espacio[1]), infoParqueo.getNombre());

        }catch (SQLException e) {
            System.out.println(e.getErrorCode());
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return correcto;
    }


    public ArrayList<String> listaEspacios() {
        ArrayList<String> listaEspacios = new ArrayList<>();
        try {
            DaoFactory factory = DaoFactory.getDaoFactory(DaoFactory.SQLSERVER);
            IEspacioDao dao = factory.getEspacioDao();
            for (Espacio dato: dao.listarEspacios().values()) {
                listaEspacios.add(dato.toString());
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return listaEspacios;
    }

    public boolean validarNumEspacio(int numEspacio) {
        boolean repetido = false;
        try {
            DaoFactory factory = DaoFactory.getDaoFactory(DaoFactory.SQLSERVER);
            IEspacioDao dao = factory.getEspacioDao();
            repetido = dao.validarNumEspacio(numEspacio);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return repetido;
    }

    public boolean validarPlacaEspacio(String numPlaca) {
        boolean repetido = false;
        try {
            DaoFactory factory = DaoFactory.getDaoFactory(DaoFactory.SQLSERVER);
            IEspacioDao dao = factory.getEspacioDao();
            repetido = dao.validarPlacaEspacio(numPlaca);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return repetido;
    }

    public boolean validarEstadoEspacio(int numEspacio) {
        boolean ocupado = false;
        try {
            DaoFactory factory = DaoFactory.getDaoFactory(DaoFactory.SQLSERVER);
            IEspacioDao dao = factory.getEspacioDao();
            ocupado = dao.validarEstadoEspacio(numEspacio);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return ocupado;
    }


    public String[] obtenerDatosEspacio(int numEspacio) {
        String [] lista = new String[2];



        try {
            DaoFactory factory = DaoFactory.getDaoFactory(DaoFactory.SQLSERVER);
            IEspacioDao dao = factory.getEspacioDao();
            for (Espacio dato: dao.obtenerEspacio(numEspacio) ) {

                lista[0] = dato.getTipoEspacio();
                lista[1] = Integer.toString(dato.getNumEspacio());
            }
        }catch (SQLException e) {
            System.out.println(e.getErrorCode());
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }

}
