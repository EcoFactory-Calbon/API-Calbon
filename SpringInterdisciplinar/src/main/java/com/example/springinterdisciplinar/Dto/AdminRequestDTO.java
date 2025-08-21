package com.example.springinterdisciplinar.Dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class AdminRequestDTO {
    @Email
    private String email;
    @NotNull(message = "O nome não pode ser nulo")
    private String nome;
    @Size(min = 8, message = "Senha deve ter mais de 8 caracteres")
    @NotNull(message = "Senha não pode ser nula")
    private String senha;

    public @Email String getEmail() {
        return email;
    }

    public @NotNull(message = "O nome não pode ser nulo") String getNome() {
        return nome;
    }

    public @Size(min = 8, message = "Senha deve ter mais de 8 caracteres") @NotNull(message = "Senha não pode ser nula") String getSenha() {
        return senha;
    }

    public void setEmail(@Email String email) {
        this.email = email;
    }

    public void setNome(@NotNull(message = "O nome não pode ser nulo") String nome) {
        this.nome = nome;
    }

    public void setSenha(@Size(min = 8, message = "Senha deve ter mais de 8 caracteres") @NotNull(message = "Senha não pode ser nula") String senha) {
        this.senha = senha;
    }
}
