package bonilla.mariela.bl;


public class Laboratorio {
    private String codigo;
    private int capacidad;
    private Curso tmpCurso; //se declara un atributo con el tipo de clase que vamos a referenciar


    public Laboratorio() {

    }

    public Laboratorio(String codigo, int capacidad) {
        this.codigo = codigo;
        this.capacidad = capacidad;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public Curso getTmpCurso() {
        return tmpCurso;
    }

    public void setTmpCurso(Curso tmpCurso) {
        this.tmpCurso = tmpCurso;
    }

    @Override
    public String toString() {
        return "\n============ LABORATORIO: ======================\n" +
                "''                                             ''" +
                "\n'' Código: " + codigo + "                                  ''" +
                "\n'' Capacidad de estudiantes: " + capacidad + "               ''" +
//                tmpCurso.toString() +
                "\n''\n================================================\n\n";
    }
}
