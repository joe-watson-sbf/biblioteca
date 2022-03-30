package com.sofkau.biblioteca.service;

import com.sofkau.biblioteca.dto.ResourceDTO;
import com.sofkau.biblioteca.model.Resource;
import com.sofkau.biblioteca.respository.ResourceRepository;
import com.sofkau.biblioteca.utils.Mapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author JOSEPH WATZSON alias Joe Watson SBF
 * @GitHub: https://github.com/joe-watson-sbf
 * @Instagram: https://www.instagram.com/joe_watson_sbf
 * @since 24/10/2021
 **/

@SpringBootTest
class ResourseServiceTest {

    @MockBean
    private ResourceRepository resourceRepository;

    @Autowired
    private ResourseService service;

    @Test
    @DisplayName("RECURSO ESTA DISPONIBLE")
    void testCheckAvailability1() {

        ResourceDTO resourceDTO = generateDTO();
        var resource = Mapper.dtoToEntity(resourceDTO);

        Mockito.when(resourceRepository.findById(resourceDTO.getIsbn())).thenReturn(Mono.just(resource));
        var response = service.checkAvailability("10001").block();

        assert response != null;
        Assertions.assertEquals(response, "El recurso está disponible!");
    }

    @Test
    @DisplayName("RECURSO NO ESTA DISPONIBLE")
    void testCheckAvailability2() {

        ResourceDTO resourceDTO = generateDTO();
        resourceDTO.setOnLoan(true);
        resourceDTO.setLoanDate(new Date());

        var resource = Mapper.dtoToEntity(resourceDTO);
        Mockito.when(resourceRepository.findById(resourceDTO.getIsbn())).thenReturn(Mono.just(resource));
        var response = service.checkAvailability("10001").block();

        assert response != null;
        Assertions.assertEquals(response, "Fecha del prestamo: " + resource.getLoanDate());
    }

    @Test
    @DisplayName("CREAR UN NUEVO RECURSO")
    void testCreateResource() {

        ResourceDTO resourceDTO = generateDTO();
        var monoDTO = Mono.just(resourceDTO);

        Resource resource = Mapper.dtoToEntity(resourceDTO);
        Mockito.when(resourceRepository.save(Mockito.any())).thenReturn(Mono.just(resource));
        var response = service.createResource(monoDTO).block();

        assert response != null;
        Assertions.assertEquals(response.getIsbn(), "10001");
        Assertions.assertEquals(response.getAuthor(), "Mr Joe");
        Assertions.assertEquals(response.getCategory(), "Programmation");
        Assertions.assertEquals(response.getTypo(), "Book");
    }

    @Test
    @DisplayName("OBTENER TODOS LOS RECURSOS")
    void testResources() {
        Flux<Resource> flux = fluxData();

        Mockito.when(resourceRepository.findAll()).thenReturn(flux);
        var response = service.resources().blockLast();
        assert response != null;

        Assertions.assertEquals(response.getIsbn(), "654");
        Assertions.assertEquals(response.getAuthor(), "Miguel");
        Assertions.assertEquals(response.getCategory(), "Football");
        Assertions.assertEquals(response.getTypo(), "Revista");

    }

    @Test
    @DisplayName("PRESTAR UN RECURSO :: EXITOSO")
    void testLoanResource1() {

        ResourceDTO resourceDTO = generateDTO();
        var resource = Mapper.dtoToEntity(resourceDTO);
        var resourceToSave = Mapper.dtoToEntity(resourceDTO);

        Mockito.when(resourceRepository.findById(resource.getIsbn()))
                .thenReturn(Mono.just(resource));
        Mockito.when(resourceRepository.save(resource)).thenReturn(Mono.just(resourceToSave));
        var response = service.loanResource("10001").block();

        assert response != null;
        Assertions.assertEquals(response, "Recurso prestado exitosamente!");
    }

    @Test
    @DisplayName("PRESTAR UN RECURSO :: NO EXITOSO")
    void testLoanResource2() {

        ResourceDTO resourceDTO = generateDTO();
        resourceDTO.setOnLoan(true);
        resourceDTO.setLoanDate(new Date());

        var resource = Mapper.dtoToEntity(resourceDTO);
        var resourceToSave = Mapper.dtoToEntity(resourceDTO);

        Mockito.when(resourceRepository.findById(resource.getIsbn()))
                .thenReturn(Mono.just(resource));
        Mockito.when(resourceRepository.save(resource)).thenReturn(Mono.just(resourceToSave));
        var response = service.loanResource("10001").block();

        assert response != null;
        Assertions.assertEquals(response, "Rescurso no está disponible para prestar!");
    }

    @Test
    @DisplayName("BUSCAR RECURSO POR TIPO Y CATEGORIA")
    void testFindByCategoryAndType() {

        var dto = generateDTO();
        var resource = Mapper.dtoToEntity(dto);
        Mockito.when(resourceRepository.findAllByTypoOrCategory("Book", "Programmation"))
                .thenReturn(Flux.just(resource));

        var response = service.
                findByCategoryAndType( "Book", "Programmation").blockLast();

        assert response != null;
        Assertions.assertEquals(response.getIsbn(), "10001");
        Assertions.assertEquals(response.getAuthor(), "Mr Joe");
        Assertions.assertEquals(response.getCategory(), "Programmation");
        Assertions.assertEquals(response.getTypo(), "Book");

    }

    @Test
    @DisplayName("RECURSO PRESTADO: RETORNA UN RECURSO")
    void testLoanedResource1() {

        ResourceDTO resourceDTO = generateDTO();
        resourceDTO.setOnLoan(true);
        resourceDTO.setLoanDate(new Date());

        Mockito.when(resourceRepository.findById("10001"))
                .thenReturn(Mono.just(Mapper.dtoToEntity(resourceDTO)));
        var response = service.loanedResource("10001").block();
        assert response != null;

        var resource = (ResourceDTO) response;
        Assertions.assertEquals(resource.getIsbn(), "10001");
        Assertions.assertEquals(resource.getAuthor(), "Mr Joe");
        Assertions.assertEquals(resource.getCategory(), "Programmation");
        Assertions.assertEquals(resource.getTypo(), "Book");
    }

    @Test
    @DisplayName("RECURSO PRESTADO: RETORNA UN MENSAJE")
    void testLoanedResource2() {

        ResourceDTO resourceDTO = generateDTO();

        Mockito.when(resourceRepository.findById("10001"))
                .thenReturn(Mono.just(Mapper.dtoToEntity(resourceDTO)));
        var response = service.loanedResource("10001").block();
        assert response != null;

        Assertions.assertEquals(response, "Recurso no se encuentra presatado!");

    }








    private ResourceDTO generateDTO(){
        ResourceDTO resourceDTO = new ResourceDTO();

        resourceDTO.setIsbn("10001");
        resourceDTO.setAuthor("Mr Joe");
        resourceDTO.setCategory("Programmation");
        resourceDTO.setTypo("Book");
        resourceDTO.setOnLoan(false);
        resourceDTO.setLoanDate(null);

        return resourceDTO;
    }

    private Flux<Resource> fluxData(){
        var dto = Mapper.dtoToEntity(generateDTO());
        List<Resource> list = new ArrayList<>();
        dto.setLoanDate(new Date());
        dto.setIsbn("987");
        dto.setAuthor("Raul");
        // 1° data
        list.add(dto);
        dto.setLoanDate(new Date());
        dto.setIsbn("234");
        dto.setAuthor("Jose");
        // 2° data
        list.add(dto);
        dto.setLoanDate(new Date());
        dto.setIsbn("654");
        dto.setAuthor("Miguel");
        dto.setTypo("Revista");
        dto.setCategory("Football");
        // 3° data
        list.add(dto);

        var mono = Mono.just(list);

        return mono.flatMapMany(Flux::fromIterable)
                .log();

    }
}