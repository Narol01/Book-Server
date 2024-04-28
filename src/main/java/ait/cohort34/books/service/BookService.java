package ait.cohort34.books.service;

import ait.cohort34.books.dto.AuthorDto;
import ait.cohort34.books.dto.BookDto;

public interface BookService {
    Boolean addBook(BookDto bookdto);
    BookDto findBookById(String id);
    BookDto removeBookById(String id);
    BookDto updateBookTitle(String id,String title);
    Iterable<BookDto> findBookByAuthor(String author);
    Iterable<BookDto> findBookByPublisher(String publisher);
    Iterable<AuthorDto> findBookAuthors(String id);
    Iterable<String> findPublishersByAuthor(String author);
    AuthorDto removeAuthorByName(String author);
    }
