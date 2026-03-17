package org.example.lab1springboot.book;

import java.time.LocalDate;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


public record UpdateBookDTO(Long id,@NotBlank(message = "Name cannot be empty") String name, @NotBlank(message = "Title cannot be empty") String title, @NotBlank(message = "Author cannot be empty") String author, @NotBlank(message = "Genre cannot be empty") String genre, @NotNull(message = "Published date cannot be empty")  LocalDate publishedDate)  {


}
