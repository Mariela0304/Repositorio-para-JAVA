package com.company;

import java.util.ArrayList;

public class CL {


    ArrayList<String> propiedades = new ArrayList<>();

    public double alquilerTotal;

    public void registroPropiedad(String pInfoPropiedad, String pcostoMensual) {

        boolean hecho = false;

        int i = 0;

        boolean seguir = true;

        double costo = Double.parseDouble(pcostoMensual);

        alquilerTotal += costo;
        propiedades.add(pInfoPropiedad);

    }


    public String buscarPropiedad(String pcodigo) {
        String propiedadBuscada = "";

        int cont = 0;

        for (String propiedad : propiedades) {
            String[] caracteristicas = propiedad.split(",");
            if (caracteristicas[0].equals(pcodigo)) {
                propiedadBuscada=propiedad;
            }
        }


        return propiedadBuscada;
    }

    public boolean validaciones(String pcodigo) {
        try {
            Integer.parseInt(pcodigo);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    public boolean repetido(String pcodigo) {
        boolean codigoRegistrado = false;


        for (String propiedad : propiedades) {
            String[] caracteristicas = propiedad.split(",");
            if (caracteristicas[0].equals(pcodigo)) {
                codigoRegistrado=true;
            }
        }
        return codigoRegistrado;
    }
}


