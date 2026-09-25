package com.acme.clean_arch.adapters.controllers;

import com.acme.clean_arch.application.useCases.UsuarioService;
import com.acme.clean_arch.core.entities.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UsuarioController {
    private final UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Usuario> criarConta(@RequestBody Usuario usuario) {
        usuarioService.criarConta(usuario);
        return ResponseEntity.ok().build();
    }

    @GetMapping("{id}")
    public ResponseEntity<Usuario> buscarUsuario(@RequestParam Integer id){
        return ResponseEntity.ok(usuarioService.buscarUsuario(id));
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> buscarUsuarios(){
        return ResponseEntity.ok(usuarioService.buscarUsuarios());
    }

    @PutMapping("{id}")
    public ResponseEntity<Usuario> atualizarConta(@RequestBody Usuario usuario, @RequestParam Integer id){
        return ResponseEntity.ok(usuarioService.atualizarConta(usuario, id));
    }
}
