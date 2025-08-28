    package com.example.springinterdisciplinar.Service;

    import com.example.springinterdisciplinar.Dto.AdminRequestDTO;
    import com.example.springinterdisciplinar.Dto.AdminResponseDTO;
    import com.example.springinterdisciplinar.Dto.UsuarioRequestDTO;
    import com.example.springinterdisciplinar.Dto.UsuarioResponseDTO;
    import com.example.springinterdisciplinar.Exception.AdminNaoEncontradoException;
    import com.example.springinterdisciplinar.Exception.UsuarioNaoEncontradoException;
    import com.example.springinterdisciplinar.Model.Admin;
    import com.example.springinterdisciplinar.Model.Usuario;
    import com.example.springinterdisciplinar.Repository.UsuarioRepository;
    import com.fasterxml.jackson.databind.ObjectMapper;
    import jakarta.validation.Valid;
    import org.springframework.stereotype.Service;
    import java.util.List;
    import java.util.Map;
    import java.util.stream.Collectors;

    @Service
    public class UsuarioService {
        private final UsuarioRepository usuarioRepository;
        private final ObjectMapper objectMapper;



        public UsuarioService(UsuarioRepository usuarioRepository, ObjectMapper objectMapper) {
            this.usuarioRepository = usuarioRepository;
            this.objectMapper = objectMapper;
        }

        private Usuario fromRequestDTO(UsuarioRequestDTO dto){
            Usuario usuario = new Usuario();
            usuario.setCracha(dto.getCracha());
            return usuario;
        }


        private UsuarioResponseDTO toResponseDTO(Usuario usuario) {
            return new UsuarioResponseDTO(
                    usuario.getId(),
                    usuario.getCracha()
            );
        }



        public List<UsuarioResponseDTO> listar(){
            return usuarioRepository.findAll()
                    .stream()
                    .map(this::toResponseDTO)
                    .collect(Collectors.toList());
        }

        public UsuarioResponseDTO inserirUsuario(UsuarioRequestDTO dto) {
            Usuario usuario = fromRequestDTO(dto);
            Usuario salvo = usuarioRepository.save(usuario);
            return toResponseDTO(salvo);
        }

        public void excluirUsuario(Long id) {
            Usuario usuario = usuarioRepository.findById(id)
                    .orElseThrow(() -> new UsuarioNaoEncontradoException("usuario "+ id +" não encontrado"));
            usuarioRepository.delete(usuario);
        }


        public UsuarioResponseDTO atualizarUsuario(@Valid UsuarioRequestDTO usuarioAtualizado, Long id) {
            Usuario existente = usuarioRepository.findById(id)
                    .orElseThrow(() -> new UsuarioNaoEncontradoException("Usuario com o Id " + id + " não encontrado"));
            existente.setCracha(usuarioAtualizado.getCracha());
            Usuario atualizado = usuarioRepository.save(existente);
            return toResponseDTO(atualizado);

        }

    }
