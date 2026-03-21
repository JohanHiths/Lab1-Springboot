package org.example.lab1springboot.book;

import jakarta.persistence.*;
// ... existing code ...
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Setter
@Getter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false)
    private Long id;



    @NotBlank(message = "Title cannot be empty")
    private String title;

    @NotBlank(message = "Author cannot be empty")
    private String author;


    @NotBlank(message = "Genre cannot be empty")
    private String genre;

    @NotNull(message = "Published date cannot be empty")
    private LocalDate publishedDate;


    public Book() {
    }

    public Book(Long id, String title, String author, String genre, LocalDate publishedDate) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.publishedDate = publishedDate;
    }


}