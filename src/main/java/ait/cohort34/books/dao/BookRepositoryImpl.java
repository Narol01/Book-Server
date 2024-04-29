package ait.cohort34.books.dao;

import ait.cohort34.books.model.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import java.util.Optional;

import java.util.stream.Stream;
@Repository
public class BookRepositoryImpl implements BookRepository {

    @PersistenceContext
    EntityManager em;
    @Override
    public Stream<Book> findByPublisher_PublisherName(String publisher) {
        String jpql = "select distinct p.publisherName from Book b join b.publisher p join b.authors a where a.name=:publisher";
        return em.createQuery(jpql, Book.class).setParameter("publisher",publisher).getResultStream();
    }

    @Override
    public void deleteByAuthorsName(String name) {
    em.createQuery("delete from Book b where?1 member of b.authors")
        .setParameter(1,name)
            .executeUpdate();
    }

    @Override
    public boolean existsById(String isbn) {
        return em.find(Book.class, isbn) != null;
    }

    @Override
    public Book save(Book book) {
         em.persist(book);
        return book;
    }

    @Override
    public Optional<Book> findById(String id) {
        return Optional.ofNullable(em.find(Book.class, id));
    }

    @Override
    public void deleteById(String isbn) {
        em.remove(em.find(Book.class,isbn));
    }
}
