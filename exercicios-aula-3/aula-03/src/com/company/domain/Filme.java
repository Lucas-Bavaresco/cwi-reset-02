package com.company.domain;

import com.company.herancas.Ator;
import com.company.herancas.Diretor;

public class Filme {

    private String nome;
    private String descricao;
    private Integer duracao;
    private Integer anoLancamento;
    private Integer avaliacao;
    private Diretor diretor;
    private Ator ator;

    public Filme(String nome, String descricao, Integer duracao, Integer anoLancamento, Integer avaliacao, Diretor diretor, Ator ator) {
        defineAvaliacao(avaliacao);
        validaNomeEDefineAvaliacao(nome);
        this.nome = nome;
        this.descricao = descricao;
        this.duracao = duracao;
        this.anoLancamento = anoLancamento;
        this.diretor = diretor;
        this.ator = ator;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public Integer getDuracao() {
        return duracao;
    }

    public Integer getAnoLancamento() {
        return anoLancamento;
    }

    public Integer getAvaliacao() {
        return avaliacao;
    }

    public Diretor getDiretor() {
        return diretor;
    }

    public void reproduzir() {
        System.out.println("Nome Filme: " + this.nome);
        System.out.println("Descrição: " + this.descricao);
        System.out.println("Duração: " + this.duracao);
        System.out.println("Ano Lançamento: " + this.anoLancamento);
        System.out.println("Avaliação: " + this.avaliacao);
        diretor.imprimirInformacoes();
        ator.imprimirInformacoes();
    }

    private void defineAvaliacao(Integer avaliacao) {
        if (avaliacao < 1 || avaliacao > 5) {
            throw new IllegalArgumentException("ATENÇÃO! Nota da avaliação inválida (somente de 1 a 5)");
            //this.avaliacao = 3;
        } else {
            this.avaliacao = avaliacao;
        }
    }

    private void validaNomeEDefineAvaliacao(String nome) {
        if ("Batman vs Superman".equals(nome)) {
            this.avaliacao = 1;
        } else if ("Interestelar".equals(nome)) {
            this.avaliacao = 5;
        }
    }
}
