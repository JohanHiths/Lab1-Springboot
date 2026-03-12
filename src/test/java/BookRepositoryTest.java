import org.example.lab1springboot.book.Book;
import org.example.lab1springboot.book.BookRepository;
import org.junit.jupiter.api.Test;
import org.testcontainers.junit.jupiter.Testcontainers;


import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;



public class BookRepositoryTest {

    BookRepository bookRepository;


    @Test
    void shouldFindBooks() {
        List<Book> books = bookRepository.findAll();

        assertThat(books).isNotEmpty();
    }

}
