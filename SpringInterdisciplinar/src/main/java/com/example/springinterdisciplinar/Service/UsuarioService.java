package com.example.springinterdisciplinar.Service;

import com.example.springinterdisciplinar.Exception.AdminNaoEncontradoException;
import com.example.springinterdisciplinar.Exception.UsuarioNaoEncontradoException;
import com.example.springinterdisciplinar.Model.Admin;
import com.example.springinterdisciplinar.Model.Usuario;
import com.example.springinterdisciplinar.Repository.UsuarioRepository;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> listar(){
        return usuarioRepository.findAll();
    }

    public Usuario inserirUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void excluirUsuario(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNaoEncontradoException("usuario "+ id +" não encontrado"));
        usuarioRepository.delete(usuario);
    }

}
