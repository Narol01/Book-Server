package ait.cohort34.books.dao;

import ait.cohort34.books.model.Book;
import ait.cohort34.books.model.Publisher;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class PublisherRepositoryImpl implements PublisherRepository {
@PersistenceContext
    EntityManager em;
    @Override
    public List<String> findByPublishersAuthors(String authorName) {
        String jpql = "select distinct p.publisherName from Book b join b.publisher p join b.authors a where a.name=:authorName";
        return em.createQuery(jpql, String.class).setParameter("authorName",authorName).getResultList();
    }

    @Override
    public Optional<Publisher> findById(String publisher) {
        return Optional.ofNullable(em.find(Publisher.class,publisher));
    }

    @Override
    public Publisher save(Publisher publisher) {
        em.persist(publisher);
        return publisher;
    }
}
