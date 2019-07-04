package bonilla.mariela.tl;


import bonilla.mariela.bl.Examen;
import bonilla.mariela.dl.*;
import java.util.ArrayList;

public class Controller {
    static CL logica = new CL();


    //Retorna la lista de las preguntas
    public ArrayList<Examen> listaPreguntas() {
        return logica.getPreguntas();
    }

    //Retorna la lista de los alumnos
    public ArrayList<Examen> listaAlumnos() {
        return logica.getAlumnos();
    }


    public void registrarAlumno (String nombre, String curso) {
        //se crea la instancia
        Examen tmpAlumno;
        tmpAlumno = new Examen(nombre, curso);
        tmpAlumno.setNota(0);
        logica.registrarAlumno(tmpAlumno);

    }


    public void registrarExamen (String curso, int cantPreg, String[] infoPreguntas ) {

    }


    public String [] listarAlumnos() {
        String [] alumnos;

        int tamanno = logica.getAlumnos().size();


        String dato;

        alumnos = new String[tamanno];

        int cont=0;

        for ( Examen obj : logica.getAlumnos()){
            alumnos[cont] = obj.toString();
            cont++;
        }


        return alumnos;
    }


}
