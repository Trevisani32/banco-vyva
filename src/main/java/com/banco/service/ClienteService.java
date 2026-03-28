package com.banco.service;

import com.banco.enums.TipoConta;
import com.banco.model.Cliente;
import com.banco.repository.ClienteRepository;

import java.util.List;

public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente cadastrar(String nome, int idade, String cpf, String endereco,
                              String telefone, String email, TipoConta tipoConta) {
        if (clienteRepository.existe(cpf))
            throw new IllegalArgumentException("Já existe um cliente com o CPF: " + cpf);

        Cliente cliente = new Cliente(nome, idade, cpf, endereco, telefone, email, tipoConta);
        clienteRepository.salvar(cliente);
        System.out.println("✔ Cliente cadastrado: " + cliente);
        return cliente;
    }

    public Cliente buscarPorCpf(String cpf) {
        return clienteRepository.buscarPorCpf(cpf);
    }

    public void atualizarEmail(String cpf, String novoEmail) {
        Cliente cliente = clienteRepository.buscarPorCpf(cpf);
        cliente.setEmail(novoEmail);
        System.out.println("✔ Email atualizado: " + novoEmail);
    }

    public void atualizarTelefone(String cpf, String novoTelefone) {
        Cliente cliente = clienteRepository.buscarPorCpf(cpf);
        cliente.setTelefone(novoTelefone);
        System.out.println("✔ Telefone atualizado: " + novoTelefone);
    }

    public void remover(String cpf) {
        clienteRepository.remover(cpf);
        System.out.println("✔ Cliente removido: " + cpf);
    }

    public List<Cliente> listarTodos() {
        return clienteRepository.listarTodos();
    }
}