package com.banco.exceptions;

public class ContaNaoEncontradaException extends RuntimeException {
    public ContaNaoEncontradaException(int numeroConta) {
        super("Conta não encontrada: " + numeroConta);
    }
}