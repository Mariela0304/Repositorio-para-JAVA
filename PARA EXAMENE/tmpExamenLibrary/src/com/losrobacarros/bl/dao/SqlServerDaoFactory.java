package com.losrobacarros.bl.dao;

import com.losrobacarros.bl.espacio.IEspacioDao;
import com.losrobacarros.bl.espacio.SqlServerEspacioDao;
import com.losrobacarros.bl.ingreso.IIngresoDao;
import com.losrobacarros.bl.ingreso.SqlServerIngresoDao;
import com.losrobacarros.bl.parqueo.IParqueoDao;
import com.losrobacarros.bl.parqueo.SqlServerParqueoDao;
import com.losrobacarros.bl.usuario.IUsuarioDao;
import com.losrobacarros.bl.usuario.SqlServerUsuarioDao;
import com.losrobacarros.bl.usuario.cliente.IClienteDao;
import com.losrobacarros.bl.usuario.cliente.SqlServerClienteDao;
import com.losrobacarros.bl.usuario.empleado.IEmpleadoDao;
import com.losrobacarros.bl.usuario.empleado.SqlServerEmpleadoDao;

public class SqlServerDaoFactory extends DaoFactory {

    public SqlServerDaoFactory() {
    }

    public IUsuarioDao getUsuarioDao() {
        return new SqlServerUsuarioDao();
    }

    @Override
    public IEmpleadoDao getEmpleadoDao() {
        return new SqlServerEmpleadoDao();
    }

    public IClienteDao getClienteDao() {
        return new SqlServerClienteDao();
    }

    @Override
    public IParqueoDao getParqueoDao() {
        return new SqlServerParqueoDao();
    }

    @Override
    public IEspacioDao getEspacioDao() {
        return new SqlServerEspacioDao();
    }

    @Override
    public IIngresoDao getIngresoDao() {
        return new SqlServerIngresoDao();
    }


}
