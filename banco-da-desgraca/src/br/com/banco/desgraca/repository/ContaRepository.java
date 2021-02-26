package br.com.banco.desgraca.repository;


import br.com.banco.desgraca.domain.conta.Conta;

import java.util.ArrayList;
import java.util.List;

public class ContaRepository {

    private List<Conta> contas;

    public ContaRepository() {
        contas = new ArrayList<Conta>();
    }

    public void criarConta(Conta conta) {
        contas.add(conta);
    }
}