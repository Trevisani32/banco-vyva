package com.banco;

import com.banco.enums.*;
import com.banco.model.*;

public class Main {

    public static void main(String[] args) {

        // Criando um cliente PF
        Cliente clientePf = new Cliente("Maria Silva", 32, "123.456.789-00",
                "Rua A, 100", "11 91234-5678", "maria@email.com", TipoConta.PF);

        // Criando a conta PF vinculada ao cliente
        ContaPf contaPf = new ContaPf(1001, "0001", "senha123", clientePf, 500.0);
        clientePf.setConta(contaPf);

        contaPf.depositar(1000.0);
        contaPf.sacar(1400.0); // usa parte do limite
        contaPf.consultarSaldo();

        System.out.println(contaPf);

        System.out.println("---");

        // Criando um cliente PJ
        Cliente clientePj = new Cliente("João Souza", 45, "987.654.321-00",
                "Av. B, 200", "11 99876-5432", "joao@empresa.com", TipoConta.PJ);

        ContaPj contaPj = new ContaPj(2001, "0001", "senha456", clientePj,
                "12.345.678/0001-99", "Empresa XYZ", 5000.0);
        clientePj.setConta(contaPj);

        contaPj.depositar(3000.0);
        contaPj.sacar(7000.0); // usa parte do limite
        contaPj.consultarSaldo();

        System.out.println(contaPj);

        System.out.println("---");

        // Funcionário do banco
        Funcionario func = new Funcionario("Carlos Lima", 28, "111.222.333-44",
                "Rua C, 300", "11 98888-7777", "carlos@banco.com", "Gerente", 8500.0);

        System.out.println(func);
    }
}