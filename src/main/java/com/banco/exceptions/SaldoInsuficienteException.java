package com.banco.exceptions;

public class SaldoInsuficienteException extends RuntimeException {
    public SaldoInsuficienteException(int numeroConta, double valor) {
        super(String.format("Saldo insuficiente na conta %d para o valor R$ %.2f", numeroConta, valor));
    }
}