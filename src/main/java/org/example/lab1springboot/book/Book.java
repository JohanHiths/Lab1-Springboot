package org.example.lab1springboot.book;

import jakarta.persistence.*;
// ... existing code ...
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
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

    @NotBlank(message = "Name cannot be empty")
    private String name;


    @NotBlank(message = "Title cannot be empty")
    private String title;

    @NotBlank(message = "Author cannot be empty")
    private String author;

//    @NotBlank
//    @jakarta.validation.constraints.Size(min = 10, max = 13, message = "ISBN must be 10-13 characters")
//    private String isbn;

    @NotBlank(message = "Genre cannot be empty")
    private String genre;

    @NotNull(message = "Published date cannot be empty")
    private LocalDate publishedDate;

//    @NotBlank(message = "Description cannot be empty")
//    @jakarta.validation.constraints.Size(min = 1, message = "Description must be at least 1 character")
//    private String description;

//    @NotNull(message = "Pagecount cannot be empty")
//    @Min(value = 1, message = "Pagecount must be at least 1")
//    private Integer pageCount;



//    @NotNull(message = "Price cannot be empty")
//    @Positive(message = "Price must be greater than 0")
//    private Double price;

    public Book() {
    }
}