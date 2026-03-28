package com.banco.model;

import com.banco.exceptions.SaldoInsuficienteException;

public class ContaPj extends Conta {

    private String cnpj;
    private String nomeEmpresa;
    private double limiteCredito;

    public ContaPj(int numeroConta, String agencia, String senha, Cliente titular,
                   String cnpj, String nomeEmpresa, double limiteCredito) {
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

    @Override
    public void sacar(double valor) {
        if (valor <= 0) throw new IllegalArgumentException("Valor de saque deve ser positivo.");
        if (valor > saldo + limiteCredito) throw new SaldoInsuficienteException(getNumeroConta(), valor);
        saldo -= valor;
    }

    @Override
    public String toString() {
        return "PJ | " + super.toString() + String.format(" | Empresa: %s | CNPJ: %s | Limite: R$ %.2f",
                nomeEmpresa, cnpj, limiteCredito);
    }
}