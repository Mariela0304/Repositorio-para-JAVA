package bonilla.mariela.tl;

import bonilla.mariela.bl.*;
import bonilla.mariela.dl.*;

import java.time.LocalDate;

public class Controller {

    private CL logica;

    public Controller() {
        logica = new CL();
    }

    public void registrarPersona(String nombre, String apellido, String identificacion){
        Persona tmpPersona;

        tmpPersona = new Persona(nombre, apellido, identificacion);
        logica.registrarPersona(tmpPersona);
    }

    //método para registrar estudiante
    public void registrarEstudiante(String nombre, String apellido, String identificacion, String carrera, int creditos){
        Estudiante tmpEstudiante;

        tmpEstudiante = new Estudiante(nombre, apellido, identificacion, carrera, creditos);
        logica.registrarPersona(tmpEstudiante);
    }

    public void registrarProfesor(String nombre, String apellido, String identificacion, String tipoContrato, LocalDate fechaContrato){
        Profesor tmpProfesor;

        tmpProfesor = new Profesor(nombre, apellido, identificacion, tipoContrato, fechaContrato);
        logica.registrarPersona(tmpProfesor);
    }

    public void registrarAdministrativo(String nombre, String apellido, String identificacion, String tipoNombramiento, int cantHoras){
        Administrativo tmpAdministrativo;

        tmpAdministrativo = new Administrativo(nombre, apellido, identificacion, tipoNombramiento, cantHoras);
        logica.registrarPersona(tmpAdministrativo);
    }

    public String [] imprimirPersonas() {
        String [] lista;
        int tamanno = logica.getPersonas().size();
        lista = new String[tamanno];

        int cont = 0;
        for (Persona dato : logica.getPersonas()) {
            lista[cont] = dato.toString();
        }
        return lista;
    }

    public void registrarMaterial(String sigantura, LocalDate fechaCompra, boolean restringido, String tema){
        Material tmpMaterial;

        tmpMaterial = new Material(sigantura, fechaCompra, restringido, tema);
        logica.registrarMaterial(tmpMaterial);
    }

    public void registrarTexto(String sigantura, LocalDate fechaCompra, boolean restringido, String tema, String titulo, String autor, LocalDate fechaPublicacion, int numPaginas, String idioma) {
        Texto tmpTexto;

        tmpTexto = new Texto(sigantura, fechaCompra, restringido, tema, titulo, autor, fechaPublicacion, numPaginas, idioma);
        logica.registrarMaterial(tmpTexto);
    }

    public void registrarAudio(String sigantura, LocalDate fechaCompra, boolean restringido, String tema, String formato, int duracion, String idioma) {
        Audio tmpAudio;

        tmpAudio = new Audio(sigantura, fechaCompra, restringido, tema, formato, duracion, idioma);
        logica.registrarMaterial(tmpAudio);
    }
    public void registrarVideo(String sigantura, LocalDate fechaCompra, boolean restringido, String tema, String formato, int duracion, String idioma, String director) {
        Video tmpVideo;

        tmpVideo = new Video(sigantura, fechaCompra, restringido, tema, formato, duracion, idioma, director);
        logica.registrarMaterial(tmpVideo);
    }

    public void registrarOtroMaterial(String sigantura, LocalDate fechaCompra, boolean restringido, String tema, String descripcion) {
        Otro_material tmpOtroMaterial;

        tmpOtroMaterial = new Otro_material(sigantura, fechaCompra, restringido, tema, descripcion);
        logica.registrarMaterial(tmpOtroMaterial);
    }

    public String [] imprimirMateriales() {
        String [] lista;
        int tamanno = logica.getMateriales().size();
        lista = new String[tamanno];
        int cont = 0;
        for (Material dato : logica.getMateriales()) {
            lista[cont] = dato.toString();
        }
        return lista;
    }

    public String buscarPersona(String identificacion ) {
        String personaEncontrada;

        personaEncontrada = logica.buscarPersona(identificacion);
        return personaEncontrada;
    }

    public String buscarMaterial(String signatura) {
        String materialEncontrado;

        materialEncontrado = logica.buscarMaterial(signatura);
        return materialEncontrado;
    }

}
