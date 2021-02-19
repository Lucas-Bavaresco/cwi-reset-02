public abstract class Imovel {

    private Endereco endereco;
    private Double valor;

    public Imovel(Endereco endereco, Double valor) {
        this.endereco = endereco;
        this.valor = valor;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public Double getValor() {
        return valor;
    }

    public String apresentacao() {
        return ("Imóvel localizado no endereço "
                + getEndereco().getLogradouro() + " , "
                + getEndereco().getNumero() + " , "
                + getEndereco().getComplemento() + " , "
                + getEndereco().getBairro() + " , "
                + getEndereco().getCidade() + " , "
                + getEndereco().getEstado() + " , " + "\n" +
                " Valor: R$ " + getValor());
    }
}
