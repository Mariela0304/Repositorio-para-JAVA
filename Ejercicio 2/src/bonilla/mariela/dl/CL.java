package bonilla.mariela.dl;

import bonilla.mariela.bl.*;

import java.util.ArrayList;

public class CL {
    private ArrayList<Examen> examenes;


    public CL() {
        //se inicializa el arraylist
        examenes = new ArrayList<>();
    }


    public void registrarExamen( Examen tmpExamen ) {
        examenes.add(tmpExamen);
    }

    public ArrayList<Examen> getExamenes() {
        return examenes;
    }



    public double notaCalculada() {
        Examen nota = new Examen();
        double valor;

        valor = nota.getNota() ;

        return valor;
    }



    public double calcularNota() {

        double valorPreguntas = 0;
        double puntajesObtenidos = 0;
        double notaObtenida = 0;

        int cont =0;

        for (Examen obj : getExamenes()) {
            valorPreguntas = +Double.parseDouble(obj.getInfoPregunta()[cont][2]);
            puntajesObtenidos = +Double.parseDouble(obj.getInfoPregunta()[cont][3]);
            cont++;
        }

        notaObtenida = (puntajesObtenidos * valorPreguntas) / 70;

        return notaObtenida;
    }

    public double buscarAlumno(String pnombre) {
        String nombre;
        double puntaje = 0;
        String [] puntajes;

        for (Examen obj : getExamenes()) {
            if (pnombre.equals(obj)) {
                nombre = obj.getAlumno();
                puntaje = obj.getNota();

            }
        }
        return puntaje;

    }
}
