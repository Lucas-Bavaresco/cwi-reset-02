package Aula02_Ex1;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

public class Pessoa {

    private String nome;
    private LocalDate dataNascimento;
    private Genero genero;

    public Pessoa(String nome, LocalDate dataNascimento, Genero genero) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.genero = genero;
    }

    public void imprimir() {
//        LocalDate dataNascimento = new LocalDate (1970, 1, 20);
//        LocalDate now = new LocalDate();
//        Years idade = LocalDate.(dataNascimento, now);
        System.out.println("Nome: " + this.nome);
        System.out.println("Idade: " + Period.between(this.dataNascimento,LocalDate.now()).getYears());
        System.out.println("Gênero: " + this.genero);
    }

    public String getNome() {
        return nome;
    }

    public void setDataNascimento(String dataNascimento){
        dataNascimento = dataNascimento;
    }

}
