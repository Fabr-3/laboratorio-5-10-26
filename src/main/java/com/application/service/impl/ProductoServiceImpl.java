package com.application.service.impl;

import com.application.dto.ProductoDto;
import com.application.service.ProductoService;
import com.domain.Producto;
import com.infrastructure.persistence.ProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductoServiceImpl implements ProductoService {
    private final ProductoRepository productoRepository;

    @Override
    public ProductoDto guardar(ProductoDto productoDto) {
        Producto producto = new Producto();
        producto.setNombre(productoDto.getNombre());
        producto.setMarca(productoDto.getMarca());
        Producto guardado = productoRepository.save(producto);
        return new ProductoDto(guardado.getId(), guardado.getNombre(), guardado.getMarca());
    }

    @Override
    public List<ProductoDto> listar() {
        return productoRepository.findAll()
                .stream()
                .map(p -> new ProductoDto(p.getId(), p.getNombre(), p.getMarca()))
                .collect(Collectors.toList());
    }

    public List<ProductoDto> listarPorMarca(String marca) {
        return productoRepository.findAll()
            .stream()
            .filter(p -> marca == null || marca.equals(p.getMarca()))
            .map(p -> new ProductoDto(p.getId(), p.getNombre(), p.getMarca()))
            .collect(Collectors.toList());
    }

    @Override
    public ProductoDto actualizar(Long id, ProductoDto productoDto) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con id: " + id));

        producto.setNombre(productoDto.getNombre());
        producto.setMarca(productoDto.getMarca());

        Producto actualizado = productoRepository.save(producto);
        return new ProductoDto(actualizado.getId(), actualizado.getNombre(), actualizado.getMarca());
    }

    @Override
    public void eliminar(Long id) {
        if (!productoRepository.existsById(id)) {
            throw new RuntimeException("Producto no encontrado con id: " + id);
        }
        productoRepository.deleteById(id);
    }
}