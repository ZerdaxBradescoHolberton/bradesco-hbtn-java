public class PersonagemGame {
    private int saudeAtual;
    private String nome;

    public int getSaudeAtual() {
        return saudeAtual;
    }

    public void setSaudeAtual(int saudeAtual) {
        this.saudeAtual = saudeAtual;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void tomarDano(int valor) {
        saudeAtual = Math.max(saudeAtual - valor, 0);
    }

    public void receberCura(int valor) {
        saudeAtual = Math.min(saudeAtual + valor, 100);
    }
}