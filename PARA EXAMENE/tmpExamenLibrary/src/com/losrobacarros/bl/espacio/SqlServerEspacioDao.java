package com.losrobacarros.bl.espacio;

import com.losrobacarros.accesobd.Conector;

import com.losrobacarros.bl.dao.DaoFactory;
import com.losrobacarros.bl.usuario.empleado.Empleado;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.TreeMap;

public class SqlServerEspacioDao implements IEspacioDao {

    public SqlServerEspacioDao() {
    }


    @Override
    public boolean registrarEspacio(String tipoVehiculo, int numEspacio, String nombreParqueo) throws SQLException, Exception {
        String sql;
        boolean correcto = false;
        sql = "EXEC pa_registrar_espacio '" +
                tipoVehiculo + "'," +
                numEspacio + ",'" +
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

        }
        return correcto;
    }

    @Override
    public boolean modificarEspacio(String tipoVehiculo, int numEspacio, String nombreParqueo) throws SQLException, Exception {
        String sql;
        boolean correcto = false;

        sql = "SELECT pa_registrar_espacio '" +
                tipoVehiculo + "'," +
                numEspacio + ",'" +
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

        } finally {
            Conector.cerrarConexion();

        }
        return correcto;
    }

    @Override
    public TreeMap<String, Espacio> listarEspacios() throws SQLException, Exception {
        TreeMap<String, Espacio> espacios = new TreeMap<>();
        String sql;
        ResultSet rs = null;
        boolean ocupado = false;
        sql = "SELECT tipoVehiculo, numEspacio, ocupado as estado FROM Espacios";

        try {
            rs = Conector.getConnectorBD(DaoFactory.SQLSERVER).ejecutarSQL(sql, false);

            while (rs.next()) {

                if (rs.getString("estado").equals("1")) {
                    ocupado = true;
                } else if (rs.getString("estado").equals("0")){
                    ocupado = true;

                }

                espacios.put(rs.getString("numEspacio"), new Espacio(rs.getString("tipoVehiculo"),
                        Integer.parseInt(rs.getString("numEspacio")), ocupado));
            }
        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
            System.out.println(e.getMessage());
        }catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            Conector.cerrarConexion();
            rs.close();
        }
        return espacios;
    }



    public boolean validarNumEspacio(int numEspacio) throws SQLException {
        boolean repetido = false;

        String sql;
        ResultSet rs = null;
        try {
            sql = "SELECT COUNT(numEspacio) FROM Espacios where numEspacio="+numEspacio+"as espacios";
            rs = Conector.getConnectorBD(DaoFactory.SQLSERVER).ejecutarSQL(sql, false);

            while (rs.next()) {
                if (rs.getString("espacios").equals(1)) {
                    repetido = true;
                }
            }
        }catch (SQLException e) {
            System.out.println(e.getErrorCode());
        }catch (Exception e) {
            System.out.println(e.getMessage());

        } finally {
            Conector.cerrarConexion();
            rs.close();
        }
        return repetido;
    }

    @Override
    public boolean validarPlacaEspacio(String numPlaca) throws SQLException, Exception {

        boolean repetido = false;

        String sql;
        ResultSet rs = null;
        try {
            sql = "SELECT COUNT(numPlaca) FROM Espacio_Ingreso where numPlaca='"+numPlaca+"' as placa";
            rs = Conector.getConnectorBD(DaoFactory.SQLSERVER).ejecutarSQL(sql, false);

            while (rs.next()) {
                if (rs.getString("placa").equals(1)) {
                    repetido = true;
                }
            }
        }catch (SQLException e) {
            System.out.println(e.getErrorCode());
        }catch (Exception e) {
            System.out.println(e.getMessage());

        } finally {
            Conector.cerrarConexion();
            rs.close();
        }
        return repetido;
    }


    @Override
    public boolean validarEstadoEspacio(int numEspacio) throws SQLException, Exception {

        boolean ocupado = false;

        String sql;
        ResultSet rs = null;
        try {
            sql = "SELECT ocupado FROM Espacios where numEspacio="+numEspacio+" as estado";
            rs = Conector.getConnectorBD(DaoFactory.SQLSERVER).ejecutarSQL(sql, false);

            while (rs.next()) {
                if (rs.getString("estado").equals(1)) {
                    ocupado = true;
                }
            }
        }catch (SQLException e) {
            System.out.println(e.getErrorCode());
        }catch (Exception e) {
            System.out.println(e.getMessage());

        } finally {
            Conector.cerrarConexion();
            rs.close();
        }
        return ocupado;
    }




    @Override
    public ArrayList<Espacio> obtenerEspacio(int numEspacio) throws SQLException, Exception {
        ArrayList<Espacio> espacio = new ArrayList<>();
        String sql;
        ResultSet rs = null;
        boolean correcto = false;
        boolean ocupado = false;
        sql = "SELECT tipoVehiculo, numEspacio, ocupado as estado FROM Espacios where numEspacio = "+numEspacio;

        try {
            rs = Conector.getConnectorBD(DaoFactory.SQLSERVER).ejecutarSQL(sql, false);

            while (rs.next()) {

                if (rs.getString("estado").equals("1")) {
                    ocupado = true;
                } else if (rs.getString("estado").equals("0")){
                    ocupado = true;

                }

                espacio.add(new Espacio(rs.getString("tipoVehiculo"),
                        Integer.parseInt(rs.getString("numEspacio")), ocupado));
            }
        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
            System.out.println(e.getMessage());
        }catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            Conector.cerrarConexion();
            rs.close();
        }
        return espacio;
    }

}

