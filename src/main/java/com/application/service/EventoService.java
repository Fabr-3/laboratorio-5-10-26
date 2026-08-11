package com.application.service;

import java.util.Map;

public interface EventoService {
    Map<String, Object> convertirDolares(float dolares, float tipoCambio);

}