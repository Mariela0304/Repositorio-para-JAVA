package bonilla.mariela;

public abstract class Figura { //DECLARAR CLASE ABSTRACTA
    private double area;

    public Figura() {
    }

    public Figura(double area) {
        this.area = area;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "La medida del área es de " + area;
    }

    public abstract void calcularArea(); //DECLARAR MÉTODO ABSTRACTO
}
