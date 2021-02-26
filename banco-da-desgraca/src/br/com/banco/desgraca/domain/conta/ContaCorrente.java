package br.com.banco.desgraca.domain.conta;

import br.com.banco.desgraca.domain.InstituicaoBancaria;
import br.com.banco.desgraca.domain.TipoTransacao;
import br.com.banco.desgraca.exception.SaldoInsuficienteException;
import java.time.LocalDate;

public class ContaCorrente extends Conta {

    public ContaCorrente(InstituicaoBancaria instituicaoBancaria, int numeroConta) {
        super(instituicaoBancaria, numeroConta);
    }
    @Override
    public void sacar(Double valor) {
        super.sacar(valor);
        if (valor % 5 != 0) {
            throw new RuntimeException("ATENÇÃO! Saque disponível nos valores: R$ 5,00 / R$ 10,00 / R$ 20,00 / R$ 100,00 / R$ 200,00. ");
        }
    }

    @Override
    public void transferir(Double valor, ContaBancaria contaDestino) {
        validarSaida(valor);
        double taxa = 0;
        if (!contaDestino.getInstituicaoBancaria().equals(this.getInstituicaoBancaria())) {
            taxa = valor * 0.01;
        }
        setSaldo(super.getSaldo() - valor - taxa);
        finalizarTransacao(valor, TipoTransacao.TRANSFERIR);
        imprimirTaxas(taxa, TipoTransacao.TRANSFERIR);
    }
}