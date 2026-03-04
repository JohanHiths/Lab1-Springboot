package Book;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EntityDTO {

    private String name;
    private LocalDate date;
    private int guests;
    private String title;

}