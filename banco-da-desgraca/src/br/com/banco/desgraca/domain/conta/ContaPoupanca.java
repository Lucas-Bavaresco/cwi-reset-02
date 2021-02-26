package br.com.banco.desgraca.domain.conta;

import br.com.banco.desgraca.domain.InstituicaoBancaria;
import br.com.banco.desgraca.domain.TipoTransacao;

public class ContaPoupanca extends Conta {
    public ContaPoupanca(InstituicaoBancaria instituicaoBancaria, int numeroConta) {
        super(instituicaoBancaria, numeroConta);
        validarInstituicaoBancaria();
    }

    @Override
    public void sacar(Double valor) {
        validarSaida(valor);
        if (valor < 50) {
            throw new RuntimeException("ATENÇÃO! O valor mínimo para saque é R$ 50.00");
        } else {
            double taxa = valor * 0.02;
            setSaldo(super.getSaldo() - valor - taxa);
            finalizarTransacao(valor, TipoTransacao.SACAR);
            imprimirTaxas(taxa, TipoTransacao.SACAR);
        }
    }

    @Override
    public void transferir(Double valor, ContaBancaria contaDestino) {
        validarSaida(valor);
        double taxa = valor * 0.01;
        if (contaDestino.getInstituicaoBancaria().equals(this.getInstituicaoBancaria())) {
            taxa = valor * 0.005;
        }
        setSaldo(super.getSaldo() - valor - taxa);
        finalizarTransacao(valor, TipoTransacao.TRANSFERIR);
        imprimirTaxas(taxa, TipoTransacao.TRANSFERIR);
    }

    private void validarInstituicaoBancaria() {
        if (super.getInstituicaoBancaria().equals(InstituicaoBancaria.NUBANK)) {
            throw new RuntimeException("ATENÇÃO! Conta Poupança não aceita pela instituição bancária " + InstituicaoBancaria.NUBANK + ".");
        }
    }
}
