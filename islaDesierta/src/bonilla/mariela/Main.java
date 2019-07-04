package bonilla.mariela;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;

public class Main {
    static BufferedReader entrada = new BufferedReader(
            new InputStreamReader(System.in));
    static PrintStream salida = new PrintStream(System.out);


    public static void main(String[] args) throws IOException {
        ArrayList<Eatable> elementos = new ArrayList<>();
        Grillo tmpGrillo;
        Manzana tmpManzana;
        Piedra tmpPiedra;
        String pregunta;

        String nombre;
        salida.println("Nombre del grillo");
        nombre = entrada.readLine();

        tmpGrillo = new Grillo(nombre);

        salida.println("Nombre de la manzana");
        nombre = entrada.readLine();

        tmpManzana = new Manzana(nombre);

        salida.println("Nombre de la piedra");
        nombre = entrada.readLine();

        tmpPiedra = new Piedra(nombre);

        elementos.add(tmpGrillo);
        elementos.add(tmpManzana);
        elementos.add(tmpPiedra);

        for (Eatable dato: elementos){
            salida.println("\n"+dato.eat());
        }



    }
}
