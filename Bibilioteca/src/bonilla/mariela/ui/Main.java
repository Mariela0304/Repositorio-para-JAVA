package bonilla.mariela.ui;

import bonilla.mariela.tl.Controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.time.LocalDate;

public class Main {

    static BufferedReader entrada = new BufferedReader(
            new InputStreamReader(System.in));
    static PrintStream salida = System.out;
    static Controller gestor = new Controller();

    public static void main(String[] args) throws java.io.IOException {

        mostrarMenu();

    }

    public static void mostrarMenu() throws java.io.IOException {
        String menu;
        boolean seguir = true;

        do {
            salida.println("1.Registrar usuario\n2.Listar usuario\n3.Buscar usuario\n4.Registrar material\n5.Listar materiales\n6.Buscar material\n7.Salir");
            salida.println("Qué desea hacer?");
            menu = entrada.readLine();

            switch (menu) {

                case "1"://registrar personas
                    registrarPersona();
                    seguir= true;
                    break;

                case "2"://listar Personas
                    listarPersonas();
                    seguir=true;
                    break;

                case "3": //buscar una persona
                    buscarPersona();
                    seguir = true;
                    break;
                case "4"://registrar Material
                    registrarMaterial();

                    seguir=true;
                    break;
                case "5"://Listar materiales
                    listarMateriales();
                    seguir=true;
                    break;

                case "6"://Buscar material
                    buscarMaterial();
                    seguir=true;
                    break;

                case "7"://salir
                    seguir=false;
                    break;
                default:

                    salida.println("Error!");
                    seguir = true;
                    break;
            }

        } while (seguir == true);
    }

    public static void registrarPersona() throws java.io.IOException {
        String nombre;
        String apellido;
        String identificacion;
        String tipoPersona;
        boolean correcto = true;


        salida.println("Ingrese el nombre");
        nombre = entrada.readLine();
        salida.println("Ingrese el apellido");
        apellido = entrada.readLine();
        salida.println("Ingrese la identificación");
        identificacion = entrada.readLine();

        salida.println("Tipos de personas que se pueden registrar:\n1.Administrativo\n2.Profesor\n3.Estudiante\n4.Persona");
        salida.println("Seleccione el tipo de persona a registrar");
        tipoPersona = entrada.readLine();

        do {
            switch (tipoPersona) {
                case "1": // Administrativo
                    String tipoNombramiento;
                    int cantHoras;
                    do {
                        salida.println("Los tipos de nombramientos existentes son: \n" +
                                "A, B ó C");
                        salida.println("Ingrese su tipo de nombramiento");
                        tipoNombramiento = entrada.readLine();

                        switch (tipoNombramiento) {
                            case "A":
                                correcto = true;
                                break;

                            case "B":
                                correcto = true;

                                break;
                            case "C":
                                correcto = true;

                                break;

                            default:
                                correcto = false;

                                salida.println("No existe este tipo de nombramiento");
                        }
                    }while (!correcto);
                    salida.println("Ingrese el nombre del autor");
                    cantHoras = Integer.parseInt(entrada.readLine());
                    gestor.registrarAdministrativo(nombre, apellido, identificacion, tipoNombramiento, cantHoras);
                    correcto = true;
                    break;
                case "2": // Profesor
                    String tipoContrato = "";
                    LocalDate fechaContratado;

                    salida.println("Existen 2 tipos de contratos: \n a) Tiempo completo\n b) Medio tiempo");

                    do {
                        salida.println("Ingrese el tipo del contrato.");
                        tipoContrato = entrada.readLine();
                    } while (tipoContrato.equals("a")||tipoContrato.equals("b"));

                    if (tipoContrato.equals("a")) {
                        tipoContrato = "Tiempo completo";
                    } else if (tipoContrato.equals("b")){
                        tipoContrato = "Medio tiempo";
                    }

                    salida.println("Ingrese la fecha en que fue contratado en formato aaaa-mm-dd");
                    fechaContratado = LocalDate.parse(entrada.readLine());
                    gestor.registrarProfesor(nombre, apellido, identificacion, tipoContrato, fechaContratado);

                    correcto = true;
                    break;
                case "3": // Estudiante
                    String carrera;
                    int creditos;

                    salida.println("Ingrese la carrera en la que se encuentra");
                    carrera = entrada.readLine();
                    salida.println("Ingrese los créditos en los que se encuentra matriculado");
                    creditos = Integer.parseInt(entrada.readLine());

                    gestor.registrarEstudiante(nombre, apellido, identificacion, carrera, creditos);

                    correcto = true;
                    break;
                case "4"://registrar una persona
                    gestor.registrarPersona(nombre, apellido, identificacion);
                    break;
                default:
                    salida.println("No se reconoce el tipo de persona que desea registrar. Ingréselo nuevamente");
                    correcto = false;
                    break;
            }
        }while (!correcto);



    }

    public static void listarPersonas() {

        String [] persona = gestor.imprimirPersonas();

        for (String dato : persona) {
            salida.println(dato);
        }

    }


    public static void registrarMaterial() throws java.io.IOException{
        String tipoMaterial;
        String signatura;
        LocalDate fechaCompra;
        boolean restricción = true;
        String pregunta = "";
        String tema;
        boolean correcto = true;

        salida.println("Ingrese el código de signatura");
        signatura = entrada.readLine();
        salida.println("Ingrese la fecha en que fue comprado");
        fechaCompra = LocalDate.parse(entrada.readLine());
        do {
            salida.println("¿Se encuentra restringido?");
            pregunta = entrada.readLine();
        }while (pregunta.equals("si")||pregunta.equals("no"));

        if (pregunta.equals("si")) {
            restricción = true;
        } else if (pregunta.equals("no")){
            restricción = false;
        }

        salida.println("Ingrese el tema al que va a pertenecer este material");
        tema = entrada.readLine();

        salida.println("Tipos de materiales:\n1.Texto\2.Audio\n3.Video\4.Otro material");
        salida.println("Seleccione el tipo de material");
        tipoMaterial = entrada.readLine();

        do {
            switch (tipoMaterial) {
                case "1": // material de texto
                    String titulo;
                    String autor;
                    LocalDate fechaPublicacion;
                    int numPaginas;
                    String idioma;


                    salida.println("Ingrese el título");
                    titulo = entrada.readLine();

                    salida.println("Ingrese el nombre del autor");
                    autor = entrada.readLine();

                    salida.println("Ingrese la fecha de publicación con el siguiente formato(aaaa-mm-dd)");
                    fechaPublicacion = LocalDate.parse(entrada.readLine());

                    salida.println("Ingrese el número de páginas");
                    numPaginas = Integer.parseInt(entrada.readLine());

                    salida.println("Ingrese el idioma en el que se encuentra");
                    idioma = entrada.readLine();

                    gestor.registrarTexto(signatura, fechaCompra, restricción, tema, titulo, autor, fechaPublicacion, numPaginas, idioma);


                    break;
                case "2": // material de audio
                    String formato;
                    int duracion;

                    salida.println("Ingrese el formato");
                    formato = entrada.readLine();

                    salida.println("Ingrese la duración del audio");
                    duracion = Integer.parseInt(entrada.readLine());

                    salida.println("Ingrese el idioma en el que se encuentra");
                    idioma = entrada.readLine();

                    gestor.registrarAudio(signatura, fechaCompra, restricción, tema, formato, duracion, idioma);

                    break;
                case "3": // material de video
                    String director;

                    salida.println("Ingrese el formato");
                    formato = entrada.readLine();

                    salida.println("Ingrese la duración del video");
                    duracion = Integer.parseInt(entrada.readLine());

                    salida.println("Ingrese el idioma en el que se encuentra");
                    idioma = entrada.readLine();

                    salida.println("Ingrese el nombre del director del video");
                    director = entrada.readLine();

                    gestor.registrarVideo(signatura, fechaCompra, restricción, tema, formato, duracion, idioma, director);


                    break;
                case "4": // otro material
                    String descripcion;

                    salida.println("Ingrese la descripción de este material");
                    descripcion = entrada.readLine();

                    gestor.registrarOtroMaterial(signatura, fechaCompra, restricción, tema, descripcion);

                    break;
                default:
                    salida.println("No se encuentra este tipo de material. Ingréselo nuevamente");
                    correcto = false;
                    break;
            }
        }while (!correcto);


    }

    public static void listarMateriales() {

        String [] material = gestor.imprimirMateriales();

        for (String dato : material) {
            salida.println(dato);
        }

    }

    public static void buscarPersona() throws java.io.IOException {
        String identificacion;
        boolean noEncontrado = false;

        do {
            salida.println("Ingrese la identificación de la persona a buscar");
            identificacion = entrada.readLine();

            String buscador = gestor.buscarPersona(identificacion);

            if (buscador.equals("Identificación no encontrada")) {
                salida.println("La identificación ingresada, no pertenece a ningúno de nuestros usuarios. Ingrésela nuevamente");
                noEncontrado = true;
            } else {
                salida.println(buscador);
            }
        } while (noEncontrado);
    }

    public static void buscarMaterial() throws java.io.IOException {
        String signatura;
        boolean noEncontrado = false;

        do {
            salida.println("Ingrese la signatura del material a buscar");
            signatura = entrada.readLine();

            String buscador = gestor.buscarMaterial(signatura);

            if (buscador.equals("Signatura no encontrada")) {
                salida.println("La signatura ingresada, no pertenece a ningúno de nuestros materiales. Ingrésela nuevamente");
                noEncontrado = true;
            } else {
                salida.println(buscador);
            }
        } while (noEncontrado);
    }

}
