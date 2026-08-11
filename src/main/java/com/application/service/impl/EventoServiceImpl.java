package com.application.service.impl;

import com.application.service.EventoService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class EventoServiceImpl implements EventoService {

    private int totalConsultas = 0;

    @Override
    public Map<String, Object> convertirDolares(float dolares, float tipoCambio) {

        float cantidadDolares = dolares;
        float cambio = tipoCambio;

        float bolivianos = cantidadDolares * cambio;

        totalConsultas++;

        Map<String, Object> salida = new HashMap<>();

        salida.put("dolares", cantidadDolares);
        salida.put("tipoCambio", cambio);
        salida.put("bolivianos", bolivianos);
        salida.put("totalConsultas", totalConsultas);

        return salida;
    }
}