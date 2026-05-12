package com.yamamoto.cadastro_usuario.business;

import org.springframework.stereotype.Service;

import com.yamamoto.cadastro_usuario.dto.usuario.UsuarioRequest;
import com.yamamoto.cadastro_usuario.dto.usuario.UsuarioResponse;
import com.yamamoto.cadastro_usuario.infrastructure.entitys.Usuario;
import com.yamamoto.cadastro_usuario.infrastructure.repository.UsuarioRepository;
import com.yamamoto.cadastro_usuario.mapper.UsuarioMapper;

@Service
public class UsuarioService {
    
    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public UsuarioResponse salvarUsuario(UsuarioRequest request){
        Usuario usuario = UsuarioMapper.toEntity(request);

        repository.saveAndFlush(usuario);

        return UsuarioMapper.toResponse(usuario);
    }

    public UsuarioResponse buscarUsuarioPorEmail(String email){
        Usuario usuario = repository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Email não encontrado"));

        return UsuarioMapper.toResponse(usuario);
    }

    public void deletarUsuarioPorEmail(String email){
        repository.deleteByEmail(email);
    }

    public UsuarioResponse atualizarUsuarioPorId(Integer id, UsuarioRequest request){
        Usuario usuarioEntity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario não encontrado"));

        Usuario usuarioAtualizado = Usuario.builder()
                .id(usuarioEntity.getId())
                .email(request.email() != null ? request.email() : usuarioEntity.getEmail())
                .nome(request.nome() != null ? request.nome() : usuarioEntity.getNome())
                .build();

                // Se estou passando o id por parametro e estou buscando
                //ele por id, no meu body(parametros), eu posso não ter passado o email por exemplo, eu posso ter passado só o nome
                // e ai eu vou verificar se eu não passei o email, se eu não passei o email, eu vou pegar o email do usuarioEntity que é o usuario que eu busquei no banco de dados, e ai eu vou construir um novo usuario com os dados atualizados.
                //mesma coisa com o nome, ai eu passei so o email quero alterar so o meu email, nao quero alterar meu nome no banco de dados, por isso a validação, se o nome for diferente de nulo, eu pego o nome do meu body, se for nulo, eu pego o nome do meu usuarioEntity que é o usuario que eu busquei no banco de dados.
                //e o id é sempre igual, eu pego da entity.

        repository.saveAndFlush(usuarioAtualizado);

        return UsuarioMapper.toResponse(usuarioAtualizado);
    }
}