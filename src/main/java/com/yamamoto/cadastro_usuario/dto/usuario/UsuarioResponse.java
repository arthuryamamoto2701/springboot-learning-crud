package com.yamamoto.cadastro_usuario.dto.usuario;

public record UsuarioResponse(
    Integer id,
    String nome,
    String email
) {}