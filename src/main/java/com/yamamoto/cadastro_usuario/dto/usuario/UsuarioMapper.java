package com.yamamoto.cadastro_usuario.dto.usuario;

import com.yamamoto.cadastro_usuario.infrastructure.entitys.Usuario;

public class UsuarioMapper {
     // Converte DTO de entrada (Request) para Entity
    public static Usuario toEntity(UsuarioRequest request) {
        if (request == null) {
            return null;
        }

        return Usuario.builder()
                .nome(request.nome())
                .email(request.email())
                .build();
    }

    // Converte Entity para DTO de saída (Response)
    public static UsuarioResponse toResponse(Usuario usuario) {
        if (usuario == null) {
            return null;
        }

        return new UsuarioResponse(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail()
        );
    }
}