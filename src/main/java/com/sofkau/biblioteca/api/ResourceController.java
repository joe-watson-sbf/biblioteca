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
public class ResourceController {

    @Autowired
    private ResourseService service;

    @GetMapping
    public Flux<ResourceDTO> findAllResource(){
        return service.resources();
    }

    @GetMapping("/search")
    public Flux<ResourceDTO> searchByTypeAndCategory(@RequestParam("type") String type,
                                                     @RequestParam("category") String category){
        return service.findByCategoryAndType(type, category);
    }

    @GetMapping("/search/{id}")
    public Mono<Object> getLoanedResource(@PathVariable String id){
        return service.loanedResource(id);
    }

    @PostMapping
    public Mono<ResourceDTO> createResource(@RequestBody Mono<ResourceDTO> resourceDTO){
        return service.createResource(resourceDTO);
    }

    @GetMapping("/availability/{id}")
    public Mono<String> getAvailability(@PathVariable String id){
        return service.checkAvailability(id);
    }

    @PostMapping("/loan/{id}")
    public Mono<String> loanResource(@PathVariable String id){
        return service.loanResource(id);
    }
}
