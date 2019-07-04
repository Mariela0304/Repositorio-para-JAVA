package com.losrobacarros.bl.usuario.cliente;

import com.losrobacarros.accesobd.Conector;
import com.losrobacarros.bl.dao.DaoFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.TreeMap;

public class SqlServerClienteDao implements IClienteDao {


    public SqlServerClienteDao() {
    }

    @Override
    public boolean registrarClienteFisico(String nombre, String apellido,
                                          String identificacion, String correo,  String direccion, String telefono,
                                          boolean estado, String nombreParqueo) throws SQLException, Exception {
        String sql;
        boolean correcto = false;
        int estadoUsuario = 0;
        if (estado) {
            estadoUsuario = 1;
        }


        sql = "EXEC pa_registrar_cliente_fisico 'Cliente','Cliente Físico','" +
                nombre + "','" +
                apellido + "','" +
                identificacion + "','" +
                correo + "','" +
                telefono + "','" +
                direccion + "'," +
                estadoUsuario + ",'" +
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
    public boolean modificarClienteFisico(String nombre, String apellido,
                                          String identificacion, String correo,  String direccion, String telefono,
                                          boolean estado, String nombreParqueo) throws SQLException, Exception {
        String sql;
        boolean correcto = false;
        int estadoUsuario = 0;
        if (estado) {
            estadoUsuario = 1;
        }

        sql = "EXEC pa_modificar_cliente_fisico '" +
                nombre + "','" +
                apellido + "','" +
                identificacion + "','" +
                correo + "','" +
                telefono + "','" +
                direccion + "'," +
                estadoUsuario + ",'" +
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
    public boolean registrarClienteJuridico( String nombre,
                                            String identificacion, String direccion,boolean estado,
                                            String nombreParqueo) throws SQLException, Exception {
        String sql;
        boolean correcto = false;
        int estadoUsuario = 0;
        if (estado) {
            estadoUsuario = 1;
        }

        sql = "EXEC pa_registrar_cliente_juridico 'Cliente','Cliente Jurídico','" +
                nombre + "','" +
                identificacion + "','" +
                direccion + "'," +
                estadoUsuario + ",'" +
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
    public boolean modificarClienteJuridico(String nombre,
                                            String identificacion, String direccion,boolean estado,
                                            String nombreParqueo) throws SQLException, Exception {
        String sql;
        boolean correcto = false;
        int estadoUsuario = 0;
        if (estado) {
            estadoUsuario = 1;
        }


        sql = "EXEC pa_modificar_cliente_juridico '" +
                nombre + "','" +
                identificacion + "','" +
                direccion + "'," +
                estadoUsuario + ",'" +
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
    public TreeMap<String, Cliente> listarClientes() throws SQLException, Exception {
        TreeMap<String, Cliente> clientes = new TreeMap<>();
        ArrayList<String> tiposClientes = new ArrayList<>();
        String[] codigosClientes = new String[obtenerTiposClientes().size()];
        String sql;
        ResultSet rs = null;
        ResultSet rs2 = null;
        int cont = 1;
        boolean estado = false;

        codigosClientes= obtenerCodigosClientes();

        for (String tipoCliente: obtenerTiposClientes()) {
           switch (tipoCliente) {
               case "Cliente Físico":
                   sql = "SELECT tipoUsuario, tipoCliente, nombre, apellido, identificacion, correo, codigoCliente, " +
                           "telefono, direccion, estado FROM vw_lista_clientes_fisicos WHERE "+
                           "codigoCliente =" + cont;
                   try {
                       rs = Conector.getConnectorBD(DaoFactory.SQLSERVER).ejecutarSQL(sql, false);

                       while (rs.next()) {

                           if (rs.getString("estado").equals("1")) {
                               estado = true;
                           } else if (rs.getString("estado").equals("0")){
                               estado = false;
                           }

                           clientes.put(rs.getString("identificacion"), new ClienteFisico(rs.getString("tipoUsuario"),
                                   rs.getString("tipoCliente"),
                                   rs.getString("nombre"), rs.getString("apellido"),
                                   rs.getString("identificacion"),
                                   Integer.parseInt(rs.getString("codigoCliente")),rs.getString("correo"),
                                   rs.getString("telefono"), rs.getString("direccion"), estado));
                       }
                       cont++;
                   } catch (SQLException e) {
                       System.out.println(e.getErrorCode());
                       System.out.println(e.getMessage());
                   }catch (Exception e) {
                       System.out.println(e.getMessage());
                   }

               case "Cliente Jurídico":
                   sql = "SELECT tipoUsuario, tipoCliente, nombre, identificacion,codigoCliente, " +
                           "direccion, estado FROM vw_lista_clientes_juridicos WHERE "+
                           "codigoCliente =" + cont;
                   try {
                       rs2 = Conector.getConnectorBD(DaoFactory.SQLSERVER).ejecutarSQL(sql, false);

                       while (rs2.next()) {

                           if (rs2.getString("estado").equals("1")) {
                               estado = true;
                           } else if (rs2.getString("estado").equals("0")){
                               estado = false;
                           }

                           clientes.put(rs2.getString("identificacion"),
                                   new ClienteJuridico(rs2.getString("tipoUsuario"),
                                           rs2.getString("tipoCliente"),
                                           rs2.getString("nombre"),
                                           rs2.getString("identificacion"),
                                           rs2.getString("direccion"),
                                   estado,
                                   Integer.parseInt(rs2.getString("codigoCliente"))));
                       }
                       cont++;
                   } catch (SQLException e) {
                       System.out.println(e.getErrorCode());
                       System.out.println(e.getMessage());
                   }catch (Exception e) {
                       System.out.println(e.getMessage());
                   } finally {
                       Conector.cerrarConexion();
                   }
               default:
                   System.out.println("Inexistente");
                   break;
           }
        }
        return clientes;
    }


    public ArrayList<String> obtenerTiposClientes() throws SQLException, Exception {
        ArrayList<String> tiposClientes = new ArrayList<>();
        String sql;
        ResultSet rs = null;

        sql = "SELECT tipoCliente FROM vw_lista_clientes";

        try {
            rs = Conector.getConnectorBD(DaoFactory.SQLSERVER).ejecutarSQL(sql, false);

            while (rs.next()) {
                tiposClientes.add(rs.getString("tipoCliente"));
            }

        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
            System.out.println(e.getMessage());

        }catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            rs.close();
            Conector.cerrarConexion();
        }
        return tiposClientes;
    }

    public String[] obtenerCodigosClientes() throws SQLException, Exception {
        String [] codigosClientes = new String[obtenerTiposClientes().size()];
        String sql;
        ResultSet rs = null;
        int cont = 0;
        sql = "SELECT codigoCliente FROM vw_lista_clientes";

        try {
            rs = Conector.getConnectorBD(DaoFactory.SQLSERVER).ejecutarSQL(sql, false);

            while (rs.next()) {
                codigosClientes[cont] = rs.getString("codigoCliente");
            }

        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
            System.out.println(e.getMessage());

        }catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            Conector.cerrarConexion();
        }
        return codigosClientes;
    }

    @Override
    public ArrayList<ClienteFisico> obtenerClienteFisico(String identificacion) throws SQLException, Exception {
        ArrayList<ClienteFisico> cliente= new ArrayList<>();
        String sql;
        ResultSet rs = null;
        int cont = 0;
        boolean estado = false;


            sql = "SELECT tipoUsuario, tipoCliente, nombre, apellido, identificacion, correo, codigoCliente, " +
                    "telefono, direccion, estado FROM vw_lista_clientes_fisicos WHERE  "+
                    "identificacion ='" + identificacion +"'";
            try {
                rs = Conector.getConnectorBD(DaoFactory.SQLSERVER).ejecutarSQL(sql, false);

                while (rs.next()) {

                    if (rs.getString("estado").equals("1")) {
                        estado = true;
                    } else if (rs.getString("estado").equals("0")){
                        estado = false;
                    }

                cliente.add(new ClienteFisico(rs.getString("tipoUsuario"),
                        rs.getString("tipoCliente"),
                        rs.getString("nombre"), rs.getString("apellido"),
                        rs.getString("identificacion"),
                        Integer.parseInt(rs.getString("codigoCliente")),rs.getString("correo"),
                        rs.getString("telefono"), rs.getString("direccion"), estado));
                }
                cont++;
            } catch (SQLException e) {
                System.out.println(e.getErrorCode());
                System.out.println(e.getMessage());
            }catch (Exception e) {
                System.out.println(e.getMessage());
            }
            rs.close();

        return cliente;
    }

    @Override
    public ArrayList<ClienteJuridico> obtenerClienteJuridico(String identificacion) throws SQLException, Exception {
        ArrayList<ClienteJuridico> cliente= new ArrayList<>();
        String sql;
        ResultSet rs = null;
        int cont = 0;
        boolean estado = false;


        sql = "SELECT tipoUsuario, tipoCliente, nombre, identificacion, codigoCliente, " +
                "direccion, estado FROM vw_lista_clientes WHERE  "+
                "identificacion ='" + identificacion +"'";
        try {
            rs = Conector.getConnectorBD(DaoFactory.SQLSERVER).ejecutarSQL(sql, false);

            while (rs.next()) {

                if (rs.getString("estado").equals("1")) {
                    estado = true;
                } else if (rs.getString("estado").equals("0")){
                    estado = false;
                }

                cliente.add(new ClienteJuridico(rs.getString("tipoUsuario"),
                        rs.getString("tipoCliente"),
                        rs.getString("nombre"),
                        rs.getString("identificacion"),
                         rs.getString("direccion"), estado,
                        Integer.parseInt(rs.getString("codigoCliente"))));
            }
            cont++;
        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
            System.out.println(e.getMessage());
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            Conector.cerrarConexion();
        }
        rs.close();

        return cliente;
    }

}

