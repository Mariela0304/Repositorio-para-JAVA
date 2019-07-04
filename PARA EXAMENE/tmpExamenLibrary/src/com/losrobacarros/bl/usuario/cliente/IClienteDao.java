package com.losrobacarros.bl.usuario.cliente;


import com.losrobacarros.bl.usuario.empleado.Empleado;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.TreeMap;

public interface IClienteDao {

    public boolean registrarClienteFisico( String nombre, String apellido,
                                          String identificacion, String correo,  String direccion, String telefono,
                                          boolean estado, String nombreParqueo) throws SQLException, Exception;

    public boolean modificarClienteFisico(String nombre, String apellido,
                                          String identificacion, String correo,  String direccion, String telefono,
                                          boolean estado, String nombreParqueo) throws SQLException, Exception;

    public boolean registrarClienteJuridico(String nombre,
                                            String identificacion, String direccion,boolean estado,
                                            String nombreParqueo) throws SQLException, Exception;

    public boolean modificarClienteJuridico(String nombre,
                                            String identificacion, String direccion,boolean estado,
                                            String nombreParqueo) throws SQLException, Exception;

    public TreeMap<String, Cliente> listarClientes() throws SQLException, Exception;

    public ArrayList<String> obtenerTiposClientes() throws SQLException, Exception;

    public String[] obtenerCodigosClientes() throws SQLException, Exception;

    public ArrayList<ClienteFisico> obtenerClienteFisico(String identificacion) throws SQLException, Exception;

    public ArrayList<ClienteJuridico> obtenerClienteJuridico(String identificacion) throws SQLException, Exception;


}
