package bonilla.mariela;

import java.util.ArrayList;
import java.util.TreeMap;

public class CL {

    private ArrayList<Libreria> librerias;

    public ArrayList<Libreria> getLibrerias() {
        return librerias;
    }

    public void registrarLibreria(Libreria tmpLibreria) {
        librerias.add(tmpLibreria);
    }

}
