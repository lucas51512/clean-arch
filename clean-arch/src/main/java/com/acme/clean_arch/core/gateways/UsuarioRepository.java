package com.acme.clean_arch.core.gateways;

import com.acme.clean_arch.core.entities.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository {
    Usuario criarUsuario(Usuario usuario);
    Optional<Usuario> buscarUsuario(Integer id);
    List<Usuario> buscarUsuarios();
    Usuario atualizarUsuario(Usuario usuariio, Integer id);
}


