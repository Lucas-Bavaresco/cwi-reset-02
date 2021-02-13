package Ex1;

public class Diretor extends Pessoa {

    private int qtdeFilmesDirigidos;

    public Diretor(String nome, int idade, int qtdeFilmesDirigidos, Genero genero) {
        super(nome, idade, genero);
        this.qtdeFilmesDirigidos = qtdeFilmesDirigidos;

    }


}