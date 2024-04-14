package edu.techsiel1.controller;

import edu.techsiel1.entity.Book;
import edu.techsiel1.service.BookService;
import edu.techsiel1.service.exception.BookAlreadyExistsException;
import edu.techsiel1.service.exception.BookNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> addBook(@RequestBody Book book) {
        try {
            Book newBook = bookService.create(book);
            return new ResponseEntity<>(newBook, HttpStatus.CREATED);
        } catch (BookAlreadyExistsException e) {
            String errorMessage = e.getMessage();
            return ResponseEntity.status(HttpStatus.CONFLICT).body(errorMessage);
        }
    }

    @GetMapping("/getAll")
    public @ResponseBody Iterable<Book> getAllBooks(){
        return bookService.getAll();
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<?> getOne(@PathVariable Integer bookId) {
        try{
            Book book = bookService.getOne(bookId);
            return ResponseEntity.ok(book);
        } catch (BookNotFoundException e) {
            String errorMessage = e.getMessage();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        } catch (IllegalArgumentException e){
            String errorMessage = e.getMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
        }
    }

    @DeleteMapping("/{bookId}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public ResponseEntity<?> deleteBook(@PathVariable Integer bookId) {
        try {
            bookService.delete(bookId);
            return ResponseEntity.noContent().build();
        } catch (BookNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

}
