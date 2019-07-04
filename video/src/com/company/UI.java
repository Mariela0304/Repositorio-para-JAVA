package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;


public class UI {

    static BufferedReader in = new BufferedReader(
            new InputStreamReader(System.in));
    static PrintStream out = System.out;
    static Controller gestor = new Controller();


    public static void main(String[] args) throws java.io.IOException {
	// write your code here

        gestor.declaracion();



        mostrarMenu();


    }


    public static void mostrarMenu() throws java.io.IOException {
        String opcionMenu;
        boolean seguir = true;

        do {

            out.println("1.Registrar película\n2.Listar película\n3.Reservar película\n4.Devolver película\n5.Salir");
            out.println("Digite la opción que desee ejecutar");
            opcionMenu = in.readLine();

            switch (opcionMenu) {
                case "1": //registrar
                    registrar();
                    seguir = true;
                    break;
                case "2": //listar
                    listar();
                    seguir = true;
                    break;
                case "3": //reservar
                    reservar();
                    seguir = true;
                    break;
                case "4": //devolver
                    devolver();
                    seguir = true;
                    break;

                case "5": //salir
                    seguir = false;
                    break;
                default:
                    seguir=true;
                    out.println("Dato incorrecto. Inténtelo nuevamente");
                    break;
            }
        } while (seguir == true);

    }


    static void registrar()throws java.io.IOException {
        String nombre;
        String cantidad;
        String codigo;
        boolean seguir;
        boolean realizado;



        do {
            out.println("Ingrese el nombre de la película");
            nombre = in.readLine();

            if (validaNombre(nombre)) {
                seguir=true;
            } else {
                System.out.println("La nombre de la película no es válida. Inténtelo nuevamente");
                seguir=false;
            }
        } while (seguir==false);

        do {
            out.println("Ingrese la cantidad de copias de la película");
            cantidad = in.readLine();


            if (gestor.validar(cantidad)) {
                seguir=true;
            } else {
                System.out.println("La cantidad ingresada no es válida. Inténtelo nuevamente");
                seguir=false;
            }
        } while (seguir==false);

        do {
            out.println("Ingrese el código de la película a registrar");
            codigo = in.readLine();

            if (gestor.validar(codigo)) {
                seguir=true;
            } else {
                System.out.println("El código ingresado no es válido. Inténtelo nuevamente");
                seguir=false;
            }
        } while (seguir==false);



        String pelicula = nombre +","+cantidad +","+codigo;
        realizado = gestor.registrarPeli(pelicula);

        if (realizado) {
            System.out.println("El registro se realizó con éxito.");
        } else {
            out.println("No se pudo registrar la película");
        }


    }

    static void reservar() throws java.io.IOException {
        String codigo;
        boolean verdadero;
        boolean realizado;
        do {
            out.println("Ingrese el código de la película");
            codigo = in.readLine();

            verdadero = gestor.validar(codigo);

        }while (verdadero==false);

        realizado = gestor.reservarPeli(Integer.parseInt(codigo));


        if (realizado == true) {
            out.println("La reserva se realizó con éxito");
        } else {
            out.println("No se pudo reservar la película. Inténtelo nuevamente");
        }
    }//By Mariela


    static void devolver() throws java.io.IOException {
        String codigo;
        boolean verdadero = false;


        do {
            out.println("Ingrese el código de la película");
            codigo = in.readLine();


            verdadero = gestor.validar(codigo);

        }while (verdadero==false);

        boolean realizado = gestor.devolverPeli(Integer.parseInt(codigo));

        if (realizado == true) {
            out.println("La devolución se realizó con éxito");
        } else {
            out.println("No se pudo devolver la película. Inténtelo nuevamente");
        }
    }//by Mariela

    static void  listar() {

        out.println("    Películas   \n\n");

        for (String lista : gestor.listaPeliculas()) {
            out.println(lista);

        }

    }


    static boolean validaNombre(String pnombre) {
        return pnombre.matches("^([A-Z]{1}[a-z ]?)$");
    }

}
