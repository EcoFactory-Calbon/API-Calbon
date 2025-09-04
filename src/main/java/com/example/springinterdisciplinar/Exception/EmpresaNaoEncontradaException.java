package com.example.springinterdisciplinar.Exception;

public class EmpresaNaoEncontradaException extends RuntimeException {
    public EmpresaNaoEncontradaException(String message) {
        super(message);
    }
}
