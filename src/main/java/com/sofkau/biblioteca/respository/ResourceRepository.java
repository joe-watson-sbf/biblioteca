package com.sofkau.biblioteca.respository;

import com.sofkau.biblioteca.model.Resource;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

/**
 * @author JOSEPH WATZSON alias Joe Watson SBF
 * @GitHub: https://github.com/joe-watson-sbf
 * @Instagram: https://www.instagram.com/joe_watson_sbf
 * @since 23/10/2021
 **/
@Repository
public interface ResourceRepository extends ReactiveCrudRepository<Resource,String> {
    Flux<Resource> findAllByTypoOrCategory(String type, String category);
}
