package com.acme.clean_arch.adapters.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataUsuarioRepository extends JpaRepository<UsuarioEntity, Integer> {
}
