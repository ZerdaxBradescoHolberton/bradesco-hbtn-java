import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

import static java.util.Objects.isNull;


public class SistemaDeGestaoDePedidos {


    // Logger SLF4j
    private static final Logger logger = LoggerFactory.getLogger(SistemaDeGestaoDePedidos.class);


    // Simulação de um banco de dados simples com mapa de pedidos
    private static final Map<Integer, Pedido> pedidos = new HashMap<>();


    public static void main(String[] args) {


        logger.info("Sistema de Gestão de Pedidos iniciado.");


        // Criando pedidos
        criarPedido(1, "Produto A", 100.00);
        criarPedido(2, "Produto B", 50.00);


        // Pagamento de pedidos
        pagarPedido(1, 100.00);
        pagarPedido(2, 60.00); // Pagamento incorreto


        // Cancelando pedidos
        cancelarPedido(1);
        cancelarPedido(3); // Pedido inexistente


        logger.info("Sistema de Gestão de Pedidos finalizado.");
    }


    // Função para criar um pedido
    private static void criarPedido(int id, String nomeProduto, double valor) {
        logger.info("Criando pedido: ID = {} - Produto = {} - Valor = {}", id, nomeProduto, valor);
        pedidos.put(id, new Pedido(id, nomeProduto, valor));
        logger.info("Pedido ID {} criado com sucesso!", id);
    }


    // Função para pagar um pedido
    private static void pagarPedido(int id, double valorPago) {
        logger.info("Processando pagamento do pedido ID {} - Valor pago = {}", id, valorPago);
        Pedido pedido = pedidos.get(id);
        if(valorPago != pedido.getValor()) {
            logger.error("Erro ao pagar: Valor pago {} é diferente do valor do pedido {} para o pedido ID {}.",
                    valorPago, pedido.getValor(), id);
            pedido.setPago(false);
        }
        else {
            logger.info("Pagamento do pedido ID {} realizado com sucesso!", id);
            pedido.setPago(true);
        }
    }


    // Função para cancelar um pedido
    private static void cancelarPedido(int id) {
        logger.info("Processando cancelamento do pedido ID {}", id);
        Pedido pedido = pedidos.get(id);
        if(isNull(pedido)) {
            logger.error("Erro ao cancelar: Pedido ID {} não encontrado.", id);
        }
        else if(pedido.isPago()) {
            logger.error("Não é possível cancelar o pedido ID {} pois já foi pago.", id);
        } else {
            logger.info("Pedido ID {} cancelado com sucesso!", id);
            pedidos.remove(id);
        }
    }
}