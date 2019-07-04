package com.losrobacarros.bl.usuario;

import com.losrobacarros.accesobd.Conector;
import com.losrobacarros.bl.dao.DaoFactory;

import java.sql.*;

public class SqlServerUsuarioDao implements IUsuarioDao {

    public SqlServerUsuarioDao() {

    }


    @Override
    public boolean validarIdentificacion(String pIdentificacion) throws SQLException, Exception {
        ResultSet rs = null;
        String sql;
        boolean repetido = false;

        sql = "SELECT [dbo].fn_validar_identificacion('" + pIdentificacion + "') as respuesta";

        try {
            rs = Conector.getConnectorBD(DaoFactory.SQLSERVER).ejecutarSQL(sql, false);
            while (rs.next()) {
                if (rs.getString("respuesta").equals("1")) {
                    repetido = true;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }  finally {
            Conector.cerrarConexion();
            rs.close();
        }


        return repetido;
    }

    @Override
    public boolean validarNombreUsuario(String nombreUsuario) throws SQLException, Exception {
        ResultSet rs = null;
        String sql;
        boolean repetido = false;

        sql = "SELECT [dbo].fn_validar_nombre_usuario('" + nombreUsuario + "') as respuesta";

        try {
            rs = Conector.getConnectorBD(DaoFactory.SQLSERVER).ejecutarSQL(sql, false);
            while (rs.next()) {
                if (rs.getString("respuesta").equals("1")) {
                    repetido = true;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }  finally {
            Conector.cerrarConexion();
            rs.close();
        }
        return repetido;
    }

    @Override
    public String validarCredenciales(String pnombreUsuario, String pcontrasenna) throws SQLException {
        String respuestaInicio = "";
        String sql;
        ResultSet rs = null;

        sql = "SELECT [dbo].fn_validar_credenciales('" + pnombreUsuario + "','" + pcontrasenna + "') AS respuesta ";

        try {
            rs = Conector.getConnectorBD(DaoFactory.SQLSERVER).ejecutarSQL(sql, false);

            while (rs.next()) {
                respuestaInicio = rs.getString("respuesta");
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            rs.close();
            Conector.cerrarConexion();
        }
        return respuestaInicio;
    }

    @Override
    public boolean validarCorreo(String correo) throws SQLException, Exception {
        ResultSet rs = null;
        String sql;
        boolean repetido = false;

        sql = "SELECT [dbo].fn_validar_correo('" + correo + "') as respuesta";

        try {
            rs = Conector.getConnectorBD(DaoFactory.SQLSERVER).ejecutarSQL(sql, false);
            while (rs.next()) {
                if (rs.getString("respuesta").equals("1")) {
                    repetido = true;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }  finally {
            Conector.cerrarConexion();
            rs.close();
        }
        return repetido;
    }


    public boolean validarNumEmpleado(int numEmpleado) throws SQLException, Exception {
        ResultSet rs = null;
        String sql;
        boolean repetido = false;

        sql = "SELECT COUNT(numEmpleado) as respuesta FROM Empleados WHERE numEmpleado = " + numEmpleado;

        try {
            rs = Conector.getConnectorBD(DaoFactory.SQLSERVER).ejecutarSQL(sql, false);
            while (rs.next()) {
                if (rs.getString("respuesta").equals("1")) {
                    repetido = true;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            Conector.cerrarConexion();
            rs.close();
        }
        return repetido;
    }




    public boolean validaciones(String pnumero) {
        try {
            Integer.parseInt(pnumero);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }
}