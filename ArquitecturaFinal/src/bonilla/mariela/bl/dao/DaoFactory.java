package bonilla.mariela.bl.dao;

import bonilla.mariela.bl.user.IUserDao;

public abstract class DaoFactory {

    public static final int SQLSERVER = 1;
    public static final int MYSQL = 2;

    public static DaoFactory getDaoFactory(int factory) {
        switch (factory) {
            case SQLSERVER:
                return new SqlServerDaoFactory();
            case MYSQL:
                return new MySqlDaoFactory();
            default:
                return null;
        }
    }

    public abstract IUserDao getUserDao();
}
