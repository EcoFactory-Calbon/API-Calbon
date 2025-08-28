package com.example.springinterdisciplinar.Dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class AdminRequestDTO {
    @Email
    @Valid
    private String email;
    @Valid
    @Size(min = 3, message = "O nome deve ter 3 ou mais caracteres")
    @NotNull(message = "O nome não pode ser nulo")
    private String nome;
    @Valid
    @Size(min = 8, message = "Senha deve ter mais de 8 caracteres")
    @NotNull(message = "Senha não pode ser nula")
    private String senha;

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
