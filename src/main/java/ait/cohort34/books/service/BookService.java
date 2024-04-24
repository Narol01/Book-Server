package ait.cohort34.books.service;

import ait.cohort34.books.dto.AuthorDto;
import ait.cohort34.books.dto.BookDto;
import ait.cohort34.books.dto.PublisherDto;
import org.springframework.stereotype.Service;

public interface BookService {
    Boolean addBook(BookDto bookdto);

    BookDto findBookById(Integer id);
    BookDto removeBookById(Integer id);
    BookDto updateBookTitle(Integer id,String title);
    Iterable<BookDto> findBookByAuthor(String author);
    Iterable<BookDto> findBookByPublisher(String publisher);
    Iterable<AuthorDto> findBookAuthors(Integer id);
    Iterable<PublisherDto> findPublishersByAuthor(String author);
    AuthorDto removeAuthorByName(String author);
    }
