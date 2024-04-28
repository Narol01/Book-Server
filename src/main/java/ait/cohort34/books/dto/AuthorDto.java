package ait.cohort34.books.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@EqualsAndHashCode(of="name")
public class AuthorDto {

    String name;
    LocalDate birthDate;
}
