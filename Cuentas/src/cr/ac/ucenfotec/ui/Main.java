package cr.ac.ucenfotec.ui;




//se importa la clase Cuenta
import cr.ac.ucenfotec.bl.*;
import cr.ac.ucenfotec.tl.Controller;
import cr.ac.ucenfotec.dl.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.time.LocalDate;


public class Main {
    static BufferedReader entrada = new BufferedReader(
            new InputStreamReader(System.in));
    static PrintStream salida = System.out;
    static Controller gestor = new Controller();
    static CL logica = new CL();

    public static void main(String[] args) throws java.io.IOException {
        //crear instancia de la clase Cuenta
        Cuenta tmpCuenta;
        mostrarMenu();

    }

    static void mostrarMenu() throws java.io.IOException {
        String menu;
        boolean seguir = true;

        do {
            salida.println("1.Crear cuenta\n2.Realizar depósito\n3.Retirar dinero\n4.Listar cuenta" +
                    "\n5.Salir");
            salida.println("Qué desea hacer?");
            menu = entrada.readLine();

            switch (menu) {

                case "1"://Crear cuenta
                    crearCuenta();
                    seguir = true;
                    break;

                case "2"://Depositar dinero de cuenta

                    depositarDinero();
                    seguir = true;
                    break;

                case "3"://Retirar dinero de cuenta

                    retirarDinero();
                    seguir = true;
                    break;
                case "4"://Listar cuentas

                    listarCuentas();
                    seguir = true;
                    break;

                case "6"://Opción de salir

                    seguir = true;
                    break;
                default:

                    salida.println("Error!");
                    seguir = true;
                    break;

            }
        }while (seguir == true);
    }


    static void crearCuenta() throws java.io.IOException {
        double deposito;
        int numCuenta;
        LocalDate fechaCreacion;
        String duenno;

        //Se piden los datos al usuario.

        System.out.println("Digite el nombre del dueño");
        duenno = entrada.readLine();
        System.out.println("Digite el depósito inicial de la cuenta");
        deposito = Double.parseDouble(entrada.readLine());
        System.out.println("Digite el número de cuenta");
        numCuenta = Integer.parseInt(entrada.readLine());

        gestor.registrarNuevaCuenta(duenno, numCuenta, deposito);

    }

    static void depositarDinero() throws java.io.IOException {
        int numCuenta;
        double monto;

        System.out.println("Digite el número de su cuenta");

        System.out.println("Digite el monto que desea depositar a su cuenta");

    }


    static void retirarDinero() throws java.io.IOException {
        int numCuenta;
        double monto;

        System.out.println("Digite el número de cuenta");

        System.out.println("Digite el monto que desea retirar");



    }

    public static void listarCuentas() throws java.io.IOException{
        String [] lista = gestor.listarCuentas();

        for (String info : lista) {
            System.out.println(info);
        }

    }



//    static void listarCuentas() throws java.io.IOException {
//
//        //Crear un arraylist de cuentas.
//
//        ArrayList<Cuenta> lista;
//
//        lista = gestor.listaCuenta();
//        //recorro la lista
//        System.out.println("Impresión del arrayList " + " en el main");
//        for (Cuenta dato : lista) {
//            salida.println(dato.toString());
//        }
//
//        //1. Debe probarlo como estaba al final de la clase.
//        //2. Va a crear una nueva cuenta debajo del for each.
//        //3. Agregar la nueva cuenta al arraylist lista.
//        //4. Volver a imprimir el Arraylist de lista con otro for each.
//        //5. Va a llamar al método imprimirLista de la CL.
//        //6. El martes se le cuenta a Cordero qué pasó.
//
//        //crear nueva cuenta quemada en ingresar a "lista"
//
//
//        String nombre  = "Maria";
//        int codigo = 12345;
//        double monto = 98089;
//
//        //Se ingresa la nueva cuenta en lista
//
//        Cuenta usuario = new Cuenta(nombre, monto, codigo);
//        lista.add(usuario);
//
//        //se imprime el ArrayList de lista con otro for each
//
//        System.out.println("Se imprime nuevamente la lista");
//        for (Cuenta dato : lista) {
//            salida.println(dato.toString());
//        }
//
//        //se llama al método de imprimirLista de la CL
//
//        gestor.imprimirCuentas();
//
//    }







}