package Ex1;

public enum Genero {
    MASCULINO("Masculino"),
    FEMINIMO("Feminimo"),
    NAO_BINARIO("Não Binário");

    private String descricao;

    Genero(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
