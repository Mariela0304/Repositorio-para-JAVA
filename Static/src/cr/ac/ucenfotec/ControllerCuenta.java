package cr.ac.ucenfotec;

public class ControllerCuenta extends Controller{

    public ControllerCuenta() {
        super();
    }

    public void registrarCuenta(int numCuenta, double monto) {
        Cuenta tmpCuenta = new Cuenta(numCuenta, monto);
        logica.registrarCuenta(tmpCuenta, Integer.toString(numCuenta));

    }

    public  void inicializarTasa(double tasa) {
        Cuenta.tasa = tasa;
    }

    public String[] listarCuentas() {
        int cont = 0;
        int size = 0;
        int i = 0;
        String[] cuentas;
        size = logica.getCuentas().size();

        cuentas = new String[size];
        cont = -1;

        for ( Cuenta dato : logica.getCuentas().values()) {
            cont++;
            cuentas[cont] = dato.toString();
        }

        return cuentas;
    }

}
