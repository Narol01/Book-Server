package ait.cohort34.books.service;

import ait.cohort34.books.dao.AuthorRepository;
import ait.cohort34.books.dao.BookRepository;
import ait.cohort34.books.dao.PublisherRepository;
import ait.cohort34.books.dto.AuthorDto;
import ait.cohort34.books.dto.BookDto;
import ait.cohort34.books.dto.exception.PersonNotFoundException;
import ait.cohort34.books.model.Author;
import ait.cohort34.books.model.Book;
import ait.cohort34.books.model.Publisher;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService {
    final BookRepository bookRepository;
    final AuthorRepository authorRepository;
    final PublisherRepository publisherRepository;
    final ModelMapper modelMapper;

    @Transactional
    @Override
    public Boolean addBook(BookDto bookDto) {
        if (bookRepository.existsById(bookDto.getIsbn())) {
            return false;
        }
        Publisher publisher = publisherRepository.findById(bookDto.getPublisher())
                .orElseGet(()->publisherRepository.save(new Publisher(bookDto.getPublisher())));
        Set <Author> authors =bookDto.getAuthors().stream()
                .map(a->authorRepository.findById( a.getName()).orElseGet(()->authorRepository.save(new Author(a.getName(),a.getBirthDate()))))
                .collect(Collectors.toSet());
        Book book = new Book(bookDto.getIsbn(),bookDto.getTitle(),authors,publisher);
        bookRepository.save(book);
        return true;
    }

    @Override
    public BookDto findBookById(String id) {
        Book book = bookRepository.findById(id).orElseThrow(PersonNotFoundException::new);
        return modelMapper.map(book, BookDto.class);
    }

    @Transactional
    @Override
    public BookDto removeBookById(String id) {
        Book book = bookRepository.findById(id).orElseThrow(PersonNotFoundException::new);
        bookRepository.deleteById(id);
        return modelMapper.map(book, BookDto.class);
    }
    @Transactional
    @Override
    public BookDto updateBookTitle(String id, String title) {
        Book book = bookRepository.findById(id).orElseThrow(PersonNotFoundException::new);
        book.setTitle(title);
        return modelMapper.map(book, BookDto.class);
    }

    @Override
    public Iterable<BookDto> findBookByAuthor(String author) {
        Author author1 = authorRepository.findById(author).orElseThrow(PersonNotFoundException::new);
        return author1.getBooks().stream().map(b->modelMapper.map(b, BookDto.class)).collect(Collectors.toList());
    }

    @Override
    public Iterable<BookDto> findBookByPublisher(String publisher) {
        Publisher publisher1=publisherRepository.findById(publisher).orElseThrow(PersonNotFoundException::new);
        return publisher1.getBooks().stream().map(b->modelMapper.map(b, BookDto.class)).collect(Collectors.toList());
    }

    @Override
    public Iterable<AuthorDto> findBookAuthors(String id) {
        Book book=bookRepository.findById(id).orElseThrow(PersonNotFoundException::new);
        return book.getAuthors().stream()
                .map(b->modelMapper.map(b, AuthorDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<String> findPublishersByAuthor(String author) {
        return publisherRepository.findByPublishersAuthors(author);
    }

    @Transactional(readOnly = true)
    @Override
    public AuthorDto  removeAuthorByName(String author) {
        Author author1 = authorRepository.findById(author).orElseThrow(PersonNotFoundException::new);
        bookRepository.deleteByAuthorsName(author);
        authorRepository.deleteById(author);
        return modelMapper.map(author1, AuthorDto.class);
    }
}
