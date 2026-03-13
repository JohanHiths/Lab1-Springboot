package org.example.lab1springboot.controller;


import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.example.lab1springboot.BookNotFoundException;
import org.example.lab1springboot.book.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
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

    @DeleteMapping("delete/{id}")
    public String deleteBook(@PathVariable Long id) {

        bookService.deleteBook(id);
        return "redirect:/books";
    }

    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model) {
        Book book = bookService.getBookById(id);

        UpdateBookDTO dto = new UpdateBookDTO(id, book.getName(), book.getTitle(), book.getAuthor(), book.getGenre(), book.getPublishedDate());


        model.addAttribute("updateBookDTO", dto);
        model.addAttribute("id", id);
        return "update-book";
    }

    @GetMapping("books/create")
    public String showCreateForm(Model model) {

        model.addAttribute("book", new CreateBookDTO(null, "", "", "", "", null));
        return "add-book";
    }

    @ExceptionHandler(BookNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleBookNotFound(BookNotFoundException ex, Model model) {
        model.addAttribute("errorMessage", ex.getMessage());
        return "error";
    }

    @GetMapping("/books")
    public String getAllBooks(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(required = false) String keyword,
            Model model) {

        Page<Book> bookPage = bookService.getAllBooksPaginated(page, size, keyword);

        model.addAttribute("books", bookPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", bookPage.getTotalPages());
        model.addAttribute("keyword", keyword);


        return "books";
    }
    @PostMapping("/books/save")
    public String saveBook(@Valid @ModelAttribute("book") Book book, BindingResult result, Model model) {
        if (result.hasErrors()) {
            log.warn("Validation errors: {}", result.getAllErrors());
            return "add-book";
        }
        bookService.saveBook(book);
        return "redirect:/books";
    }



    @GetMapping("books/add")
    public String showAddForm(Model model) {

        model.addAttribute("book", new Book());

        return "add-book";
    }



}


