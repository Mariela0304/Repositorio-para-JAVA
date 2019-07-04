package bonilla.mariela.bl.user;

import java.sql.SQLException;

public interface IUserDao {

    public void insertar(String user, String pwd) throws SQLException, Exception;

    public User validar(String user, String pwd) throws SQLException, Exception;

    public String[] listar() throws SQLException, Exception;
}
