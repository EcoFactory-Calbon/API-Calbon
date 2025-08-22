package com.example.springinterdisciplinar.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String cracha;

    public Usuario() {}

    public Usuario(String cracha) {
        this.cracha = cracha;
    }


    public Long getId() {
        return id;
    }

    public String getCracha() {
        return cracha;
    }

    public void setCracha(String cracha) {
        this.cracha = cracha;
    }

    public Usuario(Long id, String cracha) {
        this.id = id;
        this.cracha = cracha;
    }
}
