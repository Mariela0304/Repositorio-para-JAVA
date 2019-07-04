package bonilla.mariela;

import java.io.*;
import java.util.ArrayList;

public class Main {
    static BufferedReader entrada = new BufferedReader(
            new InputStreamReader(System.in));
    static PrintStream salida = new PrintStream(System.out);


    public static void main(String[] args) throws IOException {

        ArrayList<Figura> figuras = new ArrayList<>();
        Rectangulo rectangulo = new Rectangulo();
        Triangulo triangulo = new Triangulo();
        figuras.add(rectangulo);
        figuras.add(triangulo);
        double baseRec;
        double alturaRec;
        double baseTriang;
        double alturaTriang;

        for (Figura tmpFigura: figuras) {
            tmpFigura.calcularArea();
            tmpFigura.toString();
        }
    }

//        salida.println("Ingrese la base de un rectangulo");
//        baseRec = Double.parseDouble(entrada.readLine());
//
//        salida.println("Ingrese la altura de un rectangulo");
//        alturaRec = Double.parseDouble(entrada.readLine());
//
//        Rectangulo rectangulo = new Rectangulo(baseRec, alturaRec);
//
//        rectangulo.calcularArea();
//
//
//
//        salida.println("Ingrese la base de un triangulo");
//        baseTriang = Double.parseDouble(entrada.readLine());
//
//        salida.println("Ingrese la altura de un triangulo");
//        alturaTriang = Double.parseDouble(entrada.readLine());
//
//        Triangulo triangulo = new Triangulo(baseTriang, alturaTriang);
//
//        salida.println(rectangulo.toString() + "\n\n");
//        triangulo.calcularArea();
//
//        salida.println(triangulo.toString());



}
