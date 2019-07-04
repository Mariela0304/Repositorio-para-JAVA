package bonilla.mariela;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Main {

    static BufferedReader entrada = new BufferedReader(
            new InputStreamReader(System.in));
    static PrintStream salida = new PrintStream(System.out);
    static Controller gestor = new Controller();

    public static void main(String[] args) throws java.io.IOException {
	// write your code here

        String nombre;
        String nacionalidad;
        String titulo;
        String isbn;
        String nombreLibreria;
        String direccionLibreria;

        salida.println("Ingrese su nombre");
        nombre = entrada.readLine();

        salida.println("Ingrese su nacionalidad");
        nacionalidad  = entrada.readLine();
        salida.println("Ingrese el titulo del libro");
        titulo  = entrada.readLine();

        salida.println("Ingrese el isbn del libro");
        isbn  = entrada.readLine();

        salida.println("Ingrese el nombre de la libreria");
        nombreLibreria = entrada.readLine();

        salida.println("Ingrese la direccion de la libreria");
        direccionLibreria  = entrada.readLine();



        Persona persona = new Persona(nombre, nacionalidad);
        Libro libro1 = new Libro(titulo, isbn);
        libro1.setAutor(persona);
        Libreria libreria = new Libreria(nombreLibreria, direccionLibreria);
        libreria.ingresarLibro(libro1);



        salida.println(libreria);


    }
}
