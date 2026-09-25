package com.acme.clean_arch.core.useCases;

import com.acme.clean_arch.core.entities.Usuario;

import java.util.Optional;

public interface CriarContaUseCase {
    Usuario criarConta(Usuario usuario);
    Usuario atualizarConta(Usuario usuario, Integer id);
    void apagarConta(Integer id);
}
