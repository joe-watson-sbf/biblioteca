package com.sofkau.biblioteca.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * @author JOSEPH WATZSON alias Joe Watson SBF
 * @GitHub: https://github.com/joe-watson-sbf
 * @Instagram: https://www.instagram.com/joe_watson_sbf
 * @since 23/10/2021
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResourceDTO {
    private String isbn;
    private String availabilityId;
    private String title;
    private String author;
    private String type;
    private String edition;
    private Date publicationDate;
    private String publicacionCountry;
    private String content;
    private List<AvailabilityDTO> availabilities;
}
