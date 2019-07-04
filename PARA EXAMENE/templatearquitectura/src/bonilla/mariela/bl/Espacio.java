package bonilla.mariela.bl;

public class Espacio {
    private String tipoEspacio;
    private int numEspacio;
    private boolean ocupado;

    public Espacio() {

    }

    public Espacio(String tipoEspacio, int numEspacio, boolean ocupado) {
        this.tipoEspacio = tipoEspacio;
        this.numEspacio = numEspacio;
        this.ocupado = ocupado;
    }

    public String getTipoEspacio() {
        return tipoEspacio;
    }

    public void setTipoEspacio(String tipoEspacio) {
        this.tipoEspacio = tipoEspacio;
    }

    public int getNumEspacio() {
        return numEspacio;
    }

    public void setNumEspacio(int numEspacio) {
        this.numEspacio = numEspacio;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    @Override
    public String toString() {
        return "\n========== ESPACIO: ================================\n" +
                "\n Tipo de espacio:" + tipoEspacio +
                "\n Número de espacio: " + numEspacio +
                "\n Ocupado:" + ocupado +
                "\n===================================================\n\n";
    }


}
