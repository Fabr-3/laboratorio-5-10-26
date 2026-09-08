package com.application.service;

import com.application.dto.ProductoDto;

import java.util.List;

public interface ProductoService {
    ProductoDto guardar(ProductoDto productoDto);
    List<ProductoDto> listar();
    ProductoDto actualizar(Long id, ProductoDto productoDto);
    void eliminar(Long id);
}