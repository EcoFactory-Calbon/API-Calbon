package com.example.springinterdisciplinar.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ManipuladorGlobalException {
    @ExceptionHandler(DadosInvalidosException.class)
    public ResponseEntity<String> manipulaDadosInvalidos(DadosInvalidosException ex)    {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Dados inválidos: " + ex.getMessage());
    }

    @ExceptionHandler(FuncionarioNaoEncontradoException.class)
    public ResponseEntity<String> manipuladorFuncionarioNaoEncontradoException(FuncionarioNaoEncontradoException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Funcionario não encontrado "+ex.getMessage());
    }

    @ExceptionHandler(AdminNaoEncontradoException.class)
    public ResponseEntity<String> manipuladorAdminNaoEncontradoException(AdminNaoEncontradoException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Admin não encontrado "+ex.getMessage());
    }

    @ExceptionHandler(EmpresaNaoEncontradaException.class)
    public ResponseEntity<String> manipuladorEmpresaNaoEncontradaException(EmpresaNaoEncontradaException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Empresa não encontrada "+ex.getMessage());
    }

    @ExceptionHandler(LocalizacaoNaoEncontradaException.class)
    public ResponseEntity<String> LocalizacaoEmpresaNaoEncontradaException(LocalizacaoNaoEncontradaException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Localizacao não encontrada "+ex.getMessage());
    }

}
