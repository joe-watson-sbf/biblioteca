package com.sofkau.biblioteca.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;



/**
 *  @author JOSEPH WATZSON alias Joe Watson SBF
 *  @GitHub: https://github.com/joe-watson-sbf
 *  @Instagram:  https://www.instagram.com/joe_watson_sbf
 *  @since 23/10/2021
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Resource {
    @Id
    private String isbn;
    private String title;
    private String author;
    private String typo;
    private String category;
    private Date loanDate;
    private boolean onLoan;

}
