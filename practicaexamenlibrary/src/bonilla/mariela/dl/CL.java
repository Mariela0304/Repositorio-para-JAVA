package bonilla.mariela.dl;

import bonilla.mariela.bl.Persona;

import java.util.TreeMap;

public class CL {

    private TreeMap <String, Persona> personas;

    public CL() {
        personas = new TreeMap<>();
    }

    public void registrarPersona(Persona tmpPersona) {
        personas.put(tmpPersona.getIdentificacion(), tmpPersona);
    }


    public TreeMap<String, Persona> getPersonas() {
        return personas;
    }


}
