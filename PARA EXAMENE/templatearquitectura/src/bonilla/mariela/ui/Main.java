package bonilla.mariela.ui;

import bonilla.mariela.tl.Controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.IOException;



public class Main {

    static BufferedReader entrada = new BufferedReader(
            new InputStreamReader(System.in));
    static PrintStream salida = System.out;
    static Controller gestor = new Controller();

    public static void main(String[] args) throws IOException {
	mostrarMenu();
    }

    static void mostrarMenu() throws IOException{
        String menu;
        boolean seguir = true;
        do {
            salida.println("1.Configurar parqueo\n2.Mostrar la configuracion del parqueo" +
                    " \n3.Registro de empleados\n4.Listado de empleados\n5.Registro de cliente físico" +
                    "\n6.Registro de cliente jurídico\n7.Listado de clientes \n8.Registro de espacios" +
                    "\n9.Listado de espacios\n10.Salir");
            salida.println("Elija una opción");
            menu = entrada.readLine();
            switch (menu) {
                case "1"://Es un registro
                    registroParqueo();
                    seguir = true;
                    break;
                case "2"://Es un listar
                    imprimirListaParqueo();
                    seguir = true;
                    break;
                case "3"://Es un registro
                    registroEmpleado();
                    seguir = true;
                    break;
                case "4"://Listar
                    imprimirListaEmpleados();
                    seguir = true;
                    break;
                case "5"://Registro
                    registroClienteFisico();
                    seguir = true;
                    break;
                case "6"://Listar
                    registroClienteJuridico();
                    seguir = true;
                    break;
                case "7"://Registro
                    imprimirListaClientes();
                    seguir = true;
                    break;
                case "8"://Listar
                    registroEspacios();
                    seguir = true;
                    break;
                case "9"://Listar
                    imprimirListaEspacios();
                    seguir = true;
                    break;
                case "10"://Opción de salir
                    seguir = false;
                    break;
                default:
                    salida.println("Error!");
                    seguir = true;
                    break;
            }
        } while (seguir == true);
    }

    /*
    Método que registra el parqueo
     */
    static void registroParqueo() throws IOException {
        String nombre;
        String direccion;
        int cantEspacios;

        salida.println("Ingrese el nombre del parque");
        nombre = entrada.readLine();

        salida.println("Ingrese la dirección de donde se encuentra");
        direccion = entrada.readLine();

        salida.println("Ingrese la cantidad de espacios disponibles");
        cantEspacios = Integer.parseInt(entrada.readLine());

        gestor.registrarParqueo(nombre, direccion, cantEspacios);

    }


    /*
    Métodos de registro de empleados
     */

    static void registroEmpleado() throws IOException {
        String nombre;
        String apellido;
        String identificacion;
        int numEmpleado;
        String nombreUsuario;
        String contrasenna;
        int horaEntrada;
        int horaSalida;
        boolean repetido = false;

        salida.println("Ingrese el nombre");
        nombre = entrada.readLine();

        salida.println("Ingrese el apellido");
        apellido = entrada.readLine();


        do {
            if (repetido) {
                salida.println("Esta identificación ya se encuentra registrada");
            }
            salida.println("Ingrese la identificación");
            identificacion = entrada.readLine();
            repetido = gestor.validarIdentificacion(identificacion);
        } while (repetido);

        salida.println("Ingrese su número de empleado");
        numEmpleado = Integer.parseInt(entrada.readLine());

        salida.println("Ingrese su nombre de usuario");
        nombreUsuario = entrada.readLine();

        salida.println("Ingrese contraseña");
        contrasenna = entrada.readLine();

        salida.println("Ingrese la hora de entrada");
        horaEntrada = Integer.parseInt(entrada.readLine());


        salida.println("Ingrese la hora de salida");
        horaSalida = Integer.parseInt(entrada.readLine());


        String tipoUsuario= "Empleado";
        gestor.registrarEmpleado(tipoUsuario, nombre, apellido, identificacion, numEmpleado, nombreUsuario,
                contrasenna, horaEntrada, horaSalida);

    }



    /*
    Método que registra a los clientes físicos
     */

    static void registroClienteFisico() throws IOException {
        String nombre;
        String apellido;
        String identificacion;
        int codigo;
        String correo;
        String direccion;
        String telefono;
        boolean estado=false;
        String preguntaEstado;
        boolean correcto;





        boolean repetido = false;

        salida.println("Ingrese el nombre del cliente físico");
        nombre = entrada.readLine();

        salida.println("Ingrese el apellido del cliente físico");
        apellido = entrada.readLine();


        do {
            if (repetido) {
                salida.println("Esta identificación ya se encuentra registrada");
            }
            salida.println("Ingrese la identificación del cliente físico");
            identificacion = entrada.readLine();
            repetido = gestor.validarIdentificacion(identificacion);
        } while (repetido);

        salida.println("Ingrese el código del cliente físico");
        codigo = Integer.parseInt(entrada.readLine());

        salida.println("Ingrese el correo del cliente físico");
        correo = entrada.readLine();

        salida.println("Ingrese la dirección del cliente");
        direccion = entrada.readLine();

        salida.println("Ingrese el número de teléfono");
        telefono = entrada.readLine();



        do {
            salida.println("Ingrese 'si', si encuentra su estado es activo" +
                    " o ingrese 'no' si su estado se encuentra inactivo");
            preguntaEstado = entrada.readLine();
            switch (preguntaEstado) {
                case "si":
                    correcto= true;
                    estado = true;
                    break;
                case "no":
                    correcto= true;
                    estado=false;
                    break;
                default:
                    correcto=false;
                    salida.println("Ingresó un dato inválido. Inténtelo de nuevo\n");

            }

        } while (!correcto);



        String tipoUsuario= "Cliente";
        String tipoCliente="Cliente físico";


        gestor.registrarClienteFisico(tipoUsuario, tipoCliente, nombre, apellido, identificacion, correo,codigo,
                direccion, telefono, estado);

    }


    /*
    Método que registra a los clientes físicos
     */

    static void registroClienteJuridico() throws IOException {
        String nombre;
        String cedulaJuridica;
        String direccion;
        boolean estado=false;
        String preguntaEstado;
        int codigoCliente;

        boolean correcto;
        boolean repetido = false;

        salida.println("Ingrese el nombre del cliente jurídico");
        nombre = entrada.readLine();


        do {
            if (repetido) {
                salida.println("Esta identificación ya se encuentra registrada");
            }
            salida.println("Ingrese la cedula jurídica del cliente jurídico");
            cedulaJuridica = entrada.readLine();
            repetido = gestor.validarIdentificacion(cedulaJuridica);
        } while (repetido);


        salida.println("Ingrese la dirección del cliente jurídico");
        direccion = entrada.readLine();


        do {
            salida.println("Ingrese 'si', si encuentra su estado es activo" +
                    " o ingrese 'no' si su estado se encuentra inactivo");
            preguntaEstado = entrada.readLine();
            switch (preguntaEstado) {
                case "si":
                    correcto= true;
                    estado = true;
                    break;
                case "no":
                    correcto= true;
                    estado=false;
                    break;
                default:
                    correcto=false;
                    salida.println("Ingresó un dato inválido. Inténtelo de nuevo\n");

            }

        } while (!correcto);


        salida.println("Ingrese el código del cliente físico asociado");
        codigoCliente = Integer.parseInt(entrada.readLine());

        String tipoUsuario= "Cliente";
        String tipoCliente="Cliente juridico";


        gestor.registrarClienteJuridico(tipoUsuario, tipoCliente,nombre, cedulaJuridica,
                direccion, estado, codigoCliente);

    }

    /*
    Método que va a registrar los espacios
     */

    static void registroEspacios() throws IOException {
        String tipoEspacio;
        int numEspacio;
        boolean ocupado = false;
        String preguntaOcupado;
        boolean repetido = false;
        boolean noAceptado= false;
        boolean valido = false;
        boolean error;


        do {
            salida.println("TIPOS DE VEHÍCULOS\n\n 'V' = Vehículos\n 'M' = Motocicletas\n 'B' = Bicicletas");
            salida.println("Ingrese la letra correspondiente al tipo de vehículo");
            tipoEspacio = entrada.readLine();

            switch (tipoEspacio) {
                case "V":
                    tipoEspacio= "Vehículo";
                    error=false;
                    break;
                case "M":
                    tipoEspacio= "Motocicleta";
                    error=false;
                    break;
                case "B":
                    tipoEspacio= "Bicicleta";
                    error=false;
                    break;
                default:
                    salida.println("Ingresó un dato inválido. Ingréselo nuevamente");
                    error=true;
            }
        }while (error);

        /*
        En este procedimiento se valida que no hayan números de espacios repetidos
        y que ese número no se pase de la cantidad de espacios que hay en el parqueo
         */
        do {


            salida.println("Ingrese el número del espacio");
            numEspacio = Integer.parseInt(entrada.readLine());

            noAceptado = gestor.validarCantidadEspacios(numEspacio);

            if(noAceptado) {
                salida.println("Este número de espacio no es compatible con la cantidad de espacios disponibles " +
                        "en el parqueo");
                noAceptado= true;
            } else {
                do {

                    if (repetido) {
                        salida.println("Este número de espacio ya se encuentra registrado");
                        salida.println("Ingrese el número del espacio");
                        numEspacio = Integer.parseInt(entrada.readLine());
                    }
                repetido = gestor.validarNumEspacio(numEspacio);

                } while (repetido);
                noAceptado=false;

            }
        }while (noAceptado);


        do {
            salida.println("Ingrese 'si', si el espacio se encuentra ocupado" +
                    " o ingrese 'no' si el espacio se encuentra desocupado");
            preguntaOcupado = entrada.readLine();
            switch (preguntaOcupado) {
                case "si":
                    valido= true;
                    ocupado = true;
                    break;
                case "no":
                    valido= true;
                    ocupado=false;
                    break;
                default:
                    valido=false;
                    salida.println("Ingresó un dato inválido. Inténtelo de nuevo\n");

            }
        } while (!valido);


        gestor.registrarEspacio(tipoEspacio, numEspacio, ocupado);
    }



    /*
    Métodos que imprimen las listas
     */

    static void imprimirListaParqueo() {
        String [] lista = gestor.listaParqueos();

        for (String info: lista) {
            salida.println(info);
        }

    }

    static void imprimirListaEmpleados() {
        String [] lista = gestor.listaEmpleados();

        for (String info: lista) {
            salida.println(info);
        }
    }

    static void imprimirListaClientes() {
        String [] lista = gestor.listaClientes();

        for (String info: lista) {
            salida.println(info);
        }
    }

    static void imprimirListaEspacios() {
        String [] lista = gestor.listaEspacios();

        for (String info: lista) {
            salida.println(info);
        }
    }


}
