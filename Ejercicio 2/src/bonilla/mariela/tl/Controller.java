package bonilla.mariela.tl;

import bonilla.mariela.bl.*;
import bonilla.mariela.dl.*;

import java.util.ArrayList;

public class Controller {
    static CL logica = new CL();


//metodo para el ingreso de un alumno
    public void registrarAlumno (String nombre) {
        //se crea la instancia
        Examen tmpAlumno;
        tmpAlumno = new Examen(nombre);
        tmpAlumno.setNota(0);

    }

    public double obtenerNota() {
        double nota = 0;

        int cont = 0;

        for (Examen dato: logica.getExamenes()) {
            nota = dato.getNota();
        }

        return nota;
    }

    public void calcularNota() {

        double nota = logica.notaCalculada();
    }


//metodo que sirve para registrar el examen
    public void registrarExamen (String curso, int cantPreg, String[] infoPreguntas ) {
        //Crear una nueva instancia de cuenta.
        //Usando el constructor respectivo

        Examen tmpExamen;

        //Constructor
        tmpExamen = new Examen(curso, cantPreg, infoPreguntas);

        logica.registrarExamen(tmpExamen);

    }

    //metodo que permitira que se ingrese un puntaje a la un pregunta
    public void ingresarPuntaje(String alumno, int id_pregunta, double puntaje) {
        Examen tmpPregunta = new Examen();

        Examen estudiante = new Examen(alumno);

        String[][] pregunta = new String[1][3];

        pregunta[0][0]= Integer.toString(id_pregunta);
        pregunta[0][1] = Double.toString(puntaje);
        pregunta[0][2] = alumno;

        tmpPregunta.setInfoPregunta(pregunta);
    }

    public String [] imprimirExamenes() {

        String [] lista = new String[logica.getExamenes().size()];
        int cont = 0;

        for (Examen obj : logica.getExamenes()) {
            lista[cont] = obj.toString();
            cont++;
        }
        return lista;
    }


}
