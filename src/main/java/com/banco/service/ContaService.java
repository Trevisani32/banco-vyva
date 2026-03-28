package com.banco.service;

import com.banco.model.*;
import com.banco.repository.ClienteRepository;
import com.banco.repository.ContaRepository;

import java.util.List;

public class ContaService {

    private final ContaRepository contaRepository;
    private final ClienteRepository clienteRepository;

    public ContaService(ContaRepository contaRepository, ClienteRepository clienteRepository) {
        this.contaRepository = contaRepository;
        this.clienteRepository = clienteRepository;
    }

    public ContaPf criarContaPf(int numeroConta, String agencia, String senha, String cpfCliente, double limiteCredito) {
        if (contaRepository.existe(numeroConta))
            throw new IllegalArgumentException("Já existe uma conta com o número: " + numeroConta);

        Cliente cliente = clienteRepository.buscarPorCpf(cpfCliente);
        ContaPf conta = new ContaPf(numeroConta, agencia, senha, cliente, limiteCredito);
        cliente.setConta(conta);
        contaRepository.salvar(conta);
        System.out.println("✔ Conta PF criada: " + conta);
        return conta;
    }

    public ContaPj criarContaPj(int numeroConta, String agencia, String senha, String cpfCliente,
                                 String cnpj, String nomeEmpresa, double limiteCredito) {
        if (contaRepository.existe(numeroConta))
            throw new IllegalArgumentException("Já existe uma conta com o número: " + numeroConta);

        Cliente cliente = clienteRepository.buscarPorCpf(cpfCliente);
        ContaPj conta = new ContaPj(numeroConta, agencia, senha, cliente, cnpj, nomeEmpresa, limiteCredito);
        cliente.setConta(conta);
        contaRepository.salvar(conta);
        System.out.println("✔ Conta PJ criada: " + conta);
        return conta;
    }

    public void depositar(int numeroConta, double valor) {
        Conta conta = contaRepository.buscarPorNumero(numeroConta);
        conta.depositar(valor);
        System.out.printf("✔ Depósito de R$ %.2f na conta %d. Saldo: R$ %.2f%n", valor, numeroConta, conta.getSaldo());
    }

    public void sacar(int numeroConta, double valor, String senha) {
        Conta conta = contaRepository.buscarPorNumero(numeroConta);
        conta.autenticar(senha);
        conta.sacar(valor);
        System.out.printf("✔ Saque de R$ %.2f da conta %d. Saldo: R$ %.2f%n", valor, numeroConta, conta.getSaldo());
    }

    public void transferir(int numeroOrigem, int numeroDestino, double valor, String senha) {
        Conta origem = contaRepository.buscarPorNumero(numeroOrigem);
        Conta destino = contaRepository.buscarPorNumero(numeroDestino);
        origem.autenticar(senha);
        origem.sacar(valor);
        destino.depositar(valor);
        System.out.printf("✔ Transferência de R$ %.2f: conta %d → conta %d%n", valor, numeroOrigem, numeroDestino);
    }

    public void consultarSaldo(int numeroConta) {
        Conta conta = contaRepository.buscarPorNumero(numeroConta);
        System.out.printf("Saldo da conta %d: R$ %.2f%n", numeroConta, conta.getSaldo());
    }

    public List<Conta> listarContas() {
        return contaRepository.listarTodas();
    }
}