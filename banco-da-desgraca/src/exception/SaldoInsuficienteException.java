package br.com.banco.desgraca.exception;

public class SaldoInsuficienteException extends RuntimeException {

    private static final long serialVersionUID = 2853440423739423762L;

    public SaldoInsuficienteException(String mensagemDeErro) {
        super(mensagemDeErro);
    }
}