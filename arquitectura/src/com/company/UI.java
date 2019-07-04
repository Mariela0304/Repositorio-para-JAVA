package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class UI {
    static BufferedReader in = new BufferedReader(
            new InputStreamReader(System.in));
    static PrintStream out = System.out;
    static Controller gestor = new Controller();



    public static void main(String[] args) throws java.io.IOException {
       mostrarMenu();
    }

    public static void mostrarMenu() throws java.io.IOException {
        String opcionMenu;
        boolean seguir = true;

        do {

            out.println("1.Sumar\n2.Restar\n3.Multiplicar\n4.Dividir\n5.Raíz cuadrada\n6.Salir");
            out.println("Digite la opción que desee ejecutar");
            opcionMenu = in.readLine();

            switch (opcionMenu) {
                case "1": //sumar
                    sumarDigitos();
                    seguir = true;
                    break;
                case "2": //restar
                    restarDigitos();
                    seguir = true;
                    break;
                case "3": //multiplicar
                    multiplicarDigitos();
                    seguir = true;
                    break;
                case "4": //dividir
                    dividirDigitos();
                    seguir = true;
                    break;
                case "5": //raíz cuadrada
                    raizDigito();
                    seguir = true;
                    break;
                case "6": //salir
                    seguir = false;
                    break;
                 default:
                     seguir=true;
                     out.println("Dato incorrecto. Inténtelo nuevamente");
                     break;
            }
        } while (seguir == true);

    }

    public static void sumarDigitos()  throws java.io.IOException {
        int num1;
        int num2;
        out.println("Digite el primer número a sumar");
        num1 = Integer.parseInt(in.readLine());
        out.println("Digite el segundo número a sumar");
        num2 = Integer.parseInt(in.readLine());
        out.println("El resultado de esta suma es de: "+gestor.calcularSuma(num1, num2));
    }

    public static void restarDigitos() throws java.io.IOException {
        int num1;
        int num2;
        out.println("Digite el primer número a restar");
        num1 = Integer.parseInt(in.readLine());
        out.println("Digite el segundo número a restar");
        num2 = Integer.parseInt(in.readLine());
        out.println("El resultado de esta resta es de: "+gestor.calcularResta(num1, num2));
    }

    public static void multiplicarDigitos() throws java.io.IOException {
        int num1;
        int num2;
        out.println("Digite el primer número a multiplicar");
        num1 = Integer.parseInt(in.readLine());
        out.println("Digite el segundo número a multiplicar");
        num2 = Integer.parseInt(in.readLine());
        out.println("El resultado de esta multiplicación es de: "+gestor.calcularMultiplicacion(num1, num2));

    }

    public static void dividirDigitos()  throws java.io.IOException{
        int num1;
        int num2;
        out.println("Digite el primer número a dividir");
        num1 = Integer.parseInt(in.readLine());
        out.println("Digite el segundo número a dividir");
        num2 = Integer.parseInt(in.readLine());
        out.println("El resultado de esta división es de: "+gestor.calcularDividir(num1, num2));

    }

    public static void raizDigito() throws java.io.IOException {
        int num;
        out.println("Digite el número que desee calcularle la raíz cuadrada");
        num = Integer.parseInt(in.readLine());
        out.println("El resultado de esta raíz es de: "+gestor.raizCuadrada(num));

    }



}
