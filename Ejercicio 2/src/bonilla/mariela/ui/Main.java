package bonilla.mariela.ui;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.time.LocalDateTime;


import bonilla.mariela.bl.*;
import bonilla.mariela.dl.*;
import bonilla.mariela.tl.*;

public class Main {

    static BufferedReader entrada = new BufferedReader(
            new InputStreamReader(System.in));
    static PrintStream salida = System.out;
    static Controller gestor = new Controller();


    public static void main(String[] args)  throws java.io.IOException {
	// write your code here
        mostrarMenu();
    }

    public static void mostrarMenu() throws java.io.IOException {
        String menu;
        boolean seguir = true;

        do {
            salida.println("1.Registro de alumno\n2.Registrar examen\n3.Registrar puntaje\n4.Calcular nota de alumno\n5.Listar estudiantes\n6.Salir");
            salida.println("Qué desea hacer?");
            menu = entrada.readLine();

            switch (menu) {

                case "1"://digitar nombre de alumno
                    registrarAlumno();
                    seguir= true;
                    break;

                case "2"://Registrar examen

                    registrarExamen();
                    seguir=true;
                    break;

                case "3"://ingresar puntajes al examen

                    registrarPuntajes();
                    seguir=true;
                    break;
                case "4"://calcular nota de alumno

                    calcularNota();


                    seguir=true;
                    break;

                case "5"://listar estudiante
                    listarExamenes();
                    seguir=true;
                    break;
                default:

                    salida.println("Error!");
                    seguir = true;
                    break;
            }

        } while (seguir == true);
    }

    public static void registrarAlumno() throws java.io.IOException {
        String nombre;

        salida.println("Digite su nombre");
        nombre = entrada.readLine();



        gestor.registrarAlumno(nombre);
    }


    public static void registrarPuntajes() throws java.io.IOException {
        double puntaje;
        int id_pregunta;
        String alumno;

        salida.println("Ingrese el nombre del alumno");
        alumno = entrada.readLine();

        salida.println("Ingrese el id de la pregunta");
        id_pregunta = Integer.parseInt(entrada.readLine());

        salida.println("Ingrese el puntaje de su pregunta");
        puntaje = Double.parseDouble(entrada.readLine());


        gestor.ingresarPuntaje(alumno, id_pregunta, puntaje);
    }

    public static void registrarExamen() throws java.io.IOException{
        String curso;
        int cantPreguntas=0;
        String pregunta;
        double valorPregunta;

        String [] infoPreguntas;

        boolean seguir = true;

        salida.println("Ingrese el nombre del curso");
        curso = entrada.readLine();

        salida.println("Ingrese la cantidad de las preguntas que va a contener");
        cantPreguntas = Integer.parseInt(entrada.readLine());

        infoPreguntas = new String[cantPreguntas];

        for (int i = 0; i < cantPreguntas;i++) {
            salida.println("Ingrese la pregunta #" + (i+1));
            pregunta = entrada.readLine();
            salida.println("Ingrese es la valor de pregunta #" + (i+1));
            valorPregunta = Double.parseDouble(entrada.readLine());

            infoPreguntas[i] = pregunta +","+valorPregunta;
        }

        gestor.registrarExamen(curso, cantPreguntas, infoPreguntas);

    }

    public static void calcularNota() {

        double nota = gestor.obtenerNota();
        salida.println("Su nota es de: " + nota + LocalDateTime.now());

    }

    public static void listarExamenes() {

        String [] lista = gestor.imprimirExamenes();

        for (String dato : lista) {
            salida.println(dato );
        }
    }

}
