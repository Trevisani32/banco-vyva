package com.banco.model;

public class ContaPj extends Conta {

    private String cnpj;
    private String nomeEmpresa;
    private double limiteCredito;

    public ContaPj(int numeroConta, String agencia, String senha, Cliente titular, String cnpj, String nomeEmpresa, double limiteCredito) {
        super(numeroConta, agencia, senha, titular);
        this.cnpj = cnpj;
        this.nomeEmpresa = nomeEmpresa;
        this.limiteCredito = limiteCredito;
    }

    public String getCnpj() { return cnpj; }
    public void setCnpj(String cnpj) { this.cnpj = cnpj; }

    public String getNomeEmpresa() { return nomeEmpresa; }
    public void setNomeEmpresa(String nomeEmpresa) { this.nomeEmpresa = nomeEmpresa; }

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
        return "PJ | " + super.toString() + String.format(" | Empresa: %s | CNPJ: %s | Limite: R$ %.2f",
                nomeEmpresa, cnpj, limiteCredito);
    }
}