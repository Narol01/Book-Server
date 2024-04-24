package ait.cohort34.books.controller;

import ait.cohort34.books.dto.AuthorDto;
import ait.cohort34.books.dto.BookDto;
import ait.cohort34.books.dto.PublisherDto;
import ait.cohort34.books.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class BookController  {
final BookService bookService;

    @PostMapping("/book")
    public Boolean addBook(@RequestBody BookDto bookdto) {
        return null;
    }
    @GetMapping("/book/{id}")
    public BookDto findBookById(@PathVariable Integer id) {
        return null;
    }
    @DeleteMapping("/book/{id}")
    public BookDto removeBookById(@PathVariable Integer id) {
        return null;
    }
    @PutMapping("/book/{id}/title/{title}")
    public BookDto updateBookTitle(@PathVariable Integer id,@PathVariable String title) {
        return null;
    }
    @GetMapping("/books/author/{author}")
    public Iterable<BookDto> findBookByAuthor(@PathVariable String author) {
        return null;
    }
    @GetMapping("/books/publisher/{publisher}")
    public Iterable<BookDto> findBookByPublisher(@PathVariable String publisher) {
        return null;
    }
    @GetMapping("/authors/book/{id}")
    public Iterable<AuthorDto> findBookAuthors(@PathVariable Integer id) {
        return null;
    }
    @GetMapping("/publishers/author/{author}")
    public Iterable<PublisherDto> findPublishersByAuthor(@PathVariable String author) {
        return null;
    }
    @DeleteMapping("/author/{author}")
    public AuthorDto removeAuthorByName(@PathVariable String author) {
        return null;
    }
}
