package com.company;

import java.util.ArrayList;

public class CL {


    public ArrayList <String> peliculas = new ArrayList<>();

    public void declaracionPeliculas() {
        peliculas.add("Los pitufos,3,1");
        peliculas.add("El padrino,5,2");;

    }



    public boolean registrarPelicula(String ppelicula) {

        peliculas.add(ppelicula);

        return true;
    }//Realizado por Nathalie


    public boolean reservarPelicula(int pcodigo){

        boolean reservaHecha = false;
        for (String pelicula: peliculas) {
             String[] datos =pelicula.split(",");
            int cantidadreserva = Integer.parseInt(datos[1]);
            int codigoreserva = Integer.parseInt(datos[2]);

            if(pcodigo == codigoreserva){
                cantidadreserva = cantidadreserva - 1;

                datos[1] = Integer.toString(cantidadreserva);
                reservaHecha=true;

                peliculas.add(datos[0] +","+datos[1] +","+datos[2]);

            }
            break;
        }


        return reservaHecha;
    }//by Mariela

    public boolean devolverPelicula(int pcodigo){

        boolean devolucionHecha = false;

        for (String pelicula: peliculas) {
            String[] datos =pelicula.split(",");
            int cantidadreserva = Integer.parseInt(datos[1]);
            int codigoreserva = Integer.parseInt(datos[2]);

            if(pcodigo == codigoreserva){
                cantidadreserva = cantidadreserva + 1;

                datos[1] = Integer.toString(cantidadreserva);
                devolucionHecha=true;

                peliculas.add(datos[0] +","+datos[1] +","+datos[2]);

            }
            break;
        }

            return devolucionHecha;
    }//by Mariela


    public boolean validaciones(String pcodigo) {
        try {
            Integer.parseInt(pcodigo);
            return true;
        } catch (NumberFormatException nfe){
            return false;
        }
    }//by Mariela
}
