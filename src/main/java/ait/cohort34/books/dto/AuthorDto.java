package ait.cohort34.books.dto;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class AuthorDto {
    String name;
    LocalDate birthDate;
}
