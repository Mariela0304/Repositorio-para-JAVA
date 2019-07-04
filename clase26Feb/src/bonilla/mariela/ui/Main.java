package bonilla.mariela.ui;

import java.io.*;
import bonilla.mariela.tl.*;

public class Main {

    static BufferedReader entrada = new BufferedReader(
            new InputStreamReader (System.in));
    static PrintStream salida = new PrintStream(System.out);
    static Controller gestor = new Controller();

    public static void main(String[] args) throws IOException {
        mostrarMenu();



    }

    static void mostrarMenu() throws IOException {
        String menu;
        boolean seguir = true;

        do {
            salida.println("1.Registrar laboratorio\n2.Listar laboratorios\n3.Buscar laboratorio\n4.Registrar curso\n5.Listar cursos\n6.Buscar curso" +
                    "\n7.Salir");
            salida.println("Qué desea hacer?");
            menu = entrada.readLine();

            switch (menu) {

                case "1": //registrar lab

                    registrarLab();
                    seguir = true;
                    break;

                case "2"://listar laboratorios

                    listarLabs();
                    seguir = true;
                    break;

                case "3"://Buscar un laboratorio
                    buscarLab();

                    seguir = true;
                    break;
                case "4"://Eliminar laboratorio
                    eliminarLab();

                    seguir = true;
                    break;
                case "5"://Registrar curso
                    registrarCurso();

                    seguir = true;
                    break;

                case "6"://Listar cursos
                    listarCursos();

                    seguir = true;
                    break;
                case "7"://Buscar curso
                    buscarCurso();
                    seguir = true;
                    break;
                case "8"://Eliminar curso
                    eliminarCurso();
                    seguir = true;
                    break;
                case "9"://Salir

                    seguir = false;
                    break;
                default:

                    salida.println("Error!");
                    seguir = true;
                    break;

            }
        }while (seguir == true);
    }

    /*
    Registrar
     */

    static void registrarLab() throws IOException {
        String codigo;
        int capacidad;

        salida.println("Ingrese el código del laboratorio");
        codigo = entrada.readLine();
        salida.println("Ingrese la capacida máxima de estudiantes admitidos\n en ese laboratorio.");
        capacidad = Integer.parseInt(entrada.readLine());
        gestor.registrarLab(codigo, capacidad);
    }

    static void registrarCurso() throws IOException {
        String codigo;
        String nombre;
        int creditos;

        salida.println("Ingrese el código del curso");
        codigo = entrada.readLine();
        salida.println("Ingrese el nombre del curso");
        nombre = entrada.readLine();
        salida.println("Ingrese los créditos requeridos");
        creditos = Integer.parseInt(entrada.readLine());


        gestor.registrarCurso(codigo, nombre, creditos);

    }

    /*
    Listar
     */

    static void listarLabs() {

        for (String obj: gestor.imprimirLaboratorios()){
            salida.println(obj);
        }
    }

    static void listarCursos() {
        String [] lista = new String[gestor.imprimirCursos().length];

        for (String obj: gestor.imprimirCursos()){
            salida.println(obj);
        }
    }

    /*
    Buscar
     */

    static void buscarLab() throws IOException{
        String codigo;

        salida.println("Digite el codigo del lab a buscar");
        codigo = entrada.readLine();
        String laboratorio;

        laboratorio = gestor.getLaboratorio(codigo);

        salida.println("EL LAB ES: " + laboratorio);
    }

    static void buscarCurso() throws IOException{
        String codigo;

        salida.println("Digite el código del curso a buscar");
        codigo = entrada.readLine();
        String curso;

        curso = gestor.getCurso(codigo);

        salida.println("EL CURSO ES: " + curso + "\n");
    }

    /*
    Eliminar
     */

    static void eliminarLab() throws IOException {
        String codigo;
        salida.println("Digite el código del laboratorio a eliminar");
        codigo = entrada.readLine();
        String mensaje;
        mensaje = gestor.removeLab(codigo);
        salida.println(mensaje);
    }

    static void eliminarCurso() throws IOException {
        String codigo;
        salida.println("Digite el código del curso a eliminar");
        codigo = entrada.readLine();
        String mensaje;
        mensaje = gestor.removeCurso(codigo);
        salida.println(mensaje);
    }
}
