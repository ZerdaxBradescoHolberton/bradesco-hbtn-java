import exceptions.OperacaoInvalidaException;

public class ContaBancariaTarifada extends ContaBancariaBasica {
    private int quantidadeTransacoes;

    public ContaBancariaTarifada(String numeracao, double taxaJurosAnual) {
        super(numeracao, taxaJurosAnual);
        this.quantidadeTransacoes = 0;
    }

    public int getQuantidadeTransacoes() {
        return quantidadeTransacoes;
    }

    @Override
    public void depositar(double valor) throws OperacaoInvalidaException {
        super.depositar(valor);
        saldo -= 0.1;
        quantidadeTransacoes++;
    }

    @Override
    public void sacar(double valor) throws OperacaoInvalidaException {
        super.sacar(valor);
        saldo -= 0.1;
        quantidadeTransacoes++;
    }
}