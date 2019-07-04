package bonilla.mariela.tl;
import bonilla.mariela.bl.*;
import bonilla.mariela.dl.CL;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Controller {

    private CL logica = new CL();

    public void registrarCliente(String nombre, String cedula, String direccion) {
        Cliente obj;
        obj = new Cliente(nombre, cedula, direccion);
        logica.newClient(obj);
    }


    /*
    Se crea una cuenta de ahorro programada
     @Lenner Hurtado
     */
    public String nuevaCuentaAhorro(String tipoCuenta, double saldo, int cuenta, String cedula) {
        String info = "";
        try {
            Cliente obj2;
            obj2 = logica.buscarCliente(cedula);
            CuentaAhorro obj;
            /*Se crea la variable de la fecha actual*/
            LocalDate fechaApertura = LocalDate.now();
            obj = new CuentaAhorro(tipoCuenta, fechaApertura, saldo, cuenta);
            obj2.setCuentas(obj);
            logica.newCuentaAhorro(obj);
            info = tipoCuenta + "," + fechaApertura + "," + saldo + "," + cuenta + "," + CuentaAhorro.tasaInteres;

            /*
            Se llama el archivo de texto donde se van a guardar los datos
             */
            FileWriter writer = new FileWriter("Archivo.txt", true);

            BufferedWriter buffer = new BufferedWriter(writer);

            buffer.newLine();
            buffer.write(info);
            buffer.close();//se cierra el Buffered.
        } catch (IOException e) {
            e.printStackTrace();//se imprimie la pila de llamadas.
        }


        return info;
    }



    /*
    Se crea una cuenta programada
    @Mariela Bonilla
     */

    public void nuevaCuentaAhorroProgramada(String tipoCuenta, double saldo,
                                            int numCuenta, int numCuentaCorriente, String cedula) {
/*Se crea la nueva variable de la fecha actual
            @Mariela Bonilla
            29/03/2018*/
        LocalDate fechaApertura = LocalDate.now();
        String[] info = new String[30];
        String infoCuenta = "";

        try {
            /*
            Creo un objeto de tipo persona para poder agregar la cuenta a su colección
             */
            Cliente cliente;
            cliente = logica.buscarCliente(cedula);


            FileReader reader2 = new FileReader("Archivo.txt");
            BufferedReader buffer2 = new BufferedReader(reader2);
            String datosCC;
            CuentaAhorroProgramado cAProgramada = new CuentaAhorroProgramado(tipoCuenta, fechaApertura, saldo, numCuenta);
            // cAProgramada.setCuenta(info[4]);
            while ((datosCC = buffer2.readLine()) != null) {

                if (!datosCC.isEmpty()) {
                    String[] infoCC = datosCC.split(",");

                    if (infoCC[3].equals(Integer.toString(numCuentaCorriente))) {
                        CuentaCorriente tmpCuentaCorriente = new CuentaCorriente(infoCC[0], LocalDate.parse(
                                infoCC[1]), Double.parseDouble(infoCC[2]), Integer.parseInt(infoCC[3]));

                        infoCuenta = tipoCuenta + "," + fechaApertura + "," + saldo + "," + numCuenta + "," + tmpCuentaCorriente.getNumero();
                    }
                }
            }
            reader2.close();

             /*
                Se llama el archivo de texto donde se van a guardar los datos
                 */
            FileWriter writer = new FileWriter("Archivo.txt", true);

            BufferedWriter buffer = new BufferedWriter(writer);

            buffer.newLine();
            buffer.write(infoCuenta);
            buffer.close();//se cierra el Buffered.
        } catch (IOException e) {
            e.printStackTrace();//se imprimie la pila de llamadas.
        }
    }

    /*
    Se crea una cuenta corriente
    @Elizabeth Sequeira
     */
    public void nuevaCuentaCorriente(String tipoCuenta, double saldo, int cuenta, String cedula) {
        String info;
        try {
            Cliente obj2;
            obj2 = logica.buscarCliente(cedula);

            CuentaCorriente obj;
            /*Se crea la nueva variable de la fecha actual
            @Mariela Bonilla
            29/03/2018*/
            LocalDate fechaApertura = LocalDate.now();
            obj = new CuentaCorriente(tipoCuenta, fechaApertura, saldo, cuenta);

            /*Nuevo método que le va a agregar la cuenta al cliente
            @Mariela Bonilla
            29/03/2018*/

            obj2.setCuentas(obj);
            logica.newCuentaCorriente(obj);
            info = tipoCuenta + "," + fechaApertura + "," + saldo + "," + cuenta;

             /*
                Se llama el archivo de texto donde se van a guardar los datos
                 */
            FileWriter writer = new FileWriter("Archivo.txt", true);

            BufferedWriter buffer = new BufferedWriter(writer);

            buffer.newLine();
            buffer.write(info);
            buffer.close();//se cierra el Buffered.
        } catch (IOException e) {
            e.printStackTrace();//se imprimie la pila de llamadas.
        }


    }


    public boolean validarCuenta(int cuenta) {
        boolean bandera = false;
        String[] info;
        try {
            FileReader reader = new FileReader("Archivo.txt");
            BufferedReader buffer = new BufferedReader(reader);
            String datos;
            while ((datos = buffer.readLine()) != null) // Ciclo que imprime cada una de las lineas, que se almacenan en la variable datos.
            {
                if (!datos.isEmpty()) {
                    info = datos.split(",");
                    if (info[3].equals(Integer.toString(cuenta))) {
                        bandera = true;
                    }
                }
            }
            reader.close();//se cierra el reader.
        } catch (IOException e) {
            e.printStackTrace();//se imprime la pila de llamadas para ver dónde está el error.
            bandera = false;

        }

        return bandera;
    }

    public boolean validarIdentificacion(String cedula) {
        boolean bandera = false;
        bandera = logica.validarID(cedula);
        return bandera;
    }

    public boolean validarIdentificacion2(String cedula) {
        boolean bandera = false;
        bandera = logica.validarID(cedula);
        return bandera;
    }

    public boolean validarMontoRetirar(double montoRetirar, int numeroCuenta) {
        boolean bandera = false;
        try {
            FileReader reader = new FileReader("Archivo.txt");
            BufferedReader buffer = new BufferedReader(reader);
            String datos;
            while ((datos = buffer.readLine()) != null) // Ciclo que imprime cada una de las lineas, que se almacenan en la variable datos.
            {
                String[] info = datos.split(",");
                if (info[3].equals(Integer.toString(numeroCuenta))) {
                    bandera = logica.validarMontoR(montoRetirar, Double.parseDouble(info[2]));
                }
            }
            reader.close();//se cierra el reader.
        } catch (IOException e) {
            e.printStackTrace();//se imprime la pila de llamadas para ver dónde está el error.
        }
        return bandera;
    }


    public boolean validarCuentaCorriente(int numCuentaCorriente) {
        boolean bandera = false;


        try {
            FileReader reader = new FileReader("Archivo.txt");
            BufferedReader buffer = new BufferedReader(reader);
            String datos;
            while ((datos = buffer.readLine()) != null) // Ciclo que imprime cada una de las lineas, que se almacenan en la variable datos.
            {
                if (!datos.isEmpty()) {
                    String[] info = datos.split(",");
                    if (info[3].equals(Integer.toString(numCuentaCorriente))) {
                        if (info[0].equals("Cuenta corriente")) {
                            bandera = true;
                        }
                    }
                }
            }
            reader.close();//se cierra el reader.
        } catch (IOException e) {
            e.printStackTrace();//se imprime la pila de llamadas para ver dónde está el error.
        }

        return bandera;
    }

    public boolean validacionCedulaCuenta(String cedula, int numCuentaCorriente) {
        boolean bandera = false;

        bandera = logica.validarCedulaCuenta(cedula, numCuentaCorriente);

        return bandera;
    }

    public boolean validarRepeticionCuentaCorriente(int numCuentaCorriente) {
        boolean bandera = false;

        try {
            FileReader reader = new FileReader("Archivo.txt");
            BufferedReader buffer = new BufferedReader(reader);
            String datos;
            while ((datos = buffer.readLine()) != null) // Ciclo que imprime cada una de las lineas, que se almacenan en la variable datos.
            {
                String[] info = datos.split(",");
                if (info[0].equals("Cuenta de ahorro programado")) {
                    if (info[4].equals(Integer.toString(numCuentaCorriente))) {
                        bandera = true;
                    }
                }
            }
            reader.close();//se cierra el reader.
        } catch (IOException e) {
            e.printStackTrace();//se imprime la pila de llamadas para ver dónde está el error.
        }


        return bandera;
    }

    public String[] listaClientes() {
        int cont = 0;
        int size = 0;
        int i = 0;
        String[] clientes;

        size = logica.getClientes().size();

        clientes = new String[size];
        cont = -1;

        for (Cliente dato : logica.getClientes()) {
            cont++;
            clientes[cont] = dato.toString();
        }

        return clientes;
    }

    public String[] imprimirMovimientos() {
        int cont = 0;
        int size = 0;
        String[] movimientos;
        size = logica.getMovimientos().size();

        movimientos = new String[size];
        cont = -1;

        for (Movimiento dato : logica.getMovimientos()) {
            cont++;
            movimientos[cont] = dato.toString();
        }

        return movimientos;
    }
//    public String listarCuentaCorriente(String datos) {
//        String[]info = datos.split(",");
//
//
//
//        return cCorriente.toString();
//    }


    public String[] imprimirCuentas() {
        int cont = 0;
        String[] infoCuentas = new String[100];
        try {
            FileReader reader = new FileReader("Archivo.txt");
            BufferedReader buffer = new BufferedReader(reader);
            String datos;

            //el bufferedReader extrae cada línea, y verrifica si el resultado es nulo.
            // Si es nulo es que ya llegó al final del texto.
            //De ahi la condición del ciclo while.
            while ((datos = buffer.readLine()) != null) // Ciclo que imprime cada una de las lineas, que se almacenan en la variable datos.
            {
                String[] info = datos.split(",");

                switch (info[0]) {
                    case "Cuenta corriente":

                        CuentaCorriente cCorriente = new CuentaCorriente(info[0], LocalDate.parse(info[1]),
                                Double.parseDouble(info[2]), Integer.parseInt(info[3]));

                        infoCuentas[cont] = cCorriente.toString();
                        cont++;

                        break;
                    case "Cuenta de ahorro":

                        CuentaAhorro cAhorro = new CuentaAhorro(info[0], LocalDate.parse(info[1]), Double.parseDouble(info[2]),
                                Integer.parseInt(info[3]));

                        infoCuentas[cont] = cAhorro.toString();
                        cont++;

                        break;
                    case "Cuenta de ahorro programado":
                        FileReader reader2 = new FileReader("Archivo.txt");
                        BufferedReader buffer2 = new BufferedReader(reader2);
                        String datosCC;
                        CuentaAhorroProgramado cAProgramada = new CuentaAhorroProgramado(info[0], LocalDate.parse(info[1]),
                                Double.parseDouble(info[2]), Integer.parseInt(info[3]));
                        // cAProgramada.setCuenta(info[4]);
                        while ((datosCC = buffer2.readLine()) != null) {
                            String[] infoCC = datosCC.split(",");

                            if (!datosCC.isEmpty()) {
                                if (infoCC[3].equals(info[4])) {
                                    CuentaCorriente tmpCuentaCorriente = new CuentaCorriente(infoCC[0], LocalDate.parse(
                                            infoCC[1]), Double.parseDouble(info[2]), Integer.parseInt(infoCC[3])
                                    );
                                    cAProgramada.setCuenta(tmpCuentaCorriente);
                                }
                            }
                        }
                        reader2.close();
                        infoCuentas[cont] = cAProgramada.toString();
                        cont++;

                        break;
                    default:
                        break;
                }

            }
            reader.close();//se cierra el reader.
        } catch (IOException e) {
            e.printStackTrace();//se imprime la pila de llamadas para ver dónde está el error.
        }
        return infoCuentas;
    }


    public String realizarDeposito(int numCuenta, double monto, String tipoMovimiento, String descripcion, LocalDate fechaHoy) {
        String respuesta = "";

        try {
            FileReader reader = new FileReader("Archivo.txt");
            BufferedReader buffer = new BufferedReader(reader);
            String datos;
            String infoCuenta;
            int cont = 0;
            double montoNuevo = 0;
            String[] infoCuentas;
            infoCuentas = new String[10];

            //el bufferedReader extrae cada línea, y verrifica si el resultado es nulo. Si es nulo es que ya llegó al final del texto.
            //De ahi la condición del ciclo while.
            while ((datos = buffer.readLine()) != null) { // Ciclo que imprime cada una de las lineas, que se almacenan en la variable datos.
                if (!datos.isEmpty()) {
                    String[] info = datos.split(",");
                    if (info[3].equals(Integer.toString(numCuenta))) {

                        switch (info[0]) {
                            case "Cuenta corriente":
                                CuentaCorriente cCorriente = new CuentaCorriente(info[0], LocalDate.parse(info[1]),
                                        Double.parseDouble(info[2]), Integer.parseInt(info[3]));

                                montoNuevo = cCorriente.depositar(monto);

                                break;
                            case "Cuenta de ahorro":

                                CuentaAhorro cAhorro = new CuentaAhorro(info[0], LocalDate.parse(info[1]), Double.parseDouble(info[2]),
                                        Integer.parseInt(info[3]));

                                montoNuevo = cAhorro.depositar(monto);

                                break;
                            default:
                                System.out.println("Error");
                                break;
                        }
                        infoCuenta = info[0] + "," + info[1] + "," + montoNuevo + "," + info[3];
                    } else {
                        infoCuenta = datos;
                    }
                    infoCuentas[cont] = infoCuenta;
                    cont++;
                }

            }
            reader.close();//se cierra el reader.
            FileOutputStream stream = new FileOutputStream("Archivo.txt");
            OutputStreamWriter output = new OutputStreamWriter(stream,
                    "UTF-8");//se crea la variable usando en encoding UTF-8, para español.
            BufferedWriter buffer2 = new BufferedWriter(output);
            buffer2.write("");
            buffer2.newLine();
            buffer2.close();//se cierra el Buffered.


            FileWriter writer = new FileWriter("Archivo.txt", true);

            BufferedWriter buffer3 = new BufferedWriter(writer);

            for (int j = 0; j < infoCuentas.length; j++) {

                if (infoCuentas[j] != null || infoCuentas[j] == "") {
                    buffer3.newLine();
                    buffer3.write(infoCuentas[j]);
                }

            }
            buffer3.close();//se cierra el Buffered.
        } catch (IOException e) {
            e.printStackTrace();//se imprime la pila de llamadas para ver dónde está el error.
        }


        Movimiento tmpMovimiento = new Movimiento(tipoMovimiento, fechaHoy, descripcion, monto);
        logica.registrarMovimiento(tmpMovimiento);
        return respuesta;
    }

    public String consultarSaldo(int numCuenta) {
        String respuesta = "";
        String[] info;

        try {
            FileReader reader = new FileReader("Archivo.txt");
            BufferedReader buffer = new BufferedReader(reader);
            String datos;
            while ((datos = buffer.readLine()) != null) // Ciclo que imprime cada una de las lineas, que se almacenan en la variable datos.
            {
                if (!datos.isEmpty()) {
                    info = datos.split(",");
                    if (info[3].equals(Integer.toString(numCuenta))) {
                        respuesta = "El saldo de su cuenta es de: ₡" + info[2];
                    }
                }
            }
            reader.close();//se cierra el reader.
        } catch (IOException e) {
            e.printStackTrace();//se imprime la pila de llamadas para ver dónde está el error.
        }

        return respuesta;
    }

    public String retirar(int numeroCuenta, double montoRetirar, String tipoMovimiento, String descripcion,
                          LocalDate fechaHoy) throws IOException {
        String respuesta = "";
        String[] info;

        try {
            FileReader reader = new FileReader("Archivo.txt");
            BufferedReader buffer = new BufferedReader(reader);
            String datos2;
            String infoCuenta;
            int cont = 0;
            double montoNuevo = 0;
            String[] infoCuentas;
            infoCuentas = new String[10];

            //el bufferedReader extrae cada línea, y verrifica si el resultado es nulo. Si es nulo es que ya llegó al final del texto.
            //De ahi la condición del ciclo while.
            while ((datos2 = buffer.readLine()) != null) { // Ciclo que imprime cada una de las lineas, que se almacenan en la variable datos.
                if (!datos2.isEmpty()) {
                    String[] info2 = datos2.split(",");
                    if (info2[3].equals(Integer.toString(numeroCuenta))) {

                        switch (info2[0]) {
                            case "Cuenta corriente":
                                CuentaCorriente cCorriente = new CuentaCorriente(info2[0], LocalDate.parse(info2[1]),
                                        Double.parseDouble(info2[2]), Integer.parseInt(info2[3]));



                                montoNuevo = cCorriente.retirar(montoRetirar);

                                break;
                            case "Cuenta de ahorro":

                                CuentaAhorro cAhorro = new CuentaAhorro(info2[20], LocalDate.parse(info2[1]), Double.parseDouble(info2[2]),
                                        Integer.parseInt(info2[3]));
                                cAhorro.tasaInteres

                                montoNuevo = cAhorro.retirar(montoRetirar);

                                break;
                            default:
                                System.out.println("Error");
                                break;
                        }
                        infoCuenta = info2[0] + "," + info2[1] + "," + montoNuevo + "," + info2[2];
                    } else {
                        infoCuenta = datos2;
                    }
                    infoCuentas[cont] = infoCuenta;
                    cont++;
                }

            }
            reader.close();//se cierra el reader.
            FileOutputStream stream = new FileOutputStream("Archivo.txt");
            OutputStreamWriter output = new OutputStreamWriter(stream,
                    "UTF-8");//se crea la variable usando en encoding UTF-8, para español.
            BufferedWriter buffer2 = new BufferedWriter(output);
            buffer2.write("");
            buffer2.newLine();
            buffer2.close();//se cierra el Buffered.


            FileWriter writer = new FileWriter("Archivo.txt", true);

            BufferedWriter buffer3 = new BufferedWriter(writer);

            for (int j = 0; j < infoCuentas.length; j++) {

                if (infoCuentas[j] != null || infoCuentas[j] == "") {
                    buffer3.newLine();
                    buffer3.write(infoCuentas[j]);
                }

            }
            buffer3.close();//se cierra el Buffered.
        } catch (IOException e) {
            e.printStackTrace();//se imprime la pila de llamadas para ver dónde está el error.
        }


        /*
        Se crea un objeto movimiento y se registra
         */
        Movimiento tmpMovimiento = new Movimiento(tipoMovimiento, fechaHoy, descripcion, montoRetirar);
        logica.registrarMovimiento(tmpMovimiento);
        return respuesta;
    }

    public String realizarRetiroCAP(int numCuenta, double monto, String tipoMovimiento, String descripcion, LocalDate fechaHoy) {
        String respuesta = "";
        boolean respuesta2;
        String tipoMovimiento2 = "Retirar";
        double montoNuevo = 0;
        ArrayList<String> infoCuentas = new ArrayList<>();
        LocalDate fechaActual = LocalDate.now();


        try {
            FileReader reader = new FileReader("Archivo.txt");
            BufferedReader buffer = new BufferedReader(reader);
            String datos;
            int cont = 0;


            //el bufferedReader extrae cada línea, y verrifica si el resultado es nulo. Si es nulo es que ya llegó al final del texto.
            //De ahi la condición del ciclo while.
            while ((datos = buffer.readLine()) != null) { // Ciclo que imprime cada una de las lineas, que se almacenan en la variable datos.
                String[] info = datos.split(",");

                if (info[0].equals("Cuenta de ahorro programado")) {

                    respuesta2 = logica.comprobarTiempoFecha(LocalDate.parse(info[1]));

                    CuentaAhorroProgramado tmpCAProgramada = new CuentaAhorroProgramado(info[0], LocalDate.parse(info[1]),
                            Double.parseDouble(info[2]), Integer.parseInt(info[3]));


//
                    if (respuesta2) {
                        montoNuevo = tmpCAProgramada.retirar(monto);
                        infoCuentas.add(info[0] + "'" + info[1] + "," + montoNuevo + "," + info[3] + "," +
                                info[4]);

                        respuesta = "El retiro de dinero de esta cuenta, se realizó de manera exitosa";
                        Movimiento tmpMovimiento = new Movimiento(tipoMovimiento2, fechaHoy, descripcion, monto);
                        logica.registrarMovimiento(tmpMovimiento);

                    } else {
                        respuesta = "EL retiro de dinero de una cuenta de ahorro programada sólo se puede realizar después de que haya pasado un año de " +
                                "haber sido creada. \n" +
                                "Inténtelo nuevamente cuando ésta cuenta cumpla un año de su fecha de apertura.";
                    }
                } else {
                    infoCuentas.add(datos);
                }

            }
            reader.close();//se cierra el reader.

            FileOutputStream stream = new FileOutputStream("Archivo.txt");
            OutputStreamWriter output = new OutputStreamWriter(stream,
                    "UTF-8");//se crea la variable usando en encoding UTF-8, para español.
            BufferedWriter buffer2 = new BufferedWriter(output);
            buffer2.write("");
            buffer2.newLine();
            buffer2.close();//se cierra el Buffered.
            /*
            Se llama el archivo para escribir en el
             */
            FileWriter writer = new FileWriter("Archivo.txt", true);
            BufferedWriter buffer3 = new BufferedWriter(writer);

            for (String dato : infoCuentas) {
                buffer3.write(dato);
                buffer3.newLine();
            }
            buffer3.close();

        } catch (IOException e) {
            e.printStackTrace();//se imprime la pila de llamadas para ver dónde está el error.
        }


        return respuesta;
    }


    public boolean validarMontoRetirar2(double montoRetirar, int numeroCuenta) {
        boolean bandera = false;
        bandera = logica.validarMontoR(montoRetirar, numeroCuenta);
        return bandera;
    }

    public boolean validarDepositoCAP(double montoDepositar, int numeroCuenta) {
        boolean bandera = false;
        bandera = logica.validarMontoDepositoCAP(montoDepositar, numeroCuenta);
        return bandera;
    }

    /*
    Validar la cantidad de números para el número de cuenta
    @Mariela Bonilla
    29/03/2019*/


    public boolean validarCantidadNumCuenta(int numCuenta) {
        boolean numCorrecto = false;

        numCorrecto = logica.validarCantNumeroCuenta(numCuenta);

        return numCorrecto;
    }

    /*Valida que el número ingresado es numérico
     @Mariela Bonilla
    29/03/2019*/

    public boolean validarNumero(String ppnumero) {
        return logica.validarNumeros(ppnumero);
    }

    /*Valida que el número ingresado es numérico
    *  @Mariela Bonilla
    29/03/2019*/
    public boolean validarNumeroDouble(String psaldo) {
        return logica.validarNumerosDecimales(psaldo);
    }

    public boolean validarCantidadNumCedula(String cedula) {
        return logica.validarCantidadNumeroCedula(cedula);
    }

    public void realizarDepositoCAP() {
        String tipoMovimiento1 = "Depositar";
        String descripcion1 = "Depósito mensual de la cuenta de ahorro programado";
        String tipoMovimiento2 = "Retirar";
        String descripcion2 = "Aporte mensual para la cuenta de ahorro programado";
        double monto = 10000;
        String respuesta = "";


        /*
        Realiza el deposito automatico de las cuentas programadas
         */

        try {
            FileReader reader = new FileReader("Archivo.txt");
            BufferedReader buffer = new BufferedReader(reader);
            String datos;
            int cont = 0;

            double montoNuevo = 0;
            ArrayList<String> infoCuentas = new ArrayList<>();
            LocalDate fechaHoy = LocalDate.now();

            //el bufferedReader extrae cada línea, y verrifica si el resultado es nulo. Si es nulo es que ya llegó al final del texto.
            //De ahi la condición del ciclo while.
            while ((datos = buffer.readLine()) != null) { // Ciclo que imprime cada una de las lineas, que se almacenan en la variable datos.

                if (!datos.isEmpty()) {
                    String[] info = datos.split(",");

                    if (info[0].equals("Cuenta de ahorro programado")) {

                        FileReader reader2 = new FileReader("Archivo.txt");
                        BufferedReader buffer2 = new BufferedReader(reader2);
                        String datosCC;
                        CuentaAhorroProgramado tmpCAProgramada = new CuentaAhorroProgramado(info[0], LocalDate.parse(info[1]),
                                Double.parseDouble(info[2]), Integer.parseInt(info[3]));
                        // cAProgramada.setCuenta(info[4]);
                        while ((datosCC = buffer2.readLine()) != null) {
                            String[] infoCC = datosCC.split(",");
                            if (!datosCC.isEmpty()) {
                                if (infoCC[0].equals("Cuenta corriente")) {
                                    if (infoCC[3].equals(info[4])) {
                                        CuentaCorriente tmpCuentaCorriente = new CuentaCorriente(infoCC[0], LocalDate.parse(
                                                infoCC[1]), Double.parseDouble(info[2]), Integer.parseInt(infoCC[3])
                                        );


                                        if (LocalDate.parse(info[1]).getDayOfMonth() == fechaHoy.getDayOfMonth()) {
                                            montoNuevo = tmpCuentaCorriente.retirar(monto);

                                            infoCuentas.add(infoCC[0] + "," + infoCC[1] + ","
                                                    + montoNuevo + "," +
                                                    infoCC[3]);


                                            montoNuevo = tmpCAProgramada.depositar(monto);

                                            infoCuentas.add(info[0] + "," + info[1] + "," + montoNuevo + "," + info[3]
                                                    + "," + info[4]);
                /*
                Se crean los objetos de movimiento
                 */
                                            Movimiento tmpMovimiento1 = new Movimiento(tipoMovimiento1, fechaHoy, descripcion1, monto);
                                            Movimiento tmpMovimiento2 = new Movimiento(tipoMovimiento2, fechaHoy, descripcion2, monto);
                                            logica.registrarMovimiento(tmpMovimiento1);
                                            logica.registrarMovimiento(tmpMovimiento2);

                                        } else {
                                            infoCuentas.add(datos);
                                        }


                                    }
                                }
                            }


                        }


                        reader2.close();
                    } else {
                        infoCuentas.add(datos);
                    }
                }

            }
            reader.close();//se cierra el reader.

            FileOutputStream stream = new FileOutputStream("Archivo.txt");
            OutputStreamWriter output = new OutputStreamWriter(stream,
                    "UTF-8");//se crea la variable usando en encoding UTF-8, para español.
            BufferedWriter buffer2 = new BufferedWriter(output);
            buffer2.write("");
            buffer2.newLine();
            buffer2.close();//se cierra el Buffered.
            /*
            Se llama el archivo para escribir en el
             */
            FileWriter writer = new FileWriter("Archivo.txt", true);
            BufferedWriter buffer3 = new BufferedWriter(writer);

            for (String dato : infoCuentas) {
                buffer3.write(dato);
                buffer3.newLine();
            }
            buffer3.close();

        } catch (IOException e) {
            e.printStackTrace();//se imprime la pila de llamadas para ver dónde está el error.
        }


    }

    public String obtenerTipoCuenta(int tmpNumCuenta) {
        String tipo = "";
        String[] info;
        try {
            FileReader reader = new FileReader("Archivo.txt");
            BufferedReader buffer = new BufferedReader(reader);
            String datos;
            while ((datos = buffer.readLine()) != null) // Ciclo que imprime cada una de las lineas, que se almacenan en la variable datos.
            {
                if (!datos.isEmpty()) {
                    info = datos.split(",");
                    if (info[3].equals(Integer.toString(tmpNumCuenta))) {
                        tipo = info[0];
                    }
                }
            }
            reader.close();//se cierra el reader.
        } catch (IOException e) {
            e.printStackTrace();//se imprime la pila de llamadas para ver dónde está el error.
        }
        return tipo;
    }


    public void nuevaTasaInteres(double tasa) {

        String respuesta = "";


        /*
        Realiza el deposito automatico de las cuentas programadas
         */

        try {
            FileReader reader = new FileReader("Archivo.txt");
            BufferedReader buffer = new BufferedReader(reader);
            String datos;
            int cont = 0;

            double montoNuevo = 0;
            ArrayList<String> infoCuentas = new ArrayList<>();
            LocalDate fechaHoy = LocalDate.now();

            while ((datos = buffer.readLine()) != null) { // Ciclo que imprime cada una de las lineas, que se almacenan en la variable datos.
                String[] info = datos.split(",");
                if (info[0].equals("Cuenta de ahorro")) {
                    infoCuentas.add(info[0]+ "," +info[1]+ ","+ info[2] + "," + info[3] +  "," + tasa);
                } else {
                    infoCuentas.add(datos);
                }

            }
            reader.close();//se cierra el reader.

            FileOutputStream stream = new FileOutputStream("Archivo.txt");
            OutputStreamWriter output = new OutputStreamWriter(stream,
                    "UTF-8");//se crea la variable usando en encoding UTF-8, para español.
            BufferedWriter buffer2 = new BufferedWriter(output);
            buffer2.write("");
            buffer2.newLine();
            buffer2.close();//se cierra el Buffered.
            /*
            Se llama el archivo para escribir en el
             */
            FileWriter writer = new FileWriter("Archivo.txt", true);
            BufferedWriter buffer3 = new BufferedWriter(writer);

            for (String dato : infoCuentas) {
                buffer3.write(dato);
                buffer3.newLine();
            }
            buffer3.close();

        } catch (IOException e) {
            e.printStackTrace();//se imprime la pila de llamadas para ver dónde está el error.
        }
    }

    public boolean validarTasaInteres(double tasa) {
        boolean bandera;

        bandera = logica.validarTasa(tasa);

        return bandera;
    }




    public boolean validarSaldoCuentaCorriente(double montoRetirar,int numeroCuenta){

        String[] info;
        boolean bandera = false;
        try {
            FileReader reader = new FileReader("Archivo.txt");
            BufferedReader buffer = new BufferedReader(reader);
            String datos;
            while ((datos = buffer.readLine()) != null) // Ciclo que imprime cada una de las lineas, que se almacenan en la variable datos.
            {
                if (!datos.isEmpty()) {
                    info = datos.split(",");
                    if (info[3].equals(Integer.toString(numeroCuenta))) {
                        if (Double.parseDouble(info[2])>100000){
                            bandera = true;

                        }
                    }
                }
            }
            reader.close();//se cierra el reader.
        } catch (IOException e) {
            e.printStackTrace();//se imprime la pila de llamadas para ver dónde está el error.
        }
        return bandera;

    }
    public boolean validarRetiroCC(double monto,int cuenta){

        String[] info;
        boolean bandera = false;
        try {
            FileReader reader = new FileReader("Archivo.txt");
            BufferedReader buffer = new BufferedReader(reader);
            String datos;
            while ((datos = buffer.readLine()) != null) // Ciclo que imprime cada una de las lineas, que se almacenan en la variable datos.
            {
                if (!datos.isEmpty()) {
                    info = datos.split(",");
                    if (info[3].equals(Integer.toString(cuenta))) {
                        if (info[0].equals("Cuenta corriente")){
                            if (Double.parseDouble(info[2])>100000){

                                double porcentaje=Double.parseDouble(info[2])*50/100;
                                double total=Double.parseDouble(info[2])-porcentaje;

                                if (monto>total){
                                    bandera=false;
                                }

                            }

                        }
                    }
                }
            }
            reader.close();//se cierra el reader.
        } catch (IOException e) {
            e.printStackTrace();//se imprime la pila de llamadas para ver dónde está el error.
        }
        return bandera;
    }

    public boolean validarNombre(String nombre) {
        boolean validado = false;

        validado = logica.validaNombreCliente(nombre);

        return validado;
    }


    /*
    Validar que el monto inicial sea mayor a 50 mil
     */

    public boolean validarMonto(double monto) {
        return logica.validarMonto(monto);
    }

}








