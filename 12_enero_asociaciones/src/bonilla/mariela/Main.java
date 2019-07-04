package bonilla.mariela;

import bonilla.mariela.bl.Computador;
import bonilla.mariela.bl.Empleado;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Main {

    static BufferedReader entrada = new BufferedReader(
            new InputStreamReader(System.in));
    static PrintStream salida = new PrintStream(System.out);

    public static void main(String[] args) throws IOException {

        Empleado empleado = new Empleado("José", "1234");
        Computador computador = new Computador("ABC124", "HP");
        computador.setResponsable(empleado);
        salida.println(computador.toString());

//        Empleado otroEmpleado = new Empleado();
//        Computador otroComputador = new Computador();
//        salida.println(otroComputador.toString());


    }
}
