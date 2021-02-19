public class Apartamento extends Imovel {
    private int andar;

    public Apartamento(Endereco endereco, Double valor, int andar) {
        super(endereco, valor);
        this.andar = andar;
    }

    public int getAndar() {
        return andar;
    }

    @Override
    public String apresentacao() {
        return ("Imóvel localizado no endereço "
                + getEndereco().getLogradouro() + " , "
                + getEndereco().getNumero() + " , "
                + getEndereco().getComplemento() + " , "
                + getEndereco().getBairro() + " , "
                + getEndereco().getCidade() + " , "
                + getEndereco().getEstado() + " . " + "\n" +
                " Valor: R$ " + getValor() + " . " + "\n" +
                " OBS: Imóvel é um APARTAMENTO no: " + getAndar() + "º andar");
    }

}
