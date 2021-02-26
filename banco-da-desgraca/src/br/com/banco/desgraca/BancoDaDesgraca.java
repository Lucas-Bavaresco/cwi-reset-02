package br.com.banco.desgraca;

import br.com.banco.desgraca.domain.InstituicaoBancaria;
import br.com.banco.desgraca.domain.conta.ContaCorrente;
import br.com.banco.desgraca.domain.conta.ContaDigital;
import br.com.banco.desgraca.domain.conta.ContaPoupanca;

import java.time.LocalDate;

public class BancoDaDesgraca {

    public static void main(String[] args) throws Exception {

        ContaCorrente cc1 = new ContaCorrente(InstituicaoBancaria.NUBANK, 9999);
        ContaCorrente cc2 = new ContaCorrente(InstituicaoBancaria.BANCO_DO_BRASIL, 1234);
        ContaCorrente cc3 = new ContaCorrente(InstituicaoBancaria.BRADESCO, 5555);
        ContaCorrente cc4 = new ContaCorrente(InstituicaoBancaria.ITAU, 9876);
        ContaCorrente cc5 = new ContaCorrente(InstituicaoBancaria.CAIXA, 2468);

        ContaDigital cd1 = new ContaDigital(InstituicaoBancaria.NUBANK, 2222);
        cd1.depositar(99.99);
        cd1.transferir(1.000,cc1);
        cd1.exibirExtrato(null, null);

        ContaCorrente cc6 = new ContaCorrente(InstituicaoBancaria.ITAU, 1111);
        cc6.depositar(999.99);
        cc6.transferir(11.11, cd1); // teste transferência para outro banco
        cc6.transferir(50.00, cd1); // teste transferência para mesmo banco
        cc1.sacar(9.99);
        cc6.exibirExtrato(null, null);

        ContaPoupanca cp1 = new ContaPoupanca(InstituicaoBancaria.BRADESCO, 432);
        cp1.depositar(900.0);
        cp1.sacar(50.0);
        cp1.transferir(60.0, cc2); // teste transferência para outro banco
        cp1.transferir(70.0, cc3); // teste transferência para mesmo banco
        cp1.exibirExtrato(null, null);
        cp1.exibirExtrato(null, LocalDate.of(2020, 8, 14));
        cp1.exibirExtrato(LocalDate.of(2020, 8, 5), null);
        cp1.exibirExtrato(LocalDate.of(2020, 8, 5), LocalDate.of(2020, 8, 15));
        cc1.exibirExtrato(null, null);
        cc3.exibirExtrato(null, null);
    }
}