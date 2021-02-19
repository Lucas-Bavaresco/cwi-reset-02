public class Casa extends Imovel {
    private boolean patio;

    public Casa(Endereco endereco, Double valor, boolean patio) {
        super(endereco, valor);
        this.patio = patio;
    }

    public boolean isPatio() {
        return patio;
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
                " OBS: Imóvel é uma CASA:" + "\n" +
                "Possui pátio? " + isPatio() + "\n" +
                "true = Possui PÁTIO " + "\n" +
                "false = NÃO possui PÁTIO ");
    }
}