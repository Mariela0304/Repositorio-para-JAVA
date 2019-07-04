package com.company;

import java.io.PrintStream;
import java.util.Scanner;
import java.util.Iterator;


public class Main {

    static PrintStream salida = System.out;
    static Scanner entrada = new Scanner(System.in);
    static CL logica = new CL();

    public static void main(String[] args) {
        boolean seguir = true;
        int i = 0;


        String opcion;



       do {
            System.out.println("\n\n1-Ingresar estudiante \n2-Ingresar nota a estudiante\n3-Buscar estudiante\n4-Imprimir nota de estudiante\n5-Imprimir estudiantes\n6-Imprimir notas\n7-Desea salir\n\n¿Qué desea hacer? ");

            opcion = entrada.next();

            switch (opcion) {
                case "1":
                    registroEstuadiante();
                    seguir = true;
                    break;
                case "2":
                    registroNota();
                    seguir = true;
                    break;

                case "3":
                    buscarEstudiante();
                    seguir = true;
                    break;

                case "4":
                    imprimirNotaEstudiante();
                    seguir = true;
                    break;
                case "5":
                    imprimirListaEstudiantes();
                    seguir = true;
                    break;
                case "6":
                    imprimirListaNotas();
                    seguir = true;
                    break;
                case "7":
                    seguir = false;
                    break;
                default:
                    System.out.println("Dígito no válido");
                    break;
            }
        }  while (seguir == true);


    }


    static void registroEstuadiante() {
        String nombre;


        System.out.println("Nombre de estudiante");
        nombre = entrada.next();

        boolean repetido = logica.validarEstudiante(nombre);

        if (repetido != true) {
            logica.registrarEstudiante(nombre);
        } else {
            System.out.println("\n\nEste estudiante ya se encuentra registrado\n\n");

        }
    }


  static void registroNota() {
        int nota;
        String nombre;

        System.out.println("Nombre del estudiante al que le quiere agregar la nota");
        nombre = entrada.next();

        System.out.println("Nota de estudiante");
        nota = entrada.nextInt();

        logica.registrarNota(nombre, nota);
    }


    static void buscarEstudiante() {
       String nombre;

        System.out.println("Ingrese el nombre del estudiante que desee buscar");
        nombre = entrada.next();

        String resultados = logica.buscarEstudiante(nombre);

        System.out.println("\n\n------------------------------------\nResultado de búsqueda:\n\n" + resultados);

    }


    static void imprimirNotaEstudiante() {
        String nombre;

        System.out.println("Ingrese el nombre del estudiante para saber su nota");
        nombre = entrada.next();

        int resultados = logica.imprimirNotaEstudiante(nombre);

        System.out.println("\n\n------------------------------------\nResultado de búsqueda:\n\n "+ "La nota que " + nombre + " obtuvo, fue de "+resultados);

    }



    static void imprimirListaEstudiantes() {
        System.out.println("\n\nEstudiantes\n\n");
        int i=0;
        for (String nombre : logica.estudiantes ) //se puede leer por cada dato de tipo String en la coleccion de nombres
        {
            System.out.println("Estudiante: "+nombre);
        }
    }

  static void imprimirListaNotas() {
        int i =0;
        System.out.println("     Notas\n");

     //Recorriendo el array list con un ciclo mejorado con el "for each"
      for (String nombre : logica.estudiantes ) //se puede leer por cada dato de tipo String en la coleccion de nombres
      {
          i = logica.estudiantes.indexOf(nombre);
          int nota = logica.notas.get(i);
          System.out.println("Estudiante: "+nombre+"   Nota: " + nota);
      }

    }
}
