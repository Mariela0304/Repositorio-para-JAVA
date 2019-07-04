package bonilla.mariela.ui;

import bonilla.mariela.tl.Clinica;
import bonilla.mariela.tl.Controller;
import javafx.scene.control.Alert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.IOException;
import java.time.LocalDate;

public class Main {


    static BufferedReader entrada = new BufferedReader(
            new InputStreamReader(System.in));
    static PrintStream salida = System.out;
    static Clinica gestor = new Clinica();

    public static void main(String[] args) throws IOException {
        mostrarMenuInicio();
    }

    static void inicioSesion() throws IOException {
        String codigo;
        String clave;
        boolean validarCredenciales;

        salida.println("Usted se encuentra en la página de iniciar sesión");
        salida.println("Ingrese su código para ingresar");
        codigo = entrada.readLine();
        salida.println("Ingrese su clave para ingresar");
        clave = entrada.readLine();

        validarCredenciales = gestor.validarCredenciales(codigo, clave);

        if (validarCredenciales) {
            salida.println("=====================  ¡¡Bienvenido!! ===============================");
            mostrarMenuMedico();
        } else {
            salida.println("Datos incorrectos");
        }




    }


    static void mostrarMenuMedico() throws IOException {
        String menu;
        boolean seguir = true;

        do {
            salida.println("1.Registrar cita\n2.Listar Citas\n3.Registrar paciente" +
                    "\n4.Listar pacientes\n5.Registrar expediente\n6.Listar expedientes" +
                    "\nRegistrar padecimiento\n8.Listar padecimientos\n9.Salir");
            salida.println("Elija una opción");
            menu = entrada.readLine();
            switch (menu) {
                case "1"://
                    registrarCita();
                    seguir = true;
                    break;
                case "2"://
                    listaCitas();
                    seguir = true;
                    break;
                case "3"://
                    registrarPaciente();
                    seguir = true;
                    break;
                case "4"://
                    listaPacientes();
                    seguir = true;
                    break;
                case "5"://
                    registrarExpediente();
                    seguir = true;
                    break;
                case "6"://
                    listaExpedientes();
                    seguir = true;
                    break;
                case "7"://
                    registrarPadecimiento();
                    seguir = true;
                    break;
                case "8"://
                    seguir = true;
                    break;
                case "9"://Opción de salir
                    seguir = false;
                    break;
                default:
                    salida.println("Error!");
                    seguir = true;
                    break;
            }
        } while (seguir == true);
    }

    static void mostrarMenuInicio() throws IOException {
        String menu;
        boolean seguir = true;

        do {
            salida.println("1.Iniciar sesión\n2.Registrar usuario\n3.Salir");
            salida.println("Elija una opción");
            menu = entrada.readLine();
            switch (menu) {
                case "1"://
                    registrarUsuario();
                    seguir = true;
                    break;
                case "2"://
                    inicioSesion();
                    seguir = true;
                    break;
                case "3"://Opción de salir
                    seguir = false;
                    break;
                default:
                    salida.println("Error!");
                    seguir = true;
                    break;
            }
        } while (seguir == true);
    }

    static void registrarPaciente() throws IOException{
        String numSeguroSocial;

        String nombreCompleto;
        String email;
        String direccion;
        String clave;
        String telefono;
        String tipoUsuario;

        boolean verdadero;
        boolean repetido = false;

        do {
            salida.println("Ingrese el número del seguro social");
            numSeguroSocial = entrada.readLine();
            verdadero = gestor.validarNumero(numSeguroSocial);
        }while (!verdadero);

        salida.println("Ingrese el nombre completo");
        nombreCompleto = entrada.readLine();

//            do {
        if (repetido) {
            salida.println("El correo ingresado ya se encuentra en nuestros servidores");
        }


        salida.println("Ingrese su correo electrónico");
        email = entrada.readLine();

//                repetido = gestor.validarCorreo(email);

//            } while (repetido == true);
        salida.println("Ingrese su clave");
        clave = entrada.readLine();

        salida.println("Ingrese la dirección");
        direccion = entrada.readLine();
        salida.println("Ingrese el número de teléfono");
        telefono = entrada.readLine();

        tipoUsuario = "Paciente";

        gestor.registrarPaciente(tipoUsuario,numSeguroSocial, nombreCompleto, email, direccion, telefono, clave);

    }


    static void registrarUsuario() throws IOException {
            String codigoMedico;
            String numSeguroSocial;

            String nombreCompleto;
            String email;
            String direccion;
            String clave;
            String telefono;
            String tipoUsuario;
            String especialidad;


            boolean error = false;
            boolean repetido = false;
            boolean verdadero ;
            String preguntarNum;

            salida.println("Ingrese el nombre completo");
            nombreCompleto = entrada.readLine();

//            do {
                if (repetido == true) {
                    salida.println("El correo ingresado ya se encuentra en nuestros servidores");
                }


                    salida.println("Ingrese su correo electrónico");
                    email = entrada.readLine();

//                repetido = gestor.validarCorreo(email);

//            } while (repetido == true);
            salida.println("Ingrese su clave");
            clave = entrada.readLine();


            salida.println("Seleccione '1' si es un medico o seleccione '2' si es un paciente");

            do {
                tipoUsuario = entrada.readLine().trim();
                switch (tipoUsuario) {
                    case "1":
//                        do {
//                            if (repetido) {
//                                salida.println("El nombre de esta propiedad se encuentra repetido. Ingrese uno distinto");
//                            }
//                            do {
                                salida.println("Ingrese el codigo asignado por el colegio de medicos");
                                codigoMedico = entrada.readLine();
//                              repetido = gestor.validarCodigo(codigoMedico);
//                        } while (repetido);


                        salida.println("Ingrese la especialidad");
                        especialidad = entrada.readLine();

                        tipoUsuario = "Médico";

                        gestor.registrarMedico(tipoUsuario,codigoMedico, nombreCompleto, email, clave, especialidad);
                        break;


                    case "2":

                        /*
                        Se registra al usuario paciente @MarielaBonilla
                         */
                        String confirmacion;

                        //do {
//                            if (repetido) {
//                                salida.println("El nombre de esta propiedad se encuentra repetido. Ingrese uno distinto");
//                            }
//                            do {
                            do {
                                salida.println("Ingrese el número del seguro social");
                                numSeguroSocial = entrada.readLine();
                                verdadero = gestor.validarNumero(numSeguroSocial);
                            }while (!verdadero);
//                              repetido = gestor.validarCodigo(codigoMedico);
//                        } while (repetido);

                            salida.println("Ingrese la direccion");
                            direccion = entrada.readLine();
                            salida.println("Ingrese el telefono");
                            telefono = entrada.readLine();

                        tipoUsuario = "Paciente";


                        gestor.registrarPaciente(tipoUsuario,numSeguroSocial, nombreCompleto, email, direccion, telefono, clave);
                        break;


                    default:
                        salida.println("El tipo de propiedad ingresado es inválido. Ingrese 'casa' o 'apartamento'");
                        error = true;
                        break;

                }
            } while (error == true);

    }

    static void registrarCita() throws IOException {
        String id;
        String fechaCita;
        LocalDate fecha;
        String paciente;
        String medico;
        String descripcion;
        String resultado;

        boolean verdadero;

        do {
            salida.println("Ingrese el identificador de la fecha");
            id = entrada.readLine();
            verdadero = gestor.validarNumero(id);
        }while (!verdadero);

        salida.println("Ingrese la fecha de la cita");
        fecha = LocalDate.parse(entrada.readLine());

        salida.println("Ingrese el paciente atendido");
        paciente = entrada.readLine();

        salida.println("Ingrese el medico que lo atendio");
        medico = entrada.readLine();

        salida.println("Ingrese la descripcion de la cita");
        descripcion = entrada.readLine();

        salida.println("Ingrese el resultado de la cita");
        resultado = entrada.readLine();


        gestor.registrarCita(id, fecha, paciente, medico, descripcion, resultado );

    }


    static void registrarExpediente() throws IOException {
        String id;
        String numSeguroSocial;
        LocalDate fechaNaciemiento;
        String tipoSangre;
        int tamanno = 0;
        String [] padecimientos;

        boolean verdadero;
        boolean repetido = false;

        do {
            salida.println("Ingrese el id del expediente");
            id = entrada.readLine();
            verdadero = gestor.validarNumero(id);
        }while (!verdadero);

        do {
            salida.println("Ingrese el número del seguro social del paciente " +
                    "perteneciente");
            numSeguroSocial = entrada.readLine();
            verdadero = gestor.validarNumero(numSeguroSocial);
        }while (!verdadero);

        salida.println("Ingrese la de nacimiento del paciente " +
                "perteneciente");
        fechaNaciemiento = LocalDate.parse(entrada.readLine());

        salida.println("Ingrese el tipo de sangre del paciente " +
                "perteneciente");
        tipoSangre = entrada.readLine();

        salida.println("Cuantos padecimientos tiene actualmente este paciente?");
        tamanno = Integer.parseInt(entrada.readLine());
        padecimientos = new String[tamanno];


        for (int i = 0; i<padecimientos.length; i++) {
            salida.println("Ingrese el padecimiento #"+(1+i)+" al paciente " +
                    "perteneciente");
                padecimientos[i] = entrada.readLine();
        }

        gestor.registrarExpediente(id, numSeguroSocial, fechaNaciemiento, tipoSangre, padecimientos);

    }

    static void registrarPadecimiento() throws IOException{
        String id;
        String nombre;
        String descripcion;

        salida.println("Ingrese la id del padecimiento");
        id = entrada.readLine();
        salida.println("Ingrese el nombre del padecimiento");
        nombre = entrada.readLine();
        salida.println("Ingrese una descripcion para este padecimiento");
        descripcion = entrada.readLine();

        gestor.registrarPadecimiento(id, nombre, descripcion);

    }


    static void listaCitas() throws IOException {
        String [] citas = gestor.imprimirListaCitas();

        for (String dato : citas) {
            salida.println(dato);
        }

        String volverMenu;
        System.out.println("Digite 'm' si desea ir al menu");
        volverMenu = entrada.readLine();
        if (volverMenu.equals("m")) {
            mostrarMenuMedico();
        }
    }

    static void listaExpedientes() throws IOException {
        String [] expedientes = gestor.imprimirListaExpedientes();

        for (String dato : expedientes) {
            salida.println(dato);
        }
    }

    static void listaPacientes() throws IOException {
        String [] pacientes = gestor.imprimirListaPacientes();

        for (String dato : pacientes) {
            salida.println(dato);
        }
    }
}
