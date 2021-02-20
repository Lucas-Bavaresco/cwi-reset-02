package Aula02_Ex1;

import java.util.List;

public class Filme {

    private String nome;
    private String descricao;
    private int duracao;
    private int anoLancamento;
    private int avaliacao;
    private Diretor diretor;
    private List<Pessoa> elenco;

    public Filme(String nome, String descricao, int duracao, int anoLancamento, int avaliacao, Diretor diretor, List<Pessoa> elenco) {
        defineAvaliacao(avaliacao);
        validaNomeEDefineAvaliacao(nome);
        this.nome = nome;
        this.descricao = descricao;
        this.duracao = duracao;
        this.anoLancamento = anoLancamento;
        this.diretor = diretor;
        this.elenco = elenco;
    }

    public void exibirCreditos() {
       System.out.println("Créditos: ");
        for (Pessoa pessoa : elenco) {
            pessoa.imprimir();
        }
    }

    public void exibir() {
        System.out.printf("Nome do filme: %s \n" +
                "Descrição: %s \n" +
                "Duração: %s \n" +
                "Nome do diretor: %s \n",this.nome, this.descricao, this.duracao, this.diretor.getNome() );
            }

    private void defineAvaliacao(Integer avaliacao) {
        if (avaliacao < 1 || avaliacao > 5) {
            this.avaliacao = 3;
        } else {
            this.avaliacao = avaliacao;
        }
    }

    private void validaNomeEDefineAvaliacao(String nome) {
        if ("Batman vs Superman".equals(nome)) {
            this.avaliacao = 1;
        } else if ("Clube da Luta".equals(nome)) {
            this.avaliacao = 5;
        }
    }
}
