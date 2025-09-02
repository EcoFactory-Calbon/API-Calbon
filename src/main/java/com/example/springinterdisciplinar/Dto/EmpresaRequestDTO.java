package com.example.springinterdisciplinar.Dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;

public class EmpresaRequestDTO {

    @Column(name = "id_empresa")
    private Long id;

    @NotNull(message = "Nome não pode ser nulo")
    private String nome;

    private Long id_localizacao;

    private Long id_categoria_empresa;

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

    public Long getId_localizacao() {
        return id_localizacao;
    }

    public void setId_localizacao(Long id_localizacao) {
        this.id_localizacao = id_localizacao;
    }

    public Long getId_categoria_empresa() {
        return id_categoria_empresa;
    }

    public void setId_categoria_empresa(Long id_categoria_empresa) {
        this.id_categoria_empresa = id_categoria_empresa;
    }
}
