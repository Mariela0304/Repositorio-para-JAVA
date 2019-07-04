package com.company;

public class CL {

    public int sumar(int pnum1, int pnum2) {
        int suma = 0;
        suma = pnum1 + pnum2;
        return suma;
    }

    public int restar(int pnum1, int pnum2) {
        int resta = 0;
        resta = pnum1 - pnum2;
        return resta;
    }

    public int multiplicar(int pnum1, int pnum2) {
        int multiplicacio = 0;
        multiplicacio = pnum1 * pnum2;
        return multiplicacio;
    }

    public int dividir(int pnum1, int pnum2) {
        int división = 0;
        if (pnum2!=0) {
            división = pnum1 / pnum2;
        }
        return división;
    }

    public double raizCuadrada(int pnum) {
        double raiz;
        raiz =  Math.sqrt(pnum);
        return raiz;
    }


    
}
