public class Quadrado extends Retangulo {

    private double lado;

    public double getLado() {
        return lado;
    }

    public void setLado(double lado) {
        checkValorNegativo(lado, "Lado");
        this.lado = this.largura = this.altura = lado;
    }

    @Override
    public String toString() {
        return String.format("[Quadrado] %.2f", lado);
    }
}