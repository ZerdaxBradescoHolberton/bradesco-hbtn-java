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

    public void tomarDano(int quantidadeDeDano) {
        saudeAtual = Math.max(saudeAtual - quantidadeDeDano, 0);
    }

    public void receberCura(int quantidadeDeCura) {
        saudeAtual = Math.min(saudeAtual + quantidadeDeCura, 100);
    }
}