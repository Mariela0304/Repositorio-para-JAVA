package bonilla.mariela.tl;

//La responsabilidad del controlador es tomar los
// datos de la UI, instanciar los objetos y pasarlos a la Capa Lógica, para que esta se encargue de la inserción en los arreglos.

import bonilla.mariela.bl.Carrera;
import bonilla.mariela.bl.Curso;
import bonilla.mariela.bl.Estudiante;
import bonilla.mariela.dl.CL;

import java.util.ArrayList;

public class Controlador {
    CL logica = new CL(); // es un atributo de tipo CL



    //método que inicia el proceso de almacenamiento de los estudiantes en la aplicación. Recibe los datos de la capa de presentación y las pasa a la capa lógica para la inserción.
    public void ingresarEstudiante( String nombre, String apellido, String identificacion, String edad) {
        //declaro un objeto de un tipo Estudiante
        String indice =Integer.toString( logica.estudiantes.size() + 1);

        Estudiante tmpEstudiante;
        //inicialiazo el estudiante
        tmpEstudiante = new Estudiante(indice, nombre, apellido, identificacion, edad);
        //llama la capa lógica para que inserte
        logica.registroEstudiante(tmpEstudiante);
    }



    public void ingresarCarrera (String nombre, String codigo, boolean acreditada) {
        Carrera tmpCarrera;

        tmpCarrera = new Carrera(codigo, nombre, acreditada);

        logica.registrarCarrera(tmpCarrera);
    }

    public void ingresarCurso (String nombre, String codigo, int creditos) {
        Curso tmpCurso;

        tmpCurso = new Curso(codigo, nombre, creditos);

        logica.registrarCurso(tmpCurso);
    }


    //Retorna el arreglo de estudiantes de la capa lógica
    public String[] listaEstudiantes() {
        String [] lista = new String[logica.getEstudiantes().size()];
        int cont = 0;

        for (Estudiante dato: logica.getEstudiantes().values()) {
            lista[cont] = dato.toString();
        }

        return lista;
    }

    public String[] listaCarreras() {
        String [] lista = new String[logica.getCarreras().size()];
        int cont = 0;

        for (Carrera dato: logica.getCarreras().values()) {
            lista[cont] = dato.toString();
        }

        return lista;
    }


    public String[] listaCursos() {
        String [] lista = new String[logica.getCursos().size()];
        int cont = 0;

        for (Curso dato: logica.getCursos().values()) {
            lista[cont] = dato.toString();
        }

        return lista;
    }


    //Retorna un estudiante

    public ArrayList<String> getEstudiante(String key) {

        ArrayList<String> lista = new ArrayList<>(logica.getEstudiantes().size());

       for (int i = 0; i < lista.size(); i++) {
           lista.add(logica.getEstudiante(key).getId());
           lista.add(logica.getEstudiante(key).getNombre());
           lista.add(logica.getEstudiante(key).getApellido());
           lista.add(logica.getEstudiante(key).getIdentificacion());
           lista.add(logica.getEstudiante(key).getEdad());
       }
       return lista;
    }

}


