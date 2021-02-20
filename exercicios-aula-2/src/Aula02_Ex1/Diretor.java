package Aula02_Ex1;

import java.time.LocalDate;

public class Diretor extends Pessoa {

    private int qtdeFilmesDirigidos;

    public Diretor(String nome, LocalDate dataNascimento, int qtdeFilmesDirigidos, Genero genero) {
        super(nome, dataNascimento, genero);
        this.qtdeFilmesDirigidos = qtdeFilmesDirigidos;

    }

    @Override
    public void imprimir() {
        super.imprimir();
        System.out.println("Quantidade de filmes dirigidos: "+qtdeFilmesDirigidos);
    }

}