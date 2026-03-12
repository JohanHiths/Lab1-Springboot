package org.example.lab1springboot.book;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import org.example.lab1springboot.BookNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service

public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        log.info("BookService created");
        this.bookRepository = bookRepository;
    }

    @Transactional(readOnly = true)
    public List<Book> getAllBooks() {

        return bookRepository.findAll();
    }

    @Transactional
    public void deleteBook(Long id) {
        if(bookRepository.findById(id).isEmpty())
            throw new BookNotFoundException("Book not found with id: " + id);

        bookRepository.deleteById(id);
    }

    @Transactional
    public Book getBookById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book not found with id: " + id));
    }

    @Transactional
    public Book updateBook(Long id, UpdateBookDTO dto) {
        Book book = getBookById(id);
        book.setTitle(dto.getTitle());
        book.setAuthor(dto.getName());

        Book updatedBook = bookRepository.save(book);

        log.info("Book updated successfully");
        return updatedBook;
    }

    @Transactional
    public Book createBook(CreateBookDTO dto) {

        Book book = BookMapper.toEntity(dto);

        return bookRepository.save(book);
    }


    public Page<Book> getAllBooksPaginated(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return bookRepository.findAll(pageable);
    }
}
