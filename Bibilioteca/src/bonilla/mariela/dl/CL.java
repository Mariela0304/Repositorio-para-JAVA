package bonilla.mariela.dl;

import bonilla.mariela.bl.*;
import java.util.ArrayList;

public class CL {

    private ArrayList<Persona> personas;
    private ArrayList<Material> materiales;


    public CL() {
        personas = new ArrayList<>();
        materiales = new ArrayList<>();
    }

    public void registrarPersona(Persona tmpPersona) {
        personas.add(tmpPersona);
    }

    public ArrayList<Persona> getPersonas() {
        return personas;
    }

    public void registrarMaterial(Material tmpMaterial) {
        materiales.add(tmpMaterial);
    }

    public ArrayList<Material> getMateriales() {
        return materiales;
    }

    public String buscarPersona(String identificacion ) {
        String personaEncontrada = "Identificación no encontrada";
        for (Persona obj: getPersonas()) {
            if (identificacion.equals(obj.getIdentificacion())) {
                personaEncontrada = obj.toString();
            }
        }
        return personaEncontrada;
    }

    public String buscarMaterial(String signatura) {
        String materialEncontrado = "Signatura no encontrada";
        for (Material obj: getMateriales()) {
            if (signatura.equals(obj.getIdSignatura())) {
                materialEncontrado = obj.toString();
            }
        }
        return materialEncontrado;
    }
}
