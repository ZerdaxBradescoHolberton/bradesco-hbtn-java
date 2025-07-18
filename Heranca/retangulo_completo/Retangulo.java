public class Retangulo extends FormaGeometrica {

    private double largura;
    private double altura;

    public double getLargura() {
        return largura;
    }

    public void setLargura(double largura) {
        checkValorNegativo(largura, "Largura");
        this.largura = largura;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        checkValorNegativo(altura, "Altura");
        this.altura = altura;
    }

    private void checkValorNegativo(double valor, String parametroDimensionado) {
        if (valor < 0) throw new java.lang.IllegalArgumentException(parametroDimensionado
                + " deve ser maior ou igual a 0");
    }

    @Override
    public double area() {
        return largura * altura;
    }

    @Override
    public String toString() {
        return String.format("[Retangulo] %.2f / %.2f", largura, altura);
    }
}