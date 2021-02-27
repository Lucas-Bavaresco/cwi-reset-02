package br.com.banco.desgraca.domain.conta;

import br.com.banco.desgraca.domain.InstituicaoBancaria;
import br.com.banco.desgraca.domain.Transacao;
import br.com.banco.desgraca.exception.SaldoInsuficienteException;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static br.com.banco.desgraca.domain.TipoTransacao.ENTRADA;
import static br.com.banco.desgraca.domain.TipoTransacao.SAIDA;
import static java.text.NumberFormat.getCurrencyInstance;

abstract class BaseContaBancaria implements ContaBancaria {

    private final InstituicaoBancaria instituicaoBancaria;
    private final String numero;
    private final List<Transacao> transacoes;

    private Double saldo;

    BaseContaBancaria(InstituicaoBancaria instituicaoBancaria) {

        validarInstituicaoBancaria(instituicaoBancaria);

        this.instituicaoBancaria = instituicaoBancaria;
        this.numero = gerarNumeroConta();
        this.transacoes = new ArrayList<>();
        this.saldo = 0.0;

        System.out.println(this + " criada com sucesso");
    }

    /**
     * Valida se a instituição bancária possui o tipo de conta que está sendo criado.
     */
    protected abstract void validarInstituicaoBancaria(InstituicaoBancaria instituicaoBancaria);

    /**
     * Gera um novo número de conta.
     */
    protected abstract String gerarNumeroConta();

    @Override
    public Double consultarSaldo() {
        return saldo;
    }

    @Override
    public void depositar(Double valor) {

        System.out.println("Depositando "+ getCurrencyInstance().format(valor) + " na " + this);

        saldo += valor;
        transacoes.add(new Transacao(ENTRADA, valor));
    }

    @Override
    public void sacar(Double valor) {

        System.out.println("Sacando "+ getCurrencyInstance().format(valor) + " da " + this);

        validarSaque(valor);

        Double taxa = calcularTaxaSaque(valor);
        if (taxa > 0) {
            System.out.println("  Taxa: " + getCurrencyInstance().format(taxa));
        }

        debitar(valor, taxa);
    }

    /**
     *
     * @param valor
     */
    protected abstract void validarSaque(Double valor);

    /**
     *
     * @param valor
     * @return
     */
    protected abstract Double calcularTaxaSaque(Double valor);

    @Override
    public void transferir(Double valor, ContaBancaria contaDestino) {

        System.out.println("Transferindo "+ getCurrencyInstance().format(valor) + " da " + this + " para " + contaDestino);

        Double taxa = calcularTaxaTransferencia(valor, contaDestino);
        if (taxa > 0) {
            System.out.println("  Taxa: " + getCurrencyInstance().format(taxa));
        }

        debitar(valor, taxa);
        contaDestino.depositar(valor);
    }

    /**
     *
     * @param valor
     * @param contaDestino
     * @return
     */
    protected abstract Double calcularTaxaTransferencia(Double valor, ContaBancaria contaDestino);

    @Override
    public void exibirExtrato(LocalDate inicio, LocalDate fim) {

        System.out.println("----- EXTRATO " + toString().toUpperCase());

        for (Transacao transacao : transacoesOrdenadasPorDataDecrescente()) {

            boolean filtroInicial = (inicio == null || transacao.getData().isAfter(inicio));
            boolean filtroFinal = (fim == null || transacao.getData().isBefore(fim));

            if (filtroInicial && filtroFinal) {
                System.out.println(String.format("%s %12s   - %9s %12s",
                        transacao.getTipo().getSimbolo(),
                        DecimalFormat.getCurrencyInstance().format(transacao.getValor()),
                        DecimalFormat.getCurrencyInstance().format(transacao.getTaxa()),
                        DateTimeFormatter.ofPattern("dd/MM/yyyy").format(transacao.getData())));
            }
        }

        System.out.println("-----");
    }

    /**
     * Efetua o débito da conta, validando primeiramente o saldo em conta e
     *   posteriormente registrando a transação.
     */
    protected void debitar(Double valor, Double taxas) {

        Double valorTotal = valor + taxas;

        if (saldo - valorTotal < 0) {
            throw new SaldoInsuficienteException("Saldo insuficiente para esta operação.");
        }

        saldo -= valorTotal;
        transacoes.add(new Transacao(SAIDA, valor, taxas));
    }

    /**
     *
     * @return
     */
    private List<Transacao> transacoesOrdenadasPorDataDecrescente() {

        List<Transacao> transacoesOrdenadas = new ArrayList<>(transacoes);

        Collections.sort(transacoesOrdenadas, new Comparator<Transacao>() {
            @Override
            public int compare(Transacao o1, Transacao o2) {
                return o2.getData().compareTo(o1.getData());
            }
        });

        return transacoesOrdenadas;
    }

    @Override
    public InstituicaoBancaria getInstituicaoBancaria() {
        return instituicaoBancaria;
    }

    protected String getNumero() {
        return numero;
    }
}