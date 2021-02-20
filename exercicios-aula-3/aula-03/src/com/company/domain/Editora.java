package com.company.domain;

public class Editora {

    private String nome;
    private String localizacao;

    public Editora(String nome, String localizacao) {
        validaNomeEditora(nome);
        this.nome = nome;
        this.localizacao = localizacao;
    }

    public String getNome() {
        return nome;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    private void validaNomeEditora(String nome) {
        if (nome.equals("DC Comics")) {
            throw new RuntimeException("ATENÇÃO! Nome 'DC Comics' NÃO É ACEITO! Por favor, insira outro nome");
        }
    }
}
