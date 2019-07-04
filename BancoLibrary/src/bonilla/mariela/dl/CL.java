package bonilla.mariela.dl;

import bonilla.mariela.bl.Cliente;
import bonilla.mariela.bl.Cuenta;

import java.util.ArrayList;

public class CL {

    private ArrayList<Cliente> clientes;
    private ArrayList<Cuenta> cuentas;


    public CL() {
        clientes = new ArrayList<>();
        cuentas = new ArrayList<>();
    }

    public void registrarCliente(Cliente tmpCliente) {
        clientes.add(tmpCliente);
    }

    public void registrarCuenta(Cuenta tmpCuenta) {
        cuentas.add(tmpCuenta);
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public ArrayList<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(ArrayList<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }
}
