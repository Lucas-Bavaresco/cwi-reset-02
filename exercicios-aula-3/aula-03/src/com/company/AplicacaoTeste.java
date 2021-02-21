package com.company;

import com.company.domain.Editora;
import com.company.domain.Filme;
import com.company.enumerador.Genero;
import com.company.herancas.Ator;
import com.company.herancas.Diretor;

public class AplicacaoTeste {

    public static void main(String[] args) {

        Filme filme1 = new Filme("Avatar", "Ficção", 145, 2005, 4, new Diretor("Paul", 45, Genero.MASCULINO, 15), new Ator("Anna", 18, Genero.FEMININO, 0));
        filme1.reproduzir();

        Filme filme2 = new Filme("Clube da Luta", "Ação", 92, 1980, 10, new Diretor("Lucas Bavaresco", 32, Genero.MASCULINO, 8), new Ator("Bruna", 35, Genero.FEMININO, 10));
        filme2.reproduzir();

        Editora editora1 = new Editora("Marvel", "CA - EUA");
        System.out.println("Editora: " + editora1.getNome());
        Editora editora2 = new Editora("DC Comics", "CA - EUA");
        System.out.println("Editora: " + editora2.getNome());


    }
}


