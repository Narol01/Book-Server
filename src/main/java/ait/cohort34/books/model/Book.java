package ait.cohort34.books.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of="isbn")
@Entity
@Table(name = "books")
public class Book {
    @Id
    @Column(name = "isbn")
    String isbn;
    @Column(name = "title")
    String title;
    @ManyToMany
    @JoinTable(
            name = "book_authors",
            joinColumns = @JoinColumn(name = "book_isbn"),
            inverseJoinColumns = @JoinColumn(name="authors_name")
    )
    Set<Author> authors;
    @ManyToOne
    Publisher publisher;
}
