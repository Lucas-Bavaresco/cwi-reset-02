package Ex3;

public class Aplicacao {

    public static void main(String[] args) {
        Aluno aluno = new Aluno();
        String nome = aluno.nomearAluno("João");
        System.out.println("O nome do aluno é: " + nome);

        Aluno notaFinal = new Aluno();
        double nota = aluno.setNotaFinal(6.99);
        System.out.println("A nota final do aluno é: " + nota);

        Aluno statusAprovacao = new Aluno();
        boolean status = false;
        if (nota >= 7.0) {
            status = true;
        }

        System.out.println("Situação de aprovação: (true = APROVADO / false = REPROVADO)" + "\n" + "RESULTADO: " + status);
        boolean aprovarAluno = aluno.statusAprovacao(status);
    }
}
