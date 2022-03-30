package com.sofkau.biblioteca.service;

import com.sofkau.biblioteca.dto.ResourceDTO;
import com.sofkau.biblioteca.model.Resource;
import com.sofkau.biblioteca.respository.ResourceRepository;
import com.sofkau.biblioteca.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Date;

/**
 *  @author JOSEPH WATZSON alias Joe Watson SBF
 *  @GitHub: https://github.com/joe-watson-sbf
 *  @Instagram:  https://www.instagram.com/joe_watson_sbf
 *  @since 24/10/2021
 **/

@Service
public class ResourseService {
    @Autowired
    private ResourceRepository repository;


    /**
     * Metodo para verificar si un rescurso esta disponible
     * */
    public Mono<String> checkAvailability(String id){
        return repository.findById(id)
                .filter(Resource::isOnLoan)
                .map(resource -> Mono.just("Fecha del prestamo: " + resource.getLoanDate()))
                .switchIfEmpty(Mono.empty().thenReturn(Mono.just("El recurso está disponible!")))
                .flatMap(stringMono -> stringMono);
    }

    /**
     * Metodo para crear rescurso
     * */
    public Mono<ResourceDTO> createResource(Mono<ResourceDTO> dtoMono){
        return dtoMono.map(resourceDTO -> {
            resourceDTO.setLoanDate(null); // al crear debe estar dispobible
            resourceDTO.setOnLoan(false); // la fecha del Ultimo prestamo debe ser null
            return resourceDTO;
        })
                .map(Mapper::dtoToEntity)
                .flatMap(repository::save)
                .map(Mapper::entityToDTO);
    }

    /**
     * Metodo para mostrar los recursos
     * */
    public Flux<ResourceDTO> resources(){
        return repository.findAll().map(Mapper::entityToDTO);
    }

    /**
     * Metodo para hacer un prestamo de un recurso
     * */
    public Mono<String> loanResource(String id){
        return repository.findById(id)
                .filter(resource -> !resource.isOnLoan())
                .map(resource -> {
                    resource.setOnLoan(true); // marcar lo como prestado
                    resource.setLoanDate(new Date()); // guardar la fecha del prestamo
                    return resource;
                })
                .flatMap(repository::save)
                .map(resource -> Mono.just("Recurso prestado exitosamente!"))
                .switchIfEmpty(Mono.empty().thenReturn(Mono.just("Rescurso no está disponible para prestar!")))
                .flatMap(stringMono -> stringMono);
    }

    /**
     * Metodo para consultar un recurso por tipo o categoria
     * */
    public Flux<ResourceDTO> findByCategoryAndType(String type, String category){
        return repository.findAllByTypoOrCategory(type, category).map(Mapper::entityToDTO);
    }

    /**
     * Metodo para retornar un recurso que se encuentra prestado
     * En caso contrario retorna un mensaje texto
     * */
    public Mono<Object> loanedResource(String id){
        return repository.findById(id)
                .map(resource -> {
                    if(resource.isOnLoan()){
                        return Mono.just(Mapper.entityToDTO(resource));
                    }
                    return Mono.just("Recurso no se encuentra presatado!");
                })
                .flatMap(mono -> mono);
    }
}
