package com.yamamoto.cadastro_usuario.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yamamoto.cadastro_usuario.business.UsuarioService;
import com.yamamoto.cadastro_usuario.dto.usuario.UsuarioRequest;
import com.yamamoto.cadastro_usuario.dto.usuario.UsuarioResponse;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UsuarioController {
    
    private final UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<UsuarioResponse> salvarUsuario(
            @Valid @RequestBody UsuarioRequest request){
        return ResponseEntity.ok(usuarioService.salvarUsuario(request));
    }

    @GetMapping
    public ResponseEntity<UsuarioResponse> buscarUsuarioPorEmail(
            @RequestParam String email){
        return ResponseEntity.ok(usuarioService.buscarUsuarioPorEmail(email));
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarUsuarioPorEmail(
            @RequestParam String email){
        usuarioService.deletarUsuarioPorEmail(email);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<UsuarioResponse> atualizarUsuarioPorId(
            @RequestParam Integer id,
            @Valid @RequestBody UsuarioRequest request){
        return ResponseEntity.ok(usuarioService.atualizarUsuarioPorId(id, request));
    }
}