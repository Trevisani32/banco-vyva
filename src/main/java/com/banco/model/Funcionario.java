package com.banco.model;

public class Funcionario extends Pessoa {

    private String cargo;
    private double salario;

    public Funcionario(String nome, int idade, String cpf, String endereco, String telefone, String email, String cargo, double salario) {
        super(nome, idade, cpf, endereco, telefone, email);
        
        this.cargo = cargo;
        this.salario = salario;
    }

    public String getCargo() { return cargo; }
    public void setCargo(String cargo) { this.cargo = cargo; }

    public double getSalario() { return salario; }
    public void setSalario(double salario) { this.salario = salario; }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Cargo: %s | Salário: R$ %.2f", cargo, salario);
    }
}