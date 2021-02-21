package com.company.herancas;

import com.company.enumerador.Genero;
import com.company.domain.Pessoa;

public class Diretor extends Pessoa {

    private Integer quantidadeFilmesDirigidos;

    public Diretor(String nome, Integer idade, Genero genero, Integer quantidadeFilmesDirigidos) {
        super(nome, idade, genero);
        this.quantidadeFilmesDirigidos = quantidadeFilmesDirigidos;
    }

    @Override
    public void imprimirInformacoes() {
        System.out.println("Nome do Diretor: " + getNome());
        System.out.println("Idade do Diretor: " + getIdade());
        System.out.println("Gênero do Diretor " + getGenero());
    }

}
