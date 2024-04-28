package ait.cohort34.books.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="name")
@Setter
@Entity
@Table(name="author")
@ToString
public class Author {
    @Id
    @Column(name = "name")
String name;
    @Column(name = "birth_date")
    LocalDate birthDate;
    @ManyToMany(mappedBy = "authors",cascade = CascadeType.REMOVE)
    Set<Book> books;
    public Author(String authorsName, LocalDate birthDate) {
        this.name = authorsName;
        this.birthDate = birthDate;
    }
}
