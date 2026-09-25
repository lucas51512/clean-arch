package com.acme.clean_arch.adapters.dtos.usuario;

public record UsuarioResponse(
        Integer id,
        String nome,
        String email
) {}
