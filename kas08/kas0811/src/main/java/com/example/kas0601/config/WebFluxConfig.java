package com.example.kas0601.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebFluxConfig implements WebFluxConfigurer {
    Logger logger = LoggerFactory.getLogger(WebFluxConfig.class);

    @Bean
    public WebClient getWebClient() {
        return WebClient.builder()
                .baseUrl("https://api.frankfurter.app")//Hemos creado una instancia de una clase que nos permite hacer peticiones a una API REST
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }
}