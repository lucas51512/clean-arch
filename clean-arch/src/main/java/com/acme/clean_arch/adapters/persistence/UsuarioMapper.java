package com.acme.clean_arch.adapters.persistence;

import com.acme.clean_arch.core.entities.Usuario;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
    Usuario toDomain(UsuarioEntity entity);
    UsuarioEntity toEntity(Usuario usuario);

    @Mapping(target = "id", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void atualizarEntityFromDomain(Usuario origem, @MappingTarget UsuarioEntity destino);
}
