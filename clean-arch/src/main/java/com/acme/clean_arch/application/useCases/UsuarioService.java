package com.acme.clean_arch.application.useCases;

import com.acme.clean_arch.core.gateways.UsuarioRepository;
import com.acme.clean_arch.core.entities.Usuario;
import com.acme.clean_arch.core.useCases.CriarContaUseCase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService implements CriarContaUseCase {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario criarConta(Usuario usuario){
        return usuarioRepository.criarUsuario(usuario);
    }

    public Usuario buscarUsuario(Integer id){
        return usuarioRepository.buscarUsuario(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

    public List<Usuario> buscarUsuarios(){
        return usuarioRepository.buscarUsuarios();
    }

    public Usuario atualizarConta(Usuario usuario, Integer id){
        return usuarioRepository.atualizarUsuario(usuario, id);
    }

    public void apagarConta(Integer id){
        usuarioRepository.apagarUsuario(id);
    }
}
