package com.acme.clean_arch.adapters.dtos.usuario;

import com.acme.clean_arch.core.entities.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioControllerMapper {
    public Usuario toDomain(UsuarioRequest request) {
        return new Usuario(null, request.nome(), request.email(), request.senha());
    }

    public UsuarioResponse toResponse(Usuario usuario) {
        return new UsuarioResponse(usuario.getId(), usuario.getNome(), usuario.getEmail());
    }
}
