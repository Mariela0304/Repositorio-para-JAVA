package com.losrobacarros.bl.usuario.empleado;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.TreeMap;

public interface IEmpleadoDao {

    public boolean registrarEmpleado(String nombreUsuario, String contrasenna, int numEmpleado,
                                     String nombre, String apellido, String identificacion,
                                     int horaEntrada, int horaSalida, String nombreParqueo) throws SQLException, Exception;

    public boolean modificarEmpleado(String nombreUsuario, String contrasenna, int numEmpleado,
                                     String nombre, String apellido, String identificacion,
                                     int horaEntrada, int horaSalida,String nombreParqueo) throws SQLException, Exception;


    public TreeMap<String, Empleado> listarEmpleados() throws SQLException, Exception;


    public ArrayList<Empleado> obtenerEmpleado(String identificacion) throws SQLException, Exception;

}
