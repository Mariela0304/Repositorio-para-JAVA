package bonilla.mariela.dl;

import bonilla.mariela.bl.Carrera;
import bonilla.mariela.bl.Curso;
import bonilla.mariela.bl.Estudiante;

import java.util.TreeMap;

public class CL {


    public TreeMap<String, Estudiante> estudiantes;
    public TreeMap<String, Curso> cursos;
    public TreeMap<String, Carrera> carreras ;

    public CL() {
        estudiantes = new TreeMap<>();
        cursos = new TreeMap<>();
        carreras = new TreeMap<>();
    }


    public void registroEstudiante(Estudiante tmpEestudiante){
        //todo: verificar el estudiante exista//
        estudiantes.put(tmpEestudiante.getId(), tmpEestudiante);

    }
    

    public void registrarCarrera(Carrera tmpCarrera) {
        //todo: verificar la carrera exista//
        carreras.put(tmpCarrera.getCodigo(), tmpCarrera);
    }

    //
    public void registrarCurso(Curso tmpCurso) {
        //todo: verificar el curso exista//
        cursos.put(tmpCurso.getCodigo(), tmpCurso);
    }


    public TreeMap<String, Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public TreeMap<String, Curso> getCursos() {
        return cursos;
    }

    public TreeMap<String, Carrera> getCarreras() {
        return carreras;
    }



    //Retorna un estudiante
    public Estudiante getEstudiante(String key) {
        return estudiantes.get(key);
    }


}


