package com.banco.repository;

import com.banco.exceptions.ContaNaoEncontradaException;
import com.banco.model.Conta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContaRepository {

    private final Map<Integer, Conta> contas = new HashMap<>();

    public void salvar(Conta conta) {
        contas.put(conta.getNumeroConta(), conta);
    }

    public Conta buscarPorNumero(int numeroConta) {
        Conta conta = contas.get(numeroConta);
        if (conta == null) throw new ContaNaoEncontradaException(numeroConta);
        return conta;
    }

    public boolean existe(int numeroConta) {
        return contas.containsKey(numeroConta);
    }

    public List<Conta> listarTodas() {
        return new ArrayList<>(contas.values());
    }

    public void remover(int numeroConta) {
        buscarPorNumero(numeroConta); // lança exception se não existir
        contas.remove(numeroConta);
    }
}