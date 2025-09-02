package com.example.springinterdisciplinar.Exception;

public class FuncionarioNaoEncontradoException extends RuntimeException {
    public FuncionarioNaoEncontradoException(String message) {
        super(message);
    }
}
