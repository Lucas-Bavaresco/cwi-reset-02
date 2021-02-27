package br.com.banco.desgraca.domain;

public enum TipoTransacao {

    ENTRADA("+"),
    SAIDA("-");

    private String simbolo;

    TipoTransacao(String simbolo) {
        this.simbolo = simbolo;
    }

    public String getSimbolo() {
        return simbolo;
    }
}