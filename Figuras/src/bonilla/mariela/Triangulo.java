package bonilla.mariela;

public class Triangulo extends Figura {
    private double base;
    private double altura;

    public Triangulo() {
        super();
    }

    public Triangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }


    public Triangulo(double area, double base, double altura) {
        super(area);
        this.base = base;
        this.altura = altura;
    }



    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }



    public void calcularArea() {
        double area;
        area = base * altura / 2;

        setArea(area);
    }
}

