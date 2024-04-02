package edu.techsiel1.controller;

import edu.techsiel1.entity.Book;
import edu.techsiel1.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("api/book")
public class BookController {
    private final BookService bookService;
    @Autowired
    public BookController(BookService bookService){
        this.bookService = bookService;
    }
    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Book addBook(@RequestBody Book book){
        return bookService.create(book);
    }
    @GetMapping("/getAll")
    public @ResponseBody Iterable<Book> getAllBooks(){
        return bookService.getAll();
    }

    @GetMapping("/{bookId}")
    public Book getOne(@PathVariable Integer bookId){return bookService.getOne(bookId);}

}
