package Aula02_Ex1;

import java.time.LocalDate;

public class Ator extends Pessoa {

    private int oscarsVencidos;

    public Ator(String nome, LocalDate dataNascimento, int oscarsVencidos, Genero genero) {
        super(nome, dataNascimento, genero);
        this.oscarsVencidos = oscarsVencidos;
    }

    @Override
    public void imprimir() {
        super.imprimir();
        System.out.println("Quantidade de oscars: "+oscarsVencidos);
    }
}
