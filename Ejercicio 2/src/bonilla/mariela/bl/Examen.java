package bonilla.mariela.bl;


import java.util.Arrays;

public class Examen {
    private String alumno;
    private double nota;
    private String curso;
    private int numPreguntas;
    private String[][] infoPregunta;


    public Examen() {
    }


    public Examen(String palumno) {
        this.alumno = palumno;
    }

    public Examen(String pnomCurso, int pcantPreguntas, String[] infoPreg) {
        this.curso = pnomCurso;
        this.numPreguntas = pcantPreguntas;

        infoPregunta = new String[pcantPreguntas][4];

        for (int i = 0; i < pcantPreguntas; i++) {

            String[] partes = infoPreg[i].split(",");
            String pregunta = partes[0];
            String valorPregunta = partes[1];
            String cont = Integer.toString(i + 1);

            this.infoPregunta[i][0] = (cont + 1);
            this.infoPregunta[i][1] = pregunta;
            this.infoPregunta[i][2] = valorPregunta;
            this.infoPregunta[i][3] = "0.0";
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

    public String[][] getInfoPregunta() {
        return infoPregunta;
    }

    public void setInfoPregunta(String[][] pinfoPregunta) {

        String idPregunta = pinfoPregunta[0][0];
        String ppuntaje = pinfoPregunta[0][1];
        String curso = pinfoPregunta[0][2];

        for (int i = 0; i < infoPregunta.length; i++) {

            if (infoPregunta[i][3].equals(curso)) {
                if (infoPregunta[i][0].equals(idPregunta)) {
                    this.infoPregunta[i][4] = ppuntaje;
                }
            }

        }

    }

    @Override
    public String toString() {
        return "Examen{" +
                "alumno='" + alumno + '\'' +
                ", nota=" + nota +
                ", curso='" + curso + '\'' +
                '}';
    }


    public void calcularNota() {

        double valorPreguntas = 0;
        double puntajesObtenidos = 0;
        double notaObtenida = 0;

        for (int i = 0; i < infoPregunta.length; i++) {
            valorPreguntas = +Double.parseDouble(infoPregunta[i][2]);
            puntajesObtenidos = +Double.parseDouble(infoPregunta[i][3]);

        }

        notaObtenida = (puntajesObtenidos * valorPreguntas) / 70;

        this.nota = notaObtenida;
    }

}
