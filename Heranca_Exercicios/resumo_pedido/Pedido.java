import java.util.*;

public class Pedido {
    private double percentualDesconto;
    private ItemPedido[] itens;

    public Pedido(double percentualDesconto, ItemPedido[] itens) {
        this.percentualDesconto = percentualDesconto;
        this.itens = itens;
    }

    public double getPercentualDesconto() {
        return percentualDesconto;
    }

    public void setPercentualDesconto(double percentualDesconto) {
        this.percentualDesconto = percentualDesconto;
    }

    public ItemPedido[] getItens() {
        return itens;
    }

    public void setItens(ItemPedido[] itens) {
        this.itens = itens;
    }

    public double valorTotalProdutos() {
        return Arrays.stream(itens).map(itemPedido -> itemPedido.getQuantidade()
                * itemPedido.getProduto().obterPrecoLiquido()).reduce(0d, Double::sum);
    }
    public double calcularTotal() {
        return valorTotalProdutos() * ((100 - percentualDesconto)/100);
    }

    public void apresentarResumoPedido() {
        System.out.println("------- RESUMO PEDIDO -------");
        Arrays.stream(itens).forEach(itemPedido -> {
            System.out.println(String.format("Tipo: %s  Titulo: %s  Preco: %.2f  Quant.: %d  Total: %.2f",
                    itemPedido.getProduto().getClass().getName(),
                    itemPedido.getProduto().getTitulo(),
                    itemPedido.getProduto().obterPrecoLiquido(),
                    itemPedido.getQuantidade(),
                    itemPedido.getQuantidade() * itemPedido.getProduto().obterPrecoLiquido()));
        });
        System.out.println("----------------------------");
        System.out.println(String.format("DESCONTO: %.2f", valorTotalProdutos() * (percentualDesconto / 100)));
        System.out.println(String.format("TOTAL PRODUTOS: %.2f", valorTotalProdutos()));
        System.out.println("----------------------------");
        System.out.println(String.format("TOTAL PEDIDO: %.2f", calcularTotal()));
        System.out.println("----------------------------");

    }
}