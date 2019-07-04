package bonilla.mariela.bl;

public class CuentaCorriente extends Cuenta{


    public CuentaCorriente() {
    }

    public CuentaCorriente(double saldo, int numero) {
        super(saldo, numero);
    }

    @Override
    public String toString() {
        return "CuentaCorriente{" +
                "saldo=" + saldo +
                ", numero=" + numero +
                '}';
    }
}
