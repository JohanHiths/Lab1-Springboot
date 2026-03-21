package org.example.lab1springboot.book;


import jakarta.validation.Valid;
import org.example.lab1springboot.BookNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;





@Controller
@RequestMapping("/books")
public class BookController {

    Logger log = LoggerFactory.getLogger(BookController.class);


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


    @PostMapping("/create")
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
            return "books";
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
        return "redirect:/books/edit/" + id;

    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {

        model.addAttribute("book", new CreateBookDTO(null, "", "", "",null));
        return "add-book";
    }

    @ExceptionHandler(BookNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleBookNotFound(BookNotFoundException ex, Model model) {
        model.addAttribute("errorMessage", ex.getMessage());
        return "error";
    }

   @GetMapping({"", "/"})
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
    @PostMapping("/save")
    public String saveBook(@Valid @ModelAttribute("book") Book book, BindingResult result, Model model) {
        if (result.hasErrors()) {
            log.warn("Validation errors: {}", result.getAllErrors());
            return "add-book";
        }
        bookService.saveBook(book);
        return "redirect:/books";
    }



    @GetMapping("/add")
    public String showAddForm(Model model) {

        model.addAttribute("book", new Book());

        return "add-book";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Book book = bookService.getBookById(id);
        CreateBookDTO dto = BookMapper.toCreateDTO(book);

        model.addAttribute("book", dto);
        model.addAttribute("isEdit", true);
        return "add-book";

    }






}


