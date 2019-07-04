package bonilla.mariela.bl.dao;

import bonilla.mariela.bl.user.IUserDao;
import bonilla.mariela.bl.user.SqlServerUserDao;

public class SqlServerDaoFactory extends DaoFactory{


    public SqlServerDaoFactory() {
    }

    public IUserDao getUserDao() {
        return new SqlServerUserDao();
    }
}
