package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<String> nombres; //declarar un ArrayList

        nombres = new ArrayList<>(); //inicializar


        ArrayList<String> cedulas = new ArrayList<>();//o en la misma lista


        //agregar elementos al arreglo

        nombres.add("Pedro Picapiedra");
        nombres.add("Pablo Marmol");
        nombres.add("Donald Duck");
        nombres.add("Dela Duck");

        //OTROS METODOS DEL ARRAYLIST
        //para saber la cantidad de elementos
        int tamano = nombres.size();

        // modifica el tamanno del arreglo... no se tiene que tocar este, hasta cuando lo necesite
        nombres.trimToSize();

        //retorna el elemento en la posicion indicada... trae
        nombres.get(1);

        //se modifica el elemento en la posicion indicada... solo usar para modificar
        nombres.set(1, "Hugo Duck");

        //remove elimina el elemento de arraylist
        nombres.remove(2);


        //Recorriendo el array list con un ciclo mejorado con el "for each"

        for (String dato : nombres) //se puede leer por cada dato de tipo String wn la coleccion de nombres
        {
            System.out.println(dato);
        }


    }
}
