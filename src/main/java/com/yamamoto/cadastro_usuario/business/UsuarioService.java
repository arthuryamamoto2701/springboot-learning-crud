package com.yamamoto.cadastro_usuario.business;

import org.springframework.stereotype.Service;

import com.yamamoto.cadastro_usuario.infrastructure.entitys.Usuario;
import com.yamamoto.cadastro_usuario.infrastructure.repository.UsuarioRepository;

@Service
public class UsuarioService {
    
    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }





    public void salvarUsuario(Usuario usuario){
        repository.saveAndFlush(usuario);
        //salva e fecha a conexão com o banco de dados, garantindo que os dados sejam persistidos imediatamente.
    }

    public Usuario buscarUsuarioPorEmail(String email){

            return repository.findByEmail(email).orElseThrow(
                () ->   new RuntimeException("Email não encontrado")
        );
    }

    public void deletarUsuarioPorEmail(String email){
        repository.deleteByEmail(email);
    }


      public void atualizarUsuarioPorId(Integer id, Usuario usuario){
        Usuario usuarioEntity = repository.findById(id).orElseThrow(()-> 
    new RuntimeException("Usuario não encontrado"));
        Usuario usuarioAtualizado = Usuario.builder()
                .email(usuario.getEmail() != null ? usuario.getEmail() : 
                    usuarioEntity.getEmail())
                .nome(usuario.getNome() != null ? usuario.getNome() : 
                    usuarioEntity.getNome())
                .id(usuarioEntity.getId())
                .build();

        repository.saveAndFlush(usuarioAtualizado);

                // Se estou passando o id por parametro e estou buscando
                //ele por id, no meu body(parametros), eu posso não ter passado o email por exemplo, eu posso ter passado só o nome
                // e ai eu vou verificar se eu não passei o email, se eu não passei o email, eu vou pegar o email do usuarioEntity que é o usuario que eu busquei no banco de dados, e ai eu vou construir um novo usuario com os dados atualizados.
                //mesma coisa com o nome, ai eu passei so o email quero alterar so o meu email, nao quero alterar meu nome no banco de dados, por isso a validação, se o nome for diferente de nulo, eu pego o nome do meu body, se for nulo, eu pego o nome do meu usuarioEntity que é o usuario que eu busquei no banco de dados.
                //e o id é sempre igual, eu pego da entity.

    }
}

