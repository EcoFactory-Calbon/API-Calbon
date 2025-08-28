package com.example.springinterdisciplinar.Dto;

public class UsuarioResponseDTO {
    private Long id;

    private String cracha;

    public UsuarioResponseDTO() {};

    public UsuarioResponseDTO(Long id ,String cracha) {
        this.id = id;
        this.cracha = cracha;
    };
    public Long getId() {
        return id;
    }

    public String getCracha() {
        return cracha;
    }
    public void setCracha(String cracha) {
        this.cracha = cracha;
    }
}
