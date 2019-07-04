package cr.ac.ucenfotec;

import java.util.TreeMap;

public class CL {
    private TreeMap<String, Persona> personas;
    private TreeMap<String, Cuenta> cuentas;

    public CL() {
        personas = new TreeMap<>();
        cuentas = new TreeMap<>();

    }

    public void registrarPersona(Persona tmpPersona, String nombre) {
        personas.put(nombre, tmpPersona);
    }

    public void registrarCuenta(Cuenta tmpCuenta, String numCuenta) {
        cuentas.put(numCuenta, tmpCuenta);
    }

    public TreeMap<String, Persona> getPersonas() {
        return personas;
    }

    public TreeMap<String, Cuenta> getCuentas() {
        return cuentas;
    }
}
