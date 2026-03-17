package org.example.lab1springboot;

import org.example.lab1springboot.book.Book;
import org.example.lab1springboot.book.BookRepository;
import org.junit.jupiter.api.Test;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
public class BookRepositoryTest {

   @Autowired
   private TestEntityManager entityManager;

    @Autowired
    BookRepository bookRepository;


    @Test
    void shouldFindBooks() {
        Book book = new Book();
        book.setName("Test Name");
        book.setTitle("Test Title");
        book.setAuthor("Test Author");
        book.setGenre("Fiction");

        book.setPublishedDate(LocalDate.now());

        entityManager.persistAndFlush(book);

        List<Book> books = bookRepository.findAll();

        assertThat(books).isNotEmpty();
    }

    @Test
    void testSaveAndFindBook() {
        Book book = new Book();
        book.setName("Guide Name");
        book.setTitle("The Spring Guide");
        book.setAuthor("Gemini");
        book.setGenre("Tech");
        book.setPublishedDate(LocalDate.now());

        Book savedBook = bookRepository.save(book);

        Optional<Book> found = bookRepository.findById(savedBook.getId());


        assertThat(found).isPresent();
        assertThat(found.orElseThrow().getTitle()).isEqualTo("The Spring Guide");
    }



}
