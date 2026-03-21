package org.example.lab1springboot.config;

import org.example.lab1springboot.book.Book;
import org.example.lab1springboot.book.BookRepository;
import org.example.lab1springboot.book.CreateBookDTO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    private final BookRepository bookRepository;

    public DataInitializer(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) {
        if (bookRepository.count() == 0) {
            List<Book> starterBooks = List.of(

                    new Book(null, "The Hobbit", "J.R.R. Tolkien", "Fantasy", LocalDate.of(1937, 9, 21)),
                    new Book(null, "1984", "George Orwell", "Dystopian", LocalDate.of(1949, 6, 8)),
                    new Book(null, "The Great Gatsby", "F. Scott Fitzgerald", "Classic", LocalDate.of(1925, 4, 10)),
                    new Book(null, "To Kill a Mockingbird", "Harper Lee", "Classic", LocalDate.of(1960, 7, 16)),
                    new Book(null, "The Lord of the Rings", "J.R.R. Tolkien", "Fantasy", LocalDate.of(1954, 10, 19)),
                    new Book(null, "The Hunger Games", "Suzanne Collins", "Action", LocalDate.of(2008, 7, 25)),
                    new Book(null, "The Alchemist", "J.N. Chaney", "Fantasy", LocalDate.of(1988, 10, 16)),
                    new Book(null, "Pride and Prejudice", "Jane Austen", "Classic", LocalDate.of(1813, 10, 16)),
                    new Book(null, "Pippi Longstocking", "Astrid lindgren", "Fiction", LocalDate.of(1945, 11, 16)),
                    new Book(null, "The Lord of the Rings: The Fellowship of the Ring", "J.R.R. Tolkien", "Fantasy", LocalDate.of(1954, 10, 19)),
                    new Book(null, "The Lord of the Rings: The Two Towers", "J.R.R. Tolkien", "Fantasy", LocalDate.of(1954, 10, 19)),
                    new Book(null, "The Lord of the Rings: The Return of the King", "J.R.R. Tolkien", "Fantasy", LocalDate.of(1955, 10, 19)),
                    new Book(null, "The Catcher in the Rye", "J.D. Salinger", "Dystopian", LocalDate.of(1951, 10, 16)));

            bookRepository.saveAll(starterBooks);
            System.out.println("Postgres populated with starter books!");
        }
}
}