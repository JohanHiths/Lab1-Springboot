package org.example.lab1springboot.book;

import java.time.LocalDate;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;

import lombok.Setter;

public record CreateBookDTO(Long id, String name, String title, String author, String genre,  LocalDate publishedDate) {


}