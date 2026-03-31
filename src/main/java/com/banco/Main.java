package com.banco;

import com.banco.enums.TipoConta;
import com.banco.repository.*;
import com.banco.service.*;

public class Main {

    public static void main(String[] args) {

        // repositórios
        ClienteRepository clienteRepo = new ClienteRepository();
        ContaRepository contaRepo = new ContaRepository();
        FuncionarioRepository funcionarioRepo = new FuncionarioRepository();

        // services
        ClienteService clienteService = new ClienteService(clienteRepo);
        ContaService contaService = new ContaService(contaRepo, clienteRepo);
        FuncionarioService funcionarioService = new FuncionarioService(funcionarioRepo);

        System.out.println("=== CADASTRO ===");
        clienteService.cadastrar("Maria Silva", 32, "123.456.789-00",
                "Rua A, 100", "11 91234-5678", "maria@email.com", TipoConta.PF);

        clienteService.cadastrar("João Souza", 45, "987.654.321-00",
                "Av. B, 200", "11 99876-5432", "joao@empresa.com", TipoConta.PJ);

        funcionarioService.cadastrar("Carlos Lima", 28, "111.222.333-44",
                "Rua C, 300", "11 98888-7777", "carlos@banco.com", "Gerente", 8500.0);

        System.out.println("\n=== CONTAS ===");
        contaService.criarContaPf(1001, "0001", "senha123", "123.456.789-00", 500.0);
        contaService.criarContaPj(2001, "0001", "senha456", "987.654.321-00",
                "12.345.678/0001-99", "Empresa XYZ", 5000.0);

        System.out.println("\n=== OPERAÇÕES ===");
        contaService.depositar(1001, 1000.0);
        contaService.sacar(1001, 200.0, "senha123");
        contaService.transferir(2001, 1001, 500.0, "senha456");

        System.out.println("\n=== SALDOS ===");
        contaService.consultarSaldo(1001);
        contaService.consultarSaldo(2002);

        System.out.println("\n=== LISTAGENS ===");
        System.out.println("Clientes:");
        clienteService.listarTodos().forEach(System.out::println);

        System.out.println("\nFuncionários:");
        funcionarioService.listarTodos().forEach(System.out::println);

        System.out.println("\nContas:");
        contaService.listarContas().forEach(System.out::println);
    }
}