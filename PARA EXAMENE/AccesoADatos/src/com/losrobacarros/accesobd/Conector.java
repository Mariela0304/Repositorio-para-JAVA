package com.losrobacarros.accesobd;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

public class Conector {

    private static  AccesoBD connectorBD = null;

    public static AccesoBD getConnectorBD(int factory) throws SQLException, Exception {
        String [] datos = archivoConectorBD();
        if (connectorBD == null) {
            switch (factory) {
                case 1://SQLSERVER
                    connectorBD = new SqlServerAccesoBD(datos[0]
                            ,datos[1]+"://"+datos[2]+";DatabaseName="+datos[3]+";user="+datos[4]+";password="+datos[5]);
                    return connectorBD;
                    default:
                        connectorBD = null;
            }
        }
        return connectorBD;
    }


    public static void cerrarConexion() {
        connectorBD.conn = null;
        if (connectorBD.conn == null) {
            System.out.println("Se cerró la base de datos");
        }
    }

    public static String[] archivoConectorBD () {
         String [] datosArray = new String[6];
        try
        {
            FileReader reader = new FileReader("Conector.txt");
            BufferedReader buffer = new BufferedReader(reader);
            String datos;

            while((datos = buffer.readLine()) != null)
            {
                String[] partes = datos.split(",");
                datosArray[0] = partes[0];
                datosArray[1] = partes[1];
                datosArray[2] = partes[2];
                datosArray[3] = partes[3];
                datosArray[4] = partes[4];
                datosArray[5] = partes[5];


            }
            reader.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

        return datosArray;
    }
}