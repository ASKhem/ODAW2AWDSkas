package com.example.kas0601.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.kas0601.dto.CambioData;

import reactor.core.publisher.Mono;

@Service
public class CambioService {
    @Autowired
    public WebClient webClient;

    public Double calcularImporteCambiado(Double importe ,String monedaOrigen, String monedaDestino) {
        CambioData cambioData = obtenerTasaCambio(monedaOrigen, monedaDestino).block();
        Double tasaCambio = cambioData.getRates().get(monedaDestino);
        return importe * tasaCambio;
    }

    public Mono<CambioData> obtenerTasaCambio(String monedaOrigen, String monedaDestino) throws RuntimeException {
        String url = "https://api.frankfurter.app/latest?from=" +monedaOrigen +"&to="+ monedaDestino;
        return webClient.get()
            .uri(url)
            .retrieve()
            .bodyToMono(CambioData.class);
    }
}
