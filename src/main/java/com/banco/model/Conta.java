package com.banco.model;

import com.banco.exceptions.SaldoInsuficienteException;
import com.banco.exceptions.SenhaInvalidaException;

public class Conta {

    private int numeroConta;
    private String agencia;
    protected double saldo;
    private String senha;
    private Cliente titular;

    public Conta(int numeroConta, String agencia, String senha, Cliente titular) {
        this.numeroConta = numeroConta;
        this.agencia = agencia;
        this.senha = senha;
        this.titular = titular;
        this.saldo = 0.0;
    }

    public double getSaldo() { return saldo; }

    public int getNumeroConta() { return numeroConta; }
    public void setNumeroConta(int numeroConta) { this.numeroConta = numeroConta; }

    public String getAgencia() { return agencia; }
    public void setAgencia(String agencia) { this.agencia = agencia; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }

    public Cliente getTitular() { return titular; }
    public void setTitular(Cliente titular) { this.titular = titular; }

    public void autenticar(String senhaInformada) {
        if (!this.senha.equals(senhaInformada)) throw new SenhaInvalidaException();
    }

    // model só executa a operação — sem println, sem validação de negócio
    public void depositar(double valor) {
        if (valor <= 0) throw new IllegalArgumentException("Valor de depósito deve ser positivo.");
        this.saldo += valor;
    }

    public void sacar(double valor) {
        if (valor <= 0) throw new IllegalArgumentException("Valor de saque deve ser positivo.");
        if (valor > this.saldo) throw new SaldoInsuficienteException(numeroConta, valor);
        this.saldo -= valor;
    }

    @Override
    public String toString() {
        return String.format("Conta %d | Agência: %s | Titular: %s | Saldo: R$ %.2f",
                numeroConta, agencia, titular.getNome(), saldo);
    }
}