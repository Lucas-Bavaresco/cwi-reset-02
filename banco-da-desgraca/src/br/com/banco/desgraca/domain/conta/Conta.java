package br.com.banco.desgraca.domain.conta;

import br.com.banco.desgraca.Data;
import br.com.banco.desgraca.domain.InstituicaoBancaria;
import br.com.banco.desgraca.domain.TipoTransacao;
import br.com.banco.desgraca.domain.Transacao;
import br.com.banco.desgraca.exception.SaldoInsuficienteException;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;

import static br.com.banco.desgraca.Data.getDataTransacao;

public abstract class Conta implements ContaBancaria {

    private Integer numeroConta;
    private InstituicaoBancaria instituicaoBancaria;
    private Double saldo;

    ArrayList<Transacao> transacoes = new ArrayList();

    public Conta(InstituicaoBancaria instituicaoBancaria, int numeroConta) {
        this.instituicaoBancaria = instituicaoBancaria;
        this.numeroConta = numeroConta;
    }

// @Overrides (abaixo)

    @Override
    public Double consultarSaldo() {
        return saldo;
    }

    @Override
    public void depositar(Double valor) {
        saldo += valor;
        finalizarTransacao(valor, TipoTransacao.DEPOSITAR);
    }

    @Override
    public void sacar(Double valor) {
        validarSaida(valor);
        saldo -= valor;
        finalizarTransacao(valor, TipoTransacao.SACAR);
    }

    @Override
    public void transferir(Double valor, ContaBancaria contaDestino) {
        validarSaida(valor);
        saldo -= valor;
        finalizarTransacao(valor, TipoTransacao.TRANSFERIR);
    }

    @Override
    public void exibirExtrato(LocalDate inicio, LocalDate fim) {
        System.out.println("\n.......................................................");
        System.out.println("Extrato da conta " + toString());
        System.out.println(".........................................................");

        if ((inicio == null) && (fim == null)) {
            for (Transacao transacao : transacoes) {
                transacao.exibirTransacoes();
            }
        } else if ((inicio == null) && (fim != null)) {
            for (Transacao transacao : transacoes) {
                if (transacao.getData().isBefore(fim)) {
                    transacao.exibirTransacoes();
                }
            }
        } else if ((inicio != null) && (fim == null)) {
            for (Transacao transacao : transacoes) {
                if (transacao.getData().isAfter(inicio)) {
                    transacao.exibirTransacoes();
                }
            }
        } else if ((inicio != null) && (fim != null)) {
            for (Transacao transacao : transacoes) {
                if ((transacao.getData().isAfter(inicio)) && (transacao.getData().isBefore(fim))) {
                    transacao.exibirTransacoes();
                }
            }
        }

        System.out.println("Saldo atual: " + DecimalFormat.getCurrencyInstance().format(saldo));
        System.out.println("..................................................................");
    }

// Getters & Setters (abaixo)

    @Override
    public InstituicaoBancaria getInstituicaoBancaria() {
        return instituicaoBancaria;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }


// Métodos Auxiliares (abaixo)

    protected String formatarValor(double valor) {
        return DecimalFormat.getCurrencyInstance().format(valor);
    }

    protected void finalizarTransacao(double valor, TipoTransacao tipo) {
        String preposicao = "da";
        if (tipo.equals(TipoTransacao.DEPOSITAR)) {
            preposicao = "na";
        }
        System.out.println(tipo.getDescricao() + " no valor de " + formatarValor(valor) + " " + preposicao + " conta " + toString());
        transacoes.add(new Transacao(tipo, getDataTransacao(), valor));
    }

    protected void validarSaida(double valor) {
        if (valor > getSaldo()) {
            throw new RuntimeException("ATENÇÃO! Saldo insuficiente para esta transação.");
        }
    }

    protected void imprimirTaxas(double taxa, TipoTransacao tipo) {
        System.out.println("Taxa de " + tipo.getDescricao() + ": " + formatarValor(taxa));
    }
}