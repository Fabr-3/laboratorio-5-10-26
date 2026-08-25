package com.application.service;

import com.application.dto.UsuarioDto;

import java.util.List;

public interface UsuarioService {
    UsuarioDto guardar (UsuarioDto usuarioDto);
    List<UsuarioDto> listar();
}
