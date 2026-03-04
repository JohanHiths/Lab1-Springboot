package Book;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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

    @NotBlank(message = "lastName cannot be empty")
    private String lastName;

    @NotBlank(message = "Title cannot be empty")
    private String title;


    @NotBlank
    @Size(min = 10, max = 13, message = "ISBN must be 10-13 characters")
    private String isbn;

    @NotBlank(message = "Genre cannot be empty")
    private String genre;

    @NotBlank(message = "Description cannot be empty")
    @Size(min = 1, message = "Description must be at least 1 character")
    private String description;

    @NotBlank(message = "Pagecount cannot be empty")
    @Size(min = 1, message = "Pagecount must be at least 1 character")
    private int pageCount;

    @NotBlank(message = "Published date cannot be empty")
    private LocalDate publishedDate;

    public Book() {

    }





}
