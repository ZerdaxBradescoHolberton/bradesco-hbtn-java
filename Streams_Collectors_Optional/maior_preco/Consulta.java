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
//        return produtos.stream().sorted(Comparator.comparing(Produto::getPreco).reversed())
//                .findFirst().orElse(null);
        return produtos.stream().max(Comparator.comparingDouble(Produto::getPreco)).get();
    }

}