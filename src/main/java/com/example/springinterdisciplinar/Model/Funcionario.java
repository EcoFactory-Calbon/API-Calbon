package com.example.springinterdisciplinar.Model;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


@Entity
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;

    private String sobrenome;

    private String email;

    private String senha;

    private String numero_cracha;

    private Long id_cargo;

    private Long id_localizacao;

    private Boolean is_gestor;

    public Funcionario() {}

    public Funcionario(Long id, String nome, String sobrenome, String email, String senha, String numero_cracha, Long id_cargo, Long id_localizacao, Boolean is_gestor) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.senha = senha;
        this.numero_cracha = numero_cracha;
        this.id_cargo = id_cargo;
        this.id_localizacao = id_localizacao;
        this.is_gestor = is_gestor;
    }


    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public String getNumero_cracha() {
        return numero_cracha;
    }

    public Long getId_cargo() {
        return id_cargo;
    }

    public Long getId_localizacao() {
        return id_localizacao;
    }

    public Boolean getIs_gestor() {
        return is_gestor;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setNumero_cracha(String numero_cracha) {
        this.numero_cracha = numero_cracha;
    }

    public void setId_cargo(Long id_cargo) {
        this.id_cargo = id_cargo;
    }

    public void setId_localizacao(Long id_localizacao) {
        this.id_localizacao = id_localizacao;
    }

    public void setIs_gestor(Boolean is_gestor) {
        this.is_gestor = is_gestor;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", numero_cracha='" + numero_cracha + '\'' +
                ", id_cargo=" + id_cargo +
                ", id_localizacao=" + id_localizacao +
                ", is_gestor="+ is_gestor +
                '}';
    }
}
