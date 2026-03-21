package org.example.lab1springboot;

import org.example.lab1springboot.book.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class BookMapperTest {

    @Test
    void shouldMapCreateDTOToEntity() {

        CreateBookDTO dto = new CreateBookDTO(null, "title", "author", "genre", LocalDate.now());

        Book book = BookMapper.toEntity(dto);

        assertEquals("title", book.getTitle());
        assertEquals("author", book.getAuthor());
        assertEquals("genre", book.getGenre());
        assertNull(book.getId());
    }

    @Test
    void shouldMapEntityToDTO() {

        Book book = new Book();
        book.setTitle("title");
        book.setAuthor("author");
        book.setGenre("genre");
        book.setPublishedDate(LocalDate.now());

        BookDTO dto = BookMapper.toDTO(book);

        assertEquals("title", dto.title());
        assertEquals("author", dto.author());
        assertEquals("genre", dto.genre());
    }

    @Test
    void shouldUpdateExistingEntityFromUpdateDTO() {
    }
}