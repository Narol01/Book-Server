package ait.cohort34.books.dao;

import ait.cohort34.books.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PublisherRepository  {
    @Query ("select distinct p.publisherName from Book b join b.publisher p join b.authors a where a.name=?1")
    List<String> findByPublishersAuthors(String authorName);

    Optional<Publisher>  findById(String publisher);

    Publisher save(Publisher publisher);
}
