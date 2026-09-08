package com.infrastructure.web.controller;

import com.application.dto.ProductoDto;
import com.application.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    @PostMapping
    public ResponseEntity<ProductoDto> guardarProducto(@RequestBody ProductoDto productoDto) {
        ProductoDto producto = productoService.guardar(productoDto);
        return ResponseEntity.ok(producto);
    }

    @GetMapping
    public ResponseEntity<List<ProductoDto>> listarProductos() {
        return ResponseEntity.ok(productoService.listar());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductoDto> actualizarProducto(@PathVariable Long id, @RequestBody ProductoDto productoDto) {
        ProductoDto actualizado = productoService.actualizar(id, productoDto);
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Long id) {
        productoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}