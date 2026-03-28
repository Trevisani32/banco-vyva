package com.banco.repository;

import com.banco.exceptions.ClienteNaoEncontradoException;
import com.banco.model.Cliente;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClienteRepository {

    private final Map<String, Cliente> clientes = new HashMap<>();

    public void salvar(Cliente cliente) {
        clientes.put(cliente.getCpf(), cliente);
    }

    public Cliente buscarPorCpf(String cpf) {
        Cliente cliente = clientes.get(cpf);
        if (cliente == null) throw new ClienteNaoEncontradoException(cpf);
        return cliente;
    }

    public boolean existe(String cpf) {
        return clientes.containsKey(cpf);
    }

    public List<Cliente> listarTodos() {
        return new ArrayList<>(clientes.values());
    }

    public void remover(String cpf) {
        buscarPorCpf(cpf); // lança exception se não existir
        clientes.remove(cpf);
    }
}