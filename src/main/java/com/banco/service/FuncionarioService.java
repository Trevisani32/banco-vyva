package com.banco.service;

import com.banco.model.Funcionario;
import com.banco.repository.FuncionarioRepository;

import java.util.List;

public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public Funcionario cadastrar(String nome, int idade, String cpf, String endereco,
                                  String telefone, String email, String cargo, double salario) {
        if (funcionarioRepository.existe(cpf))
            throw new IllegalArgumentException("Já existe um funcionário com o CPF: " + cpf);

        Funcionario funcionario = new Funcionario(nome, idade, cpf, endereco, telefone, email, cargo, salario);
        funcionarioRepository.salvar(funcionario);
        System.out.println("✔ Funcionário cadastrado: " + funcionario);
        return funcionario;
    }

    public Funcionario buscarPorCpf(String cpf) {
        return funcionarioRepository.buscarPorCpf(cpf);
    }

    public void atualizarCargo(String cpf, String novoCargo) {
        Funcionario funcionario = funcionarioRepository.buscarPorCpf(cpf);
        funcionario.setCargo(novoCargo);
        System.out.println("✔ Cargo atualizado: " + novoCargo);
    }

    public void atualizarSalario(String cpf, double novoSalario) {
        if (novoSalario <= 0) throw new IllegalArgumentException("Salário deve ser positivo.");
        Funcionario funcionario = funcionarioRepository.buscarPorCpf(cpf);
        funcionario.setSalario(novoSalario);
        System.out.printf("✔ Salário atualizado: R$ %.2f%n", novoSalario);
    }

    public void remover(String cpf) {
        funcionarioRepository.remover(cpf);
        System.out.println("✔ Funcionário removido: " + cpf);
    }

    public List<Funcionario> listarTodos() {
        return funcionarioRepository.listarTodos();
    }
}