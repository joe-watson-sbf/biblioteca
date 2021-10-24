package com.sofkau.biblioteca.api;


import com.sofkau.biblioteca.dto.ResourceDTO;
import com.sofkau.biblioteca.service.ResourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 *  @author JOSEPH WATZSON alias Joe Watson SBF
 *  @GitHub: https://github.com/joe-watson-sbf
 *  @Instagram:  https://www.instagram.com/joe_watson_sbf
 *  @since 23/10/2021
 **/


@RestController
@RequestMapping("api/library")
public class ResourceRouter {

    @Autowired
    private ResourseService service;

    @GetMapping
    public Flux<ResourceDTO> findAllResource(){
        return service.resources();
    }

    @GetMapping("/model")
    public Mono<ResourceDTO> model(){
        return Mono.just(new ResourceDTO());
    }

    @PostMapping
    public Mono<ResourceDTO> createResource(@RequestBody Mono<ResourceDTO> resourceDTO){
        return service.createResource(resourceDTO);
    }

    @GetMapping("/availability/{id}")
    public Mono<String> getAvailability(@PathVariable String id){
        return service.checkAvailability(id);
    }
}
