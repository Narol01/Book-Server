package ait.cohort34.books.dao;

import ait.cohort34.books.model.Book;

import java.util.Optional;
import java.util.stream.Stream;

public interface BookRepository  {
    Stream<Book> findByPublisher_PublisherName(String publisher);

    void deleteByAuthorsName(String name);

    boolean existsById(String isbn);

    Book save(Book book);

    Optional<Book> findById(String id);

    void deleteById(String isbn);
}
