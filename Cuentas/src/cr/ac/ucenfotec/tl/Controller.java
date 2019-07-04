package cr.ac.ucenfotec.tl;

import cr.ac.ucenfotec.bl.*;
import cr.ac.ucenfotec.dl.*;
import java.time.LocalDate;
import java.util.ArrayList;


public class Controller {
    //se inicialiaza la capa lógica
    private CL logica = new CL();

//    //Se crea el constructor de la clase controller que inicializa la capa lógica
//    public Controller(CL logica) {
//        this.logica = logica;
//    }

    //Este método va a crear una nueva instancia de la clase cuenta y la va a enviar
    //a insertarse en el arraylist.
    public void registrarNuevaCuenta(String pduenno, int pnumCuenta, double psaldo) {

        //Crear una nueva instancia de cuenta.
        //Usando el constructor respectivo

        Cuenta tmpCuenta;

        //Constructor
        tmpCuenta = new Cuenta(psaldo, pduenno);
        //Para asignar el valor al número de cuenta se debe usa el método set
        //porque el número de cuenta no se inicializa en el constructor.
        //Igual la fecha de creación.
        // con el se definexa
        tmpCuenta.setNumCuenta(pnumCuenta);
        tmpCuenta.setFechaCreacion(LocalDate.now());
        logica.registrar(tmpCuenta);


    }

    //metodo que retorna un arraylist
    public ArrayList<Cuenta> listaCuenta() {
        return logica.getCuentas();
    }


    //metodo que imprime el método de imprimirLista de la CL

    public void imprimirCuentas() {
        logica.imprimirLista();
    }


    //metodo que retorna un arreglo(String). Este arreglo contine el toString de cada elemnto del arraylist de cuenta de la capa
    //logica
    public String[] listarCuentas () {
        String[] info;
        int tamanno = logica.getCuentas().size();

        //info = new String[logica.getCuentas().size()];
        String dato;

        info = new String[tamanno];

        //0. INICIALIZAR EL ARREGLO (DEBE TENER UN TAMANNO ANTES DE USARSE)
        //1.llamar al metodo que retorna el arraylist de cuentas de la cl
        //2.Declarar una variable, temporal de tipo String llamada dato.
        //3.Usando un for each, recorrer el arraylist de cuenta de la cl.
        //4. En cada posicion del arreglo almacenar el dato.toString().


        int cont=0;

        for ( Cuenta obj : logica.getCuentas()){
            info[cont] = obj.toString();
            cont++;
        }


        return info;
    }
}
