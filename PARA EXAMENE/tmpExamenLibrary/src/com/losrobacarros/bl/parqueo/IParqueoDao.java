package com.losrobacarros.bl.parqueo;

import java.sql.SQLException;
import java.util.TreeMap;

public interface IParqueoDao {

    public boolean registrarParqueo(String nombre, String direccion, int cantEspacios) throws SQLException, Exception;

    public boolean modificarParqueo(String nombre, String direccion, int cantEspacios) throws SQLException, Exception;


    public TreeMap<String, Parqueo> listarParqueos() throws SQLException, Exception;


    public boolean validarCantEspacios(int tmpNum) throws SQLException, Exception;


    public boolean validarExistenciaParqueo() throws SQLException, Exception;

}
