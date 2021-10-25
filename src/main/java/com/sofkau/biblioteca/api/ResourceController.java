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

    /**
     * Peticion: GET
     * URL: http://localhost:8080/api/library
     * Description: Obtener todos los recursos
     * */
    @GetMapping
    public Flux<ResourceDTO> findAllResource(){
        return service.resources();
    }

    /**
     * Peticion: GET
     * URL: http://localhost:8080/api/library/search?type=[el tipo aqui]&category=[categoria aqui]
     * Exemple: http://localhost:8080/api/library/search?type=Book&category=Programmation
     * Description: Obtener recursos por categoria o tipo
     * */
    @GetMapping("/search")
    public Flux<ResourceDTO> searchByTypeAndCategory(@RequestParam("type") String type,
                                                     @RequestParam("category") String category){
        return service.findByCategoryAndType(type, category);
    }

    /**
     * Peticion: GET
     * URL: http://localhost:8080/api/library
     * Exemple: http://localhost:8080/api/library/search/61750c9cdb45d1497be1bb3e
     * Description: Obtener un recurso prestado sino un mensaje texto
     * */
    @GetMapping("/search/{id}")
    public Mono<Object> getLoanedResource(@PathVariable String id){
        return service.loanedResource(id);
    }

    /**
     * Peticion: POST
     * URL: http://localhost:8080/api/library
     * Description: Crear un nuevo recurso
     * */
    @PostMapping
    public Mono<ResourceDTO> createResource(@RequestBody Mono<ResourceDTO> resourceDTO){
        return service.createResource(resourceDTO);
    }

    /**
     * Peticion: GET
     * URL: http://localhost:8080/api/library/availability/{recursoId}
     * Exemple: http://localhost:8080/api/library/availability/617508c6be546732aba73338
     * Description: Verifique si un recurso se encuentra disponible
     * */
    @GetMapping("/availability/{id}")
    public Mono<String> getAvailability(@PathVariable String id){
        return service.checkAvailability(id);
    }

    /**
     * Peticion: POST
     * URL: http://localhost:8080/api/library/loan/{recursoId}
     * Exemple: http://localhost:8080/api/library/loan/617508c6be546732aba73338
     * Description: Hacer prestamo de un recurso
     * */
    @PostMapping("/loan/{id}")
    public Mono<String> loanResource(@PathVariable String id){
        return service.loanResource(id);
    }
}
