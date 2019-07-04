package bonilla.mariela.ui;

import bonilla.mariela.tl.Controlador;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class UI {
    static BufferedReader in = new BufferedReader(
            new InputStreamReader(System.in));
    static PrintStream out = System.out;
    static Controlador gestor = new Controlador();

    public static void main(String[] args) throws IOException {
	// write your code here
        mostrarMenu();

    }

    static void mostrarMenu() throws IOException {
        String menu;

        boolean seguir = true;

        do {
            out.println("1.Registro de estudiante\n2.Listar estudiantes\n3.Registro de carrera\n4.Listar carreras\n5.Registro de curso\n6.Listar cursos\n7.Salir\n");
            out.println("Qué desea hacer?");
            menu = in.readLine();

            switch (menu) {
                case "1"://registro de estudiante
                    registrarEstudiante();
                    seguir = true;
                    break;
                case "2"://listar estudiantes
                    listarEstudiantes();
                    seguir = true;
                    break;
                case "3"://registro de carrera
                    registrarCarrera();
                    seguir = true;
                    break;
                case "4"://listar carreras
                    listarCarreras();
                    seguir = true;
                    break;
                case "5"://registro de curso
                    registrarCurso();
                    seguir = true;
                    break;
                case "6"://listar cursos
                    listarCursos();
                    seguir = true;
                    break;
                case "7"://Salir
                    seguir = false;
                    break;

                default:
                    out.println("Error!");
                    seguir = true;
                    break;
            }

        } while (seguir == true);

    }


    static void registrarEstudiante() throws IOException {
        String nombre;
        String identificacion;
        String edad;
        String apellido;

        out.println("Digite el nombre del estudiante");
        nombre = in.readLine();
        out.println("Digite el apellido del estudiante");
        apellido = in.readLine();
        out.println("Digite la identificación del estudiante");
        identificacion = in.readLine();
        out.println("Digite la edad del estudiante");
        edad = in.readLine();


        gestor.ingresarEstudiante(nombre, apellido, identificacion, edad);
    }


    static void registrarCarrera() throws IOException {
        String nombre;
        String codigo;
        String pregunta;
        boolean acreditada = false;
        boolean correcto = true;

        out.println("Digite el nombre de la carrera");
        nombre = in.readLine();
        out.println("Digite el código de la carrera");
        codigo = in.readLine();
        do {
            out.println("¿Está acreditada?");
            pregunta = in.readLine();
            switch (pregunta) {
               case "Sí":
                    acreditada=true;
                    correcto = true;
                    break;
               case "No":
                    acreditada=false;
                    correcto = true;
                    break;
               default:
                     correcto=false;
                     out.println("Ingrese Sí o No");
                     break;
            }

        }while (correcto== false);


        gestor.ingresarCarrera(nombre, codigo, acreditada);
    }

    static void registrarCurso() throws IOException {
        String nombre;
        String codigo;
        int creditos;

        out.println("Digite el nombre del curso");
        nombre = in.readLine();
        out.println("Digite el código del curso");
        codigo = in.readLine();
        out.println("Digite los créditos para el curso");
        creditos = Integer.parseInt(in.readLine()) ;


        gestor.ingresarCurso(nombre, codigo, creditos);
    }






    static void listarCarreras() {
        //se declara variable que tenga en la lista de estidiantes de la capa logica
        String[] lista = new String[gestor.listaCarreras().length];

        for (String dato: gestor.listaCarreras()) {
            out.println(dato);
        }

    }

    static void listarEstudiantes() {
        //se declara variable que tenga en la lista de estidiantes de la capa logica
        String[] lista = gestor.listaEstudiantes();

        for (String dato: lista) {
            out.println(dato.toString());
        }

    }

    static void listarCursos(){
        //se declara variable que tenga en la lista de estidiantes de la capa logica
        String[] lista = new String[gestor.listaCursos().length];

        for (String dato: gestor.listaCursos()) {
            out.println(dato);
        }

    }

}
