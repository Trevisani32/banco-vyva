package com.banco.model;

public class Conta {

    private int numeroConta;
    private String agencia;
    protected double saldo; // protected para subclasses (ContaPf/ContaPj) acessarem
    private String senha;
    private Cliente titular; // referência ao dono da conta

    public Conta(int numeroConta, String agencia, String senha, Cliente titular) {
        this.numeroConta = numeroConta;
        this.agencia = agencia;
        this.senha = senha;
        this.titular = titular;
        this.saldo = 0.0; // saldo sempre começa em zero
    }

    // saldo NÃO tem setter — só muda via depositar() e sacar()
    public double getSaldo() { return saldo; }

    public int getNumeroConta() { return numeroConta; }
    public void setNumeroConta(int numeroConta) { this.numeroConta = numeroConta; }

    public String getAgencia() { return agencia; }
    public void setAgencia(String agencia) { this.agencia = agencia; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }

    public Cliente getTitular() { return titular; }
    public void setTitular(Cliente titular) { this.titular = titular; }

    public boolean autenticar(String senhaInformada) {
        return this.senha.equals(senhaInformada);
    }

    public void depositar(double valor) {
        if (valor <= 0) {
            System.out.println("Valor de depósito inválido.");
            return;
        }
        this.saldo += valor;
        System.out.printf("Depósito de R$ %.2f realizado. Saldo atual: R$ %.2f%n", valor, saldo);
    }

    public boolean sacar(double valor) {
        if (valor <= 0) {
            System.out.println("Valor de saque inválido.");
            return false;
        }
        if (this.saldo < valor) {
            System.out.println("Saldo insuficiente.");
            return false;
        }
        this.saldo -= valor;
        System.out.printf("Saque de R$ %.2f realizado. Saldo atual: R$ %.2f%n", valor, saldo);
        return true;
    }

    public void consultarSaldo() {
        System.out.printf("Saldo atual da conta %d: R$ %.2f%n", numeroConta, saldo);
    }

    @Override
    public String toString() {
        return String.format("Conta %d | Agência: %s | Titular: %s | Saldo: R$ %.2f",
                numeroConta, agencia, titular.getNome(), saldo);
    }
}