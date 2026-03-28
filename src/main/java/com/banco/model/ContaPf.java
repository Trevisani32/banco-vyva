package com.banco.model;

import com.banco.exceptions.SaldoInsuficienteException;

public class ContaPf extends Conta {

    private double limiteCredito;

    public ContaPf(int numeroConta, String agencia, String senha, Cliente titular, double limiteCredito) {
        super(numeroConta, agencia, senha, titular);
        this.limiteCredito = limiteCredito;
    }

    public double getLimiteCredito() { return limiteCredito; }
    public void setLimiteCredito(double limiteCredito) { this.limiteCredito = limiteCredito; }

    @Override
    public void sacar(double valor) {
        if (valor <= 0) throw new IllegalArgumentException("Valor de saque deve ser positivo.");
        if (valor > saldo + limiteCredito) throw new SaldoInsuficienteException(getNumeroConta(), valor);
        saldo -= valor;
    }

    @Override
    public String toString() {
        return "PF | " + super.toString() + String.format(" | Limite: R$ %.2f", limiteCredito);
    }
}