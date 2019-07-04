package com.company;

import java.io.*;
import java.util.Scanner;

public class Main {

    static BufferedReader in = new BufferedReader(
            new InputStreamReader(System.in));
    static PrintStream out = System.out;
    public static void main(String[] args) throws java.io.IOException{
	// write your code here
        mostrarMenu();

    }

    public static void mostrarMenu() throws java.io.IOException{
        int opcion;
        opcion = -1;
        do {
            out.println("1.Registrar laboratorio");
            out.println("2.Listar laboratorios");
            out.println("3.Buscar laboratorio");
            out.println("0.salir");
            out.println("Digite la opcuón que desee");
            opcion = Integer.parseInt(in.readLine());
            procesarOpcion(opcion);
        } while (opcion != 0);

    }

    public static void procesarOpcion(int popcion) throws java.io.IOException {
        switch (popcion) {
            case 1:
                registrarLaboratorio();
                //logica.registrarLaboratorio();
                break;
            case 2:
                //logica.imprimirLaboratorios();
                break;
            case 3:
                //buscarLaboratorio();
                break;
            case 0:
                out.println("Adiós");
                break;
            default:
                out.println("Opción inválida");
            break;
        }
    }

    public static void registrarLaboratorio() throws java.io.IOException{
        String dato;
        String codigo;
        String nombre;
        int capacidad;
        out.println("Digite el código del laboratorio");
        codigo= in.readLine();
        out.println("Digite el nombre del laboratorio");
        nombre = in.readLine();
        out.println("Digite la capacidad del laboratorio");
        capacidad = Integer.parseInt(in.readLine());

        dato = codigo + "," + nombre + "," + capacidad;

        imprimirDatos(dato);
        //logica.registrarLaboratorio(dato);
    }

    public static void imprimirDatos(String dato) {
        String[] info = dato.split(",");
        for (int i = 0;i<info.length;i++) {
            out.println(info[i]);
        }
    }
}
