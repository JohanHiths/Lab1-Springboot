package Book;

import java.time.LocalDate;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateBookDTO {


    @NotBlank(message = "name cannot be empty")
    private String name;

    @NotBlank(message = "Description cannot be empty")
    private String description;

    @NotBlank(message = "Title cannot be empty")
    private String title;


    @Min(1)
    private int pageCount;

    @NotNull(message = "Price cannot be 0")
    @Min(0)
    private Double price;

    @NotBlank(message = "Genre cannot be empty")
    private String genre;

    @NotNull(message = "Published date cannot be empty")
    private LocalDate date;


}
