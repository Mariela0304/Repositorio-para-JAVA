package bonilla.mariela.dl;

import bonilla.mariela.accesobd.*;
import bonilla.mariela.bl.item.Item;
import bonilla.mariela.bl.oferta.Oferta;
import bonilla.mariela.bl.ordencompra.OrdenCompra;
import bonilla.mariela.bl.subasta.Subasta;
import bonilla.mariela.bl.usuario.Coleccionista;
import bonilla.mariela.bl.usuario.Moderador;
import bonilla.mariela.bl.usuario.Usuario;
import bonilla.mariela.bl.usuario.Vendedor;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.TreeMap;

public class CL {

    /*private TreeMap<String, Usuario> usuarios;

     */
    private TreeMap<String, Subasta> subastas;
    private TreeMap<String, Item> items;
    private TreeMap<String, Oferta> ofertas;
    private TreeMap<String, OrdenCompra> ordenesCompra;


//    public TreeMap<String, Usuario> getUsuarios() {
//        return usuarios;
//    }

    public TreeMap<String, Usuario> listasDeUsuarios() throws SQLException{
        TreeMap<String, Usuario> listusuarios = new TreeMap<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        ResultSet rs2 = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            int cont = 0;
            Statement stmt2 = null;
            ArrayList<String> tiposUsuario;
            Usuario tmpUsuario;

            String connectionUrl = "jdbc:sqlserver://MARIELABONILLA3;DatabaseName=CollectorsBazarBD;user=MarielaBonilla;password=1234";
            //String connectionUrl = "jdbc:sqlserver://MARIELABONILLA3;DatabaseName=laboratorio;user=sa;password=123456";
            conn = DriverManager.getConnection(connectionUrl);
            stmt = conn.createStatement();

            tiposUsuario = obtenerTiposUsuarios();

            for (String tipo : tiposUsuario) {
                cont++;
                if (tipo.equals("Coleccionista")) {
                    rs = stmt.executeQuery("SELECT tipoUsuario, nombre, tipoID, identificacion, " +
                            "fechaNacimiento, edad," +
                            " correo," +
                            " provincia, canton, " +
                            "distrito, direccion, puntuacion, estado " +
                            "FROM vw_lista_coleccionistas where posicion="+cont);

                    while (rs.next()) {
                        tmpUsuario = new Coleccionista(rs.getString("estado"),rs.getString("tipoUsuario"),
                                rs.getString("nombre"), rs.getString("tipoID"), rs.getString("identificacion"),
                                LocalDate.parse(rs.getString("fechaNacimiento")),
                                Integer.parseInt(rs.getString("edad")),
                                rs.getString("correo"), rs.getString("provincia"),
                                rs.getString("canton"), rs.getString("distrito"),
                                rs.getString("direccion"),
                                Double.parseDouble(rs.getString("puntuacion")));


                        listusuarios.put(rs.getString("identificacion"), tmpUsuario);
                    }
                }

                if (tipo.equals("Vendedor")) {
                    rs2 = stmt.executeQuery("SELECT tipoUsuario, nombre, tipoID,identificacion, " +
                            "fechaNacimiento, edad," +
                            " correo," +
                            " provincia, canton, " +
                            "distrito, direccion, puntuacion , estado" +
                            "FROM vw_lista_vendedores where posicion="+cont);

                    Vendedor tmpVendedor;
                    while (rs2.next()) {

                        tmpVendedor = new Vendedor(rs2.getString("estado"),
                                rs2.getString("tipoUsuario"),
                                rs2.getString("nombre"), rs2.getString("tipoID"),
                                rs2.getString("identificacion"),
                                LocalDate.parse(rs2.getString("fechaNacimiento")),
                                Integer.parseInt(rs2.getString("edad")),
                                rs2.getString("correo"), rs2.getString("provincia"),
                                rs2.getString("canton"), rs2.getString("distrito"),
                                rs2.getString("direccion"),
                                Double.parseDouble(rs2.getString("puntuacion")));

                        tmpUsuario = (Usuario) tmpVendedor;


                        listusuarios.put(rs2.getString("identificacion"), tmpUsuario);
                    }
                }
            }


        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }finally {

            rs.close();
            rs2.close();
            conn.close();
        }

        return listusuarios;
    }

    public TreeMap<String, Subasta> getSubastas() {
        return subastas;
    }

    public TreeMap<String, Item> getItems() {
        return items;
    }

    public TreeMap<String, Oferta> getOfertas() {
        return ofertas;
    }

    public TreeMap<String, OrdenCompra> getOrdenesCompra() {
        return ordenesCompra;
    }


    public boolean registrarColeccionista(Coleccionista tmpColeccionista) throws SQLException{
        boolean registroCorrecto = false;
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            String connectionUrl = "jdbc:sqlserver://MARIELABONILLA3;DatabaseName=CollectorsBazarBD;user=MarielaBonilla;password=1234";
            //String connectionUrl = "jdbc:sqlserver://MARIELABONILLA3;DatabaseName=laboratorio;user=sa;password=123456";
            conn = DriverManager.getConnection(connectionUrl);
            stmt = conn.createStatement();
            stmt.executeQuery("EXEC pa_registrar_coleccionista '" +
                    tmpColeccionista.getTipoUsuario() + "','" + tmpColeccionista.getNombre() + "','" +
                    tmpColeccionista.getTipoIdentificacion()+ "','" +
                    tmpColeccionista.getIdentificacion() + "','" +
                    tmpColeccionista.getFechaNacimiento() + "','" +
                    tmpColeccionista.getEdad() + "','" +
                    tmpColeccionista.getCorreo() + "','" +
                    tmpColeccionista.getContrasenna() + "','" + tmpColeccionista.getProvincia() + "','" +
                    tmpColeccionista.getCanton() + "','" + tmpColeccionista.getDistrito() + "','" +
                    tmpColeccionista.getDireccion() + "','" + tmpColeccionista.getIntereses().toString() + "'");

            registroCorrecto = true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            registroCorrecto = false;
        } finally {
            rs.close();
            conn.close();
        }
        return registroCorrecto;
    }

    public boolean registrarVendedor(Vendedor tmpVendedor) throws SQLException{
        boolean registroCorrecto = false;
        Connection conn = null;

        try {


            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Statement stmt = null;


            String connectionUrl = "jdbc:sqlserver://MARIELABONILLA3;DatabaseName=CollectorsBazarBD;user=MarielaBonilla;password=1234";
            //String connectionUrl = "jdbc:sqlserver://MARIELABONILLA3;DatabaseName=laboratorio;user=sa;password=123456";
            conn = DriverManager.getConnection(connectionUrl);
            stmt = conn.createStatement();
            stmt.executeQuery("EXEC pa_registrar_vendedor '" +
                    tmpVendedor.getTipoUsuario() + "','" + tmpVendedor.getNombre() + "','" +
                    tmpVendedor.getTipoIdentificacion()+ "','" +
                    tmpVendedor.getIdentificacion() + "','" +
                    tmpVendedor.getFechaNacimiento() + "','" +
                    tmpVendedor.getEdad() + "','" +
                    tmpVendedor.getCorreo() + "','" +
                    tmpVendedor.getContrasenna() + "','" + tmpVendedor.getProvincia() + "','" +
                    tmpVendedor.getCanton() + "','" + tmpVendedor.getDistrito() + "','" +
                    tmpVendedor.getDireccion() + "'");

            registroCorrecto = true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            registroCorrecto = false;
        }finally {
            conn.close();
        }
        return registroCorrecto;
    }

    public void registrarSubasta(Subasta tmpSubasta) {
        subastas.put(Integer.toString(tmpSubasta.getId()), tmpSubasta);
    }


    public void registrarOferta(Oferta tmpOferta) {
        ofertas.put(tmpOferta.getNomOferente(), tmpOferta);
    }

    public void crearOrdenCompra(OrdenCompra tmpOrdenCompra) {
        ordenesCompra.put(tmpOrdenCompra.getNomGanador(), tmpOrdenCompra);
    }


    /*
    Métodos que va a permitir modificar el usuario
     */

    //FALTAAAAA
    public boolean modificarVendedor(Vendedor tmpVendedor) throws SQLException{
        boolean registroCorrecto = false;
        Connection conn = null;

        try {


            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Statement stmt = null;


            String connectionUrl = "jdbc:sqlserver://MARIELABONILLA3;DatabaseName=CollectorsBazarBD;user=MarielaBonilla;password=1234";
            //String connectionUrl = "jdbc:sqlserver://MARIELABONILLA3;DatabaseName=laboratorio;user=sa;password=123456";
            conn = DriverManager.getConnection(connectionUrl);
            stmt = conn.createStatement();
            stmt.executeQuery("EXEC pa_modificar_vendedor '" +
                     tmpVendedor.getNombre() + "','" +
                    tmpVendedor.getFechaNacimiento() + "','" +
                    tmpVendedor.getEdad() + "','" +
                    tmpVendedor.getCorreo() + "','" +
                    tmpVendedor.getContrasenna() + "','" + tmpVendedor.getProvincia() + "','" +
                    tmpVendedor.getCanton() + "','" + tmpVendedor.getDistrito() + "','" +
                    tmpVendedor.getDireccion() + "'");

            registroCorrecto = true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            registroCorrecto = false;
        }finally {
            conn.close();
        }
        return registroCorrecto;
    }

    /*
    Método donde se validan las credenciales para poder iniciar sesión
     */

    public String validarCredenciales(String pcorreo, String pcontrasenna) throws SQLException {
        String respuestaInicio = "";
        ResultSet rs = null;
        Connection conn = null;

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Statement stmt = null;

            Usuario tmpUsuario;

            String connectionUrl = "jdbc:sqlserver://MARIELABONILLA3;DatabaseName=CollectorsBazarBD;user=MarielaBonilla;password=1234";
            //String connectionUrl = "jdbc:sqlserver://MARIELABONILLA3;DatabaseName=laboratorio;user=sa;password=123456";
            conn = DriverManager.getConnection(connectionUrl);
            stmt = conn.createStatement();

            rs = stmt.executeQuery
                    ("SELECT [dbo].fn_validar_credenciales('"+pcorreo+"','"+ pcontrasenna+"') AS respuesta ");

            while (rs.next()) {
                respuestaInicio = rs.getString("respuesta");
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }finally {
            rs.close();
            conn.close();
        }

       return respuestaInicio;
    }


    /*
    Método para verificar que la identificación ingresada no está repetida
     */
    public boolean validarIdentificacion(String pidentificacion) throws SQLException {
        boolean repetido = false;
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            Usuario tmpUsuario;

            String connectionUrl = "jdbc:sqlserver://MARIELABONILLA3;DatabaseName=CollectorsBazarBD;user=MarielaBonilla;password=1234";
            //String connectionUrl = "jdbc:sqlserver://MARIELABONILLA3;DatabaseName=laboratorio;user=sa;password=123456";
            conn = DriverManager.getConnection(connectionUrl);
            stmt = conn.createStatement();

            rs = stmt.executeQuery
                    ("SELECT [dbo].fn_validar_identificacion('"+pidentificacion+"') as respuesta");

           while (rs.next()) {
               if(rs.getString("respuesta").equals("1")) {
                   repetido = true;
               }
           }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }finally {
            rs.close();
            conn.close();
        }
        return repetido;
    }


    /*
    Método que verifica que no haya otro correo similar
     */

    public boolean validarCorreo(String pcorreo) throws SQLException {
        boolean repetido = false;
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null; try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            Usuario tmpUsuario;

            String connectionUrl = "jdbc:sqlserver://MARIELABONILLA3;DatabaseName=CollectorsBazarBD;user=MarielaBonilla;password=1234";
            //String connectionUrl = "jdbc:sqlserver://MARIELABONILLA3;DatabaseName=laboratorio;user=sa;password=123456";
            conn = DriverManager.getConnection(connectionUrl);
            stmt = conn.createStatement();

            rs = stmt.executeQuery
                    ("SELECT [dbo].fn_validar_correo('"+pcorreo+"') as respuesta");
                if(rs.getString("respuesta").equals("1")) {
                    repetido = true;
                }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        finally {
            rs.close();
            conn.close();
        }
        return repetido;
    }


     /*
    Método que va a validar si es coleccionista o vendedor para que pueda hacer la subasta

    Debe mejorse
     */

    public boolean validarSubastador(String identificacion) {
        boolean coleccionista = false;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = null;
            Statement stmt = null;
            ResultSet rs = null;
            Statement stmt2 = null;
            ResultSet rs2 = null;
            Usuario tmpUsuario;

            String connectionUrl = "jdbc:sqlserver://MARIELABONILLA3;DatabaseName=CollectorsBazarBD;user=MarielaBonilla;password=1234";
            //String connectionUrl = "jdbc:sqlserver://MARIELABONILLA3;DatabaseName=laboratorio;user=sa;password=123456";
            conn = DriverManager.getConnection(connectionUrl);
            stmt = conn.createStatement();

            rs = stmt.executeQuery
                    ("SELECT identificacion " +
                            "FROM vw_lista_usuarios ");

            while (rs.next()) {
                if(rs.getString("identificacion").equals(identificacion)) {
                    for (String dato: obtenerTiposUsuarios()) {
                        if (dato.equals("Coleccionista") ){
                            coleccionista = true;
                        } else if ( dato.equals("Vendedor")) {
                            coleccionista = true;
                        }
                    }
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return coleccionista;
    }

//
//    /*
//    Método que va a validar si el que realiza la subasta es coleccionista
//
//    debe mejorarse
//     */
//
//    public boolean validarColeccionista(String identificacion) {
//        boolean coleccionista = false;
//        for (Usuario dato: getUsuarios().values()) {
//            if (dato.getIdentificacion().equals(identificacion)) {
//                if (dato.getTipoUsuario().equals("Coleccionista")) {
//                    coleccionista = true;
//                }
//            }
//        }
//        return coleccionista;
//    }
//
//    /*
//    Método que va a validar que el oferente no sea el mismo que realizó la subasta
//
//    Mejorarse
//     */
//
//    public boolean validarOferente() {
//        boolean creadorSubasta = false;
//        for (Subasta dato: getSubastas().values()) {
//            if (dato.getColeccionista() == true) {
//                dato.getNomVendedor().equals("");
//                creadorSubasta = true;
//            }
//        }
//        return creadorSubasta;
//    }
//
//
//
//
//    /*
//    Valida que ya haya un moderador registrado
//        Mejorarse
//
//     */
//
//    public boolean validarModerador() {
//        boolean existente = false;
//
//        for (Usuario dato:getUsuarios().values()) {
//            if (dato.getTipoUsuario().equals("Moderador")) {
//                existente = true;
//            }
//        }
//        return existente;
//    }


/*
    Metodo que va a obtener el tipo de usuario de todos los usuarios
     */
    public ArrayList<String> obtenerTiposUsuarios() throws SQLException {
        ArrayList<String> tiposUsuario = new ArrayList<>();
        Connection conn = null;
        ResultSet rs = null;

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Statement stmt = null;
            Usuario tmpUsuario;

            String connectionUrl = "jdbc:sqlserver://MARIELABONILLA3;DatabaseName=CollectorsBazarBD;user=MarielaBonilla;password=1234";
            //String connectionUrl = "jdbc:sqlserver://MARIELABONILLA3;DatabaseName=laboratorio;user=sa;password=123456";
            conn = DriverManager.getConnection(connectionUrl);
            stmt = conn.createStatement();

            rs = stmt.executeQuery
                    ("SELECT tipoUsuario " +
                            "FROM usuarios ");

            while (rs.next()) {
                tiposUsuario.add(rs.getString("tipoUsuario"));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            rs.close();
            conn.close();
        }

        return tiposUsuario;
    }


    public void buscarUsuario(String correo) throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            Usuario tmpUsuario;

            String connectionUrl = "jdbc:sqlserver://MARIELABONILLA3;DatabaseName=CollectorsBazarBD;user=MarielaBonilla;password=1234";
            //String connectionUrl = "jdbc:sqlserver://MARIELABONILLA3;DatabaseName=laboratorio;user=sa;password=123456";
            conn = DriverManager.getConnection(connectionUrl);
            stmt = conn.createStatement();

            rs = stmt.executeQuery
                    ("SELECT tipoUsuario, nombre, tipoID, identificacion, " +
                            "fechaNacimiento, edad," +
                            " correo," +
                            " provincia, canton, " +
                            "distrito, direccion, puntuacion, estado " +
                            "FROM vw_lista_coleccionistas");

            while (rs.next()) {

            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }finally {
            rs.close();
            conn.close();
        }


    }

    /*
    Metodo que va a obtener el tipo de usuario de un usuario
     */
    public String obtenerTipoUsuario(String correo) throws SQLException {
            String tipoUsuario = "";
            Connection conn = null;
            Statement stmt = null;
            ResultSet rs = null;
            Usuario tmpUsuario;
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");


                String connectionUrl = "jdbc:sqlserver://MARIELABONILLA3;DatabaseName=CollectorsBazarBD;user=MarielaBonilla;password=1234";
                //String connectionUrl = "jdbc:sqlserver://MARIELABONILLA3;DatabaseName=laboratorio;user=sa;password=123456";
                conn = DriverManager.getConnection(connectionUrl);
                stmt = conn.createStatement();

                rs = stmt.executeQuery
                        ("SELECT tipoUsuario FROM vw_lista_usuarios where correo = '" + correo + "'");

                while (rs.next()) {
                    tipoUsuario = rs.getString("tipoUsuario");
                }
            } catch (SQLException e) {
                System.out.println(e.getErrorCode());
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            } finally {
                rs.close();
                conn.close();
            }
            return tipoUsuario;
        }


        /*
        Métodos donde llamo la información de un usuario
         */


    /*
    Obtener el estado del usuario
     */
    public String obtenerEstado(String correo) throws SQLException {
        String estado = "";
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        Usuario tmpUsuario;
        Conector con;

        try {

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            String connectionUrl = "jdbc:sqlserver://MARIELABONILLA3;DatabaseName=CollectorsBazarBD;user=MarielaBonilla;password=1234";
            //String connectionUrl = "jdbc:sqlserver://MARIELABONILLA3;DatabaseName=laboratorio;user=sa;password=123456";
            conn = DriverManager.getConnection(connectionUrl);
            stmt = conn.createStatement();

            rs = stmt.executeQuery
                    ("SELECT estado FROM vw_lista_usuarios where correo = '" + correo + "'");

            while (rs.next()) {
                estado = rs.getString("estado");
            }
        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            rs.close();
            conn.close();
        }
        return estado;
    }

}
