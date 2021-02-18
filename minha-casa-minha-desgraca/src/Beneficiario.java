public class Beneficiario {

    private String nome;
    private Double salario;

    public Beneficiario(String nome, double salario) {
        this.nome = nome;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public double getSalario() {
        return salario;
    }

}
