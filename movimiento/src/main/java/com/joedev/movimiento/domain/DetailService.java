package com.joedev.movimiento.domain;

import com.joedev.movimiento.dto.ResourceDTO;
import com.joedev.movimiento.restClient.BibliotecaRestClient;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@AllArgsConstructor
@NoArgsConstructor

public class DetailService {

    @Autowired
    private BibliotecaRestClient restClient; // INTERFACE TO CONSUME THE OTHER MICROSERVICE SERVICE

    public Flux<ResourceDTO> findAllRessource(){
        return restClient.ListOfRessource();
    }

}
