package br.com.banco.desgraca.domain.conta;

import br.com.banco.desgraca.domain.InstituicaoBancaria;
import br.com.banco.desgraca.exception.InstituicaoBancariaInvalidaException;
import br.com.banco.desgraca.exception.ValorSaqueInvalidoException;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import static java.util.Arrays.asList;

public class ContaPoupanca extends BaseContaBancaria {

    private static final double MINIMO_SAQUE = 50.0;
    private static final double TAXA_SAQUE = 0.02;
    private static final double TAXA_TRANSFERENCIA_MESMO_BANCO = 0.005;
    private static final double TAXA_TRANSFERENCIA_OUTROS_BANCOS = 0.01;

    public ContaPoupanca(InstituicaoBancaria instituicaoBancaria) {
        super(instituicaoBancaria);
    }

    @Override
    public String toString() {
        return String.format("Conta Poupança %s %s", getInstituicaoBancaria(), getNumero());
    }

    @Override
    protected String gerarNumeroConta() {
        return String.format("%s-%s", new Random().nextInt(9999) + 1, new Random().nextInt(+99) + 1);
    }

    @Override
    protected void validarInstituicaoBancaria(InstituicaoBancaria instituicaoBancaria) {

        Set<InstituicaoBancaria> bancosComPoupanca = new HashSet<>(asList(InstituicaoBancaria.values()));
        bancosComPoupanca.remove(InstituicaoBancaria.NUBANK);

        if (! bancosComPoupanca.contains(instituicaoBancaria)) {
            throw new InstituicaoBancariaInvalidaException(instituicaoBancaria + " não possui conta poupança.");
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
        return valor * TAXA_SAQUE;
    }

    @Override
    protected Double calcularTaxaTransferencia(Double valor, ContaBancaria contaDestino) {

        Double percentual = contaDestino.getInstituicaoBancaria() == getInstituicaoBancaria()
                ? TAXA_TRANSFERENCIA_MESMO_BANCO
                : TAXA_TRANSFERENCIA_OUTROS_BANCOS;

        return valor * percentual;
    }
}