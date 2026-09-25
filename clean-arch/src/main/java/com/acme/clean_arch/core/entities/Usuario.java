package com.acme.clean_arch.core.entities;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Usuario {
    private Integer id;
    private String nome;
    private String email;
    private String senha;
}
