package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.time.LocalDate;


public class UI {

    static BufferedReader entrada = new BufferedReader(
            new InputStreamReader(System.in));
    static PrintStream salida = System.out;
    static CL logica = new CL();


    public static void main(String[] args)  throws java.io.IOException {
	// write your code here


        String menu;
        boolean seguir = true;

        do {
            salida.println("1.Registro de propiedad\n2.Listar propiedades\n3.Buscar propiedad\n4.Alquiler mensual\n5.Salir");
            salida.println("Qué desea hacer?");
            menu = entrada.readLine();

            switch (menu) {

                case "1"://registro de propiedad
                    registrarPropiedad();
                    seguir= true;
                    break;

                case "2"://listar propiedades

                    listarPropiedades();
                    seguir=true;
                    break;

                case "3"://buscar propiedad

                    buscarPropiedad();
                    seguir=true;
                    break;
                case "4":// Total de alquiler por mes

                    System.out.println("El total que usted recibe de alquiler por mes es de: " + logica.alquilerTotal);

                    seguir=true;
                    break;

                case "5":// Total de alquiler por mes

                    LocalDate today = LocalDate.now();
                    System.out.println("Current Date="+today);
                    seguir=true;
                    break;
                default:

                    salida.println("Error!");
                    seguir = true;
                    break;
            }

        } while (seguir == true);
    }



    static void registrarPropiedad()  throws java.io.IOException{
        String codigo;
        String nombre;
        String cuartos;
        String provincia;
        String costoMensual;
        boolean seguir = false;

        do {
            System.out.println("Ingrese el código de su propiedad");
            codigo = entrada.readLine();

            if (logica.validaciones(codigo)) {
                if (logica.repetido(codigo)) {
                    System.out.println("El código de esta propieda ya se encuentra registrado. Ingrese uno nuevo");
                    seguir=false;
                } else {
                    seguir=true;
                }
            } else {
                System.out.println("El código ingresado no es válido. Inténtelo nuevamente");
            }

        } while (seguir==false);

        do {
            System.out.println("Ingrese el nombre de su propiedad");
            nombre = entrada.readLine();

            if (validaNombre(nombre)) {
                seguir=true;


            } else {
                System.out.println("\nEl nombre ingresado no es válido. Inténtelo nuevamente. \nRecuerde que la primera letra de cada nombre debe de ir en mayúsucula y las demás en minúscula\n");
                seguir=false;
            }

        } while (seguir==false);



        do {
            System.out.println("Ingrese cuántas habitaciones tiene esta propiedad");
            cuartos = entrada.readLine();

            if (validarCuartos(cuartos)) {
                seguir=true;
            } else {
                System.out.println("El número de cuartos ingresado no es válido. Inténtelo nuevamente");
                seguir=false;
            }

        } while (seguir==false);



        do {
            System.out.println("Ingrese la provincia de su ubicación");
            provincia = entrada.readLine();

            if (validarProvincias(provincia)) {
                seguir=true;
            } else {
                System.out.println("\nLa provincia ingresada no es existe. Inténtelo nuevamente. \nRecuerde que la primera letra de cada provincia debe ir en mayúsucula y las demás en minúscula\n");
                seguir=false;
            }

        } while (seguir==false);




        do {
            System.out.println("Ingrese cuál es el costo mensual del alquiler");
            costoMensual = entrada.readLine();

            if (logica.validaciones(costoMensual)) {
                seguir=true;
            } else {
                System.out.println("El código ingresado no es válido. Inténtelo nuevamente");
                seguir=false;
            }

        } while (seguir==false);

        String infoPropiedad = codigo + "," + nombre + "," + cuartos + "," + provincia + "," + costoMensual;




       logica.registroPropiedad(infoPropiedad, costoMensual);

       System.out.println("¡El registro de esta propiedad fue exitosa!\n\n");


    }

    static boolean validaNombre(String pnombre) {
        return pnombre.matches("^([A-Z]{1}[a-z]+[ ]?){1,2}$");
    }

    static boolean validarCuartos(String pcuartos) {
        return pcuartos.matches("^([0-9]{1,2})$");
    }

    static boolean validarProvincias(String pprovincias) {
        return pprovincias.matches("^([A-Z]{1}[a-z]+)$");
    }




    static void listarPropiedades() {

        System.out.println("\n\n   Lista de propiedades \n");

        for (String infoPropiedad : logica.propiedades) {
            System.out.println(infoPropiedad+"\n\n");
        }
    }

    static void buscarPropiedad() throws java.io.IOException{
        String codigo;
        String nombre;


        System.out.println("Ingrese el código de la propiedad a buscar");
        codigo = entrada.readLine();


        String resultadoBusqueda = logica.buscarPropiedad(codigo);

        String[] propiedad = resultadoBusqueda.split(",");

        System.out.println("----------------------------------------------------------\n\n  Resultado de busqueda:\n\n\nCódigo: " +propiedad[0]+"\nNombre: "+propiedad[1] +"\nCuartos: "+propiedad[2]+"\nProvincia: "+propiedad[3]+"\nCosto mensual: "+propiedad[4]+"\n\n--------------------------------------------");
    }

}



