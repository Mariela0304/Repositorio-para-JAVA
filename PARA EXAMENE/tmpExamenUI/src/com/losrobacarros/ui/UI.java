package com.losrobacarros.ui;

import com.losrobacarros.tl.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.IOException;



public class UI {

    static BufferedReader entrada = new BufferedReader(
            new InputStreamReader(System.in));
    static PrintStream salida = System.out;

    public static void main(String[] args) throws IOException {
        menuInicial();
    }



    static void menuInicial() throws IOException{
        String menu;

        boolean seguir = true;
        salida.println("\n===================================================================\n");
        System.out.println(" ¡Bienvenido al sistema del parqueo Los Roba Carros:parqueo seguro!");
        salida.println("\n===================================================================\n");
        do {
            salida.println("\n===================================================================\n");
            System.out.println("Usted está en el menú inicial");
            salida.println("\n===================================================================\n");
            salida.println("1.Registrar parqueo");
            salida.println("2.Iniciar sesión");
            salida.println("3.Registrarse como empleado");
            salida.println("0.Salir");

            salida.println("Elija una opción");
            menu = entrada.readLine();
            switch (menu) {
                case "1":
                    registroParqueo();
                    seguir = true;
                    break;
                case "2":
                    iniciarSesion();
                    seguir = true;
                    break;
                case "3":
                    registroEmpleado();
                    seguir = true;
                    break;
                default:
                    salida.println("Error!");
                    seguir = true;
                    break;
            }
        } while (seguir == true);
    }

    static void mostrarMenu() throws IOException{
        String menu;
        boolean seguir = true;
        do {
            salida.println("\n1.Configuración del parqueo" +
                    "\n2.Configuración de los empleados" +
                    "\n3.Configuración de los clientes" +
                    "\n4.Configuración de los espacios" +
                    "\n5.Configuración de los ingresos" +
                    "\n0.Cerrar sesión");
            salida.println("Elija una opción");
            menu = entrada.readLine();
            switch (menu) {
                case "1"://Menú del parqueo
                    mostrarMenuParqueo();
                    seguir = true;
                    break;
                case "2"://Menú de los empleados
                    mostrarMenuEmpleados();
                    seguir = true;
                    break;
                case "3"://Menú de los clientes
                    mostrarMenuClientes();
                    seguir = true;
                    break;
                case "4"://Menú de los espacios
                    mostrarMenuEspacios();
                    seguir = true;
                    break;
                case "5"://Menú de los ingresso
                    mostrarMenuIngresos();
                    seguir = true;
                    break;
                case "0"://Opción de cerrar sesión
                    seguir = false;
                    break;
                default:
                    salida.println("Error!");
                    seguir = true;
                    break;
            }
        } while (seguir == true);
    }

    static void mostrarMenuParqueo() throws IOException{
        String menu;
        boolean seguir = true;
        do {
            salida.println("\n1.Configuración del parqueo" +
                    "\n2.Modificar datos del parqueo" +
                    "\n3.Mostrar la configuracion del parqueo" +
                    "\n0.Volver al menú");
            salida.println("Elija una opción");
            menu = entrada.readLine();
            switch (menu) {
                case "1"://Registro del parqueo
                    registroParqueo();
                    seguir = true;
                    break;
                case "2"://Modificar datos del parqueo
                    modificarParqueo();
                    seguir = true;
                    break;
                case "3"://Imprimir informarción del parqueo
                    imprimirListaParqueo();
                    seguir = true;
                    break;
                case "0"://Cerrar sesión
                    seguir = false;
                    break;
                default:
                    salida.println("Error!");
                    seguir = true;
                    break;
            }
        } while (seguir == true);
    }

    static void mostrarMenuEmpleados() throws IOException{
        String menu;
        boolean seguir = true;
        do {
            salida.println("\n1.Registro de empleado" +
                    "\n2.Modificar datos de empleado" +
                    "\n3.Listado de empleados" +
                    "\n0.Volver al menú");
            salida.println("Elija una opción");
            menu = entrada.readLine();
            switch (menu) {
                case "1"://Registro del empleado
                    registroEmpleado();
                    seguir = true;
                    break;
                case "2"://Modificar empleado
                    modificarEmpleado();
                    seguir = true;
                    break;
                case "3"://ListarEmpleados
                    imprimirListaEmpleados();
                    seguir = true;
                    break;
                case "0"://Opción de salir
                    seguir = false;
                    break;
                default:
                    salida.println("Opción inválida");
                    seguir = true;
                    break;
            }
        } while (seguir == true);
    }


    static void mostrarMenuClientes() throws IOException{
        String menu;
        boolean seguir = true;
        do {
            salida.println("\n1.Registro de cliente físico" +
                    "\n2.Registro de cliente jurídico" +
                    "\n3.Modificar cliente físico" +
                    "\n4.Modificar cliente jurídico" +
                    "\n5.Listar todos los clientes" +
                    "\n0.Volver al menú");
            salida.println("Elija una opción");
            menu = entrada.readLine();
            switch (menu) {
                case "1"://Registrar cliente físico
                    registroClienteFisico();
                    seguir = true;
                    break;
                case "2"://Registrar cliente jurídico
                    registroClienteJuridico();
                    seguir = true;
                    break;
                case "3"://Modificar datos del cliente físico
                    modificarClienteFisico();
                    seguir = true;
                    break;
                case "4"://Modificar datos del cliente jurídico
                    modificarClienteJuridico();
                    seguir = true;
                    break;
                case "5"://Modificar datos del parqueo
                    imprimirListaClientes();
                    seguir = true;
                    break;
                case "0"://Opción de salir
                    seguir = false;
                    break;
                default:
                    salida.println("Error!");
                    seguir = true;
                    break;
            }
        } while (seguir == true);
    }

    static void mostrarMenuEspacios() throws IOException{
        String menu;
        boolean seguir = true;
        do {
            salida.println("\n1.Registrar espacio" +
                    "\n2.Modificar datos del espacio" +
                    "\n3.Mostrar los espacios registrados" +
                    "\n0.Volver al menú");
            salida.println("Elija una opción");
            menu = entrada.readLine();
            switch (menu) {
                case "1"://Registro del espacio
                    registroParqueo();
                    seguir = true;
                    break;
                case "2"://Modificar los datos de un espacio
                    modificarEspacio();
                    seguir = true;
                    break;
                case "3"://Imprimir datos de los espacios
                    imprimirListaEspacios();
                    seguir = true;
                    break;
                case "0"://Opción de salir
                    seguir = false;
                    break;
                default:
                    salida.println("Error!");
                    seguir = true;
                    break;
            }
        } while (seguir == true);
    }


    static void mostrarMenuIngresos() throws IOException{
        String menu;
        boolean seguir = true;
        do {
            salida.println("\n1.Registrar ingreso de vehículo" +
                    "\n2.Registrar salida del vehículo" +
                    "\n3.Mostrar lista de todos los ingresos del parqueo" +
                    "\n0.Volver al menú");
            salida.println("Elija una opción");
            menu = entrada.readLine();
            switch (menu) {
                case "1"://Registro del parqueo
                    registroParqueo();
                    seguir = true;
                    break;
                case "2"://Modificar datos del parqueo
                    modificarParqueo();
                    seguir = true;
                    break;
                case "3"://Imprimir informarción del parqueo
                    imprimirListaParqueo();
                    seguir = true;
                    break;
                case "0"://Cerrar sesión
                    seguir = false;
                    break;
                default:
                    salida.println("Error!");
                    seguir = true;
                    break;
            }
        } while (seguir == true);
    }

    static void iniciarSesion() throws IOException {
        String nombreUsuario;
        String contrasenna;
        ControllerUsuario gestorUsuario = new ControllerUsuario();
        ControllerParqueo gestorParquero = new ControllerParqueo();
        String registrado;
        boolean continuar = false;

        do {
            salida.println("Ingrese su nombre de usuario");
            nombreUsuario = entrada.readLine();
            salida.println("Ingrese su contraseña");
            contrasenna = entrada.readLine();

            registrado = gestorUsuario.validarCredenciales(nombreUsuario, contrasenna);

            switch (registrado){
                case "1":
                    continuar = true;
                    gestorParquero.validarExistenciaParqueo();
                    salida.println("Usted ha iniciado sesión correctamente");
                    mostrarMenu();
                    break;
                case "2":
                    salida.println("\n===========================================================");
                    salida.println("La contraseña no coincide con la del nombre de usuario");
                    salida.println("============================================================\n");
                    continuar = false;
                    break;
                case "0":
                    salida.println("\n===========================================================");
                    salida.println("El nombre de usuario no se encuentra registrado en nuestros ");
                    salida.println("servidores");
                    salida.println("============================================================\n");
                    continuar = false;
                    break;
                default:
                    break;
            }
        } while (!continuar);
    }



    /*
    Método que registra el parqueo
     */
    static void registroParqueo() throws IOException {
        String nombre = "";
        String direccion;
        int cantEspacios;
        String preguntaEspacios = "";

        boolean registrado;

        ControllerParqueo gestorParqueo = new ControllerParqueo();
        ControllerUsuario gestorUsuario = new ControllerUsuario();

        if (gestorParqueo.validarExistenciaParqueo()) {
            salida.println("\n===========================================================\n");
            System.out.println(" El parqueo ya se ha registrado anteriormente");
            salida.println("\n===========================================================\n");
            mostrarMenu();
        } else {

            do {
                if(!validarNombres(nombre)) {
                    salida.println("\n===========================================================\n");
                    System.out.println(" Recuerde no ingresar números");
                    salida.println("\n===========================================================\n");
                }
                salida.println("Ingrese el nombre del parqueo");
                nombre = entrada.readLine();

            } while (!validarNombres(nombre));

            salida.println("Ingrese la dirección de donde se encuentra");
            direccion = entrada.readLine();

            do {
                if(!gestorUsuario.validar(preguntaEspacios)) {
                    salida.println("\n===========================================================\n");
                    System.out.println(" Debe ingresar números");
                    salida.println("\n===========================================================\n");
                }
                salida.println("Ingrese la cantidad de espacios disponibles");
                preguntaEspacios = entrada.readLine();
            } while (!gestorUsuario.validar(preguntaEspacios));
             cantEspacios = Integer.parseInt(preguntaEspacios);


            if (gestorParqueo.registrarParqueo(nombre, direccion, cantEspacios)) {
                salida.println("\n===========================================================\n");
                salida.println("  Se registró correctamente");
                salida.println("\n===========================================================\n");
            } else {
                salida.println("\n===========================================================\n");
                salida.println("  No se pudo registrar el parqueo");
                salida.println("\n===========================================================\n");
            }
        }
    }



    /*
    Métodos de registro de empleados
     */

    static void registroEmpleado() throws IOException {
        String nombre = "";
        String apellido = "";
        String identificacion = "";
        int numEmpleado;
        String nombreUsuario;
        String contrasenna;
        int horaEntrada;
        int horaSalida;
        boolean repetido = false;
        String preguntaNumero = "";

        ControllerUsuario gestorUsuario = new ControllerUsuario();
        ControllerEmpleado gestorEmpleado = new ControllerEmpleado();

         do{
            if(!validarNombres(nombre)) {
                salida.println("\n===========================================================");
                System.out.println(" Recuerde no ingresar números");
                salida.println("===========================================================\n");
            }
             salida.println("Ingrese el nombre del empleado");
             nombre = entrada.readLine();

        } while (!validarNombres(nombre));


        do{
            if(!validarNombres(apellido)) {
                salida.println("\n===========================================================");
                System.out.println(" Recuerde no ingresar números");
                salida.println("===========================================================\n");
            }
            salida.println("Ingrese el apellido del empleado");
            apellido = entrada.readLine();
        } while (!validarNombres(apellido));



        do {
            if (repetido) {
                salida.println("\n===========================================================");
                salida.println("Esta identificación ya se encuentra registrada");
                salida.println("===========================================================\n");
            }
            salida.println("Ingrese la identificación");
            identificacion = entrada.readLine();
            repetido = gestorUsuario.validarIdentificacion(identificacion);
        } while (repetido);


        do {
            if (repetido) {
                salida.println("\n===========================================================");
                salida.println("Este número ya se encuentra registrado en otro empleado");
                salida.println("===========================================================\n");
            }
            salida.println("Ingrese un número de empleado");
            numEmpleado = Integer.parseInt(entrada.readLine());
            repetido = gestorUsuario.validarNumEmpleado(numEmpleado);
        } while (repetido);


        do {
            if (repetido) {
                salida.println("\n===========================================================");
                salida.println("Este nombre de usuario ya se encuentra registrado. \n" +
                                "Por favor ingrese uno nuevamente.");
                salida.println("===========================================================\n");
            }
            salida.println("Ingrese un nombre de usuario");
            nombreUsuario = entrada.readLine();
            repetido = gestorUsuario.validarNombreUsuario(nombreUsuario);
        } while (repetido);


        salida.println("Ingrese una contraseña");
        contrasenna = entrada.readLine();



        do {
            if(!gestorUsuario.validar(preguntaNumero)) {
                salida.println("\n===========================================================\n");
                System.out.println(" Ingrese la hora en número entero");
                salida.println("\n===========================================================\n");
            }
            salida.println("Ingrese la hora de entrada");
            preguntaNumero = entrada.readLine();
        } while (!gestorUsuario.validar(preguntaNumero));
        horaEntrada = Integer.parseInt(preguntaNumero);

        do {
            if(!gestorUsuario.validar(preguntaNumero)) {
                salida.println("\n===========================================================\n");
                System.out.println(" Ingrese la hora en número entero");
                salida.println("\n===========================================================\n");
            }
            salida.println("Ingrese la hora de salida");
            preguntaNumero = entrada.readLine();
        } while (!gestorUsuario.validar(preguntaNumero));
        horaSalida = Integer.parseInt(preguntaNumero);

        if (gestorEmpleado.registrarEmpleado(nombre, apellido, identificacion, numEmpleado, nombreUsuario,
                contrasenna, horaEntrada, horaSalida)) {
            salida.println("\n===========================================================\n");
            salida.println("  El empleado se ha registrado correctamente");
            salida.println("\n===========================================================\n");
        } else {
            salida.println("\n===========================================================\n");
            salida.println("  No se pudo registrar el empleado");
            salida.println("\n===========================================================\n");
        }

    }



    /*
    Método que registra a los clientes físicos
     */

    static void registroClienteFisico() throws IOException {
        String nombre = "";
        String apellido = "";
        String identificacion;
        String correo = "";
        String direccion;
        String telefono;
        boolean estado=false;
        String preguntaNumero  = "";
        String preguntaEstado;
        boolean correcto;
        ControllerUsuario gestorUsuario = new ControllerUsuario();
        ControllerCliente gestorCliente= new ControllerCliente();





        boolean repetido = false;


        do{
            if(!validarNombres(nombre)) {
                salida.println("\n===========================================================");
                System.out.println(" Recuerde no ingresar números");
                salida.println("===========================================================\n");
            }
            salida.println("Ingrese el nombre del cliente físico");
            nombre = entrada.readLine();

        } while (!validarNombres(nombre));


        do{
            if(!validarNombres(apellido)) {
                salida.println("\n===========================================================");
                salida.println(" Recuerde no ingresar números");
                salida.println("===========================================================\n");
            }
            salida.println("Ingrese el apellido del  cliente físico");
            apellido = entrada.readLine();
        } while (!validarNombres(apellido));





        do {
            if (repetido) {
                salida.println("\n===========================================================");
                salida.println("Esta identificación ya se encuentra registrada");
                salida.println("===========================================================\n");
            }
            salida.println("Ingrese la identificación del cliente físico");
            identificacion = entrada.readLine();
            repetido = gestorUsuario.validarIdentificacion(identificacion);
        } while (repetido);



        do {
            if (repetido) {
                salida.println("\n===========================================================");
                salida.println("Esta identificación ya se encuentra registrada");
                salida.println("===========================================================\n");
            }
            salida.println("Ingrese el correo del cliente físico");
            correo = entrada.readLine();
            repetido = gestorUsuario.validarCorreo(correo);
        } while (repetido);


        salida.println("Ingrese la dirección del cliente");
        direccion = entrada.readLine();

        salida.println("Ingrese el número de teléfono");
        telefono = entrada.readLine();



        do {
            salida.println("Ingrese 'si', si se encuentra en estado activo" +
                    " o ingrese 'no' si su estado se encuentra en inactivo");
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
                    salida.println("\n===========================================================");
                    salida.println("Ingresó un dato inválido. Inténtelo de nuevo\n");
                    salida.println("===========================================================\n");
            }

        } while (!correcto);




        if (gestorCliente.registrarClienteFisico(nombre, apellido, identificacion, correo,
                direccion, telefono, estado)) {
            salida.println("\n===========================================================\n");
            salida.println("  El cliente físico se ha registrado correctamente");
            salida.println("\n===========================================================\n");
        } else {
            salida.println("\n===========================================================\n");
            salida.println("  No se pudo registrar el cliente físico");
            salida.println("\n===========================================================\n");
        }

    }


    /*
    Método que registra a los clientes físicos
     */

    static void registroClienteJuridico() throws IOException {
        ControllerUsuario gestorUsuario = new ControllerUsuario();
        ControllerCliente gestorCliente= new ControllerCliente();
        String nombre = "";
        String cedulaJuridica;
        String direccion;
        boolean estado=false;
        String preguntaEstado;
        String preguntaNumero = "";

        boolean correcto;
        boolean repetido = false;

        do{
            if(!validarNombres(nombre)) {
                salida.println("\n===========================================================");
                System.out.println(" Recuerde no ingresar números");
                salida.println("===========================================================\n");
            }
            salida.println("Ingrese el nombre del cliente jurídico");
            nombre = entrada.readLine();

        } while (!validarNombres(nombre));


        do {
            if (repetido) {
                salida.println("\n===========================================================");
                salida.println("Esta identificación ya se encuentra registrada");
                salida.println("===========================================================\n");
            }
            salida.println("Ingrese la cedula jurídica del cliente jurídico");
            cedulaJuridica = entrada.readLine();
            repetido = gestorUsuario.validarIdentificacion(cedulaJuridica);
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


        if (gestorCliente.registrarClienteJuridico(nombre, cedulaJuridica,
                direccion, estado)) {
            salida.println("\n===========================================================\n");
            salida.println("  El cliente jurídico se ha registrado correctamente");
            salida.println("\n===========================================================\n");
        } else {
            salida.println("\n===========================================================\n");
            salida.println("  No se pudo registrar el cliente jurídico");
            salida.println("\n===========================================================\n");
        }
    }

    /*
    Método que va a registrar los espacios
     */

    static void registroEspacios() throws IOException {
        String tipoEspacio;
        int numEspacio;
        boolean ocupado = false;
        String preguntaNumero = "";
        boolean repetido = false;
        boolean noAceptado= false;
        boolean valido = false;
        boolean error;

        ControllerUsuario gestorUsuario = new ControllerUsuario();
        ControllerEspacio gestorEspacio = new ControllerEspacio();
        ControllerParqueo gestorParqueo= new ControllerParqueo();


        do {
            salida.println("Tipos de vehículos\n\n 'V' = Vehículos\n 'M' = Motocicletas\n 'B' = Bicicletas");
            salida.println("Ingrese la letra correspondiente al tipo de vehículo");
            tipoEspacio = entrada.readLine();

            switch (tipoEspacio) {
                case "V":
                    error=false;
                    break;
                case "M":
                    error=false;
                    break;
                case "B":
                    error=false;
                    break;
                default:
                    salida.println("\n===========================================================");
                    salida.println("Ingresó un dato inválido. Ingréselo nuevamente");
                    salida.println("===========================================================\n");
                    error=true;
            }
        }while (error);

        /*
        En este procedimiento se valida que no hayan números de espacios repetidos
        y que ese número no se pase de la cantidad de espacios que hay en el parqueo
         */
        do {
            do {
                if(!gestorUsuario.validar(preguntaNumero)) {
                    salida.println("\n===========================================================");
                    System.out.println(" Recuerde que la cantidad es numérica");
                    salida.println("===========================================================\n");
                }
                salida.println("Ingrese el número del espacio");
                preguntaNumero = entrada.readLine();
            } while (!gestorUsuario.validar(preguntaNumero));

            numEspacio = Integer.parseInt(preguntaNumero);
            noAceptado = gestorParqueo.validarCantidadEspacios(numEspacio);

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
                repetido = gestorEspacio.validarNumEspacio(numEspacio);

                } while (repetido);
                noAceptado=false;

            }
        }while (noAceptado);


        if (gestorEspacio.registrarEspacio(tipoEspacio, numEspacio)) {
            salida.println("\n===========================================================\n");
            salida.println("  El espacio se ha registrado correctamente");
            salida.println("\n===========================================================\n");
        } else {
            salida.println("\n===========================================================\n");
            salida.println("  No se pudo registrar el espacio");
            salida.println("\n===========================================================\n");
        }
    }


    static void registroIngreso() throws IOException  {
        String numPlaca;
        String preguntaNumero= "";
        String pregunta= "";
        int horaEntrada;
        int numEspacio;
        boolean repetido = false;
        boolean existe = false;
        boolean ocupado = false;
        boolean correcto = false;

        ControllerIngreso gestorIngreso = new ControllerIngreso();
        ControllerEspacio gestorEspacio = new ControllerEspacio();
        ControllerUsuario gestorUsuario = new ControllerUsuario();


        do {
            if (repetido) {
                salida.println("\n===========================================================");
                salida.println("Este número de placa ya se encuentra utilizando nuestro parqueo");
                salida.println("===========================================================\n");
            }
            salida.println("Ingrese el número de placa");
            numPlaca = entrada.readLine();

            repetido = gestorEspacio.validarPlacaEspacio(numPlaca);
        } while (repetido);


        do {
            if(!gestorUsuario.validar(preguntaNumero)) {
                salida.println("\n===========================================================\n");
                System.out.println(" Ingrese la hora en número entero");
                salida.println("\n===========================================================\n");
            }
            salida.println("Ingrese la hora de entrada al parqueo");
            preguntaNumero = entrada.readLine();
        } while (!gestorUsuario.validar(preguntaNumero));
        horaEntrada = Integer.parseInt(preguntaNumero);

        do {
            do {
                if(!gestorUsuario.validar(preguntaNumero)) {
                    salida.println("\n===========================================================\n");
                    System.out.println(" Ingrese el número del espacio en número entero");
                    salida.println("\n===========================================================\n");
                }
                salida.println("Ingrese el número del espacio del parqueo");
                preguntaNumero = entrada.readLine();
            } while (!gestorUsuario.validar(preguntaNumero));
            numEspacio = Integer.parseInt(preguntaNumero);
            do {
                existe = gestorEspacio.validarNumEspacio(numEspacio);
            }while (!existe);
           ocupado = gestorEspacio.validarEstadoEspacio(numEspacio);

           if (ocupado) {
               correcto = false;
               salida.println("\n===========================================================\n");
               System.out.println(" Este espacio se encuentra ocupado");
               salida.println("\n===========================================================\n");

           } else {
               correcto = true;
           }

        } while (!correcto);



        if (gestorIngreso.registrarIngresoVehiculo(numPlaca, numEspacio, horaEntrada)) {
            salida.println("\n===========================================================\n");
            salida.println("  El ingreso se ha registrado correctamente");
            salida.println("\n===========================================================\n");
        } else {
            salida.println("\n===========================================================\n");
            salida.println("  No se pudo registrar el ingreso del vehículo");
            salida.println("\n===========================================================\n");
        }

    }

    static void registroSalida() throws IOException  {
        String numPlaca;
        String preguntaNumero= "";
        String pregunta= "";
        int horaEntrada;
        int horaSalida;
        int numEspacio;
        double tarifaFinal;
        boolean repetido = false;
        boolean existe = false;
        boolean ocupado = false;

        boolean seguir = false;
        boolean correcto = false;

        ControllerIngreso gestorIngreso = new ControllerIngreso();
        ControllerEspacio gestorEspacio = new ControllerEspacio();
        ControllerUsuario gestorUsuario = new ControllerUsuario();


        do {
            if (!repetido) {
                salida.println("\n===========================================================");
                salida.println(" Este número de placa no se encuentra en nuestro parqueo");
                salida.println("===========================================================\n");
                do {
                    salida.println("Indique que desea hacer ");
                    salida.println("1.Volver a intentar con otra placa");
                    salida.println("2.Volver al menú inicial e intentar otra opción");
                    pregunta = entrada.readLine();
                    switch (pregunta){
                        case "1":
                            seguir=true;
                            break;
                        case "2":
                            mostrarMenu();
                            seguir=false;
                            break;
                        default:
                            salida.println("Opción inválida");
                            seguir=false;
                            break;
                    }
                    break;
                }while (!seguir);
            }
            salida.println("Ingrese el número de placa");
            numPlaca = entrada.readLine();

            repetido = gestorEspacio.validarPlacaEspacio(numPlaca);
        } while (!repetido);


        do {
            if(!gestorUsuario.validar(preguntaNumero)) {
                salida.println("\n===========================================================\n");
                System.out.println(" Ingrese la hora en número entero");
                salida.println("\n===========================================================\n");
            }
            salida.println("Ingrese la hora de entrada al parqueo");
            preguntaNumero = entrada.readLine();
        } while (!gestorUsuario.validar(preguntaNumero));
        horaEntrada = Integer.parseInt(preguntaNumero);

        numEspacio = gestorIngreso.obtenerEspacioPlaca(numPlaca);



        do {
            if(!gestorUsuario.validar(preguntaNumero)) {
                salida.println("\n===========================================================\n");
                System.out.println(" Ingrese la hora en número entero");
                salida.println("\n===========================================================\n");
            }
            salida.println("Ingrese la hora de salida");
            preguntaNumero = entrada.readLine();
        } while (!gestorUsuario.validar(preguntaNumero));
        horaSalida = Integer.parseInt(preguntaNumero);

        do {
            if(!gestorUsuario.validar(preguntaNumero)) {
                salida.println("\n===========================================================\n");
                System.out.println(" Ingrese la tarifa en número entero");
                salida.println("\n===========================================================\n");
            }
            salida.println("Ingrese la tarifa final del uso del parqueo");
            preguntaNumero = entrada.readLine();
        } while (!gestorUsuario.validar(preguntaNumero));
        tarifaFinal = Integer.parseInt(preguntaNumero);



        if (gestorIngreso.registrarRetiroVehiculo(numPlaca, numEspacio, horaSalida, tarifaFinal)) {
            salida.println("\n===========================================================\n");
            salida.println("  El retiro se ha registrado correctamente");
            salida.println("\n===========================================================\n");
        } else {
            salida.println("\n===========================================================\n");
            salida.println("  No se pudo registrar el retiro del vehículo");
            salida.println("\n===========================================================\n");
        }

    }


    /*
    Métodos de modificar
     */

    static void modificarParqueo() throws IOException  {
        ControllerParqueo gestorParqueo = new ControllerParqueo();
        ControllerUsuario gestorUsuario = new ControllerUsuario();
        String nombre;
        String direccion;
        int cantEspacios;
        String preguntaEspacios = "";

        String pregunta;
        String [] datosParqueo = gestorParqueo.obtenerDatosParqueo();

        boolean modificado;
        boolean seguir = false;
        boolean continuar = false;



        imprimirListaParqueo();


        do {
            do {
                salida.println("¿Cuál dato desea modificarle?");
                salida.println("1.El nombre");
                salida.println("2.La dirección");
                salida.println("3.La cantidad de espacios");
                pregunta = entrada.readLine();
                switch (pregunta) {
                    case "1":
                        salida.println("Ingrése el nuevo nombre");
                        nombre = entrada.readLine();
                        datosParqueo[0] = nombre;
                        seguir = true;
                        break;
                    case "2":
                        salida.println("Ingrése la nueva dirección");
                        direccion = entrada.readLine();
                        datosParqueo[1] = direccion;
                        seguir = true;
                        break;
                    case "3":

                        do {
                            if(!gestorUsuario.validar(preguntaEspacios)) {
                                salida.println("\n===========================================================\n");
                                System.out.println(" Debe ingresar números");
                                salida.println("\n===========================================================\n");
                            }
                            salida.println("Ingrése la nueva cantidad de espacios");
                            preguntaEspacios = entrada.readLine();
                        } while (!gestorUsuario.validar(preguntaEspacios));
                        datosParqueo[2] = preguntaEspacios;
                        seguir=true;
                        break;
                    default:
                        salida.println("Opción inválida");
                        seguir=false;
                        break;
                }
            }while (!seguir);

            salida.println("¿Desea hacer otra modificación?");
            salida.println("1.Sí");

            pregunta = entrada.readLine();

            if (pregunta.equals("1")) {
                continuar=false;
            } else {
                continuar = true;
            }



        }while (!continuar);

        if (gestorParqueo.modificarParqueo(datosParqueo)){
            salida.println("\n===========================================================\n");
            salida.println("  El parqueo se ha modificado correctamente");
            salida.println("\n===========================================================\n");
        } else {
            salida.println("\n===========================================================\n");
            salida.println("  No se pudo modificar el parqueo");
            salida.println("\n===========================================================\n");
        }

    }

    static void modificarEspacio() throws IOException  {
        ControllerUsuario gestorUsuario = new ControllerUsuario();
        ControllerEspacio gestorEspacio = new ControllerEspacio();
        ControllerParqueo gestorParqueo = new ControllerParqueo();
        String preguntaEspacios = "";
        int numEspacio;
        boolean error;
        boolean seguir = false;
        boolean continuar = false;
        boolean repetido = false;
        boolean noAceptado = false;
        String tipoEspacio;

        String pregunta;


        do {
            if(!gestorUsuario.validar(preguntaEspacios)) {
                salida.println("\n===========================================================\n");
                System.out.println(" Debe ingresar números");
                salida.println("\n===========================================================\n");
            }
            salida.println("Ingrese el número del espacio que desea modificar");
            preguntaEspacios = entrada.readLine();
        } while (!gestorUsuario.validar(preguntaEspacios));
        numEspacio = Integer.parseInt(preguntaEspacios);

        String [] infoEspacio = gestorEspacio.obtenerDatosEspacio(numEspacio);

        for (String dato: infoEspacio) {
            salida.println("Datos del espacio a modificar");
            salida.println(dato);
        }

        do {
            do {
                salida.println("¿Cuál dato desea modificarle?");
                salida.println("1.El tipo de vehículo que permite");
                salida.println("2.El número de espacio");
                pregunta = entrada.readLine();
                switch (pregunta) {
                    case "1":
                        do {
                            salida.println("Tipos de vehículos\n\n 'V' = Vehículos\n 'M' = Motocicletas\n 'B' = Bicicletas");
                            salida.println("Ingrese la letra correspondiente al tipo de vehículo");
                            tipoEspacio = entrada.readLine();

                            switch (tipoEspacio) {
                                case "V": //Vehículo
                                    error=false;
                                    break;
                                case "M"://Motocicleta
                                    error=false;
                                    break;
                                case "B"://Bicicleta
                                    error=false;
                                    break;
                                default:
                                    salida.println("\n===========================================================");
                                    salida.println("Ingresó un dato inválido. Ingréselo nuevamente");
                                    salida.println("===========================================================\n");
                                    error=true;
                            }
                        }while (error);
                        infoEspacio[0] = tipoEspacio;
                        seguir=true;
                        break;
                    case "2":
                        do {
                            do {
                                if(!gestorUsuario.validar(preguntaEspacios)) {
                                    salida.println("\n===========================================================");
                                    System.out.println(" Recuerde que la cantidad es numérica");
                                    salida.println("===========================================================\n");
                                }
                                salida.println("Ingrese el número del espacio");
                                pregunta = entrada.readLine();
                            } while (!gestorUsuario.validar(preguntaEspacios));

                            numEspacio = Integer.parseInt(preguntaEspacios);
                            noAceptado = gestorParqueo.validarCantidadEspacios(numEspacio);

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
                                    repetido = gestorEspacio.validarNumEspacio(numEspacio);

                                } while (repetido);
                                noAceptado=false;

                            }
                        }while (noAceptado);
                        infoEspacio[1] = preguntaEspacios;
                        seguir = true;

                        break;

                    default:
                        salida.println("Opción inválida");
                        seguir=false;
                        break;
                }
            }while (!seguir);

            salida.println("¿Desea hacer otra modificación?");
            salida.println("1.Sí");

            pregunta = entrada.readLine();

            if (pregunta.equals("1")) {
                continuar=false;
            } else {
                continuar = true;
            }



        }while (!continuar);



        if (gestorEspacio.modificarEspacio(infoEspacio)) {
            salida.println("\n===========================================================\n");
            salida.println("  El espacio se ha modificado correctamente");
            salida.println("\n===========================================================\n");
        } else {
            salida.println("\n===========================================================\n");
            salida.println("  No se pudo modificar el espacio");
            salida.println("\n===========================================================\n");
        }

    }

    static void modificarEmpleado() throws IOException  {
        ControllerUsuario gestorUsuario = new ControllerUsuario();
        ControllerEmpleado gestorEmpleado = new ControllerEmpleado();

        String[] infoEmpleado;
        int numEspacio;
        boolean error;
        String identificacion;
        boolean seguir = false;
        boolean continuar = false;
        boolean repetido = false;
        boolean noAceptado = false;
        String preguntaNumero = "";
        String pregunta;

        salida.println("Ingrese la identificacion del empleado que desee modificar");
        identificacion = entrada.readLine();

        if (gestorUsuario.validarIdentificacion(identificacion)) {

        } else {
            salida.println("Esta identificación no está registrada\nSerá redirigido al menú principal");
            menuInicial();
        }
        infoEmpleado = gestorEmpleado.obtenerDatosEmpleado(identificacion);

        for (String dato: infoEmpleado) {
            salida.println("Datos del empleado a modificar");
            salida.println(dato);
        }

        do {
            do {
                salida.println("¿Cuál dato desea modificarle?");
                salida.println("1.El nombre");
                salida.println("2.El apellido");
                salida.println("3.La hora de entrada");
                salida.println("4.La hora de salida");
                salida.println("5.El nombre de usuario");
                salida.println("6.La contraseña");
                pregunta = entrada.readLine();
                switch (pregunta) {
                    case "1":
                        do{
                            if(!validarNombres(infoEmpleado[0])) {
                                salida.println("\n===========================================================");
                                System.out.println(" Recuerde no ingresar números");
                                salida.println("===========================================================\n");
                            }
                            salida.println("Ingrese el nombre del empleado");
                            infoEmpleado[0] = entrada.readLine();

                        } while (!validarNombres(infoEmpleado[0]));


                        seguir=true;
                        break;
                    case "2":
                        do{
                            if(!validarNombres(infoEmpleado[1])) {
                                salida.println("\n===========================================================");
                                System.out.println(" Recuerde no ingresar números");
                                salida.println("===========================================================\n");
                            }
                            salida.println("Ingrese el apellido del empleado");
                            infoEmpleado[1] = entrada.readLine();
                        } while (!validarNombres(infoEmpleado[1]));
                        seguir=true;
                        break;

                    case "3"://modificar el nombre del usuario

                        do {
                            if (repetido) {
                                salida.println("\n===========================================================");
                                salida.println("Este nombre de usuario ya se encuentra registrado. \n" +
                                        "Por favor ingrese uno nuevamente.");
                                salida.println("===========================================================\n");
                            }
                            salida.println("Ingrese un nuevo nombre de usuario");
                            infoEmpleado[4] = entrada.readLine();
                            repetido = gestorUsuario.validarNombreUsuario(infoEmpleado[2]);
                        } while (repetido);
                        seguir = true;

                        break;
                    case "4":// modificar la contraseña
                        salida.println("Ingrese una nueva contraseña");
                        infoEmpleado[5] = entrada.readLine();
                        seguir = true;

                        break;
                    case "5":
                        do {
                            if(!gestorUsuario.validar(preguntaNumero)) {
                                salida.println("\n===========================================================\n");
                                System.out.println(" Ingrese la hora en número entero");
                                salida.println("\n===========================================================\n");
                            }
                            salida.println("Ingrese la hora de entrada");
                            preguntaNumero = entrada.readLine();
                        } while (!gestorUsuario.validar(preguntaNumero));
                        infoEmpleado[6] = preguntaNumero;



                        seguir = true;

                        break;
                    case "6":

                        do {
                            if(!gestorUsuario.validar(preguntaNumero)) {
                                salida.println("\n===========================================================\n");
                                System.out.println(" Ingrese la hora en número entero");
                                salida.println("\n===========================================================\n");
                            }
                            salida.println("Ingrese la hora de salida");
                            preguntaNumero = entrada.readLine();
                        } while (!gestorUsuario.validar(preguntaNumero));
                        infoEmpleado[7] = preguntaNumero;
                        seguir = true;

                        break;
                    default:
                        salida.println("Opción inválida");
                        seguir=false;
                        break;
                }
            }while (!seguir);

            salida.println("¿Desea hacer otra modificación?");
            salida.println("1.Sí");

            pregunta = entrada.readLine();

            if (pregunta.equals("1")) {
                continuar=false;
            } else {
                continuar = true;
            }

        }while (!continuar);

        if (gestorEmpleado.modificarEmpleado(infoEmpleado)) {
            salida.println("\n===========================================================\n");
            salida.println("  El empleado se ha modificado correctamente");
            salida.println("\n===========================================================\n");
        } else {
            salida.println("\n===========================================================\n");
            salida.println("  No se pudo modificar el empleado");
            salida.println("\n===========================================================\n");
        }

    }

    static void modificarClienteFisico() throws IOException  {
        ControllerUsuario gestorUsuario = new ControllerUsuario();
        ControllerCliente gestorCliente = new ControllerCliente();

        String[] infoCliente;
        int numEspacio;
        boolean error;
        String identificacion;
        boolean seguir = false;
        boolean continuar = false;
        boolean repetido = false;
        boolean noAceptado = false;
        String preguntaNumero = "";
        String pregunta;

        salida.println("Ingrese la identificacion del cliente físico que desee modificar");
        identificacion = entrada.readLine();

        if (gestorUsuario.validarIdentificacion(identificacion)) {

        } else {
            salida.println("Esta identificación no está registrada\nSerá redirigido al menú principal");
            menuInicial();
        }
        infoCliente = gestorCliente.obtenerDatosClienteFisico(identificacion);

        for (String dato: infoCliente) {
            salida.println("Datos del cliente físico a modificar");
            salida.println(dato);
        }


        do {
            do {
                salida.println("¿Cuál dato desea modificarle?");
                salida.println("1.El nombre");
                salida.println("2.El apellido");
                salida.println("3.Correo");
                salida.println("4.Teléfono");
                salida.println("5.Dirección");
                salida.println("6.Estado");
                pregunta = entrada.readLine();
                switch (pregunta) {
                    case "1":
                        do{
                            if(!validarNombres(infoCliente[0])) {
                                salida.println("\n===========================================================");
                                System.out.println(" Recuerde no ingresar números");
                                salida.println("===========================================================\n");
                            }
                            salida.println("Ingrese el nombre del cliente físico");
                            infoCliente[0] = entrada.readLine();

                        } while (!validarNombres(infoCliente[0]));


                        seguir=true;
                        break;
                    case "2":
                        do{
                            if(!validarNombres(infoCliente[1])) {
                                salida.println("\n===========================================================");
                                System.out.println(" Recuerde no ingresar números");
                                salida.println("===========================================================\n");
                            }
                            salida.println("Ingrese el apellido del cliente físico");
                            infoCliente[1] = entrada.readLine();
                        } while (!validarNombres(infoCliente[1]));
                        seguir=true;
                        break;

                    case "3"://modificar el correo

                        do {
                            if (repetido) {
                                salida.println("\n===========================================================");
                                salida.println("Este correo ya se encuentra registrado. \n" +
                                        "Por favor ingrese uno nuevamente.");
                                salida.println("===========================================================\n");
                            }
                            salida.println("Ingrese un nuevo correo electrónico");
                            infoCliente[3] = entrada.readLine();
                            repetido = gestorUsuario.validarCorreo(infoCliente[3]);
                        } while (repetido);
                        seguir = true;

                        break;
                    case "4":// modificar teleéfono
                        salida.println("Ingrese un nuevo teléfono");
                        infoCliente[4] = entrada.readLine();
                        seguir = true;

                        break;
                    case "5":
                        salida.println("Ingrese una nueva dirección");
                        infoCliente[5] = entrada.readLine();
                        seguir = true;

                        break;
                    case "6":

                       do {
                           salida.println("¿Actualmente se encuentra activo o inactivo?");
                           salida.println("1.Activo");
                           salida.println("2.Inactivo");
                           pregunta = entrada.readLine();
                           switch (pregunta) {
                               case "1":
                                   infoCliente[6] = "Activo";
                                   seguir=true;
                                   break;
                               case "2":
                                   infoCliente[6] = "Inactivo";
                                   seguir=true;
                                   break;
                               default:
                                   salida.println("Opción inválida");
                                   seguir=false;
                                   break;
                           }

                       }while (!seguir);
                        seguir = true;

                        break;
                    default:
                        salida.println("Opción inválida");
                        seguir=false;
                        break;
                }
            }while (!seguir);

            salida.println("¿Desea hacer otra modificación?");
            salida.println("1.Sí");

            pregunta = entrada.readLine();

            if (pregunta.equals("1")) {
                continuar=false;
            } else {
                continuar = true;
            }

        }while (!continuar);

        if (gestorCliente.modificarClienteFisico(infoCliente)) {
            salida.println("\n===========================================================\n");
            salida.println("  El cliente físico se ha modificado correctamente");
            salida.println("\n===========================================================\n");
        } else {
            salida.println("\n===========================================================\n");
            salida.println("  No se pudo modificar el cliente físico");
            salida.println("\n===========================================================\n");
        }

    }


    static void modificarClienteJuridico() throws IOException  {
        ControllerUsuario gestorUsuario = new ControllerUsuario();
        ControllerCliente gestorCliente = new ControllerCliente();

        String[] infoCliente;
        int numEspacio;
        boolean error;
        String identificacion;
        boolean seguir = false;
        boolean continuar = false;
        boolean repetido = false;
        boolean noAceptado = false;
        String preguntaNumero = "";
        String pregunta;

        salida.println("Ingrese la identificacion del cliente jurídico que desee modificar");
        identificacion = entrada.readLine();

        if (gestorUsuario.validarIdentificacion(identificacion)) {

        } else {
            salida.println("Esta identificación no está registrada\nSerá redirigido al menú principal");
            mostrarMenu();
        }
        infoCliente = gestorCliente.obtenerDatosClienteJuridico(identificacion);

        for (String dato: infoCliente) {
            salida.println("Datos del cliente jurídico a modificar");
            salida.println(dato);
        }


        do {
            do {
                salida.println("¿Cuál dato desea modificarle?");
                salida.println("1.El nombre");
                salida.println("2.Dirección");
                salida.println("3.Estado");
                pregunta = entrada.readLine();
                switch (pregunta) {
                    case "1":
                        do{
                            if(!validarNombres(infoCliente[0])) {
                                salida.println("\n===========================================================");
                                System.out.println(" Recuerde no ingresar números");
                                salida.println("===========================================================\n");
                            }
                            salida.println("Ingrese el nombre del cliente físico");
                            infoCliente[0] = entrada.readLine();

                        } while (!validarNombres(infoCliente[0]));


                        seguir=true;
                        break;

                    case "2":
                        salida.println("Ingrese una nueva dirección");
                        infoCliente[5] = entrada.readLine();
                        seguir = true;

                        break;
                    case "3":

                        do {
                            salida.println("¿Actualmente se encuentra activo o inactivo?");
                            salida.println("1.Activo");
                            salida.println("2.Inactivo");
                            pregunta = entrada.readLine();
                            switch (pregunta) {
                                case "1":
                                    infoCliente[6] = "Activo";
                                    seguir=true;
                                    break;
                                case "2":
                                    infoCliente[6] = "Inactivo";
                                    seguir=true;
                                    break;
                                default:
                                    salida.println("Opción inválida");
                                    seguir=false;
                                    break;
                            }

                        }while (!seguir);
                        seguir = true;

                        break;
                    default:
                        salida.println("Opción inválida");
                        seguir=false;
                        break;
                }
            }while (!seguir);

            salida.println("¿Desea hacer otra modificación?");
            salida.println("1.Sí");

            pregunta = entrada.readLine();

            if (pregunta.equals("1")) {
                continuar=false;
            } else {
                continuar = true;
            }

        }while (!continuar);

        if (gestorCliente.modificarClienteJuridico(infoCliente)) {
            salida.println("\n===========================================================\n");
            salida.println("  El cliente jurídico se ha modificado correctamente");
            salida.println("\n===========================================================\n");
        } else {
            salida.println("\n===========================================================\n");
            salida.println("  No se pudo modificar el cliente jurídico");
            salida.println("\n===========================================================\n");
        }

    }

    /*
    Métodos que imprimen las listas
     */

    static void imprimirListaParqueo() {
        ControllerParqueo gestorParqueo = new ControllerParqueo();
        for (String dato: gestorParqueo.listaParqueos()) {
            salida.println(dato);
        }

    }

    static void imprimirListaEmpleados() {
        ControllerEmpleado gestorEmpleado = new ControllerEmpleado();
        for (String info: gestorEmpleado.listaEmpleados()) {
            if (info != null) {
                salida.println(info);
            }
        }
    }

    static void imprimirListaClientes() {
        ControllerCliente gestorCliente = new ControllerCliente();

        for (String info: gestorCliente.listaClientes()) {
                salida.println(info);
        }
    }

    static void imprimirListaEspacios() {
        ControllerEspacio gestorEspacio = new ControllerEspacio();

        for (String info: gestorEspacio.listaEspacios()) {
            salida.println(info);
        }
    }

    static void imprimirListaIngresos() {
        ControllerIngreso gestorIngreso = new ControllerIngreso();

        for (String info: gestorIngreso.listaIngresos()) {
            salida.println(info);
        }
    }

    public static boolean validarNombres(String str) {
        String expression = "^[a-zA-Z:\\s]+";
        return str.matches(expression);
    }
}
