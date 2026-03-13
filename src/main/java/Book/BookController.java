package Book;


import jakarta.validation.Valid;
import org.example.lab1springboot.book.Book;
import org.example.lab1springboot.book.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        return "book";
    }

    @GetMapping("/books")
    List<Book> getAllBooks(@PathVariable(value = "id") Long id) {
        return bookService.getAllBooks();
    }

    BookService getBookService() {
        return bookService;
    }


    @PostMapping("/create")
    public String createBook() {

        return "books";
    }

    @PostMapping("/update")
    public void updateBook() {}

    @PostMapping("/delete")
    public void deleteBook() {}


}
