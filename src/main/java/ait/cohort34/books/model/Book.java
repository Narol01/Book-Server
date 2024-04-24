package ait.cohort34.books.model;

import ait.cohort34.books.dto.AuthorDto;
import jakarta.persistence.*;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of="isbn")
@Entity
@Table(name="books")
@Inheritance(strategy= InheritanceType.JOINED)
public class Book {
    @Id
    int isbn;
    @Setter
    String title;
    String authors;
    Author author;
    String publisher;
}
