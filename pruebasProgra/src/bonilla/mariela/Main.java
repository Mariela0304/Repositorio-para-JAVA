package bonilla.mariela;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Main {

    static BufferedReader entrada = new BufferedReader(
            new InputStreamReader(System.in));
    static PrintStream salida = System.out;

    public static void main(String[] args) throws java.io.IOException {
        int cont1 = 0;// suma de boletos
        int cont2 = 0; // suma regulares
        int cont3 = 0; // suma VIP
        int cont4= 0; // suma preferenciales
        int total = 0; // total de funciones
        int suma; //suma de los boletos
        int cantboRegulares = 0;
        int cantboVIP= 0;
        int cantboPre = 0;


        for (int i = 0; i < 2; i++) {

            boolean correcto = false;
            cont4 = 0;
            for (int s = 0; s < 2; s++) {

                for (int f = 0; f<2; f++){
                    while (correcto == false) {
                        suma = 0;

                        salida.println("Digite la cantidad de boletos regulares del local #" + (1+i) + " de la sala #"+ (1+s) + " de la funcion # "+(1+f));
                        cantboRegulares = Integer.parseInt(entrada.readLine());
                        salida.println("Digite la cantidad de boletos VIP del local #" + (1+i) + " de la sala #" + (1+s)+ " de la funcion # "+(1+f));
                        cantboVIP = Integer.parseInt(entrada.readLine());
                        salida.println("Digite la cantidad de boletos preferenciales del local #" + (1+i) + " de la sala #"+(1+s)+ " de la funcion # "+(1+f));
                        cantboPre = Integer.parseInt(entrada.readLine());

                        cont2 = cont2 + cantboRegulares;
                        cont3 = cont3 + cantboVIP;
                        cont4 = cont4 + cantboPre;

                        suma = cantboRegulares + cantboVIP + cantboPre;

                        if (suma > 60) {
                            correcto = false;
                            salida.println("El numero total de boletos vendidos se excede a los permitidos. \nPor favor ingreselos menos de 60");
                        } else {
                            cont1 = cont1 + suma;
                            correcto = true;
                        }
                    }
                }

            }

            salida.println("La cantidad de boletos preferenciales de este local es de "+cont4);
        }

        total = 3*(8*3);

        salida.println("El total de las funciones de todos los locales es de: "+total+"\n El total de boletos vendidos de todos los locales es de: "+ cont1);
        salida.println("El total de boletos regulares vendidos es de: "+cont2+"\nEl total de los boletos VIP vendidos es de: "+ cont3);



    }
}
