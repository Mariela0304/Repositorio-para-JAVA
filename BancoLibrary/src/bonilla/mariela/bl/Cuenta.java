package bonilla.mariela.bl;

public class Cuenta {
    protected double saldo;
    protected int numero;

    public Cuenta() {
    }

    public Cuenta(double saldo, int numero) {
        this.saldo = saldo;
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Cuenta{" +
                "saldo=" + saldo +
                ", numero=" + numero +
                '}';
    }
}
