import java.util.HashMap;
import java.util.Map;


public class GerenciamentoDeContatos {
    private Map<String, Contato> contatos;


    // Construtor
    public GerenciamentoDeContatos() {
        contatos = new HashMap<>();
    }


    // Adiciona um novo contato
    public void adicionarContato(String nome, String telefone, String email) {
        // IMPLEMENTE ESTE METODO
        Contato contato = new Contato();
        contato.adicionarTelefone(telefone);
        contato.adicionarEmail(email);
        contatos.put(nome, contato);
    }


    // Exibe todos os contatos
    public void exibirContatos() {
        // IMPLEMENTE ESTE METODO
        contatos.keySet().forEach(s -> {
            Contato contato = contatos.get(s);
            System.out.printf("%s - %s - %s%n", s, contato.getEmails(), contato.getTelefones());
        });
    }


    // Busca um contato pelo nome
    public void buscarContato(String nome) {
        // IMPLEMENTE ESTE METODO
        Contato contato = contatos.get(nome);
        System.out.printf("%s - %s - %s%n", nome, contato.getEmails(), contato.getTelefones());
    }


    // Remove um contato pelo nome
    public void removerContato(String nome) {
        // IMPLEMENTE ESTE METODO
        Contato contato = contatos.get(nome);
        try {
            System.out.printf("%s - %s - %s%n", nome, contato.getEmails(), contato.getTelefones());
            contatos.remove(nome);
        } catch (Exception e) {
            System.out.println("Tentando remover contato 'João' que não existe");
        }
    }


    public static void main(String[] args) {
        GerenciamentoDeContatos gestao = new GerenciamentoDeContatos();


        // Adicionando contatos
        gestao.adicionarContato("Carlos", "1234-5678", "carlos@email.com");
        gestao.adicionarContato("Maria", "8765-4321", "maria@email.com");
        gestao.adicionarContato("Ana", "1122-3344", "ana@email.com");
        gestao.adicionarContato("Carlos", "1234-5678", "carlos@email.com"); // Tentando duplicar


        // Exibindo todos os contatos
        System.out.println("\nExibindo todos os contatos:");
        gestao.exibirContatos();


        // Buscando um contato
        System.out.println("\nBuscando contato 'Maria':");
        gestao.buscarContato("Maria");


        // Removendo um contato
        System.out.println("\nRemovendo contato 'Carlos':");
        gestao.removerContato("Carlos");


        // Tentando remover um contato inexistente
        System.out.println("\nTentando remover contato 'João' que não existe:");
        gestao.removerContato("João");


        // Exibindo todos os contatos após remoções
        System.out.println("\nExibindo todos os contatos após remoções:");
        gestao.exibirContatos();
    }
}