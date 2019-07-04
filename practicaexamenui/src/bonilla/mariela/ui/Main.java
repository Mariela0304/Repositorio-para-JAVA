package bonilla.mariela.ui;

import bonilla.mariela.tl.Controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintStream;

public class Main {
    static BufferedReader entrada = new BufferedReader(
            new InputStreamReader(System.in));
    static PrintStream salida = System.out;
    static Controller gestor = new Controller();



    public static void main(String[] args) throws IOException  {
	    mostrarMenu();
    }

    static void mostrarMenu() throws IOException {
        String menu;
        boolean seguir = true;
        do {
            salida.println("1.Registrar Proveedor\n2.Listar Proveedor\n3.Registrar clientes\n4.Listar clientes\n5.Salir");
            salida.println("Elija una opción");
            menu = entrada.readLine();
            switch (menu) {
                case "1"://
                    registrarProveedor();
                    seguir = true;
                    break;
                case "2"://
                    listarProveedores();
                    seguir = true;
                    break;
                case "3"://
                    registrarCliente();
                    seguir = true;
                    break;
                case "4"://
                    listarClientes();
                    seguir = true;
                    break;
                case "5"://Opción de salir
                    seguir = false;
                    break;
                default:
                    salida.println("Error!");
                    seguir = true;
                    break;
            }
        } while (seguir == true);
    }

    static void registrarProveedor() throws IOException {

        String nombre;
        String apellidos;
        String telefono;
        String direccion;
        String identificacion;
        String representante;
        String tipoProveedor;

        boolean error = false;
        boolean repetido = false;
        boolean verdadero ;



        do {
            if (repetido == true) {
                salida.println("La identificación se encuentra repetida. Ingrese una distinta");
            }
            salida.println("Digite la identificación de la persona");
            identificacion = entrada.readLine();

            //repetido = gestor.validarIdentificacion(identificacion);

        } while (repetido == true);

            salida.println("Ingrese el nombre de esta persona");
            nombre = entrada.readLine();


        salida.println("Digite la dirección");
        direccion = entrada.readLine();
        salida.println("Ingrese el número de teléfono");
        telefono = entrada.readLine();


        do {
            salida.println("Seleccione '1' si es una organización o seleccione '2' si es una persona física");
            tipoProveedor = entrada.readLine().trim();
            switch (tipoProveedor) {
                case "1":
                    salida.println("Digite el nombre del representante legal");
                    representante = entrada.readLine();

                    gestor.registrarOrganizacion(identificacion, nombre, direccion, telefono, representante);
                    break;
                case "2":

                    salida.println("Ingrese el o los apellidos de esta persona");
                    apellidos = entrada.readLine();

                    gestor.registrarPersonaFisica(identificacion, nombre, apellidos, direccion, telefono);
                    break;
                default:
                    salida.println("El tipo de proveedor ingresado es inválido.");
                    error = true;
                    break;
            }
        } while (error == true);
    }


    static void registrarCliente() throws IOException{
        String nombre;
        String apellidos;
        String identificacion;
        String correo;
        String telefono;
        String provincia;
        String canton;
        String distrito;
        String direccion;

        boolean repetido=false;

        salida.println("Ingrese el nombre del cliente");
        nombre = entrada.readLine();
        salida.println("Ingrese el o los apellidos de esta persona");
        apellidos = entrada.readLine();
        do {
            if (repetido == true) {
                salida.println("La identificación se encuentra repetida. Ingrese una distinta");
            }
            salida.println("Digite la identificación de la persona");
            identificacion = entrada.readLine();

            //repetido = gestor.validarIdentificacion(identificacion);

        } while (repetido == true);

        salida.println("Ingrese el correo de este cliente");
        correo = entrada.readLine();
        salida.println("Ingrese la provincia de residencia");
        provincia = entrada.readLine();
        salida.println("Ingrese el cantón de residencia");
        canton = entrada.readLine();
        salida.println("Ingrese el distrito de residencia");
        distrito = entrada.readLine();
        salida.println("Ingrese la dirección exacta de residencia");
        direccion = entrada.readLine();

        salida.println("Ingrese el número de teléfono del cliente");
        telefono = entrada.readLine();

        gestor.registrarClientes(identificacion, nombre, apellidos, correo, provincia, canton, distrito, direccion, telefono);
    }


    static void listarProveedores() {


        String [] lista = new String[gestor.imprimirListaProveedores().length];

        for (String ob: gestor.imprimirListaProveedores()){
            salida.println(ob);
        }
    }

    static void listarClientes() {
        String [] lista = new String[gestor.imprimirListaClientes().length];

        for (String ob: gestor.imprimirListaClientes()){
            salida.println(ob);
        }
    }
}
