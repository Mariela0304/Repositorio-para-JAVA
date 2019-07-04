package bonilla.mariela.ui;

import bonilla.mariela.tl.Controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.IOException;



public class Main {

    static BufferedReader entrada = new BufferedReader(
            new InputStreamReader(System.in));
    static PrintStream salida = System.out;
    static Controller gestor = new Controller();

    public static void main(String[] args) {
	// write your code here
    }

    static void mostrarMenu() throws IOException{
        String menu;
        boolean seguir = true;
        do {
            salida.println("1.Registrar \n2.Listar \n3.Registrar \n4.Listar\n5.Registrar " +
                    "\n6.Listar\n7.Registrar \n8.Listar\n9.Salir");
            salida.println("Elija una opción");
            menu = entrada.readLine();
            switch (menu) {
                case "1"://Es un registro

                    seguir = true;
                    break;
                case "2"://Es un listar

                    seguir = true;
                    break;
                case "3"://Es un registro

                    seguir = true;
                    break;
                case "4"://Listar

                    seguir = true;
                    break;
                case "5"://Registro

                    seguir = true;
                    break;
                case "6"://Listar

                    seguir = true;
                    break;
                case "7"://Registro

                    seguir = true;
                    break;
                case "8"://Listar

                    seguir = true;
                    break;
                case "9"://Opción de salir
                    seguir = false;
                    break;
                default:
                    salida.println("Error!");
                    seguir = true;
                    break;
            }
        } while (seguir == true);
    }
}
