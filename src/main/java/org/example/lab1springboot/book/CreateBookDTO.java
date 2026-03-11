package org.example.lab1springboot.book;

import java.time.LocalDate;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;

import lombok.Setter;

@Getter
@Setter
@Data
public class CreateBookDTO {

    @NotBlank(message = "name cannot be empty")
    private String name;

    @NotBlank(message = "title cannot be empty")
    private String title;
    @NotBlank(message = "author cannot be empty")
    private String author;


    @NotBlank(message = "Description cannot be empty")
    private String description;

    @Min(1)
    private int pageCount;

    @NotNull(message = "Price cannot be 0")
    @Min(0)
    private Double price;

    @NotBlank(message = "ISBN cannot be empty")
    private String isbn;
    @NotBlank(message = "Genre cannot be empty")
    private String genre;

    @NotNull(message = "Published date cannot be empty")
    private LocalDate date;



}