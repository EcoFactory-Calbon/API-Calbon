package com.example.springinterdisciplinar.Dto;

import jakarta.validation.constraints.NotNull;

public class UsuarioRequestDTO {

    private Long id;

    @NotNull(message = "Cracha não pode ser vazio!")
    private String cracha;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotNull(message = "Cracha não pode ser vazio!") String getCracha() {
        return cracha;
    }

    public void setCracha(@NotNull(message = "Cracha não pode ser vazio!") String cracha) {
        this.cracha = cracha;
    }
}
