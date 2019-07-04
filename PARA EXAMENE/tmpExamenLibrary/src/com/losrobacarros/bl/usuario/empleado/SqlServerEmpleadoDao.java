package com.losrobacarros.bl.usuario.empleado;

import com.losrobacarros.accesobd.Conector;
import com.losrobacarros.bl.dao.DaoFactory;
import com.losrobacarros.bl.parqueo.InfoParqueo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.TreeMap;

public class SqlServerEmpleadoDao implements IEmpleadoDao{


    @Override
    public boolean registrarEmpleado(String nombreUsuario, String contrasenna, int numEmpleado, String nombre, String apellido,
                                     String identificacion, int horaEntrada, int horaSalida, String nombreParqueo) throws SQLException, Exception {
        String sql;
        boolean correcto = false;

        sql = "EXEC pa_registrar_empleado 'Empleado','" +
                nombre + "','" +
                apellido + "','" +
                identificacion + "'," +
                numEmpleado + "," +
                horaEntrada + "," +
                horaSalida + ",'" +
                nombreUsuario + "','" +
                contrasenna + "','" +
                nombreParqueo + "'";

        try {


            Conector.getConnectorBD(DaoFactory.SQLSERVER).ejecutarSQL(sql);
            correcto = true;

        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
            System.out.println(e.getMessage());
            correcto = false;

        }catch (Exception e) {
            System.out.println(e.getMessage());
            correcto = false;

        }finally {
            Conector.cerrarConexion();
        }
        return correcto;
    }

    @Override
    public boolean modificarEmpleado(String nombreUsuario, String contrasenna, int numEmpleado, String nombre, String apellido,
                                     String identificacion, int horaEntrada, int horaSalida, String nombreParqueo) throws SQLException, Exception {
        String sql;
        boolean correcto = false;
        sql = "EXEC pa_modificar_empleado '" +
                nombre + "','" +
                apellido + "','" +
                identificacion + "'," +
                numEmpleado + "," +
                horaEntrada + "," +
                horaSalida + ",'" +
                nombreUsuario + "','" +
                contrasenna + "','" +
                nombreParqueo + "'";

        try {


            Conector.getConnectorBD(DaoFactory.SQLSERVER).ejecutarSQL(sql);
            correcto = true;

        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
            System.out.println(e.getMessage());
            correcto = false;

        }catch (Exception e) {
            System.out.println(e.getMessage());
            correcto = false;

        }finally {
            Conector.cerrarConexion();
        }
        return correcto;
    }

    @Override
    public TreeMap<String, Empleado> listarEmpleados() throws SQLException, Exception {
        TreeMap<String, Empleado> empleados = new TreeMap<>();
        String sql;
        ResultSet rs = null;
        boolean correcto = false;
        sql = "SELECT tipoUsuario, nombre, apellido, identificacion, numEmpleado, nombreUsuario, contrasenna, horaEntrada, horaSalida FROM vw_lista_empleados";

        try {
            rs = Conector.getConnectorBD(DaoFactory.SQLSERVER).ejecutarSQL(sql, false);

            while (rs.next()) {
                empleados.put(rs.getString("nombre"), new Empleado(rs.getString("tipousuario"),
                        rs.getString("nombre"), rs.getString("apellido"),
                        rs.getString("identificacion"),
                        Integer.parseInt(rs.getString("numEmpleado")), rs.getString("nombreUsuario"),
                        rs.getString("contrasenna"), Integer.parseInt(rs.getString("horaEntrada")),
                        Integer.parseInt(rs.getString("horaSalida"))));
            }
        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
            System.out.println(e.getMessage());
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            Conector.cerrarConexion();
        }
        return empleados;
    }

    @Override
    public ArrayList<Empleado> obtenerEmpleado(String identificacion) throws SQLException, Exception {
        ArrayList<Empleado> empleado = new ArrayList<>();
        String sql;
        ResultSet rs = null;
        boolean correcto = false;
        sql = "SELECT tipoUsuario, nombre, apellido, identificacion, numEmpleado, nombreUsuario, contrasenna," +
                " horaEntrada, horaSalida FROM vw_lista_empleados where identificacion = '"+identificacion+"'";

        try {
            rs = Conector.getConnectorBD(DaoFactory.SQLSERVER).ejecutarSQL(sql, false);

            while (rs.next()) {
                empleado.add(new Empleado(rs.getString("tipousuario"),
                        rs.getString("nombre"), rs.getString("apellido"),
                        rs.getString("identificacion"),
                        Integer.parseInt(rs.getString("numEmpleado")), rs.getString("nombreUsuario"),
                        rs.getString("contrasenna"), Integer.parseInt(rs.getString("horaEntrada")),
                        Integer.parseInt(rs.getString("horaSalida"))));
            }
        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
            System.out.println(e.getMessage());
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            Conector.cerrarConexion();
        }
        return empleado;
    }

}
