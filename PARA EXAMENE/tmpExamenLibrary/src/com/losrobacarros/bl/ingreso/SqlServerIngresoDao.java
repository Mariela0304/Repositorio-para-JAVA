package com.losrobacarros.bl.ingreso;

import com.losrobacarros.accesobd.Conector;
import com.losrobacarros.bl.dao.DaoFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.TreeMap;

public class SqlServerIngresoDao implements IIngresoDao {

    public SqlServerIngresoDao() {
    }

    @Override
    public boolean registrarIngreso(String nombreParqueo, String numPlaca,
                                    int numEspacio, int horaEntrada) throws SQLException, Exception {
        String sql;
        boolean correcto = false;



        sql = "EXEC pa_registrar_ingreso '" +
                nombreParqueo + "','" +
                numPlaca + "'," +
                numEspacio + "," +
                horaEntrada;

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
    public boolean registrarSalida(String nombreParqueo, String numPlaca, int numEspacio,
                                   int horaSalida, double tarifaFinal) throws SQLException, Exception {
        String sql;
        boolean correcto = false;



        sql = "EXEC pa_registrar_salida '" +
                nombreParqueo + "','" +
                numPlaca + "'," +
                numEspacio + "," +
                horaSalida + "," +
                tarifaFinal;

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
    public TreeMap<String, Ingreso> listarIngresos() throws SQLException, Exception {
        TreeMap<String, Ingreso> ingresos = new TreeMap<>();
        String sql;
        ResultSet rs = null;
        boolean correcto = false;
        sql = "SELECT id, espacioDado, numPlaca, horaIngreso, horaSalida, tarifaFinal FROM Ingresos";

        try {
            rs = Conector.getConnectorBD(DaoFactory.SQLSERVER).ejecutarSQL(sql, false);

            while (rs.next()) {
                ingresos.put(rs.getString("id"), new Ingreso(
                        Integer.parseInt(rs.getString("id")),
                        Integer.parseInt(rs.getString("espacioDado")),
                        rs.getString("numPlaca"),
                        Integer.parseInt(rs.getString("horaEntrada")),
                        Integer.parseInt(rs.getString("horaSalida")),
                        Double.parseDouble(rs.getString("tarifaFinal"))));
            }
        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
            System.out.println(e.getMessage());
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            Conector.cerrarConexion();
        }
        return ingresos;
    }

    @Override
    public boolean validarNumPlaca(String numPlaca, int numEspacio) throws SQLException, Exception {
        String sql;
        ResultSet rs = null;
        boolean encontrado = false;
        sql = "SELECT COUNT(numPlaca) as total FROM Ingresos WHERE numPlaca ='"+numPlaca+"' AND espacioDado = "+numEspacio;


        try {
            rs = Conector.getConnectorBD(DaoFactory.SQLSERVER).ejecutarSQL(sql, false);

            while (rs.next()) {
                if (rs.getString("total").equals("1")) {
                    encontrado = true;
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

        return encontrado;
    }

    @Override
    public int obtenerHoraEntrada(String numPlaca, int numEspacio) throws SQLException, Exception {
        int hora = 0;
        String sql;
        ResultSet rs = null;
        boolean encontrado = false;
        sql = "SELECT horaEntrada as hora FROM Ingresos WHERE numPlaca ='"+numPlaca+"' AND espacioDado = "+numEspacio;


        try {
            rs = Conector.getConnectorBD(DaoFactory.SQLSERVER).ejecutarSQL(sql, false);

            while (rs.next()) {
               hora = Integer.parseInt(rs.getString("hora"));
            }
        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
            System.out.println(e.getMessage());
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            Conector.cerrarConexion();
        }

        return hora;
    }

    @Override
    public int obtenerEspacioPlaca(String numPlaca) throws SQLException, Exception {
        int numEspacio = 0;
        String sql;
        ResultSet rs = null;
        boolean encontrado = false;
        sql = "SELECT numEspacio as espacio FROM Espacio_Ingreso WHERE numPlaca ='"+numPlaca+"'";


        try {
            rs = Conector.getConnectorBD(DaoFactory.SQLSERVER).ejecutarSQL(sql, false);

            while (rs.next()) {
                numEspacio = Integer.parseInt(rs.getString("espacio"));
            }
        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
            System.out.println(e.getMessage());
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            Conector.cerrarConexion();
        }

        return numEspacio;
    }
}
