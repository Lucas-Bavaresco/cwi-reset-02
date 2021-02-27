package br.com.banco.desgraca.exception;

public class InstituicaoBancariaInvalidaException extends RuntimeException {

    private static final long serialVersionUID = 6367877824210308535L;

    public InstituicaoBancariaInvalidaException(String message) {
        super(message);
    }
}