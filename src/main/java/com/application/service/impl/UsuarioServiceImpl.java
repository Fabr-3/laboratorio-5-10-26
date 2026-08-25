package com.application.service.impl;

import com.application.dto.UsuarioDto;
import com.application.service.UsuarioService;
import com.domain.Usuario;
import com.infrastructure.persistence.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
       Usuario guardado =  usuarioRepository.save(usuario);
        return new UsuarioDto(guardado.getId(), guardado.getNombre(),guardado.getEmail());
    }

    @Override
    public List<UsuarioDto> listar(){
        return usuarioRepository.findAll()
                .stream()
                .map(u -> new UsuarioDto(u.getId(),u.getNombre(), u.getEmail()))
                .collect(Collectors.toList());

    }
    

}
