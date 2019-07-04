package bonilla.mariela.ui;

import bonilla.mariela.tl.Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Main {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;
    static Controller gestor = new Controller();

    public static void main(String[] args) throws IOException {
	    mostrarMenu();
    }

    public static void mostrarMenu() throws IOException {
        int opcion;
        opcion = -1;
        do {
            out.println("1.Registrar usuario");
            out.println("2.Validar usuario");
            out.println("3.");
            out.println("4.");
            out.println("0.Salir");
            out.println("Digite la opción que desee");
            opcion = Integer.parseInt(in.readLine());
            procesarOpcion(opcion);
        }while (opcion != 0);
    }

    public static void procesarOpcion(int pOpcion)  throws IOException  {
        switch (pOpcion) {
            case 1:
                registrarUsuario();
                break;
            case 2:
                validarUsuario();
                break;
            case 0:
                out.println("Adiós!");
            default:
                out.println("Opción inválida");
        }
    }

    public static void registrarUsuario() throws IOException{
        String nombre;
        String clave;
        out.println("Digite el nombre de usuario");
        nombre = in.readLine();
        out.println("Digite la clave");
        clave = in.readLine();
        gestor.registrarUsuario(nombre, clave);
    }

    public static void validarUsuario() throws IOException{
        String nombre;
        String clave;
        out.println("Ingrese el nombre de usuario");
        nombre = in.readLine();
        out.println("Ingrese la clave");
        clave = in.readLine();
        gestor.validarUsuario(nombre, clave);
        out.println(Controller.login.toString());
    }
}
