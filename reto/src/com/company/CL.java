package com.company;

import java.util.ArrayList;


public class CL {

    public ArrayList<String> estudiantes = new ArrayList<>();
    public ArrayList<Integer> notas = new ArrayList<>();


    public void registrarEstudiante(String pnombre) {

        estudiantes.add(pnombre);

    }


    public void registrarNota(String pnombre, int pnota) {

        int indice =estudiantes.indexOf(pnombre);//Devuelve la posición en la que se encuentra ese elemento
        notas.add(indice, pnota);

    }


    public String buscarEstudiante(String pnombre) {
      String resultado;

        int indice =estudiantes.indexOf(pnombre);//Devuelve la posición en la que se encuentra ese elemento
        String nombre = estudiantes.get(indice);
        int nota = notas.get(indice);

        resultado ="Estudiante: "+ nombre +"  Nota: "+ nota;

        return resultado;
    }


    public int imprimirNotaEstudiante(String pnombre) {
        int resultadoNota = 0;

        int indice =estudiantes.indexOf(pnombre);//Devuelve la posición en la que se encuentra ese elemento
        resultadoNota = notas.get(indice);

        return resultadoNota;
    }


    public boolean validarEstudiante(String pnombre) {
        boolean error = false;

        if (estudiantes.contains(pnombre)) {
            error = true;
        }
        return error;
    }
}

