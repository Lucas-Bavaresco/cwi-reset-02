package Aula02_Ex1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Aplicacao {

    public static void main(String[] args) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate meuNascimento = LocalDate.parse("24-05-1988",formatter);

        Pessoa pessoa = new Pessoa("Lucas",meuNascimento,Genero.MASCULINO);

        pessoa.imprimir();


//        Pessoa ator1 = new Ator("João",25,0,Genero.MASCULINO);
//        Pessoa ator2 = new Ator("Bruno",25,100,Genero.MASCULINO);
//        Pessoa ator3 = new Ator("Lucas",90,0,Genero.MASCULINO);
//        Pessoa diretor1 = new Diretor("Alexandre",30,50,Genero.MASCULINO);
//        List<Pessoa> elenco = new ArrayList<>();
//        elenco.add(ator1);
//        elenco.add(ator2);
//        elenco.add(ator3);
//        elenco.add(diretor1);


//        Diretor diretor10 = new Diretor("John", 65, 10, Genero.MASCULINO);
//        Filme filme1 = new Filme("Gladiador", "Épico", 90, 1998, 5, diretor10, elenco);
//        Ator ator5 = new Ator("Carl", 25, 10, Genero.MASCULINO);
//        Diretor diretor2 = new Diretor("Mark", 51, 5, Genero.NAO_BINARIO);
//        Filme filme2 = new Filme("Coração Valente", "Épico", 75, 2001, 4, diretor2, elenco);
//
//
//        filme1.exibirCreditos();
//        filme1.exibir();

//        filme1.exibir();
//        System.out.println("");
//        filme2.exibir();
//        diretor1.imprimir();
//        diretor2.imprimir();
//        ator1.imprimir();


    }
}
