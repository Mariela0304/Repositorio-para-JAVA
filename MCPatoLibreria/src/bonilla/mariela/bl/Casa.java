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
        return "\n------------ CASA: -----------------------------\n\n" +
                "\n  Nombre: " + nombre +
                "\n Residencial: " + residencial +
                "\n Número de casa: " + numCasa +
                "\n Código: " + codigo +
                "\n Valor de alquiler: " + valor +
                "\n Dirección: " + direccion +
                "\n Patio: " + patio +
                "\n Cantidad de habitaciones: " + cantHab +
                "\n Cochera: " + cochera +
                "\n Cantidad de vehículos: " + cantVehiculos +
                "\n\n-----------------------------------------------------------\n\n";

    }
}
