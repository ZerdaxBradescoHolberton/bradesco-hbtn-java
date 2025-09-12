import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private List<PedidoCookie> cookies;

    public Pedido() {
        this.cookies = new ArrayList<>();
    }

    public void adicionarPedidoCookie(PedidoCookie cookie) {
        cookies.add(cookie);
    }

    public int obterTotalCaixas() {
        return cookies.stream().map(PedidoCookie::getQuantidadeCaixas).reduce(0, Integer::sum);
    }

    public int removerSabor(String sabor) {
        int quantidadeRemovidos = 0;
        for(int k = 0; k < cookies.size(); k++) {
            if(cookies.get(k).getSabor().equals(sabor)) {
                quantidadeRemovidos += cookies.get(k).getQuantidadeCaixas();
                cookies.remove(k);
            }
        }
        return quantidadeRemovidos;
    }
}