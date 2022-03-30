package com.joedev.movimiento.restClient;

import com.joedev.movimiento.dto.ResourceDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import reactivefeign.spring.config.ReactiveFeignClient;
import reactor.core.publisher.Flux;

/**
 *  @author JOSEPH WATZSON alias Joe Watson SBF
 *  @GitHub: https://github.com/joe-watson-sbf
 *  @Instagram:  https://www.instagram.com/joe_watson_sbf
 *  @since 5/3/2021
 **/

@Component
@ReactiveFeignClient(name = "com.sofkau.biblioteca.service", url = "http://localhost:8080/api/library")
public interface BibliotecaRestClient {
    @GetMapping
    Flux<ResourceDTO> ListOfRessource();
}
