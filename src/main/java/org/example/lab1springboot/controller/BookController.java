package org.example.lab1springboot.controller;


import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.example.lab1springboot.book.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
public class BookController {

    Logger log = LoggerFactory.getLogger(BookController.class);

    BookService bookService;

    BookController(BookService bookService) {
        this.bookService = bookService;
    }




//    @GetMapping("/{id}")
//    public String getBookById(@PathVariable Long id, Model model) {
//        Book book = bookService.getBookById(id);
//
//        model.addAttribute("book", book);
//        return "books";
//    }

    @GetMapping("/books")
    public String getBooks(@RequestParam(required = false) String title,Model model) {

        model.addAttribute("activePage", "viewBooks");
        model.addAttribute("books", bookService.getAllBooks());
        return "books";
    }



    @PostMapping("books/create")
    public String createBook(@Valid CreateBookDTO dto, BindingResult result) {

        if(result.hasErrors()){
            return "create-book";
        }
        bookService.createBook(dto);
        return "redirect:/books";
    }

    @PutMapping("/{id}")
    public String updateBook(@PathVariable Long id, @Valid UpdateBookDTO updateBookDTO, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "update-book";
        }

        bookService.updateBook(id, updateBookDTO);

        return "redirect:/books";
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable Long id) {

        bookService.deleteBook(id);
        return "redirect:/books";
    }

    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model) {
        Book book = bookService.getBookById(id);
        model.addAttribute("book", book);
        return "update-book";
    }

    @GetMapping("books/create")
    public String showCreateForm(Model model) {

        model.addAttribute("book", new CreateBookDTO());
        return "create-book";
    }






}


