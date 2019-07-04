package bonilla.mariela.tl;

import bonilla.mariela.bl.*;
import bonilla.mariela.dl.*;
//clase que sirve como intermedio entre la ui y la CL
public class Controller {
    //instancia de la clase CL que almacena las listas
   private CL logica;

   //constructor que inicializa los atributos
   public Controller() {
       logica = new CL();
   }

   //Metodo que toma la informacion que viene de la UI y la guarda tanto en la lista de laboratorio de la CL
   public void registrarLab(String codigo, int capacidad){
      //instancia de laboratorio
       Laboratorio tmpLaboratorio = new Laboratorio(codigo, capacidad);

       //llamado al metodo registrar de la clase CL
       logica.registrarLaboratorio(tmpLaboratorio);
   }

    public void registrarCurso(String codigo, String nombre, int creditos){
        //instancia de laboratorio
        Curso tmpCurso = new Curso(codigo, nombre, creditos);

        //llamado al metodo registrar de la clase CL
        logica.registrarCurso(tmpCurso);
    }



    public String [] imprimirLaboratorios() {
        String [] lista = new String[logica.getLaboratorios().size()];
        int cont = 0;
        for (Laboratorio dato : logica.getLaboratorios().values()) {
            lista[cont] = dato.toString();
            cont++;
        }
        return lista;
    }

    public String [] imprimirCursos() {
        String [] lista = new String[logica.getCursos().size()];
        int cont = 0;

        for (Curso dato : logica.getCursos().values()) {
            lista[cont] = dato.toString();
            cont++;
        }
        return lista;
    }


    public String getLaboratorio(String key) {
       return logica.getLaboratorio(key).toString();
    }

    public String getCurso(String key) {
        return logica.getCurso(key).toString();
    }


    public String removeLab(String key) {
       String eliminado = "El laboratorio fue eliminado";
       logica.eliminarLaboratorio(key);
       return eliminado;
    }

    public String removeCurso(String key) {
        String eliminado = "El curso fue eliminado";
        logica.eliminarCurso(key);
        return eliminado;
    }
}
