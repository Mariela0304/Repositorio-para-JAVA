package com.losrobacarros.bl.dao;


import com.losrobacarros.bl.espacio.IEspacioDao;
import com.losrobacarros.bl.ingreso.IIngresoDao;
import com.losrobacarros.bl.parqueo.IParqueoDao;
import com.losrobacarros.bl.usuario.IUsuarioDao;
import com.losrobacarros.bl.usuario.cliente.IClienteDao;
import com.losrobacarros.bl.usuario.empleado.IEmpleadoDao;

public abstract  class DaoFactory {
    public static final int SQLSERVER = 1;
    // public static final int MYSQL = 2;

    public static DaoFactory getDaoFactory(int factory) {
        switch (factory) {
            case SQLSERVER:
                return new SqlServerDaoFactory();
//            case MYSQL:
//                return new MySqlDaoFactory();
            default:
                return null;
        }
    }

    public abstract IUsuarioDao getUsuarioDao();
    public abstract IEmpleadoDao getEmpleadoDao();
    public abstract IClienteDao getClienteDao();
    public abstract IParqueoDao getParqueoDao();
    public abstract IEspacioDao getEspacioDao();
    public abstract IIngresoDao getIngresoDao();


}
