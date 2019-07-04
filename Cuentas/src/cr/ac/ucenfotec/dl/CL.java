package cr.ac.ucenfotec.dl;

import cr.ac.ucenfotec.bl.*;
import java.util.ArrayList;
public class CL {

    private ArrayList<Cuenta> cuentas;


    public CL() {
        //se inicializa el arraylist
        cuentas = new ArrayList<>();
    }

    //metodo de acceso que retorna un arraylist
    public ArrayList<Cuenta> getCuentas() {
        return cuentas ;
    }

    //método que inserta y registrar la cuenta en la colección
    public void registrar(Cuenta ptmpCuenta) {
        cuentas.add(ptmpCuenta);
    }


    //método que va a imprimir el arrayList
    public void imprimirLista(){
        System.out.println("Impresión en la CL");
        for (Cuenta dato: cuentas) {
            System.out.println(dato.toString());
        }
    }
}

