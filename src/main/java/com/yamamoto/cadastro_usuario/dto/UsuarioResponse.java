package com.yamamoto.cadastro_usuario.dto;

public record UsuarioResponse(
    Integer id,
    String nome,
    String email
) {}