package com.company.herancas;

import com.company.enumerador.Genero;
import com.company.domain.Pessoa;

public class Ator extends Pessoa {

    private Integer quantidadeOscarsVencidos;

    public Ator(String nome, int idade, Genero genero, int quantidadeOscarsVencidos) {
        super(nome, idade, genero);
        this.quantidadeOscarsVencidos = quantidadeOscarsVencidos;
    }

    @Override
    public void imprimirInformacoes() {
        System.out.println("Nome do Ator: " + getNome());
        System.out.println("Idade do Ator: " + getIdade());
        System.out.println("Gênero do Ator: " + getGenero());
    }

}
