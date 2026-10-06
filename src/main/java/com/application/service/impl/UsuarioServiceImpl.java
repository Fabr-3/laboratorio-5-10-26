package com.application.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.dto.UsuarioDto;
import com.application.service.UsuarioService;
import com.domain.Usuario;
import com.infrastructure.persistence.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UsuarioDto guardar (UsuarioDto usuarioDto){
        Usuario usuario = new Usuario();
        // validacion
        usuario.setNombre(usuarioDto.getNombre());
        usuario.setEmail(usuarioDto.getEmail());
        Usuario guardado = usuarioRepository.save(usuario);
        return new UsuarioDto(guardado);
    }

    @Override
    public List<UsuarioDto> listar(){
        // Llamamos al método que ya filtra los registros en la base de datos
        return usuarioRepository.findByEliminadoFalse()
                .stream()
                .map(UsuarioDto::new)
                .collect(Collectors.toList());
    }
}