package com.losrobacarros.bl.parqueo;

import com.losrobacarros.accesobd.Conector;
import com.losrobacarros.bl.dao.DaoFactory;

import javax.imageio.IIOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.TreeMap;

public class SqlServerParqueoDao implements IParqueoDao{

    public SqlServerParqueoDao() {
    }

    @Override
    public boolean registrarParqueo(String nombre, String direccion, int cantEspacios) throws SQLException, Exception {
        String sql;
        InfoParqueo infoParqueo = new InfoParqueo();
        boolean correcto = false;
        sql = "EXEC pa_registrar_parqueo '" +
                nombre + "','" +
                direccion + "'," +
                cantEspacios + "";

        try {
            Conector.getConnectorBD(DaoFactory.SQLSERVER).ejecutarSQL(sql);
            correcto = true;
            infoParqueo.setNombre(nombre);
            infoParqueo.setDireccion(direccion);
            infoParqueo.setCantEspacios(cantEspacios);
        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
            System.out.println(e.getMessage());
            correcto = false;

        }catch (Exception e) {
            System.out.println(e.getMessage());
            correcto = false;

        }
        return correcto;
    }

    @Override
    public boolean modificarParqueo(String nombre, String direccion, int cantEspacios) throws SQLException, Exception {
        InfoParqueo infoParqueo = new InfoParqueo();
        String sql;
        boolean correcto = false;
        sql = "UPDATE Parqueos SET nombre = '"+nombre+"',direccion='"+direccion+"', cantidad_espacios= "+cantEspacios;

        try {
            Conector.getConnectorBD(DaoFactory.SQLSERVER).ejecutarSQL(sql);
            correcto=true;
            infoParqueo.setNombre(nombre);
            infoParqueo.setDireccion(direccion);
            infoParqueo.setCantEspacios(cantEspacios);
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
    public TreeMap<String, Parqueo> listarParqueos() throws SQLException, Exception {
        TreeMap<String, Parqueo> parqueos = new TreeMap<>();
        String sql;
        ResultSet rs = null;
        boolean correcto = false;
        sql = "SELECT nombre, direccion, cantidad_espacios FROM Parqueos";

        try {
            rs = Conector.getConnectorBD(DaoFactory.SQLSERVER).ejecutarSQL(sql, false);

            while (rs.next()) {
                parqueos.put(rs.getString("nombre"), new Parqueo(rs.getString("nombre"), rs.getString("direccion"),
                        Integer.parseInt(rs.getString("cantidad_espacios"))));
            }
        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
            System.out.println(e.getMessage());
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            Conector.cerrarConexion();
        }
        return parqueos;
    }


    public boolean validarCantEspacios(int cantEspacios) {
        boolean noAceptado = false;
        String sql;
        ResultSet rs = null;
        try {
            sql = "SELECT top(1) cantidad_espacios FROM Parqueos";
            rs = Conector.getConnectorBD(DaoFactory.SQLSERVER).ejecutarSQL(sql, false);

            while (rs.next()) {
                if (rs.getString("cantidad_espacios").equals(cantEspacios)) {
                    noAceptado = true;
                }
            }
        }catch (SQLException e) {
            System.out.println(e.getErrorCode());
        }catch (Exception e) {
            System.out.println(e.getMessage());

        }
        return noAceptado;
    }



    public boolean validarExistenciaParqueo() throws Exception {
        InfoParqueo infoParqueo = new InfoParqueo();
        String sql;
        String sql2;
        ResultSet rs = null;
        ResultSet rs2 = null;
        boolean parqueRegistrado = false;
        sql = "SELECT id,nombre, direccion, cantidad_espacios FROM Parqueos";

        try {
            rs = Conector.getConnectorBD(DaoFactory.SQLSERVER).ejecutarSQL(sql, false);

            while (rs.next()) {
                if (rs.getString("id").equals("1")) {
                    parqueRegistrado = true;
                    new InfoParqueo(rs.getString("nombre"), rs.getString("direccion"),
                            Integer.parseInt(rs.getString("cantidad_espacios")));
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
            System.out.println(e.getMessage());
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            Conector.cerrarConexion();
        }
        return parqueRegistrado;

    }
}
