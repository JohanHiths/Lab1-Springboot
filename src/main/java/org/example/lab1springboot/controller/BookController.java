package org.example.lab1springboot.controller;


import jakarta.validation.Valid;
import org.example.lab1springboot.book.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
public class BookController {


    BookService bookService;

    BookController(BookService bookService) {
        this.bookService = bookService;
    }




    @GetMapping("/{id}")
    public String getBookById(@PathVariable Long id, Model model) {
        Book book = bookService.getBookById(id);
        model.addAttribute("book", book);
        return "books";
    }

    @GetMapping
    public String getAllBooks(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "books";
    }


    @PostMapping("books/create")
    public String createBook(@Valid CreateBookDTO dto, BindingResult result) {

        if(result.hasErrors()){
            return "createbook";
        }
        bookService.createBook(dto);
        return "redirect:/books";
    }

    @PutMapping("/{id}")
    public String updateBook(@PathVariable Long id, @Valid UpdateBookDTO updateBookDTO, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("updateBookDTO", updateBookDTO);
            return "updatebook";
        }

        return "book";
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id, @Valid Book book, BindingResult bindingResult) {
        bookService.deleteBook(id);
        ;
    }



}


