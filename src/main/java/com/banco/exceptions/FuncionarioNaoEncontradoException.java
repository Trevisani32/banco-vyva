package com.banco.exceptions;

public class FuncionarioNaoEncontradoException extends RuntimeException {
    public FuncionarioNaoEncontradoException(String cpf) {
        super("Funcionário não encontrado com CPF: " + cpf);
    }
}