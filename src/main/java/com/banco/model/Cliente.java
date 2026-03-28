package com.banco.model;
import com.banco.enums.TipoConta;

public class Cliente extends Pessoa {

    private TipoConta tipoConta;
    private Conta conta;

    public Cliente(String nome, int idade, String cpf, String endereco, String telefone, String email, TipoConta tipoConta) {
        super(nome, idade, cpf, endereco, telefone, email);
        this.tipoConta = tipoConta;
    }

    public TipoConta getTipoConta() { return tipoConta; }
    public void setTipoConta(TipoConta tipoConta) { this.tipoConta = tipoConta; }

    public Conta getConta() { return conta; }
    public void setConta(Conta conta) { this.conta = conta; }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Tipo: %s", tipoConta);
    }
}