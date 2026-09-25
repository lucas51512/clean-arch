package com.acme.clean_arch.adapters.dtos.usuario;

public record UsuarioRequest(
        String nome,
        String email,
        String senha
) {}
