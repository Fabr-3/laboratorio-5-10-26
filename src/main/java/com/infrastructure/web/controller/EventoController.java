package com.infrastructure.web.controller;

import com.application.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tools.jackson.databind.JsonNode;

import java.util.Map;

@RestController
@RequestMapping("/api/evento")
public class EventoController {

    @Autowired
    private EventoService eventoService;

    @PostMapping("/convertir")
    public Map<String, Object> convertir(@RequestBody JsonNode entrada) {

        float dolares = entrada.get("dolares").floatValue();
        float tipoCambio = entrada.get("tipoCambio").floatValue();

        return eventoService.convertirDolares(
                dolares,
                tipoCambio
        );
    }
}