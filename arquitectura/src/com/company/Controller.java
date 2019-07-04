package com.company;

public class Controller {

    public CL logica = new CL();


    public int calcularSuma(int num1, int num2) {
        return logica.sumar(num1, num2);
    }

    public int calcularResta(int num1, int num2) {
        return logica.restar(num1, num2);

    }

    public int calcularMultiplicacion(int num1, int num2) {
        return logica.multiplicar(num1, num2);

    }

    public int calcularDividir(int num1, int num2) {
        return logica.dividir(num1, num2);

    }

    public  double raizCuadrada( int pnum) {
        return logica.raizCuadrada(pnum);

    }
}
