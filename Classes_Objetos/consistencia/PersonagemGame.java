import static java.util.Objects.nonNull;

public class PersonagemGame {
    private int saudeAtual;
    private String nome;
    private String status;

    public PersonagemGame(int saudeAtual, String nome) {
        setSaudeAtual(saudeAtual);
        setNome(nome);
    }

    public int getSaudeAtual() {
        return saudeAtual;
    }

    public void setSaudeAtual(int saudeAtual) {
        this.saudeAtual = saudeAtual;
        this.status = this.saudeAtual > 0 ? "vivo" : "morto";
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if(nonNull(nome) && !nome.isBlank()) this.nome = nome;
    }

    public String getStatus() {
        return status;
    }

    public void tomarDano(int quantidadeDeDano) {
        setSaudeAtual(Math.max(saudeAtual - quantidadeDeDano, 0));
    }

    public void receberCura(int quantidadeDeCura) {
        setSaudeAtual(saudeAtual = Math.min(saudeAtual + quantidadeDeCura, 100));
    }
}