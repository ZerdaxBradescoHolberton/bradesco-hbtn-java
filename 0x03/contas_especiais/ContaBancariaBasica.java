import exceptions.OperacaoInvalidaException;

public class ContaBancariaBasica {
    private String numeracao;
    protected double saldo;
    private double taxaJurosAnual;

    public ContaBancariaBasica(String numeracao, double taxaJurosAnual) {
        this.numeracao = numeracao;
        this.saldo = 0;
        this.taxaJurosAnual = taxaJurosAnual;
    }

    public String getNumeracao() {
        return numeracao;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getTaxaJurosAnual() {
        return taxaJurosAnual;
    }

    public void depositar(double valor) throws OperacaoInvalidaException {
        if(valor <= 0) throw new OperacaoInvalidaException("Valor para deposito deve ser maior que 0");
        saldo += valor;
    }

    public void sacar(double valor) throws OperacaoInvalidaException {
        if(valor <= 0) throw new OperacaoInvalidaException("Valor de saque deve ser maior que 0");
        if(valor > saldo) throw new OperacaoInvalidaException("Valor de saque deve ser menor que o saldo atual");
        saldo -= valor;
    }

    public double calcularTarifaMensal() {
        return Double.min(saldo * 0.1, 10);
    }

    public double calcularJurosMensal() {
        return saldo < 0 ? 0 : ((taxaJurosAnual / 12) / 100) * saldo;
    }

    public void aplicarAtualizacaoMensal() {
        saldo += (calcularJurosMensal() - calcularTarifaMensal());
    }
}