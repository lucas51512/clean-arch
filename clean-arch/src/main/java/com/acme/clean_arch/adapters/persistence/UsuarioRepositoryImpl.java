package com.acme.clean_arch.adapters.persistence;

import com.acme.clean_arch.core.entities.Usuario;
import com.acme.clean_arch.core.gateways.UsuarioRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class UsuarioRepositoryImpl implements UsuarioRepository {
    private final SpringDataUsuarioRepository springDataUsuarioRepository;
    private final UsuarioMapper mapper;

    public UsuarioRepositoryImpl(SpringDataUsuarioRepository springDataUsuarioRepository, UsuarioMapper mapper){
        this.springDataUsuarioRepository = springDataUsuarioRepository;
        this.mapper = mapper;
    }

    @Override
    public Usuario criarUsuario(Usuario usuario){
        UsuarioEntity entity = mapper.toEntity(usuario);
        UsuarioEntity savedEntity = springDataUsuarioRepository.save(entity);

        return mapper.toDomain(savedEntity);
    }

    @Override
    public Optional<Usuario> buscarUsuario(Integer id) {

        return springDataUsuarioRepository.findById(id).map(mapper::toDomain);
    }

    @Override
    public List<Usuario> buscarUsuarios() {
        return springDataUsuarioRepository.findAll().stream().map(mapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public Usuario atualizarUsuario(Usuario usuarioAtualizado, Integer id) {
        UsuarioEntity entityExistente = springDataUsuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado com o ID informado"));
        mapper.atualizarEntityFromDomain(usuarioAtualizado, entityExistente);

        UsuarioEntity entitySalva = springDataUsuarioRepository.save(entityExistente);
        return mapper.toDomain(entitySalva);
    }
}
