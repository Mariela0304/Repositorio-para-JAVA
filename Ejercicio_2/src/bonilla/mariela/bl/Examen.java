package bonilla.mariela.bl;


import java.util.ArrayList;
import bonilla.mariela.dl.*;

public class Examen {
    private String alumno;
    private double nota;
    private String curso;
    private int numPreguntas;
    private String[][] infoPregunta;


    public Examen (){
    }


    public Examen (String palumno, String pcurso) {
        this.alumno = palumno;
        this.curso = pcurso;
    }

    public Examen (String pnomCurso, int pcantPreguntas, String[] infoPreg) {
        this.curso = pnomCurso;
        this.numPreguntas = pcantPreguntas;
        for (int i = 0; i < infoPreg.length; i++) {

            String[] partes = infoPreg[i].split("-");
            String infoPregunta = partes[0];
            String valorPregunta = partes[1];

            String cont = Integer.toString(i);
            this.infoPregunta[i][0] = cont ;
            this.infoPregunta[i][1] = infoPregunta ;
            this.infoPregunta[i][2] = valorPregunta ;
        }

    }

    public String getAlumno() {
        return alumno;
    }

    public void setAlumno(String alumno) {
        this.alumno = alumno;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getNumPreguntas() {
        return numPreguntas;
    }

    public void setNumPreguntas(int numPreguntas) {
        this.numPreguntas = numPreguntas;
    }



    public String toString() {

        return "Nota de alumno" +
                "\nNombre de alumno: " + alumno +
                "\nCurso: "+ curso+
                "\nNota obtenida: " + nota +  '\n'
                ;
    }


    public void ingresarNota(int pid_pregunta, double ppuntaje) {




    }


    public void calcularNota() {



    }

}
