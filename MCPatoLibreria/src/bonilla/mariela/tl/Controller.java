package bonilla.mariela.tl;

import bonilla.mariela.bl.*;
import bonilla.mariela.dl.CL;
import java.util.ArrayList;

public class Controller {

    private CL logica = new CL();

    public void registrarCasa(int codigo, String nombre, double valor, String direccion, String residencial, int numCasa, String patio, int habitaciones, String cochera, int vehiculos) {
        Casa tmpCasa;
        Propiedad casa;
        tmpCasa = new Casa(codigo, nombre, valor, direccion, residencial, numCasa, patio, habitaciones, cochera, vehiculos);
        casa = new Propiedad(codigo, valor, direccion, patio, habitaciones, cochera, vehiculos);
        logica.registrarCasa(tmpCasa);
        logica.registrarPropiedad(casa);
    }


    public void registrarApartamento(int codigo, double valor, String direccion, String patio, int habitaciones, ArrayList amenidades, String cochera, int vehiculos) {
        Apartamento tmpApartamento;
        Propiedad apartamento;
        tmpApartamento = new Apartamento(codigo, valor, direccion, patio, habitaciones, amenidades, cochera, vehiculos);
        apartamento = new Propiedad(codigo, valor, direccion, patio, habitaciones, cochera, vehiculos);
        logica.registrarApartamento(tmpApartamento);
        logica.registrarPropiedad(apartamento);
    }

    public  void registrarInquilino(String nombre, String apellidos, String correo, String direccion, String identificacion, int telefono, String genero) {
        Inquilino tmpInquilino;
        tmpInquilino = new Inquilino(nombre, apellidos, correo, direccion, identificacion, telefono, genero);
        logica.registrarInquilino(tmpInquilino);
    }



    public String[] listaPropiedades() {
        String[] info;
        int cont=0;
        int tamanno = logica.getPropiedades().size();
        info = new String[tamanno];
        for ( Propiedad obj : logica.getPropiedades()){
            info[cont] = obj.toString();
            cont++;
        }
        return info;
    }

    public String [] listaInquilinos() {
        String[] info;
        int cont=0;
        int tamanno = logica.getInquilinos().size();
        info = new String[tamanno];
        for ( Inquilino obj : logica.getInquilinos()){
            info[cont] = obj.toString();
            cont++;
        }
        return info;
    }


    public boolean validarNombrePropiedad(String nombre) {
        boolean repetido = false;
        for (Casa obj : logica.getCasas()) {
            if (obj.getNombre().equals(nombre)) {
                repetido = true;
            }
        }
        return repetido;
    }

    public boolean validarResidencial(String residencial) {
        boolean repetido = false;
        for (Casa obj : logica.getCasas()) {
            if (obj.getResidencial().equals(residencial)) {
                repetido = true;
            }
        }
        return repetido;
    }

    public boolean validarCodigo(int pcodigo) {
        boolean repetido = false;
        repetido = logica.buscarPropiedad(pcodigo);
        return repetido;
    }

    public boolean validarInquilino(String pidentificacion) {
        boolean repetido = false;
        repetido = logica.buscarInquilino(pidentificacion);
        return repetido;
    }

    public boolean validarCorreo(String pcorreo) {
        boolean repetido = false;
        for (Inquilino obj : logica.getInquilinos()) {
                if (obj.getCorreo().equals(pcorreo)) {
                repetido = true;
            }
        }
        return repetido;
    }

    public boolean validarNumero(String ppnumero) {
        return logica.validarNumeros(ppnumero);
    }

    public boolean validarValor(String ppnumero) {
        return logica.validarDouble(ppnumero);
    }
}
