package bonilla.mariela;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Estudiante estudiante1 = new Estudiante("Mario", "117738745");
        Estudiante estudiante2 = new Estudiante("Bertha", "1197738745");
        Estudiante estudiante3 = new Estudiante("Julio", "111972745");

        ArrayList<Estudiante> estudiantes = new ArrayList<>();

        estudiantes.add(estudiante1);
        estudiantes.add(estudiante2);
        estudiantes.add(estudiante3);

        Carrera carrera = new Carrera("Sociales");
        carrera.setEstudiante(estudiantes);

        System.out.println(carrera.toString());

    }
}
