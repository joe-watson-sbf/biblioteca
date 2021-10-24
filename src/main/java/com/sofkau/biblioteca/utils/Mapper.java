package com.sofkau.biblioteca.utils;

import com.sofkau.biblioteca.dto.ResourceDTO;
import com.sofkau.biblioteca.model.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * @author JOSEPH WATZSON alias Joe Watson SBF
 * @GitHub: https://github.com/joe-watson-sbf
 * @Instagram: https://www.instagram.com/joe_watson_sbf
 * @since 23/10/2021
 **/

@Component
public class Mapper {

    public static Resource dtoToEntity(ResourceDTO resourceDTO){
        Resource resource = new Resource();
        BeanUtils.copyProperties(resourceDTO, resource);
        return resource;
    }

    public static ResourceDTO entityToDTO(Resource resource){
        ResourceDTO resourceDTO = new ResourceDTO();
        BeanUtils.copyProperties(resource, resourceDTO);
        return resourceDTO;
    }
}
