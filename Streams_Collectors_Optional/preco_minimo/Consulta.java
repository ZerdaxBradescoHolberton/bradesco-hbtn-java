import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Consulta {

    public static List<Produto> obterLivrosDoPedido(Pedido pedido) {
        return pedido.getProdutos().stream().filter(produto -> produto.getCategoria()
                .equals(CategoriaProduto.LIVRO)).collect(Collectors.toCollection(ArrayList::new));
    }

    public static Produto obterProdutoMaiorPreco(List<Produto> produtos) {
        return produtos.stream().max(Comparator.comparingDouble(Produto::getPreco)).orElse(null);
    }

    public static List<Produto> obterProdutosPorPrecoMinimo(List<Produto> produtos, double precoMinimo) {
        return produtos.stream().filter(produto -> produto.getPreco() >= precoMinimo)
                .collect(Collectors.toCollection(ArrayList::new));
    }

}