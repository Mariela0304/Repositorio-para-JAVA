package bonilla.mariela.bl.user;

import bonilla.mariela.accesobd.Conector;
import bonilla.mariela.bl.dao.DaoFactory;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MySqlUserDao implements IUserDao{

    public MySqlUserDao() {
    }

    @Override
    public void insertar(String user, String pwd) throws SQLException, Exception {
        String sql;
        try {
            sql = "INSERT INTO USERS(USERNAME, PASSWORD) VALUES ('"+user+"','"+ pwd +"')";

            Conector.getConnectorBD(DaoFactory.MYSQL).ejecutarSQL(sql);

        } catch (Exception e){
            System.out.println(e.toString());
        }
    }

    @Override
    public User validar(String user, String pwd) throws SQLException, Exception {
        ResultSet rs;
        String sql;
        User tmpUser = null;
        sql = "SELECT * FROM USERS WHERE USERNAME = '" + user +"' AND PASSWORD = '"+pwd +"'";
        try {
            rs = Conector.getConnectorBD(DaoFactory.MYSQL).ejecutarSQL(sql,false);
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
