package ait.cohort34.books.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of="publisherName")
@Entity
@Table(name="publisher")
public class Publisher {
    @Id
    @Column(name = "publisher_name")
    String publisherName;
    @OneToMany(mappedBy = "publisher")
    Set<Book> books;

    public Publisher(String publisherName) {
        this.publisherName = publisherName;
    }

    @Override
    public String toString() {
        return publisherName;
    }
}
