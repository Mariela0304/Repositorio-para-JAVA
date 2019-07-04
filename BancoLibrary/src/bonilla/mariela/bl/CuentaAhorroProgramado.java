package bonilla.mariela.bl;

public class CuentaAhorroProgramado extends Cuenta{
    CuentaCorriente cuentaCorriente;
    Cliente cliente;

    public CuentaAhorroProgramado() {
    }

    public CuentaAhorroProgramado(double saldo, int numero, CuentaCorriente cuentaCorriente, Cliente cliente) {
        super(saldo, numero);
        this.cuentaCorriente = cuentaCorriente;
        this.cliente = cliente;
    }

    public CuentaCorriente getCuenta() {
        return cuentaCorriente;
    }

    public void setCuenta(CuentaCorriente cuenta) {
        this.cuentaCorriente = cuenta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "CuentaAhorroProgramado{" +
                "saldo=" + saldo +
                ", numero=" + numero +
                ", cuenta=" + cuentaCorriente.toString() +
                ", cliente=" + cliente +
                '}';
    }
}
