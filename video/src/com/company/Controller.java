package com.company;


import java.util.ArrayList;

public class Controller {

    public CL logica = new CL();


    public boolean registrarPeli( String ppelicula) {

        return logica.registrarPelicula(ppelicula);
    }

    public ArrayList<String> listaPeliculas() {
        return logica.peliculas;

    }

    public boolean reservarPeli(int ppcodigo) {
        return logica.reservarPelicula(ppcodigo);

    }

    public boolean devolverPeli(int ppcodigo) {
        return logica.devolverPelicula(ppcodigo);

    }


    public void declaracion() {
        logica.declaracionPeliculas();
    }

    public boolean validar(String ppcodigo) {
        return logica.validaciones(ppcodigo);
    }
}
