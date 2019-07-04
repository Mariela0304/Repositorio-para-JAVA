package bonilla.mariela.ui;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.time.LocalDate;

import bonilla.mariela.bl.*;
import bonilla.mariela.dl.*;
import bonilla.mariela.tl.*;

public class Main {

    static BufferedReader entrada = new BufferedReader(
            new InputStreamReader(System.in));
    static PrintStream salida = System.out;
    static Controller gestor = new Controller();

    public static void main(String[] args) throws java.io.IOException{
	// write your code here
        mostrarMenu();

    }

    public static void mostrarMenu() throws java.io.IOException {
        String menu;
        boolean seguir = true;

        do {
            salida.println("1.Registro de alumno\n2.Listar alumnos\n3.Buscar alumno\n4.Registrar examen\n5.Salir");
            salida.println("Qué desea hacer?");
            menu = entrada.readLine();

            switch (menu) {

                case "1"://registro de alumno
//                    registrarAlumno();
                    seguir= true;
                    break;

                case "2"://listar alumnos

//                    listarAlumnos();
                    seguir=true;
                    break;

                case "3"://buscar alumno

//                    buscarAlumno();
                    seguir=true;
                    break;
                case "4"://calcular nota de alumno

                    registrarExamen();


                    seguir=true;
                    break;

                case "5"://registrar preguntar para examen
                    registrarExamen();
                    seguir=true;
                    break;
                default:

                    salida.println("Error!");
                    seguir = true;
                    break;
            }

        } while (seguir == true);
    }



    public static void registrarExamen() throws java.io.IOException{
        String curso;
        int cantPreguntas=0;
        String pregunta;
        double valorPregunta;

        String [] infoPreguntas = new String[cantPreguntas];

        boolean seguir = true;

        salida.println("Cursos disponibles: \n1.Español\n2.Estudios Sociales");
        salida.println("Ingrese el numero del curso");
        do {
            curso = entrada.readLine();
            switch (curso) {
                case "1":
                    curso="Español";
                    seguir=true;
                break;
                case "2":
                    curso="Estudios Sociales";
                    seguir=true;
                    break;
                default:
                    salida.println("Este curso no esta disponible");
                    seguir=false;
                    break;
            }
        }while (seguir == false);

        salida.println("Ingrese la cantidad de las preguntas que va a contener");
        cantPreguntas = Integer.parseInt(entrada.readLine());


        for (int i = 0; i < cantPreguntas;i++) {
            salida.println("Ingrese la pregunta #" + i);
            pregunta = entrada.readLine();
            salida.println("Ingrese es la valor de pregunta #" + i);
            valorPregunta = Double.parseDouble(entrada.readLine());

            infoPreguntas[i] = pregunta +","+valorPregunta;
        }


        gestor.registrarExamen(curso, cantPreguntas, infoPreguntas);

    }
}
