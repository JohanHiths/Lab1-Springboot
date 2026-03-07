package org.example.lab1springboot.book;


import org.springframework.stereotype.Component;

@Component
public class BookMapper {


    public static Book toEntity(CreateBookDTO dto) {
        Book book = new Book();
        book.setName(dto.getName());
        book.setDescription(dto.getDescription());
        book.setAuthor(dto.getName());

        return book;
    }

    public BookDTO toBookDTO(Book book) {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setName(book.getName());
        return bookDTO;
    }

    public Book toBook(CreateBookDTO createDTO) {
        Book book = new Book();
        book.setName(createDTO.getName());
        return book;
    }
    public void updateBookDTO(UpdateBookDTO dto, Book book) {
        book.setName(dto.getName());
    }



}
