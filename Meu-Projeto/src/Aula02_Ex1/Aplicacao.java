package Ex1;

public class Aplicacao {

    public static void main(String[] args) {
        Diretor diretor1 = new Diretor("John", 65, 10, Genero.MASCULINO);
        Filme filme1 = new Filme("Gladiador", "Épico", 90, 1998, 5, diretor1);
        Ator ator1 = new Ator("Carl", 25, 10, Genero.MASCULINO);
        Diretor diretor2 = new Diretor("Mark", 51, 5, Genero.NAO_BINARIO);
        Filme filme2 = new Filme("Coração Valente", "Épico", 75, 2001, 4, diretor2);

        filme1.exibir();
        System.out.println("");
        filme2.exibir();
        diretor1.imprimir();
        diretor2.imprimir();
        ator1.imprimir();


    }
}
