package com.losrobacarros.accesobd;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SqlServerAccesoBD extends AccesoBD{


    public SqlServerAccesoBD(String driver, String conexion) throws SQLException,Exception {
        super(driver, conexion);
    }

    public SqlServerAccesoBD(String driver, String url, String user, String password) throws SQLException,Exception {
        super(driver, url,user, password);
    }

    @Override
    public void ejecutarSQL(String query) throws SQLException,Exception{
        stmt.execute(query);
    }

    @Override
    public ResultSet ejecutarSQL (String query, boolean retorno)throws SQLException,Exception {
        ResultSet rs;

        rs = stmt.executeQuery(query);
        return rs;
    }

}
