package com.application.service;

import com.application.dto.ProductoDto;

import java.util.List;

public interface ProductoService {
    ProductoDto guardar (ProductoDto usuarioDto);
    List<ProductoDto> listar();
}
