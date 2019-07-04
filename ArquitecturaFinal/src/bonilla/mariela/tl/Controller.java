package bonilla.mariela.tl;

import bonilla.mariela.bl.dao.DaoFactory;
import bonilla.mariela.bl.user.IUserDao;
import bonilla.mariela.bl.user.User;

public class Controller {

    public static User login;
    public Controller() {
    }

    public void registrarUsuario(String nombre, String password) {
       L
    }

    public void validarUsuario(String nombre, String password) {
        try {
            DaoFactory factory =  DaoFactory.getDaoFactory(DaoFactory.SQLSERVER);
            IUserDao dao = factory.getUserDao();
            login = dao.validar(nombre, password);
        }catch (Exception e) {

        }
    }

    public void listar() {
        try {
            DaoFactory factory =  DaoFactory.getDaoFactory(DaoFactory.SQLSERVER);
            IUserDao dao = factory.getUserDao();
            String [] data = dao.listar();
        }catch (Exception e) {

        }
    }
}
