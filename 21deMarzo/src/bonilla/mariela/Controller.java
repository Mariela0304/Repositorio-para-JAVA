package bonilla.mariela;

public class Controller {
    private CL logica;

    //constructor que inicializa los atributos
    public Controller() {
        logica = new CL();
    }

    public void registrarLab(String nombre, String direccion){
        //instancia de laboratorio
        Libreria tmpLibreria = new Libreria(nombre, direccion);

        //llamado al metodo registrar de la clase CL
        logica.registrarLibreria(tmpLibreria);
    }


    public String [] imprimirLibreria() {
        String [] lista = new String[logica.getLibrerias().size()];
        int cont = 0;

        for (Libreria dato : logica.getLibrerias()) {
            lista[cont] = dato.toString();
            cont++;
        }
        return lista;
    }

}
