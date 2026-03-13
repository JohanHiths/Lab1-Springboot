package org.example.lab1springboot.book;

public class BookMapper {


    public static Book toEntity(CreateBookDTO dto) {
        if (dto == null) return null;

        Book book = new Book();

        book.setName(dto.name());
        book.setTitle(dto.title());
        book.setAuthor(dto.author());
        book.setGenre(dto.genre());
        book.setPublishedDate(dto.publishedDate());

        return book;
    }

    public static BookDTO toDTO(Book book) {
        if (book == null) return null;

        return new BookDTO(
                book.getId(),
                book.getName(),
                book.getTitle(),
                book.getAuthor(),
                book.getGenre(),
                book.getPublishedDate()
        );
    }
}