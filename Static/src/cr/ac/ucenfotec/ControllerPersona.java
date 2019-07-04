package cr.ac.ucenfotec;

public class ControllerPersona extends Controller {


    public ControllerPersona() {
        super();
    }

    public void registrarPersona(String nombre, String apellido){
        Persona tmpPersona = new Persona(nombre, apellido);
        logica.registrarPersona(tmpPersona, nombre);
    }



    public String[] listarPersonas() {
        int cont = 0;
        int size = 0;
        int i = 0;
        String[] cuentas;
        size = logica.getPersonas().size();

        cuentas = new String[size];
        cont = -1;

        for ( Persona dato : logica.getPersonas().values()) {
            cont++;
            cuentas[cont] = dato.toString();
        }

        return cuentas;
    }

}
