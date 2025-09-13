import java.util.function.Consumer;
import java.util.function.Supplier;

public class Produto {
    private double preco;
    private String nome;
    private double percentualMarkup;
    public Supplier<Double> precoComMarkup = () -> preco * (1 + (percentualMarkup / 100));
    public Consumer<Double> atualizarMarkup = aDouble -> {percentualMarkup = aDouble;};

    public Produto(double preco, String nome) {
        this.preco = preco;
        this.nome = nome;
        this.percentualMarkup = 10;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getPercentualMarkup() {
        return percentualMarkup;
    }

    public void setPercentualMarkup(double percentualMarkup) {
        this.percentualMarkup = percentualMarkup;
    }
}