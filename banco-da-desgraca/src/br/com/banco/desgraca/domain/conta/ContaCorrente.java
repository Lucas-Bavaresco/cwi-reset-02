package br.com.banco.desgraca.domain.conta;

import br.com.banco.desgraca.domain.InstituicaoBancaria;
import br.com.banco.desgraca.exception.ValorSaqueInvalidoException;

import java.util.Random;

public class ContaCorrente extends BaseContaBancaria {

    private static final double TAXA_TRANSFERENCIA_OUTROS_BANCOS = 0.01;

    public ContaCorrente(InstituicaoBancaria instituicaoBancaria) {
        super(instituicaoBancaria);
    }

    @Override
    public String toString() {
        return String.format("Conta Corrente %s %s", getInstituicaoBancaria(), getNumero());
    }

    @Override
    protected String gerarNumeroConta() {
        return String.format("%s-%s", new Random().nextInt(99999) + 1, new Random().nextInt(+9) + 1);
    }

    @Override
    protected void validarInstituicaoBancaria(InstituicaoBancaria instituicaoBancaria) {
    }

    @Override
    protected void validarSaque(Double valor) {
        if (valor % 5 != 0) {
            throw new ValorSaqueInvalidoException("Valor inválido para esta operação.");
        }
    }

    @Override
    protected Double calcularTaxaSaque(Double valor) {
        return 0.0;
    }

    @Override
    protected Double calcularTaxaTransferencia(Double valor, ContaBancaria contaDestino) {

        if (contaDestino.getInstituicaoBancaria() != getInstituicaoBancaria()) {
            return valor * TAXA_TRANSFERENCIA_OUTROS_BANCOS;
        }

        return 0.0;
    }
}