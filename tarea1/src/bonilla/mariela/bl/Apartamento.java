package bonilla.mariela.bl;

import java.util.ArrayList;

public class Apartamento extends Propiedad{

    private ArrayList<Apartamento> amenidades = new ArrayList<>();

    public Apartamento () {

    }



    public Apartamento(int codigo, double valor, String direccion, String patio, int habitaciones, ArrayList<Apartamento> amenidades, String cochera, int vehiculos) {

        super(codigo, valor, direccion, patio, habitaciones, cochera, vehiculos);
        this.amenidades = amenidades;
    }

    public ArrayList<Apartamento> getAmenidades() {
        return amenidades;
    }

    public void setAmenidades(ArrayList<Apartamento> amenidades) {
        this.amenidades = amenidades;
    }

    @Override
    public String toString() {
        return "Apartamento{" +
                " Código: " + codigo +
                ", Valor de alquiler: " + valor +
                ", Dirección: " + direccion +
                ", Patio: " + patio +
                ", Cantidad de habitaciones: " + cantHab +
                ", Cochera: " + cochera +
                ", Cantidad de vehículos: " + cantVehiculos +
                ", Amenidades: " + amenidades +
                '}';
    }
}
