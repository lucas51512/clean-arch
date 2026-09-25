package com.acme.clean_arch.adapters.controllers;

import com.acme.clean_arch.adapters.dtos.usuario.UsuarioControllerMapper;
import com.acme.clean_arch.adapters.dtos.usuario.UsuarioRequest;
import com.acme.clean_arch.adapters.dtos.usuario.UsuarioResponse;
import com.acme.clean_arch.application.useCases.UsuarioService;
import com.acme.clean_arch.core.entities.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UsuarioController {
    private final UsuarioService usuarioService;
    private final UsuarioControllerMapper mapper;

    @PostMapping
    public ResponseEntity<UsuarioResponse> criarConta(@RequestBody UsuarioRequest request) {
        var usuarioDomain = mapper.toDomain(request);
        var usuarioSalvo = usuarioService.criarConta(usuarioDomain);
        return ResponseEntity.ok(mapper.toResponse(usuarioSalvo));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponse> buscarUsuario(@RequestParam Integer id){
        var usuario = usuarioService.buscarUsuario(id);
        return ResponseEntity.ok(mapper.toResponse(usuario));
    }

    @GetMapping
    public ResponseEntity<List<UsuarioResponse>> buscarUsuarios(){
        List<UsuarioResponse> respostas = usuarioService.buscarUsuarios().stream().map(mapper::toResponse).collect(Collectors.toList());
        return ResponseEntity.ok(respostas);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponse> atualizarConta(@RequestBody UsuarioRequest request,
                                                  @RequestParam Integer id){
       var usuarioDomain = mapper.toDomain(request);
       var usuarioAtualizado = usuarioService.atualizarConta(usuarioDomain, id);
       return ResponseEntity.ok(mapper.toResponse(usuarioAtualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> apagarConta(@RequestParam Integer id) {
        usuarioService.apagarConta(id);
        return ResponseEntity.ok().build();
    }
}
