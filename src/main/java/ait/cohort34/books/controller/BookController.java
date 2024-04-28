package ait.cohort34.books.controller;

import ait.cohort34.books.dto.AuthorDto;
import ait.cohort34.books.dto.BookDto;
import ait.cohort34.books.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class BookController  {
final BookService bookService;

    @PostMapping("/book")
    public Boolean addBook(@RequestBody BookDto bookdto) {
        return bookService.addBook(bookdto);
    }
    @GetMapping("/book/{isbn}")
    public BookDto findBookById(@PathVariable String isbn) {
        return bookService.findBookById(isbn);
    }
    @DeleteMapping("/book/{isbn}")
    public BookDto removeBookById(@PathVariable String isbn) {
        return bookService.removeBookById(isbn);
    }
    @PutMapping("/book/{isbn}/title/{title}")
    public BookDto updateBookTitle(@PathVariable String isbn,@PathVariable String title) {
        return bookService.updateBookTitle(isbn, title);
    }
    @GetMapping("/books/author/{author}")
    public Iterable<BookDto> findBookByAuthor(@PathVariable String author) {
        return bookService.findBookByAuthor(author);
    }
    @GetMapping("/books/publisher/{publisher}")
    public Iterable<BookDto> findBookByPublisher(@PathVariable String publisher) {
        return bookService.findBookByPublisher(publisher);
    }
    @GetMapping("/authors/book/{isbn}")
    public Iterable<AuthorDto> findBookAuthors(@PathVariable String isbn) {
        return bookService.findBookAuthors(isbn);
    }
    @GetMapping("/publishers/author/{author}")
    public Iterable<String> findPublishersByAuthor(@PathVariable String author) {
        return bookService.findPublishersByAuthor(author);
    }
    @DeleteMapping("/author/{author}")
    public AuthorDto removeAuthorByName(@PathVariable String author) {
        return bookService.removeAuthorByName(author);
    }
}
