import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

public class Estoque implements EstoqueIfc {

    private static int id = 0;
    private final String fileName;
    private final HashSet<Produto> produtos;


    public Estoque(String fileName) {
        this.fileName = fileName;
        produtos = new HashSet<>();
        try {
            dataPopulate();
            id = produtos.stream().map(Produto::getId)
                    .collect(Collectors.toCollection(ArrayList::new)).stream()
                    .mapToInt(Integer::valueOf).max().orElse(0);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void adicionarProduto(String nome, int quantidade, double preco) {
        try {
            if(quantidade < 0 || preco < 0)
                throw new IOException("Quantidade e/ou preco nao podem ser menores do que zero.");
            produtos.add(new Produto(++id, nome, quantidade, preco));
            dataPersist();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void excluirProduto(int id) {
        try {
            produtos.stream().filter(produto -> produto.getId() == id)
                    .findFirst()
                    .ifPresent(produtos::remove);
            dataPersist();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void exibirEstoque() {
        produtos.forEach(System.out::println);
    }

    @Override
    public void atualizarQuantidade(int id, int quantidade) {
        try {
            if(quantidade < 0) throw new IOException("Quantidade nao pode ser menor do que zero.");
            produtos.stream().filter(produto -> produto.getId() == id)
                    .findFirst().ifPresent(produto -> produto.setQuantidade(quantidade));
            dataPersist();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void dataPersist() throws Exception {
        File file  = new File(fileName);
        if(Files.exists(file.toPath())) Files.delete(file.toPath());
        try (FileWriter fw = new FileWriter(fileName);
            BufferedWriter bw = new BufferedWriter(fw)) {
            produtos.forEach(produto -> {
                try {
                    bw.write(produto.toCsv());
                    bw.newLine();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }

    private void dataPopulate() throws Exception {
        try (FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr)) {
            br.lines().filter(s -> !s.isBlank()).forEach(s -> {
                try {
                    String[] values = s.split(",", -1);
                    Produto produto = new Produto(Integer.parseInt(values[0]),
                            values[1],
                            Integer.parseInt(values[2]),
                            Double.parseDouble(values[3]));
                    produtos.add(produto);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }
}


interface EstoqueIfc {
    void adicionarProduto(String nome, int quantidade, double preco);
    void excluirProduto(int id);
    void exibirEstoque();
    void atualizarQuantidade(int id, int quantidade);
}