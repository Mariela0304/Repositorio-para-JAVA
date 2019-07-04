package com.losrobacarros.bl.espacio;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.TreeMap;

public interface IEspacioDao {



    public boolean registrarEspacio(String tipoVehiculo, int numEspacio, String nombreParqueo) throws SQLException, Exception;

    public boolean modificarEspacio(String tipoVehiculo, int numEspacio, String nombreParqueo) throws SQLException, Exception;


    public TreeMap<String, Espacio> listarEspacios() throws SQLException, Exception;

    public boolean validarNumEspacio(int tmpNum) throws SQLException, Exception;

    public boolean validarPlacaEspacio(String numPlaca) throws SQLException, Exception;

    public boolean validarEstadoEspacio(int numEspacio) throws SQLException, Exception;


    public ArrayList<Espacio> obtenerEspacio(int numEspacio) throws SQLException, Exception;

}
