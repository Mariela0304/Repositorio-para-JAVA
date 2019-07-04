package bonilla.mariela.dl;

import bonilla.mariela.bl.*;

import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;


public class CL {
    private ArrayList<Cliente> clientes;
    private ArrayList<Cuenta> cuentas;
    private ArrayList<Movimiento> movimientos;

    public CL() {
        clientes = new ArrayList<>();
        cuentas = new ArrayList<>();
        movimientos = new ArrayList<>();
    }

    public void newClient(Cliente obj){
        clientes.add(obj);
    }

    /*
    registro de cuenta de ahorro
    @Lenner Hurtado
     */
    public void newCuentaAhorro( CuentaAhorro obj){
        cuentas.add(obj);
    }
    /*
    registro de cuenta de ahorro programado
    @Mariela Bonilla
     */
    public void newCuentaAhorroProgramado(CuentaAhorroProgramado tmpCuentaAProgramado){
        cuentas.add(tmpCuentaAProgramado);
    }

    /*
 Registro de cuenta de ahorro programado
 @Elizabeth Sequeira
  */
    public void newCuentaCorriente(CuentaCorriente tmpCuentaCorriente){
        cuentas.add(tmpCuentaCorriente);
    }


    /*
    Registrar nuevo movimiento
     */

    public void registrarMovimiento(Movimiento tmpMovimiento){
        movimientos.add(tmpMovimiento);
    }

    public ArrayList<Cliente> getClientes(){
        return clientes;
    }
    public ArrayList<Cuenta> getCuentas(){
        return cuentas;
    }

    public ArrayList<Movimiento> getMovimientos() {
        return movimientos;
    }

    /*
    realiza las busqueda de los cliente para obtener el dato de ese cliente
    ...hay que modificarlo
     */


    public Cliente buscarCliente(String cedula){
        boolean bandera = false;
        Cliente encontrado = new Cliente();
        String cedula2;

        for (Cliente dato: clientes) {
            cedula2 = dato.getCedula();
            if (cedula.equals(cedula2)){
                encontrado = dato;
            }

        }
        return encontrado;
    }

    public CuentaCorriente buscarCuentaCorriente(int numCuentaCorriente) {
        CuentaCorriente cuenta = new CuentaCorriente();

        for (Cuenta dato: cuentas) {
            if (dato.getTipoCuenta().equals("Cuenta corriente")) {
                if (dato.getNumero() == numCuentaCorriente) {
                    cuenta = (CuentaCorriente) dato;
                }
            }
        }
        return cuenta;
    }


    public CuentaAhorroProgramado buscarCuentaAhorroProgramado(int numCuentaAP) {
        CuentaAhorroProgramado cuenta = new CuentaAhorroProgramado();

        for (Cuenta dato: cuentas) {
            if (dato.getTipoCuenta().equals("Cuenta de ahorro programado")) {
                if (dato.getNumero() == numCuentaAP) {
                    cuenta = (CuentaAhorroProgramado) dato;
                }
            }
        }
        return cuenta;
    }


    public String hacerDeposito(int numCuenta, double monto) {
        String respuesta = "";
        for (Cuenta dato : cuentas) {
            if (dato.getNumero() == numCuenta){
                if (dato.getTipoCuenta().equals("Cuenta de ahorro programado")) {
                    respuesta = "Este número de cuenta pertenece a una cuenta de ahorro programado";
                } else {
                    dato.depositar(monto);
                    respuesta = "Su depósito se realizó con éxito";
                }
            }
        }
        return respuesta;
    }


    public String depositaCAP(int numCuenta) {
        String respuesta = "";
        double monto = 10000;
        for (Cuenta dato : cuentas) {
            if (dato.getNumero() == numCuenta){
                if (dato.getTipoCuenta().equals("Cuenta de ahorro programado")) {
                    dato.depositar(monto);
                    respuesta = "Su depósito se realizó con éxito";

                } else {
                    respuesta = "Esta cuenta no es una cuenta de ahorro programado";
                }
            }
        }
        return respuesta;
    }

    public boolean validarID(String cedula){
        boolean bandera = false;
        String cedula2;

        for (Cliente dato: clientes) {
            cedula2 = dato.getCedula();
            if (cedula.equals(cedula2)){
                bandera = true;
            }
        }
        return bandera;
    }


    public boolean validarDoplicacionCuenta(int cuenta){
        boolean bandera = false;
        int cuenta2;

        for (Cuenta dato: cuentas) {
            cuenta2 = dato.getNumero();
            if (cuenta == cuenta2){
                bandera = true;
            }
        }
        return bandera;
    }


    public boolean validarMontoR(double montoRetirar, double montoTarjeta){
        boolean bandera = false;
        int numeroCuenta2 = 0;
        if (montoRetirar > montoTarjeta ){
            bandera = true;
        }
        return bandera;
    }

    public boolean validarMontoDepositoCAP(double montoDeposito, int numeroCuenta){
        boolean bandera = false;

        for (Cuenta dato: cuentas) {
            if (numeroCuenta == dato.getNumero()){
                if (montoDeposito < dato.getSaldo() ){
                    bandera = true;
                }
            }
        }
        return bandera;
    }

    public boolean validarCuentaCorriente(int numCuentaCorriente){
        boolean bandera = false;

        for (Cuenta dato: cuentas) {
            if (dato.getTipoCuenta().equals("Cuenta corriente")) {
                if (dato.getNumero() == numCuentaCorriente){
                    bandera = true;
                }
            }
        }
        return bandera;
    }

    public boolean validarCedulaCuenta(String cedula, int numCuentaCorriente){
        boolean bandera = false;
        int numeroCuenta;

        /*
        Nuevo método para validar que la cédula ingresada para crear la cuenta de ahorro programada sea
        la misma que tiene la cuenta corriente que se le asociará
         */
        for (Cliente dato: clientes) {
            if (dato.getCedula().equals(cedula)) {
                for (Cuenta cuenta: dato.getCuentas()) {
                    if (cuenta.getTipoCuenta().equals("Cuenta corriente")) {
                        if (cuenta.getNumero() == numCuentaCorriente) {
                            bandera = true;
                        }

                    }
                }
            }
        }
        return bandera;
    }

    public boolean validarDuplicacionCuentaCorriente(int numCuentaCorriente){
        boolean bandera = false;

        for (Cuenta dato: cuentas) {
            if (dato.getTipoCuenta().equals("Cuenta de ahorro programado")) {


                if (((CuentaAhorroProgramado) dato).getCuenta().getNumero()== numCuentaCorriente){
                    bandera = true;

                }
            }
        }
        return bandera;
    }

    public String consultarSaldo(int numCuenta) {
        String respuesta = "El número de cuenta ingresado no pertenece a ningúna de las cuentas registradas";
        for (Cuenta dato: cuentas) {
                if (dato.getNumero() == numCuenta){
                    respuesta = "El saldo de su cuenta es de: " +dato.getSaldo();
                }
        }
        return respuesta;
    }

    public String retirarSaldo(int numeroCuenta, double montoRetirar){
        int numeroCuenta2 = 0;
        String respuesta = "Hubo un error";

        for (Cuenta dato: cuentas) {
            numeroCuenta2 = dato.getNumero();
            if (numeroCuenta == numeroCuenta2){
                dato.retirar(montoRetirar);
                respuesta = "El retiro de su cuenta se realizó correctamente";
            }
        }
        return respuesta;
    }

    public boolean validarCantNumeroCuenta(int numCuenta) {
        boolean numCorrecto = false;
        if(Integer.toString(numCuenta).length()==7) {
          numCorrecto = true;
        }
        return numCorrecto;
    }

    /*
    *@Mariela Bonilla
    *29/03/2019
     */

    public boolean validarNumeros(String pnumero) {
        try {
            Integer.parseInt(pnumero); /*Va a validar que el dato "pnumero" sólo contenga números,
                                        si esto es cierto, dice que va a devolver un "true", diciendo
                                        que es un valor numérico*/
            return true;
        } catch (NumberFormatException nfe){  /*Aquí dice que si se encuentra al menos un valor NO numérico
                                                va a devolver un estado de "falso"*/
            return false;
        }
    }

    /*
     *@Mariela Bonilla
     *29/03/2019
     */

    public boolean validarNumerosDecimales(String psaldo) {
        try {
            Double.parseDouble(psaldo); /*Va a validar que el dato "psaldo" sólo sea de tipo double,
                                        si esto es cierto, dice que va a devolver un "true", diciendo
                                        que es un valor numérico*/
            return true;
        } catch (NumberFormatException nfe){  /*Aquí dice que si se encuentra al menos un valor NO numérico
                                                va a devolver un estado de "falso"*/
            return false;
        }
    }

    /*
    *Se validará que la cantidad de dígitos de la cédula ingresada esté entre 9 y 13
     *@Mariela Bonilla
     *29/03/2019
     */
    public boolean validarCantidadNumeroCedula(String pcedula) {
        boolean cedulaCorrecta = false;
        if (pcedula.length() >= 9 && pcedula.length() <=13 ) {
            cedulaCorrecta = true;
        }
        return cedulaCorrecta;
    }


    /*
     *Se validará que haya pasado un año desde la fecha de apertura de la cuenta de ahorro programado
     *@Mariela Bonilla
     *29/03/2019
     * Se sigue realizando... la validacion no esta completa
     */

    public boolean comprobarTiempoFecha(LocalDate fechaApertura) {
        boolean annoCumplido = false;
        LocalDate fechaHoy = LocalDate.now();

        int dia = fechaApertura.getDayOfMonth();
        int mes = fechaApertura.getDayOfMonth();
        int anno = fechaApertura.getDayOfMonth();


        if (dia==fechaHoy.getDayOfMonth() &&  mes == fechaHoy.getMonthValue() && anno < fechaHoy.getYear()) {
            annoCumplido = true;
        }

        return annoCumplido;
    }

    /*
     *Va a validar que el nombre que ingrese sólo permita los siguiente carácteres, que comience con una mayúsculas y que las demás
     * sean minúsculas, permite espacios y demás
     *@Mariela Bonilla
     *29/03/2019
     */

    public boolean validaNombreCliente(String pnombre) {
        return pnombre.matches("^([a-zAZ]+?)$");
    }

    public boolean validarTasa(double tasa){
        boolean bandera = false;
        if(tasa > 100 || tasa == 0){
            bandera = true;
        }
        return bandera;
    }


////////////////////////////////////////////////////////////////////////////

    public boolean validarSaldoCC(double montoRetirar, int numeroCuenta){
        boolean bandera=false;

        for (Cuenta dato: cuentas) {
            if (numeroCuenta == dato.getNumero()){
                if (dato.getTipoCuenta().equals("Cuenta corriente") ){
                    if (dato.getSaldo()>100000){
                        bandera = true;

                    }
                }
            }
        }
        return bandera;
    }

    public boolean validarRetiroCuentaCorriente(double montoRetirar,int cuenta){

        boolean bandera=false;


        for (Cuenta dato: cuentas) {
            if (cuenta == dato.getNumero()){
                if (dato.getTipoCuenta().equals("Cuenta corriente") ){
                    if (dato.getSaldo()>100000){

                        double porcentaje=dato.getSaldo()*50/100;
                        double total=dato.getSaldo()-porcentaje;

                        if (montoRetirar>total){
                            bandera=false;
                        }

                    }
                }
            }
        }
        return bandera;
    }


    public boolean validarMonto(double monto) {
        boolean correcto = false;

        if (monto> 50000) {
            correcto=true;
        }
        return correcto;
    }


}

