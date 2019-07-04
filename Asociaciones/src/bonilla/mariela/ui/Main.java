package bonilla.mariela.ui;

import bonilla.mariela.bl.Banco;
import bonilla.mariela.bl.Carrera;
import bonilla.mariela.bl.Empleado;
import bonilla.mariela.bl.Estudiante;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;

public class Main {

    static BufferedReader entrada = new BufferedReader(
            new InputStreamReader(System.in));
    static PrintStream salida = new PrintStream(System.out);

    public static void main(String[] args) throws IOException{
       mostrarMenu();
    }

    static void mostrarMenu() throws IOException {
        String menu;
        boolean seguir = true;

        do {
            salida.println("1.Asociacion\n2.Agregacion\n3.Composicion\n" +
                    "\n4.Salir");
            salida.println("Qué desea hacer?");
            menu = entrada.readLine();

            switch (menu) {

                case "1": //registrar lab

                    asociacion();
                    seguir = true;
                    break;

                case "2"://listar laboratorios

                    agregacion();
                    seguir = true;
                    break;

                case "3"://Buscar un laboratorio
                    composicion();
                    seguir = true;
                    break;

                case "4"://Salir

                    seguir = false;
                    break;
                default:

                    salida.println("Error!");
                    seguir = true;
                    break;

            }
        }while (seguir == true);
    }

    static void asociacion() {
        Banco banco = new Banco("BCR", "Avenida Segunda, San José");
        Empleado empleado = new Empleado("Julian", "187698765");
        empleado.setLugarTrabajo(banco);
        salida.println(empleado.toString());
    }


    static void agregacion() {
        Estudiante estudiante1 = new Estudiante("Mario", "117738745");
        Estudiante estudiante2 = new Estudiante("Bertha", "1197738745");
        Estudiante estudiante3 = new Estudiante("Julio", "111972745");

        ArrayList<Estudiante> estudiantes = new ArrayList<>();

        estudiantes.add(estudiante1);
        estudiantes.add(estudiante2);
        estudiantes.add(estudiante3);

        Carrera carrera = new Carrera("Sociales");
        carrera.setEstudiante(estudiantes);

        System.out.println(carrera.toString());

    }

    static void composicion() {

    }


}
