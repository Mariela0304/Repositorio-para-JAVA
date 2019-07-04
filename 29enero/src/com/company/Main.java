package com.company;

public class Main {



    public static void main(String[] args) {

        //creo una variable para las instancias de persona
        Persona miPersona;
        Persona otraPersona;

        //Inicializo la variable

        miPersona = new Persona();
        otraPersona = new Persona();


        miPersona.edad = 10;
        miPersona.nombre = "Pedro Picapiedra";
        otraPersona.edad= 15;
        otraPersona.primerApellido = "Monestel";

        System.out.println(miPersona.edad);
        System.out.println(miPersona.nombre);
        System.out.println(otraPersona.primerApellido);
        //ambas instancias tienen los mismos datos

    }
}
