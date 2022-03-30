package com.joedev.movimiento.api;

import com.joedev.movimiento.domain.DetailService;
import com.joedev.movimiento.dto.ResourceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("api/library/operation")
public class DetailController {

    @Autowired
    private DetailService service;

    @GetMapping("/all")
    public Flux<ResourceDTO> getAll(){
        return service.findAllRessource();
    }
}
