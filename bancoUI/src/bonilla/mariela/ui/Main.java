package bonilla.mariela.ui;

import bonilla.mariela.tl.Controller;

import java.io.*;
import java.time.LocalDate;
import java.util.Scanner;


public class Main {
    static Controller gestor = new Controller();
    static PrintStream salida = System.out;
    static Scanner entrada = new Scanner(System.in);


    public static void main(String[] args) throws IOException {
        gestor.realizarDepositoCAP();
        mostrarMenu();
    }

    public static void mostrarMenu() throws IOException {


        int opcion;
        opcion = -1;
        do {
            salida.println("1. Registrar clientes");
            salida.println("2. Registrar cuentas");
            salida.println("3. Listar clientes");
            salida.println("4. Listar cuentas");
            salida.println("5. Depositar saldo");
            salida.println("6. Retirar dinero");
            salida.println("7. Consultar saldo");
            salida.println("8. Imprimir movimientos");
            salida.println("9. Tasa de interes");
            salida.println("0. Salir");
            salida.println("Digite las opción que desea");
            opcion = Integer.parseInt(entrada.next());
            procesarOpcion(opcion);
        } while (opcion != 0);
    }

    public static void procesarOpcion(int pOpcion) throws IOException {
        switch (pOpcion) {
            case 1:
                registrarCliente();
                break;
            case 2:
                registroCuenta();
                break;
            case 3:
                listarClientes();
                break;
            case 4:
                listarCuentas();
                break;
            case 5:
                depositarSaldo();
                break;
            case 6:
                retirarDinero();
                break;
            case 7:
                consultarSaldo();
                break;
            case 8:
                listarMovimientos();
                break;
            case 9:
                tasaInteres();
                break;
            case 0:
                salida.println("Adiós");
                break;

            default:
                salida.print("Opción inválida");
                break;
        }
    }

    public static void registroCuenta() throws IOException {
        String info = "";
        double saldo;
        int cuenta;
        String cedula = "";
        int numeroCuenta = 0;
        boolean bandera = false;
        int opcion = 0;
        String tipoCuenta;
        boolean bandera2 = false;
        boolean bandera3 = false;
        boolean numCorrecto = false;
        String pregunta;
        boolean cantidadCorrecta = false;

        salida.println("Bienvenido al Banco 'Los lavadores dot com'");
        do {
            salida.println("Seleccione un tipo de cuenta");
            salida.println("1. Cuenta de ahorro");
            salida.println("2. Cuenta corriente");
            salida.println("3. Cuenta de ahorro programado");
            salida.println("Ingrese una opción");
            opcion = entrada.nextInt();

            switch (opcion) {
                case 1: // cuenta de ahorro

                    do {
                        System.out.println("Ingrese la cédula del cliente");
                        cedula = entrada.next();
                        bandera = gestor.validarIdentificacion2(cedula);
                        if (bandera == false) {
                            salida.println("--------------------------------------------------------------------------");
                            salida.println("'' Este cliente no está registrado en el sistema\n" +
                                    "'' Debe de estar registrado en el sistema para poder registrar una " +
                                    "cuenta.\n" +
                                    "'' Si aún no tiene una cuenta registrada, por favor digite 1 si desea \n" +
                                    "'' registrarse dentro del sistema\n'' Digite 2 si desea volver \n" +
                                    "'' a intentar con su cédula");
                            salida.println("--------------------------------------------------------------------------");
                            salida.println("\nIngrese la opción");

                            pregunta = entrada.next();
                            if (pregunta.equals("1")) {
                                registrarCliente();
                                salida.println("-----------------------------------------------------------");
                                salida.println("Ya ha realizado su registro dentro del sistema, puede \n" +
                                        "continuar con el registro de su cuenta");
                                salida.println("--------------------------------------------------------");
                            }
                        }
                    } while (bandera == false);

                    do {
                        do {

                            do {
                                salida.println("Ingrese es el número de la cuenta");
                                cuenta = entrada.nextInt();
                                numCorrecto = gestor.validarNumero(Integer.toString(cuenta));
                            } while (!numCorrecto);
                            /*
                            Va a validar que la cuenta cuenta sea de 7 dígitos
                            @Mariela Bonilla
                             */

                            bandera3 = gestor.validarCantidadNumCuenta(cuenta);
                            if (bandera3 == false) {
                                salida.println("------------------------------------------");
                                salida.println("El número de cuenta debe ser de 7 dígitos");
                                salida.println("------------------------------------------");
                            }
                        } while (!bandera3);

                        bandera = gestor.validarCuenta(cuenta);
                        if (bandera == true) {
                            salida.println("---------------------------------------------------------");
                            salida.println("Este número de cuenta ya está registrada en el sistema");
                            salida.println("---------------------------------------------------------");
                        }
                    } while (bandera == true);


                   do {
                       do {
                           salida.println("¿Cuál es el depósito inicial de la cuenta?");
                           saldo = entrada.nextDouble();

                           /*Se hace la validación que el número ingresado sea numérico*/
                           numCorrecto = gestor.validarNumeroDouble(Double.toString(saldo));
                           if (!numCorrecto) {
                               salida.println("--------------------------------------");
                               salida.println("Debe ingresar un valor de tipo numérico");
                               salida.println("---------------------------------------");
                           }
                       } while (!numCorrecto);

                       cantidadCorrecta = gestor.validarMonto(saldo);

                       if (!cantidadCorrecta) {
                               salida.println("--------------------------------------------");
                               salida.println("El monto inicial debe ser mayor a los 50 mil");
                               salida.println("--------------------------------------------");
                       }
                   }while (!cantidadCorrecta);


                    tipoCuenta = "Cuenta de ahorro";

                    info = gestor.nuevaCuentaAhorro(tipoCuenta, saldo, cuenta, cedula);

                    bandera = false;
                    break;
                case 2:

                    /*
                    Registro de cuentas corrientes
                    @Elizabeth Sequeira
                     */


                    do {
                        System.out.println("Ingrese la cédula del cliente");
                        cedula = entrada.next();
                        bandera = gestor.validarIdentificacion(cedula);
                        if (bandera == false) {
                            salida.println("--------------------------------------------------------------------------");
                            salida.println("Este cliente no está registrado en el sistema\n" +
                                    "Debe de registrarse primero.\n" +
                                    "Si aún no tiene una cuenta registrada, por favor digite 1 si desea \n" +
                                    "registrarse dentro del sistema\n Digite 2 si desea volver \n" +
                                    "a intentar con su cédula");
                            salida.println("--------------------------------------------------------------------------");
                            salida.println("Ingrese la opción");

                            pregunta = entrada.next();
                            if (pregunta.equals("1")) {
                                registrarCliente();
                                salida.println("-----------------------------------------------------------");
                                salida.println("Ya ha realizado su registro dentro del sistema, puede \n" +
                                        "continuar con el registro de su cuenta");
                                salida.println("--------------------------------------------------------");
                            }
                        }
                    } while (bandera == false);


                    do {
                        do {

                            do {
                                salida.println("Ingrese el número de cuenta");
                                numeroCuenta = entrada.nextInt();
                                numCorrecto = gestor.validarNumero(Integer.toString(numeroCuenta));
                                if (!numCorrecto) {
                                    salida.println("---------------------------------");
                                    salida.println("Debe ingresar un valor numérico");
                                    salida.println("----------------------------------");
                                }
                            } while (!numCorrecto);

                            bandera3 = gestor.validarCantidadNumCuenta(numeroCuenta);
                            if (bandera3 == false) {
                                salida.println("------------------------------------------");
                                salida.println("El número de cuenta debe ser de 7 dígitos");
                                salida.println("------------------------------------------");
                            }
                        } while (!bandera3);


                        bandera = gestor.validarCuenta(numeroCuenta);
                        if (bandera == true) {
                            salida.println("--------------------------------------------------------");
                            salida.println("Este número de cuenta ya está registrado en el sistema");
                            salida.println("--------------------------------------------------------");

                        }
                    } while (bandera == true);


                    salida.println("¿Cuál será su depósito inicial en la cuenta?");
                    saldo = entrada.nextDouble();


                    tipoCuenta = "Cuenta corriente";
                    gestor.nuevaCuentaCorriente(tipoCuenta, saldo, numeroCuenta, cedula);

                    bandera = false;
                    break;
                case 3:

                    do {
                        salida.println("Número de su cuenta corriente");
                        numeroCuenta = entrada.nextInt();
                        bandera = gestor.validarCuentaCorriente(numeroCuenta);
                        if (!bandera) {
                            salida.println("\n\n--------------------------------------------------------------");
                            salida.println("\nEste cuenta corriente no está registrada en el sistema. " +
                                    "Debe de registrar una cuenta corriente primero.\n" +
                                    "Si aún no tiene una cuenta registrada, por favor digite '1'. \n" +
                                    "Si desea \n" +
                                    "realizar un registro de cuenta corriente dentro del sistema\n digite cualquier " +
                                    "otra opcion, " +
                                    "\n\nsi usted ya tiene una cuenta corriente y desea volver a intentar");
                            salida.println("--------------------------------------------------------------------------\n\n");
                            salida.println("Ingrese la opción");
                            pregunta = entrada.next();
                            if (pregunta.equals("1")) {
                                registroCuenta();
                                salida.println("-------------------------------------------------------------------------");
                                salida.println("Ya ha realizado el registro de su cuenta corriente, puede" +
                                        " continuar con el registro de su\n " +
                                        "cuenta de ahorro programado");
                                salida.println("-------------------------------------------------------------------------");

                            }
                        }

                        bandera2 = gestor.validarRepeticionCuentaCorriente(numeroCuenta);

                        if (bandera2) {
                            salida.println("------------------------------------------------------------------------");
                            salida.println("Esta cuenta corriente ya tiene una cuenta de ahorro programada asociada");
                            salida.println("-------------------------------------------------------------------------");
                            bandera = false;
                        }
                    } while (!bandera);

                    do {

                        salida.println("Ingrese la cedula del cliente");
                        cedula = entrada.next();
                            /*
                            Nuevo método de validación
                            Va a validar que la cantida del número de cédula esté entre el rango esperado
                            */
                        bandera3 = gestor.validarCantidadNumCedula(cedula);
                        if (!bandera3) {
                            salida.println("----------------------------------------------------------");
                            salida.println("La cédula debe de estar dentro del rango de 9 a 13 dígitos");
                            salida.println("----------------------------------------------------------");
                        }
                    } while (!bandera3);
                    bandera = gestor.validarIdentificacion(cedula);
                    if (bandera == false) {
                        salida.println("--------------------------------------------------------------------------");
                        salida.println("'' Este cliente no está registrado en el sistema\n" +
                                "'' Debe de estar registrado en el sistema para poder registrar una " +
                                "cuenta.\n" +
                                "'' Si aún no tiene una cuenta registrada, por favor digite 1 si desea \n" +
                                "'' registrarse dentro del sistema\n'' Digite 2 si desea volver \n" +
                                "'' a intentar con su cédula");
                        salida.println("--------------------------------------------------------------------------");
                        salida.println("\nIngrese la opción");

                        pregunta = entrada.next();
                        if (pregunta.equals("1")) {
                            registrarCliente();
                            salida.println("-----------------------------------------------------------");
                            salida.println("Ya ha realizado su registro dentro del sistema, puede \n" +
                                    "continuar con el registro de su cuenta");
                            salida.println("--------------------------------------------------------");
                        }

                            /*
                        Se validará que el cliente sea el mismo que el de la cuenta corriente
                         @Mariela Bonilla
                         */
                        bandera = gestor.validacionCedulaCuenta(cedula, numeroCuenta);
                        if (bandera == false) {
                            salida.println("--------------------------------------------------------");
                            salida.println("Esta cédula no corresponde a la de la cuenta corriente. \n" +
                                    "Ingresela nuevamente");
                            salida.println("--------------------------------------------------------");
                        }

                    }
                    while (bandera == false) ;


                    do {
                        salida.println("¿Con cuánto dinero desea empezar la cuenta de ahorro programado?. \n Se le descontará de la " +
                                "cuenta corriente asociada");
                        saldo = entrada.nextDouble();
                        bandera = gestor.validarDepositoCAP(saldo, numeroCuenta);
                        if (!bandera) {
                            salida.println("------------------------------------------------------------------");
                            salida.println("Está cuenta no cuenta con la cantidad de dinero que usted digitó.");
                            salida.println("---------------------------------------------------------------");
                        } else {
                            String tipoMovimiento = "Retirar";
                            String descripcion = "Aporte inicial para la cuenta de ahorro programado";
                            LocalDate fechaHoy = LocalDate.now();
                            gestor.retirar(numeroCuenta, saldo, tipoMovimiento, descripcion, fechaHoy);
                        }

                    } while (!bandera);


                    do {
                        salida.println("¿Cuál es el número de la cuenta de ahorro programada?");
                        cuenta = entrada.nextInt();
                        bandera = gestor.validarCuenta(cuenta);
                        if (bandera == true) {
                            salida.println("--------------------------------------------------------");
                            salida.println("Este número de cuenta, ya está registrado en el sistema");
                            salida.println("--------------------------------------------------------");
                        }
                    } while (bandera == true);

                    bandera = false;


                    tipoCuenta = "Cuenta de ahorro programado";

                    gestor.nuevaCuentaAhorroProgramada(tipoCuenta, saldo, cuenta, numeroCuenta, cedula);

                    break;
                default:
                    salida.println("-----------------------------");
                    salida.println("Esta no es una opción valida");
                    salida.println("-----------------------------");
                    bandera = true;
                    break;

            }
        } while (bandera == true);


    }




    /*
    Se realiza el registro de un cliente, recibiendo su nombre, su número de cédula y su dirección
    @Lenner Hurtado
     */

    public static void registrarCliente(){
        boolean bandera2 = false;
        String cedula = "";
        String nombre;
        String direccion;
        boolean bandera3;
        boolean nombrePermitido = false;

        do {
            System.out.println("Ingrese el nombre el nombre del cliente");
            nombre = entrada.next();
            nombrePermitido = gestor.validarNombre(nombre);
            if (!nombrePermitido) {
                salida.println("--------------------------------------------------------------");
                salida.println("El nombre no puede llevar ni numeros ni caracteres especiales");
                salida.println("--------------------------------------------------------------");
            }
        }while (!nombrePermitido);

        do {


            /*
            Nuevo método de validación
            Va a validar que la cantida del número de cédula esté entre el rango esperado
             */
            do {
                System.out.println("Ingrese la cédula del cliente");
                cedula = entrada.next();
                bandera3 = gestor.validarCantidadNumCedula(cedula);
                if (!bandera3) {
                    salida.println("------------------------------------------------------");
                    salida.println("La cédula debe de estar en un rango de 9 a 13 dígitos");
                    salida.println("------------------------------------------------------");
                }
            }while (!bandera3);

            bandera2 = gestor.validarIdentificacion(cedula);
            if (bandera2 == true){
                salida.println("--------------------------------------------------------");
                salida.println("Está identificación ya está registrada con otro cliente");
                salida.println("--------------------------------------------------------");
            }
        }while(bandera2 == true);

        salida.println("Ingrese su dirección");
        direccion = entrada.next();
        gestor.registrarCliente(nombre, cedula, direccion);
    }

    /*
    Método que realizará un listar de clientes con toda su información
    @Lenner Hurtado
     */
    public static void listarClientes(){

        String[] clientes = gestor.listaClientes();
        int i = 0;
        salida.println("\n\nLISTA DE CLIENTES");
        for (String dato : clientes) {
            salida.println(clientes[i]);
            i++;
        }
    }

    public static void listarCuentas(){
        String cuenta;
        String[] cuentas = gestor.imprimirCuentas();
        int i = 0;
        salida.println("\n\nLISTA DE CUENTAS");
        for (String dato : cuentas) {
            if(dato != null) {
                salida.println(cuentas[i]);
            }
            i++;
        }
    }

    public static void listarMovimientos() {
        String[] movimientos = gestor.imprimirMovimientos();
        salida.println("\n\nLISTA DE MOVIMIENTOS");
        for (String dato : movimientos) {
            if(dato != null) {
                salida.println(dato);
            }
        }
    }

    public static void depositarSaldo() throws IOException {
        String respuesta;
        int numeroCuenta;
        String tipoMovimiento = "Depositar";
        String descripcion;
        double montoDeposito;
        String pregunta;
        boolean bandera = false;
        LocalDate fechaHoy = LocalDate.now();

        do {
            salida.println("Digite el número de su cuenta");
            numeroCuenta = entrada.nextInt();
            bandera = gestor.validarCuentaCorriente(numeroCuenta);
            if (!bandera){
                salida.println("\n\n--------------------------------------------------------------");
                salida.println("\nEsta cuenta no se encuentra registrada en el sistema. " +
                        "Debe de tener una cuenta, antes de realizar un deposito.\n\n" +
                        "Si aún no tiene una cuenta registrada, por favor digite '1', para proceder a crearle una" +
                        " cuenta. \n" +
                        "y si desea \n" +
                        "continuar con el proceso de deposito intentando una vez mas \n con" +
                        " otro numero de cuenta, debe \n digitar cualquier " +
                        "otra tecla");
                salida.println("--------------------------------------------------------------------------\n\n");
                salida.println("Ingrese la opción");
                pregunta = entrada.next();
                if (pregunta.equals("1")) {
                    registroCuenta();
                    salida.println("-------------------------------------------------------------------------");
                    salida.println("Ya ha realizado el registro de su cuenta, puede" +
                            " continuar con su proceso de deposito");
                    salida.println("-------------------------------------------------------------------------");

                }
            }
        }while(!bandera);

        salida.println("¿Cuánto desea depositar a la cuenta?");
        montoDeposito = entrada.nextDouble();

        salida.println("Ingrese una pequeña descripción de su depósito");
        descripcion = entrada.next();

        respuesta = gestor.realizarDeposito(numeroCuenta, montoDeposito,  tipoMovimiento, descripcion, fechaHoy);

        salida.println(respuesta);
    }

    public static void consultarSaldo() {
       int numCuenta;
        String saldoActual;

        salida.println("Para consultar su saldo, digite el número de su cuenta");
        numCuenta = entrada.nextInt();
       saldoActual = gestor.consultarSaldo(numCuenta);

       salida.println(saldoActual);
    }

    public static void retirarDinero() throws IOException{
        double montoRetirar;
        int numeroCuenta;
        boolean bandera = false;
        String tipoMovimiento = "Retirar";
        String respuesta;
        String tipo;
        String descripcion;
        LocalDate fechaHoy = LocalDate.now();
        boolean bandera2;
        boolean bandera3;

        do {
            salida.println("Para retirar un monto, digite su número de cuenta");
            numeroCuenta = entrada.nextInt();
            bandera = gestor.validarCuenta(numeroCuenta);
            if (!bandera){
                salida.println("--------------------------------------------------------");
                salida.println("Está cuenta no es valida, no existe en el sistema");
                salida.println("--------------------------------------------------------");
            }

        }while(!bandera);
        tipo = gestor.obtenerTipoCuenta(numeroCuenta);


        do {
            salida.println("¿De cuánto es el monto que desea retirar?");
            montoRetirar = entrada.nextDouble();
            bandera = gestor.validarMontoRetirar(montoRetirar, numeroCuenta);
            if (bandera){
                salida.println("--------------------------------------------------------");
                salida.println("Está cuenta no tiene saldo suficiente");
                salida.println("--------------------------------------------------------");
            }

            if (tipo.equals("Cuenta corriente")){
                bandera2=gestor.validarSaldoCuentaCorriente(montoRetirar, numeroCuenta);
                if (bandera2==false) {
                    salida.println("--------------------------------------------------------");
                    salida.println("No se puede retirar dinero debido a que el saldo de esta es\n" +
                            "inferior a 100 000");
                    salida.println("--------------------------------------------------------");
                }else{
                    bandera3=gestor.validarRetiroCC(montoRetirar, numeroCuenta);
                    if (bandera3==false){
                        salida.println("--------------------------------------------------------");
                        salida.println("El monto que intenta retirar es superior al 50%\n " +
                                "del saldo en la cuenta");
                        salida.println("--------------------------------------------------------");
                    }
                    //*******
                }
            }
        }while(bandera);


        salida.println("Ingrese una pequeña descripción de su retiro");
        descripcion = entrada.next();
        /*
        Se obtiene el tipo de la cuenta
         */

        if (tipo.equals("Cuenta de ahorro programado")) {

            respuesta = gestor.realizarRetiroCAP(numeroCuenta, montoRetirar, tipoMovimiento, descripcion, fechaHoy);
        } else {

            respuesta = gestor.retirar(numeroCuenta, montoRetirar, tipoMovimiento, descripcion, fechaHoy);
        }

        salida.println(respuesta);
    }


    public static void tasaInteres(){
        double tasa;
        boolean bandera = false;

        do {
            salida.println("¿ Cual es la tasa de interes que se va aplicar a las cuentas de ahorro");
            tasa = entrada.nextDouble();
            bandera = gestor.validarTasaInteres(tasa);
            if (bandera == true){
                salida.println("La tasa de interes debe ser entre %1 y %100");
            }
        }while (bandera == true);


        gestor.nuevaTasaInteres(tasa);
    }


}



