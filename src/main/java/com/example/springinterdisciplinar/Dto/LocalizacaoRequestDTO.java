package com.example.springinterdisciplinar.Dto;

import jakarta.validation.constraints.Size;

public class LocalizacaoRequestDTO {

    private Long id;

    @Size(min = 2, max = 2, message = "Estado tem que ser pela sua sigla")
    private String estado;

    private String cidade;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}
