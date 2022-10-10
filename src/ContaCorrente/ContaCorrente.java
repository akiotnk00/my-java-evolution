package main.java.ContaCorrente;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ContaCorrente {

    private Integer numeroConta;
    private Integer numeroAgencia;
    private String nomeCliente;
    private LocalDate dataNascimento;
    private Double saldoConta;
    private boolean contaCancelada;
    private String justificativa;
    private List<Operacao> operacoes;


    public ContaCorrente() {
        saldoConta = 00.00;
        this.contaCancelada = true;
        this.operacoes = new ArrayList<>();
    }

    public ContaCorrente(Integer numeroConta, Integer numeroAgencia, String nomeCliente, LocalDate dataNascimento, Double saldoConta) {
        this.numeroConta = numeroConta;
        this.numeroAgencia = numeroAgencia;
        this.nomeCliente = nomeCliente;
        this.dataNascimento = dataNascimento;
        this.saldoConta = saldoConta;
        this.contaCancelada = false;
        this.operacoes = new ArrayList<Operacao>();
    }

    public List<Operacao> getOperacoes() {
        return operacoes;
    }

    public Integer getNumeroConta() {
        return numeroConta;
    }

    public Integer getNumeroAgencia() {
        return numeroAgencia;
    }

    public String getJustificativa() {
        return justificativa;
    }

    public boolean isContaCancelada() {
        return contaCancelada;
    }

    public void depositarValor(Double valor) throws Exception {
        validacaoConta();
        if (valor == null || valor <= 0.0) {
            throw new Exception("Não é possível realizar o depósito com valor negativo");
        }
        saldoConta = saldoConta + valor;
        operacoes.add(new Operacao("deposito", valor));
    }

    public void sacarValor(Double valor) throws Exception {
        validacaoConta();
        if (valor == null || valor <= 0.0) {
            throw new Exception("Não é possível realizar o saque com valor negativo");
        }
        if (valor > saldoConta) {
            throw new Exception("Não é possível realizar o saque com saldo insuficiente");
        }
        saldoConta = saldoConta - valor;
        operacoes.add(new Operacao("saque", valor));
    }

    public void transferirValor(Double valor, ContaCorrente contadestino) throws Exception {
        validacaoConta();
        if (contadestino == null) {
            throw new Exception("Não é possível transferir o valor, conta inexistente");
        }
        if (contadestino.contaCancelada){
            throw new Exception("Não é possível transferir o valor, conta destino cancelada");
        }
        sacarValor(valor);
        contadestino.depositarValor(valor);

    }

    public void cancelarConta(String justificativa) throws Exception {
        if (justificativa == null || justificativa.isBlank()) {
            throw new Exception("Justifique o motivo do cancelamento");
        }
        validacaoConta();
        this.justificativa = justificativa;
        contaCancelada = true;
    }

    public void validacaoConta() throws Exception {
        if (contaCancelada) {
            throw new Exception("Não é possível realizar essa operação.Conta cancelada.");
        }
    }

    public Double consultarSaldoAtual() {
        return saldoConta;
    }

    public List<Operacao> consultarExtrato(LocalDate datainicial, LocalDate datafinal) throws Exception {
        validacaoConta();
        if (datainicial == null || datafinal == null){
            throw new Exception("Data inicial ou final é inválida");
        }
        if (datainicial.isAfter(datafinal)){
            throw new Exception("Data inicial é maior que a final");
        }
        return operacoes
                .stream()
                .filter(o -> o.getData().isAfter(datainicial) && o.getData().isBefore(datafinal))
                .toList();


    }
}
