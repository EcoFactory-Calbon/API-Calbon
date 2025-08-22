package com.example.springinterdisciplinar.Dto;

public class AdminResponseDTO {

    private String email;
    private String nome;

    public AdminResponseDTO(String email, String nome) {
        this.email = email;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

}
