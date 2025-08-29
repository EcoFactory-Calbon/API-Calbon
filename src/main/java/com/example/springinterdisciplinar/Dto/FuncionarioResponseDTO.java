package com.example.springinterdisciplinar.Dto;

import com.example.springinterdisciplinar.Model.Funcionario;

public class FuncionarioResponseDTO {
    private Long id;
    private String nome;
    private String sobrenome;
    private String email;
    private String numero_cracha;
    private Boolean is_gestor;


    public FuncionarioResponseDTO() {}

    public FuncionarioResponseDTO(Long id, String nome, String sobrenome, String email, String numero_cracha, Boolean is_gestor) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.numero_cracha = numero_cracha;
        this.is_gestor = is_gestor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumero_cracha() {
        return numero_cracha;
    }

    public void setNumero_cracha(String numero_cracha) {
        this.numero_cracha = numero_cracha;
    }

    public Boolean getIs_gestor() {
        return is_gestor;
    }

    public void setIs_gestor(Boolean is_gestor) {
        this.is_gestor = is_gestor;
    }
}
