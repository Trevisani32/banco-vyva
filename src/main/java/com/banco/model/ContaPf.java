package com.banco.model;

public class ContaPf extends Conta {

    private double limiteCredito;

    public ContaPf(int numeroConta, String agencia, String senha, Cliente titular, double limiteCredito) {
        super(numeroConta, agencia, senha, titular);
        // CPF não duplicado aqui — já está no titular (Cliente → Pessoa)
        this.limiteCredito = limiteCredito;
    }

    public double getLimiteCredito() { return limiteCredito; }
    public void setLimiteCredito(double limiteCredito) { this.limiteCredito = limiteCredito; }

    // Sobrescreve sacar para usar o limite de crédito
    @Override
    public boolean sacar(double valor) {
        if (valor <= 0) {
            System.out.println("Valor de saque inválido.");
            return false;
        }
        if (valor > saldo + limiteCredito) {
            System.out.println("Saldo e limite de crédito insuficientes.");
            return false;
        }
        saldo -= valor;
        System.out.printf("Saque de R$ %.2f realizado. Saldo atual: R$ %.2f%n", valor, saldo);
        return true;
    }

    @Override
    public String toString() {
        return "PF | " + super.toString() + String.format(" | Limite: R$ %.2f", limiteCredito);
    }
}