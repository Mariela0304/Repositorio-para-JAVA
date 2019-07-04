package cr.ac.ucenfotec;


import java.io.*;
import java.io.PrintStream;



public class Main {

    static BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream salida = System.out;


    public static void main(String[] args) throws IOException {
        inicializarTasa();
        registrarPersona();
        registrarCuenta();
        listarPersonas();
        listarCuentas();

    }

    public static void mostrarMenu() throws IOException {
        String menu;
        boolean seguir = true;

        do {
            salida.println("1.Registrar persona\n2.Registrar cuenta\n3.Listar personas\n" +
                    "4.Listar cuentas\n0.Salir");
            salida.println("Qué desea hacer?");
            menu = entrada.readLine();

            switch (menu) {

                case "1"://registrar personas
                    registrarPersona();
                    seguir= true;
                    break;

                case "2"://listar Personas
                    registrarCuenta();
                    seguir=true;
                    break;

                case "3": //buscar una persona
                    listarPersonas();
                    seguir = true;
                    break;
                case "4"://registrar Material
                    listarCuentas();

                    seguir=true;
                    break;

                case "0"://salir
                    seguir=false;
                    break;
                default:

                    salida.println("Error!");
                    seguir = true;
                    break;
            }

        } while (seguir == true);
    }



    public static void registrarPersona() throws IOException {
        ControllerPersona gestorPersona = new ControllerPersona();
        String nombre;
        String apellido;

        System.out.println("Ingrese el nombre del cliente");
        nombre = entrada.readLine();

        System.out.println("Ingrese el apellido del cliente");
        apellido = entrada.readLine();

        gestorPersona.registrarPersona(nombre, apellido);
    }

    public static void registrarCuenta() throws IOException {
        ControllerCuenta gestorCuenta = new ControllerCuenta();
        int numCuenta;
        double monto;

        System.out.println("Ingrese el numero de cuenta");
        numCuenta = Integer.parseInt(entrada.readLine());
        System.out.println("Ingrese el monto");
        monto = Double.parseDouble(entrada.readLine());

        gestorCuenta.registrarCuenta(numCuenta, monto);
    }


    public static void listarPersonas(){
        ControllerPersona gestorPersona = new ControllerPersona();
        String[] personas = gestorPersona.listarPersonas();
               salida.println("LISTA DE PERSONAS");
        for (String dato : personas) {
            salida.println(dato);

        }
    }

    public static void listarCuentas() {
        ControllerCuenta gestorCuenta = new ControllerCuenta();
        String[] cuentas = gestorCuenta.listarCuentas();
        salida.println("LISTA DE CUENTAS");
        for (String dato : cuentas) {
            salida.println(dato);
        }
    }

    public static void inicializarTasa() throws IOException {
        ControllerCuenta gestorCuenta = new ControllerCuenta();
        salida.println("Ingrese la tasa de interes de las cuentas de ahorro");
        Cuenta.tasa = Double.parseDouble(entrada.readLine());
    }
}
