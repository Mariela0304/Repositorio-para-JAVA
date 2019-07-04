package bonilla.mariela.bl;

public class CuentaAhorro extends Cuenta{

    public CuentaAhorro() {
        super();
    }

    public CuentaAhorro(double saldo, int numero) {
        super(saldo, numero);
    }

    @Override
    public String toString() {
        return "CuentaAhorro{" +
                "saldo=" + saldo +
                ", numero=" + numero +
                '}';
    }
}
