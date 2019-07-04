package cr.ac.ucenfotec;/*

NOTA: PARA LOS QUE USAN SQL SERVER ESTO ES LO QUE DEBEN HACER SI VAN A USAR AUTENTICACIÓN INTEGRADA

1. DESCARGAR EL DIRVER Y DESOOMPRIMIRLO. ESTO LES CREARÁ UNA CARPETA Microsoft JDBC Driver 6.0 for SQL Server
2. DEBER IR A LA CARPETA \sqljdbc_6.0\enu\auth\x64, SI USA 64 BITS O X86 EN CASO CONTRARIO.
3. DEBE TOMAR LA DLL sqljdbc_auth.dll Y COPIARLA EN LA CARPETA BIN UBICADA EN EL DIRECTORIO
DONDE ESTÁ INTALADO JAVA, POR LO GENERAL
   C:\Program Files\Java\jdk1.8.0_92\bin.
4. LUEGO DEBE CERRAR EL IDE RESPECTIVO Y VOLVERLO A INICIAL.
 */

import java.sql.*;
import java.util.ArrayList;
import java.io.*;
import java.util.*;

public class JDBCExample{
    static BufferedReader entrada = new BufferedReader(
            new InputStreamReader(System.in));
    static PrintStream salida = System.out;    public static void main (String args[]) {
        try {
            //sqlServer();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    public static void MySql()
    {
       try {
            // The newInstance() call is a work around for some
            // broken Java implementations

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn = null;
            Statement stmt = null;
            ResultSet rs = null;

            conn = DriverManager.getConnection("jdbc:mysql://localhost/laboratorio?" +
                    "user=root&password=root");
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM personas");
            while(rs.next())
            {
                System.out.println(rs.getString("nombre"));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public  static void sqlServer() throws IOException
    {
        try {
            // The newInstance() call is a work around for some
            // broken Java implementations

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = null;
            Statement stmt = null;
            ResultSet rs = null;

    String connectionUrl = "jdbc:sqlserver://MARIELABONILLA3;DatabaseName=laboratorio;integratedsecurity = true";
            //String connectionUrl = "jdbc:sqlserver://MARIELABONILLA3;DatabaseName=laboratorio;user=sa;password=123456";
            conn = DriverManager.getConnection(connectionUrl);
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM personas");
            while(rs.next())
            {
                System.out.println(rs.getString("nombre"));
                System.out.println(rs.getString("apellido"));
                System.out.println(rs.getString("cedula"));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        insertar();
    }

    public static void insertar() throws IOException {

        String nombre;
        String apellido;
        String cedula ;

            System.out.println("Ingrese su nombre");
            nombre= entrada.readLine();
            System.out.println("Ingrese su apellido");
            apellido= entrada.readLine();
            System.out.println("Ingrese su cedula");
            cedula = entrada.readLine();
        try {
            // The newInstance() call is a work around for some
            // broken Java implementations

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = null;
            Statement stmt = null;


            String connectionUrl = "jdbc:sqlserver://MARIELABONILLA3;DatabaseName=laboratorio;integratedsecurity = true";
            //String connectionUrl = "jdbc:sqlserver://MARIELABONILLA3;DatabaseName=laboratorio;user=sa;password=123456";
            conn = DriverManager.getConnection(connectionUrl);
            stmt = conn.createStatement();
            //rs = stmt.executeQuery("SELECT * FROM personas");
          //  stmt.execute("INSERT INTO personas(nombre, apellido, cedula) VALUES"+"('" + nombre + "','" + apellido + "','" + cedula + "')" );
            stmt.execute("EXEC pa_registrar_persona"+"'" + nombre + "','" + apellido + "','" + cedula + "'" );

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    modificar();
    }

    public static void modificar() throws IOException {
        String nombre;
        String apellido;
        String cedula;

//        System.out.println("Ingrese el nuevo nombre");
//        nombre= entrada.readLine();
//        System.out.println("Ingrese el nuevo apellido");
//        apellido= entrada.readLine();
        System.out.println("Ingrese su cedula");
        cedula = entrada.readLine();

            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                Connection conn = null;
                Statement stmt = null;
                ResultSet rs = null;
                Persona tmpPersona;

                String connectionUrl = "jdbc:sqlserver://MARIELABONILLA3;DatabaseName=laboratorio;integratedsecurity = true";
                //String connectionUrl = "jdbc:sqlserver://MARIELABONILLA3;DatabaseName=laboratorio;user=sa;password=123456";
                conn = DriverManager.getConnection(connectionUrl);
                stmt = conn.createStatement();

              //  rs = stmt.executeQuery
                  //      ("UPDATE personas SET nombre='" + nombre + "', apellido='" + apellido + "'WHERE cedula ='" + cedula + "'");

                rs = stmt.executeQuery
                        ("SELECT nombre, apellido, cedula FROM personas where cedula ="+cedula);

                while(rs.next())
                {
                    tmpPersona = new Persona(rs.getString("nombre")
                            , rs.getString("apellido"), rs.getString("cedula"));


                }

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

            //listar();

    }

    public static void listar() {


        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = null;
            Statement stmt = null;
            ResultSet rs = null;
            Persona tmpPersona;

            String connectionUrl = "jdbc:sqlserver://MARIELABONILLA3;DatabaseName=laboratorio;integratedsecurity = true";
            //String connectionUrl = "jdbc:sqlserver://MARIELABONILLA3;DatabaseName=laboratorio;user=sa;password=123456";
            conn = DriverManager.getConnection(connectionUrl);
            stmt = conn.createStatement();

            rs = stmt.executeQuery
                    ("SELECT * FROM personas");

            ArrayList<Persona> personas = new ArrayList<>();
            while(rs.next())
            {
                tmpPersona = new Persona(rs.getString("nombre"),
                        rs.getString("apellido"), rs.getString("cedula"));
                personas.add(tmpPersona);
            }

            for (Persona ppersona: personas) {
                System.out.println(ppersona.toString());
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }


    }

}


