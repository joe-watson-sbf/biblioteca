package com.sofkau.biblioteca.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

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
    private String title;
    private String author;
    private String typo;
    private String category;
    private Date loanDate;
    private boolean onLoan;
}
