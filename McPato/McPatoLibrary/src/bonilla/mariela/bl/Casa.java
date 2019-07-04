package bonilla.mariela.bl;

public class Casa extends Propiedad {

    private String nombre;
    private String residencial;
    private int numCasa;


    public Casa(int codigo, String nombre, double valor, String direccion, String residencial, int numCasa, String patio, int habitaciones, String cochera, int vehiculos) {

        super(codigo, valor, direccion, patio, habitaciones, cochera, vehiculos);
        this.nombre = nombre;
        this.residencial = residencial;
        this.numCasa = numCasa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getResidencial() {
        return residencial;
    }

    public void setResidencial(String residencial) {
        this.residencial = residencial;
    }

    public int getNumCasa() {
        return numCasa;
    }

    public void setNumCasa(int numCasa) {
        this.numCasa = numCasa;
    }


    @Override
    public String toString() {
        return "Casa{" +
                "  Nombre: " + nombre +
                ", Residencial: " + residencial +
                ", Número de casa: " + numCasa +
                ", Código: " + codigo +
                ", Valor de alquiler: " + valor +
                ", Dirección: " + direccion +
                ", Patio: " + patio +
                ", Cantidad de habitaciones: " + cantHab +
                ", Cochera: " + cochera +
                ", Cantidad de vehículos: " + cantVehiculos +
                '}';
    }


}
