package bonilla.mariela.ui;

import bonilla.mariela.logica.Persona;

import java.io.*;

public class Main {

    static BufferedReader entrada = new BufferedReader(
            new InputStreamReader(System.in));
    static PrintStream salida = new PrintStream(System.out);



    public static void main(String[] args) throws IOException {
        String nombre;
        String apellidos;
        String cedula;

        System.out.println("Digite el nombre de la persona");
        nombre = entrada.readLine();
        System.out.println("Digite los apellidos");
        apellidos = entrada.readLine();
        System.out.println("Digite la cédula");
        cedula = entrada.readLine();

        Persona other = new Persona(nombre, apellidos, cedula);
        Persona otherProject =other;
        //salida.println(other.equals(otherProject));




    }

    public static void mostrarMenu() {
        int opcion=-1;
        System.out.println("1.Registrar");
        System.out.println("2.");
        System.out.println("3.");
        System.out.println("4.");
        System.out.println("5.");
        System.out.println("6.");
        System.out.println("7.");
        System.out.println("8.");
        System.out.println("0");
        System.out.println("Digite la opción");

    }


}
