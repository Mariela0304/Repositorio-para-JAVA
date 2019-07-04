package com.losrobacarros.accesobd;


import java.sql.*;


public abstract class AccesoBD {
    protected Connection conn = null;
    protected Statement stmt = null;

    public AccesoBD(String driver, String conexion) throws SQLException, Exception
    {
        Class.forName(driver);
        conn = DriverManager.getConnection(conexion);
        stmt = conn.createStatement();

    }

    public AccesoBD(String driver, String url, String user, String password) throws SQLException, Exception
    {
        Class.forName(driver);
        conn = DriverManager.getConnection(url, user, password);
        stmt = conn.createStatement();

    }

    public abstract void ejecutarSQL(String query) throws SQLException, Exception;

    public abstract ResultSet ejecutarSQL(String query, boolean retorno) throws SQLException, Exception;


}
