package br.com.banco.desgraca.domain;

import br.com.banco.desgraca.Data;

import java.time.LocalDate;

public class Transacao {

    private final TipoTransacao tipo;
    private final Double valor;
    private final Double taxa;
    private final LocalDate data;

    public Transacao(TipoTransacao tipo, Double valor) {
        this(tipo, valor, 0.0);
    }

    public Transacao(TipoTransacao tipo, Double valor, Double taxa) {
        this.tipo = tipo;
        this.valor = valor;
        this.taxa = taxa;
        this.data = Data.getDataTransacao();
    }

    public TipoTransacao getTipo() {
        return tipo;
    }

    public Double getValor() {
        return valor;
    }

    public Double getTaxa() {
        return taxa;
    }

    public LocalDate getData() {
        return data;
    }
}