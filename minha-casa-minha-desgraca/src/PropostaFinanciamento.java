public class PropostaFinanciamento {

    private Beneficiario beneficiario;
    private Imovel imovelEscolhido;
    private int mesesParaPagamento;


    public PropostaFinanciamento(Beneficiario beneficiario, Imovel imovelEscolhido, int mesesParaPagamento) {
        this.beneficiario = beneficiario;
        this.imovelEscolhido = imovelEscolhido;
        this.mesesParaPagamento = mesesParaPagamento;
    }

    public Beneficiario getBeneficiario() {
        return beneficiario;
    }

    public Imovel getImovelEscolhido() {
        return imovelEscolhido;
    }

    public int getMesesParaPagamento() {
        return mesesParaPagamento;
    }

    /**
     * Valida a proposta de financiamento e apresenta o resultado para o cliente.
     * <p>
     * A proposta de financiamento é aceita somente se o salário do beneficiário multiplicado pelo prazo de pagamento
     * for equivalente a pelo menos 50% do valor do imóvel.
     * <p>
     * Esta regra possui duas exceções: se o imóvel se localiza no estado SP ou RJ,
     * o salário multiplicado pelo prazo deve ser equivalente a 65% e 60% do valor imóvel (respectivamente).
     */
    public void validarProposta() {
        boolean validacao = false;
        if (getImovelEscolhido().getEndereco().getEstado().equals(UnidadeFederativa.SAO_PAULO)) {
            validacao = (beneficiario.getSalario() * getMesesParaPagamento()) >= (imovelEscolhido.getValor() * 0.65);
        } else if (getImovelEscolhido().getEndereco().getEstado().equals(UnidadeFederativa.RIO_DE_JANEIRO)) {
            validacao = beneficiario.getSalario() * getMesesParaPagamento() >= (imovelEscolhido.getValor() * 0.60);
        } else if (getImovelEscolhido().getEndereco().getEstado() != (UnidadeFederativa.RIO_DE_JANEIRO)) {
            validacao = beneficiario.getSalario() * getMesesParaPagamento() >= (imovelEscolhido.getValor() * 0.50);
        }
        if (validacao == true) {
            imprimirPropostaAprovada();
        } else {
            imprimirPropostaNegada();
        }
        System.out.println("ATENÇÃO: Status da VALIDAÇÃO FINANCIAMENTO = " + validacao + "\n" +
                "LEGENDA:" + "\n" +
                "true = APROVADA " + "\n" +
                "false = NEGADA ");
    }


    private void imprimirPropostaAprovada() {
        System.out.println("PARABÉNS! Aprovada a proposta abaixo: \n" +
                "Beneficiário: " + beneficiario.getNome() + "\n" +
                "Salário: " + beneficiario.getSalario() + "\n" +
                "Imóvel: " + imovelEscolhido.apresentacao() + "\n" +
                "Prazo: " + getMesesParaPagamento() + '\n');
    }

    private void imprimirPropostaNegada() {
        System.out.println("TÁ PENSANDO QUE É FÁCIL, MANÉ ? A proposta solicitada abaixo foi NEGADA: \n" +
                "Beneficiário: " + beneficiario.getNome() + "\n" +
                "Salário: " + beneficiario.getSalario() + "\n" +
                "Imóvel: " + imovelEscolhido.apresentacao() + "\n" +
                "Prazo: " + getMesesParaPagamento() + '\n');
    }


}
