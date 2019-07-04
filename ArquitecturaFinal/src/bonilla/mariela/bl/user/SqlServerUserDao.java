package bonilla.mariela.bl.user;

import bonilla.mariela.accesobd.*;
import bonilla.mariela.bl.dao.DaoFactory;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SqlServerUserDao implements IUserDao
{
    public SqlServerUserDao() {
    }

    @Override
    public void insertar(String user, String pwd) throws SQLException, Exception {
        String sql;
        try {
            sql = "INSERT INTO USERS(USERNAME, PASSWORD) VALUES ('"+user+"','"+ pwd +"')";

            Conector.getConnectorBD(DaoFactory.SQLSERVER).ejecutarSQL(sql);

        } catch (Exception e){
            System.out.println(e.toString());
        }

    }



        /*
        Primera forma de conectar la base de datos

        AccesoBD acceso;
        acceso = Conector.getConnectorBD(DaoFactory.SQLSERVER);
        acceso.ejecutarSQL(sql);
         */


        /*
        Segunda forma de conectar la base de datos

        Conector.getConnectorBD(DaoFactory.SQLSERVER).ejecutarSQL(sql);
         */



    @Override
    public User validar(String user, String pwd) throws SQLException, Exception {
        ResultSet rs;
        String sql;
        User tmpUser = null;
        sql = "SELECT * FROM USERS WHERE USERNAME = '" + user +"' AND PASSWORD = '"+pwd +"'";
        try {
            rs = Conector.getConnectorBD(DaoFactory.SQLSERVER).ejecutarSQL(sql,false);
            while (rs.next()) {
                tmpUser =new User(rs.getString("USERNAME"), rs.getString("PASSWORD"));
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return tmpUser;
    }

    @Override
    public String[] listar() throws SQLException, Exception {
        return new String[0];
    }
}
