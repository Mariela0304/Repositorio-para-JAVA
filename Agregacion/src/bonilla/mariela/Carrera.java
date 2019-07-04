package bonilla.mariela;

import java.util.ArrayList;

public class Carrera {
    private String nombre;
    private ArrayList<Estudiante> estudiantes;

    public Carrera() {
    }

    public Carrera(String nombre) {
        this.nombre = nombre;
    }

    public Carrera(String nombre, ArrayList<Estudiante> estudiantes) {
        this.nombre = nombre;
        this.estudiantes = estudiantes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Carrera{" +
                "Nombre: '" + nombre + '\'' +
                ", Estudiantes: " + estudiantes +
                '}';
    }


    public ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiante(ArrayList estudiantes) {
        this.estudiantes = estudiantes;
    }
}
