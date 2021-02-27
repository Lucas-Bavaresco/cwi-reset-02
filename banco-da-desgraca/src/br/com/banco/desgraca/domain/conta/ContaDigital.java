package br.com.banco.desgraca.domain.conta;

import br.com.banco.desgraca.domain.InstituicaoBancaria;
import br.com.banco.desgraca.exception.InstituicaoBancariaInvalidaException;
import br.com.banco.desgraca.exception.ValorSaqueInvalidoException;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class ContaDigital extends BaseContaBancaria {

    private static final double MINIMO_SAQUE = 10.0;

    public ContaDigital(InstituicaoBancaria instituicaoBancaria) {
        super(instituicaoBancaria);
    }

    @Override
    public String toString() {
        return String.format("Conta Digital %s %s", getInstituicaoBancaria(), getNumero());
    }

    @Override
    protected String gerarNumeroConta() {
        return String.format("%s-%s", new Random().nextInt(99999999) + 1, new Random().nextInt(+9) + 1);
    }

    @Override
    protected void validarInstituicaoBancaria(InstituicaoBancaria instituicaoBancaria) {

        Set<InstituicaoBancaria> bancosComContaDigital = new HashSet<>();
        bancosComContaDigital.add(InstituicaoBancaria.ITAU);
        bancosComContaDigital.add(InstituicaoBancaria.NUBANK);

        // Java 9+
        //Set<InstituicaoBancaria> bancosComContaDigital = Set.of(InstituicaoBancaria.ITAU, InstituicaoBancaria.NUBANK);

        if (! bancosComContaDigital.contains(instituicaoBancaria)) {
            throw new InstituicaoBancariaInvalidaException(instituicaoBancaria + " não possui contas digitais.");
        }
    }

    @Override
    protected void validarSaque(Double valor) {
        if (valor < MINIMO_SAQUE) {
            throw new ValorSaqueInvalidoException("Valor inválido para esta operação.");
        }
    }

    @Override
    protected Double calcularTaxaSaque(Double valor) {
        return 0.0;
    }

    @Override
    protected Double calcularTaxaTransferencia(Double valor, ContaBancaria contaDestino) {
        return 0.0;
    }
}