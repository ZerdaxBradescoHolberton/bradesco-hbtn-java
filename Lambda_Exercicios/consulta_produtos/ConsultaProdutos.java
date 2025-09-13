import java.util.ArrayList;
import java.util.List;

public class ConsultaProdutos {

    public static List<Produto> filtrar(List<Produto> produtos, CriterioFiltro criterioFiltro) {
        List<Produto> filtrados = new ArrayList<>();
        produtos.forEach(produto -> {
            if(criterioFiltro.testar(produto)) filtrados.add(produto);
        });
        return filtrados;
    }

}