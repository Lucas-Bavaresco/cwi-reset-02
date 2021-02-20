package Aula02_Ex1;

public class Ator extends Pessoa {

    private int oscarsVencidos;

    public Ator(String nome, int idade, int oscarsVencidos, Genero genero) {
        super(nome, idade, genero);
        this.oscarsVencidos = oscarsVencidos;
    }

    @Override
    public void imprimir() {
        super.imprimir();
        System.out.println("Quantidade de oscars: "+oscarsVencidos);
    }
}
