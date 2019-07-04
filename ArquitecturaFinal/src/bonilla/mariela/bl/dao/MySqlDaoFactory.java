package bonilla.mariela.bl.dao;

import bonilla.mariela.bl.user.IUserDao;
import bonilla.mariela.bl.user.MySqlUserDao;

public class MySqlDaoFactory extends DaoFactory{

    public MySqlDaoFactory() {
    }

    public IUserDao getUserDao() {
        return new MySqlUserDao();
    }
}
