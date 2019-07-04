package com.losrobacarros.bl.usuario;

import com.losrobacarros.bl.usuario.empleado.Empleado;

import java.sql.SQLException;
import java.util.TreeMap;

public interface IUsuarioDao {

    public boolean validarIdentificacion(String identificacion) throws SQLException, Exception;

    public boolean validarNombreUsuario(String nombreUsuario) throws SQLException, Exception;

    public String validarCredenciales(String nombreUsuario, String contrasenna) throws SQLException, Exception;

    public boolean validarCorreo(String correo) throws SQLException, Exception;

    public boolean validarNumEmpleado(int numEmpleado) throws SQLException, Exception;


    public boolean validaciones(String pnumero);



}
