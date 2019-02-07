package com.kasiyanov.week6.practicespringboot.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {

    private Long id;
    private String name;
    private Integer creationYear;
    private String genre;
    private String author;

}
