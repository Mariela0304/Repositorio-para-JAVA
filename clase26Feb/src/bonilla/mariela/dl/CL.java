package bonilla.mariela.dl;

import bonilla.mariela.bl.Curso;
import bonilla.mariela.bl.Laboratorio;

import java.util.TreeMap;
//Clase que
//La clase tiene todos los metodos de almacenamiento y extraccion
public class CL {
    //Variable de tipo TreeMap que almacena la info de los labs
    private TreeMap<String, Laboratorio> laboratorios;
    private TreeMap<String, Curso> cursos;

    //Controlador que inicializa la lista de laboratorios
    public CL() {
        this.laboratorios = new TreeMap<>();
        this.cursos = new TreeMap<>();
    }

    //metodo que registra el laboratorio en la lista de labs
    public void registrarLaboratorio(Laboratorio pLab) {
        laboratorios.put(pLab.getCodigo(), pLab);
    }

    //Metodo que retorna una instancia especifica basado en el key del laboratorio
    public Laboratorio getLaboratorio(String key) {
        return laboratorios.get(key);
    }

    public TreeMap<String, Laboratorio> getLaboratorios() {
        return laboratorios;
    }

    //Cursos
    public void registrarCurso(Curso pCurso) {
        cursos.put(pCurso.getCodigo(), pCurso);
    }
    public Curso getCurso(String key) {
        return cursos.get(key);
    }

    public void eliminarLaboratorio(String key) {
        laboratorios.remove(key);
    }
    public void eliminarCurso(String key) {
        cursos.remove(key);
    }

    public TreeMap<String, Curso> getCursos() {
        return cursos;
    }
}
