package org.example.lab1springboot.book;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookService {

    private static final Logger log = LoggerFactory.getLogger(BookService.class);
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        log.info("BookService created");
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {

        return bookRepository.findAll();
    }

    public void deleteBook(Long id) {

        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        bookRepository.delete(book);
    }

    public Book getBookById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found with id: " + id));
    }
    public Book updateBook(Long id, UpdateBookDTO dto) {
        Book book = getBookById(id);
        book.setTitle(dto.getTitle());
        book.setAuthor(dto.getName());

        bookRepository.save(book);
        log.info("Book updated successfully");
        return book;
    }

    public Book createBook(CreateBookDTO dto) {

        Book book = BookMapper.toEntity(dto);

        return bookRepository.save(book);
    }

}
