package bonilla.mariela.ui;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import bonilla.mariela.tl.Controller;



public class Main {
    static BufferedReader entrada = new BufferedReader(
            new InputStreamReader(System.in));
    static PrintStream salida = System.out;
    static Controller gestor = new Controller();

    public static void main(String[] args) throws java.io.IOException {
        mostrarMenu();
    }

    static void mostrarMenu() throws java.io.IOException {
        String menu;
        boolean seguir = true;
        do {
            salida.println("1.Registrar propiedad\n2.Registrar inquilino\n3.Listar propiedades\n4.Listar inquilinos" +
                    "\n5.Salir");
            salida.println("Elija una opción");
            menu = entrada.readLine();
            switch (menu) {
                case "1"://Registrar propiedad
                    registrarPropiedad();
                    seguir = true;
                    break;
                case "2"://Registrar inquilino
                    registrarInquilino();
                    seguir = true;
                    break;
                case "3"://Listar propiedades
                    listarPropiedades();
                    seguir = true;
                    break;
                case "4"://Listar inquilinos
                    listarInquilinos();
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
        } while (seguir == true);
    }

    public static void registrarPropiedad() throws java.io.IOException {
        int codigo;
        String nombre;
        double valor;
        String direccion;
        String residencial;
        int numCasa;
        String patio;
        int cantHab = 0;
        String cochera;
        int cantVehiculo = 0;
        ArrayList<String> amenidades;
        String tipoPropiedad;
        boolean error = false;
        boolean repetido = false;
        amenidades = new ArrayList<>();
        boolean verdadero ;
        String preguntarNum;



        do {
            if (repetido == true) {
                salida.println("El código de esta propiedad se encuentra repetido. Ingrese uno distinto");
            }


            do {
                salida.println("Digite el código de la propiedad");
                preguntarNum = entrada.readLine();
                verdadero = gestor.validarNumero(preguntarNum);
            }while (!verdadero);
            codigo = Integer.parseInt(preguntarNum);

            repetido = gestor.validarCodigo(codigo);

        } while (repetido == true);

        do {
            salida.println("Digite el valor del alquiler de la propiedad");
            preguntarNum = entrada.readLine();

            verdadero = gestor.validarValor(preguntarNum);
        }while (!verdadero);
        valor = Double.parseDouble(preguntarNum);

        salida.println("Digite la dirección");
        direccion = entrada.readLine();
        salida.println("¿Con cuántas habitaciones cuenta? Contando la sala, el comedor,\n el cuarto de pilas y cuartos");
        cantHab = Integer.parseInt(entrada.readLine());
        salida.println("¿Esta propiedad cuenta con patio?");
        patio = entrada.readLine().trim();
        salida.println("¿Esta propiedad cuenta con cochera?");
        cochera = entrada.readLine().trim();
        if (cochera.equals("si") || cochera.equals("sí")) {

            do {
                salida.println("¿Cuántos vehículos caben?");
                preguntarNum = entrada.readLine();
                verdadero = gestor.validarNumero(preguntarNum);
            }while (!verdadero);
            cantVehiculo = Integer.parseInt(preguntarNum);
        }

        salida.println("Seleccione '1' si es una casa o seleccione '2' si es un apartamento");

        do {
            tipoPropiedad = entrada.readLine().trim();
            switch (tipoPropiedad) {
                case "1":
                    do {
                        if (repetido) {
                            salida.println("El nombre de esta propiedad se encuentra repetido. Ingrese uno distinto");
                        }
                        salida.println("Ingrese el nombre de la propiedad");
                        nombre = entrada.readLine();
                        repetido = gestor.validarNombrePropiedad(nombre);
                    } while (repetido);

                    do {
                        if (repetido) {
                            salida.println("El nombre de este residencial se encuentra repetido. Ingrese uno distinto");
                        }
                        salida.println("Ingrese el nombre del residencial donde se encuentra");
                        residencial = entrada.readLine();
                        repetido = gestor.validarResidencial(residencial);

                    } while (repetido);

                    do {
                        salida.println("Ingrese el número de casa");
                        preguntarNum = entrada.readLine();
                        verdadero = gestor.validarNumero(preguntarNum);
                    }while (!verdadero);
                    numCasa = Integer.parseInt(preguntarNum);

                    gestor.registrarCasa(codigo, nombre, valor, direccion, residencial, numCasa, patio, cantHab, cochera, cantVehiculo);
                    break;
                case "2":
                    String confirmacion;
                    int cantAmen = 0;
                    salida.println("¿Tiene alguna amenidad?");
                    confirmacion = entrada.readLine();
                    if (confirmacion.equals("si")) {
                        do {
                            salida.println("Ingrese cuántas ofrece");
                            preguntarNum = entrada.readLine();
                            verdadero = gestor.validarNumero(preguntarNum);
                        }while (!verdadero);
                        cantAmen = Integer.parseInt(preguntarNum);


                        if (cantAmen != 0) {
                            for (int i = 0; i < cantAmen; i++) {
                                salida.println("Ingrese la amenidad asociada");
                                amenidades.add(entrada.readLine());
                            }
                        }
                    } else {
                        amenidades.add("No tiene");
                    }
                    gestor.registrarApartamento(codigo, valor, direccion, patio, cantHab, amenidades, cochera, cantVehiculo);
                    break;
                default:
                    salida.println("El tipo de propiedad ingresado es inválido. Ingrese 'casa' o 'apartamento'");
                    error = true;
                    break;
            }
        } while (error == true);
    }


    public static void registrarInquilino() throws java.io.IOException {
        String nombre;
        String apellidos;
        String correo;
        String direccion;
        String identificacion;
        int telefono;
        String genero;
        boolean repetido = false;
        boolean verdadero ;
        String preguntarNum;



        salida.println("Digite el nombre del inquilino");
        nombre = entrada.readLine();
        salida.println("Digite el o los apellidos");
        apellidos = entrada.readLine();
        do {
            if (repetido == true) {
                salida.println("El correo de este inquilino se encuentra repetido. Ingrese uno distinto");
            }
            salida.println("Digite el correo electrónico");
            correo = entrada.readLine();
            repetido = gestor.validarCorreo(correo);
        } while (repetido == true);

        salida.println("Digite su direccion");
        direccion = entrada.readLine();
        do {
            if (repetido == true) {
                salida.println("La identificación de este inquilino se encuentra repetida. No puede haber dos identificaciones iguales");
            }
            salida.println("Ingrese la identificación");
            identificacion = entrada.readLine();
            repetido = gestor.validarInquilino(identificacion);
        } while (repetido == true);


        do {
            salida.println("Digite el número de teléfono");
            preguntarNum = entrada.readLine();
            verdadero = gestor.validarNumero(preguntarNum);
        }while (!verdadero);
        telefono = Integer.parseInt(preguntarNum);


        salida.println("Digite el género al que pertenece");
        genero = entrada.readLine();
        gestor.registrarInquilino(nombre, apellidos, correo, direccion, identificacion, telefono, genero);
    }

    public static void listarPropiedades() {
        String[] propiedad = gestor.listaPropiedades();
        for (String dato : propiedad) {
            salida.println(dato);
        }
    }

    public static void listarInquilinos() {
        String[] inquilino = gestor.listaInquilinos();
        for (String dato : inquilino) {
            salida.println(dato);
        }
    }
}
