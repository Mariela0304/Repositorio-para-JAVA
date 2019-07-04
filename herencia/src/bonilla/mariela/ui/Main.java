package bonilla.mariela.ui;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;

import bonilla.mariela.bl.*;
import bonilla.mariela.dl.*;
import bonilla.mariela.tl.*;

public class Main {

    static BufferedReader entrada = new BufferedReader(
            new InputStreamReader(System.in));
    static PrintStream salida = System.out;
    static Controller gestor = new Controller();




    public static void main(String[] args) {

        //Se crea la persona
        Persona tmpPersona;
        //Se crea la persona fisica
        PersonaFisica pf;
        //Se crea la persona juridica
        PersonaJuridica pj;
        //se
        ArrayList<Object> lista;

        tmpPersona = new Persona();
        pf = new PersonaFisica();
        pj = new PersonaJuridica();
        lista = new ArrayList<>();
        lista.add(tmpPersona);//se agrega la persona
        lista.add(pf);//se agrega la persona fisica
        lista.add(pj);//se agrega la persona juridica


        for (Object dato : lista) {
            salida.println(dato.toString());
        }


    }
}
