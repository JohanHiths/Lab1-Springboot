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
        dto.id();
        dto.title();
        dto.author();
        dto.genre();
        dto.publishedDate();

        Book book  = BookMapper.toEntity(dto);

        assertEquals(book.getTitle(), book.getTitle());
        assertEquals(book.getGenre(), book.getGenre());
        assertNull(book.getId());
    }

    @Test
    void shouldMapEntityToDTO() {

        Book book = new Book();

        BookDTO dto = BookMapper.toDTO(book);
    }

    @Test
    void shouldUpdateExistingEntityFromUpdateDTO() {
    }
}