package br.com.banco.desgraca.domain.conta;

import br.com.banco.desgraca.domain.InstituicaoBancaria;


public class ContaDigital extends Conta {
    public ContaDigital(InstituicaoBancaria instituicaoBancaria, int numeroConta) {
        super(instituicaoBancaria, numeroConta);
        validarInstituicaoBancaria();
    }

    @Override
    public void sacar(Double valor) {
        super.sacar(valor);
        if (valor < 10) {
            throw new RuntimeException("\n\nAtenção! Os saques só são permitidos se o valor solicitado for de pelo menos R$ 10,00.\n");
        }
    }

    private void validarInstituicaoBancaria() {
        if ((!getInstituicaoBancaria().equals(InstituicaoBancaria.NUBANK)) && (!getInstituicaoBancaria().equals(InstituicaoBancaria.ITAU))) {
            throw new RuntimeException("ATENÇÃO! O tipo 'Conta Digital' não é suportado pela instituição bancária ''" + getInstituicaoBancaria().getDescricao() + "''");
        }
    }
}
