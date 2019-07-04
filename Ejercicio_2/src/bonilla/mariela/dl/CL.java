package bonilla.mariela.dl;

import bonilla.mariela.bl.Examen;

import java.util.ArrayList;

public class CL {
    private ArrayList<Examen> preguntas;

    private ArrayList<Examen> alumnos;


    public CL() {
        //se inicializa el arraylist
        preguntas = new ArrayList<>();
        alumnos = new ArrayList<>();
    }

    //metodo de acceso que retorna un arraylist
    public ArrayList<Examen> getPreguntas() {
        return preguntas;
    }

    public ArrayList<Examen> getAlumnos() {
        return alumnos;
    }



    //registro de alumnos con el curso y la nota en 0
    public void registrarAlumno(Examen ptmpAlumno) {
        alumnos.add(ptmpAlumno);
    }






    //método que inserta la nota en la colección
//    public void insertaNota(Examen notaObtenida ) {
//        cuentas.add(ptmpCuenta);
//    }
}
