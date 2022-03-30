package com.joedev.movimiento.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

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
