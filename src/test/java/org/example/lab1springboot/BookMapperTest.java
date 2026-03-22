package org.example.lab1springboot;

import org.example.lab1springboot.book.*;
import org.junit.jupiter.api.DisplayName;
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
    void shouldUpdateExistingEntity_FromUpdateDTO() {

        Book existingBook = new Book();
        existingBook.setId(1L);
        existingBook.setTitle("Old Title");
        existingBook.setAuthor("Old Author");

        UpdateBookDTO updateDto = new UpdateBookDTO(
                1L,
                "New Title",
                "New Author",
                "New Genre",
                LocalDate.now()
        );

        BookMapper.updateEntityFromDto(updateDto, existingBook);

        assertEquals(1L, existingBook.getId());
        assertEquals("New Title", existingBook.getTitle());
        assertEquals("New Author", existingBook.getAuthor());
        assertEquals("New Genre", existingBook.getGenre());

    }
}