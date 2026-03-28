package com.banco.repository;

import com.banco.exceptions.FuncionarioNaoEncontradoException;
import com.banco.model.Funcionario;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FuncionarioRepository {

    private final Map<String, Funcionario> funcionarios = new HashMap<>();

    public void salvar(Funcionario funcionario) {
        funcionarios.put(funcionario.getCpf(), funcionario);
    }

    public Funcionario buscarPorCpf(String cpf) {
        Funcionario funcionario = funcionarios.get(cpf);
        if (funcionario == null) throw new FuncionarioNaoEncontradoException(cpf);
        return funcionario;
    }

    public boolean existe(String cpf) {
        return funcionarios.containsKey(cpf);
    }

    public List<Funcionario> listarTodos() {
        return new ArrayList<>(funcionarios.values());
    }

    public void remover(String cpf) {
        buscarPorCpf(cpf); // lança exception se não existir
        funcionarios.remove(cpf);
    }
}