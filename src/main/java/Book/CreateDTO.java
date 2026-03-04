package Book;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateDTO {

    private String name;
    private LocalDate date;
    private int guests;
    private String title;

}