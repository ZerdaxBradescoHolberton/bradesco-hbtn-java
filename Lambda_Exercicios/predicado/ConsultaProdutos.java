import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ConsultaProdutos {

    public static List<Produto> filtrar(List<Produto> produtos, Predicate<Produto> produtoPredicate) {
        List<Produto> filtrados = new ArrayList<>();
        produtos.forEach(produto -> {
            if(produtoPredicate.test(produto)) filtrados.add(produto);
        });
        return filtrados;
    }

}