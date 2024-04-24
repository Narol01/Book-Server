package ait.cohort34.books.dto;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class BookDto {
    int isbn;
    String title;
    String authors;
    AuthorDto author;
    String publisher;
}

