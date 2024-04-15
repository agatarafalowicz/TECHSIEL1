package edu.techsiel1.controller;

import edu.techsiel1.entity.Book;
import edu.techsiel1.service.BookService;
import edu.techsiel1.service.exception.BookAlreadyExistsException;
import edu.techsiel1.service.exception.BookNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller class for managing Book entities via RESTful endpoints.
 */
@RestController
@RequestMapping("api/book")
public class BookController {

    private final BookService bookService;

    /**
     * Constructor injection for BookService.
     *
     * @param bookService The BookService used to interact with Book entities.
     */
    @Autowired
    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    /**
     * Add a new Book.
     *
     * @param book The Book object to be added.
     * @return ResponseEntity containing the newly created Book, or error response if Book already exists.
     */
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

    /**
     * Get all Books.
     *
     * @return Iterable of all Books.
     */
    @GetMapping("/getAll")
    public @ResponseBody Iterable<Book> getAllBooks(){
        return bookService.getAll();
    }

    /**
     * Get a specific Book by ID.
     *
     * @param bookId The ID of the Book to retrieve.
     * @return ResponseEntity containing the retrieved Book, or error response if not found or invalid ID.
     */
    @GetMapping("/{bookId}")
    public ResponseEntity<?> getOne(@PathVariable Integer bookId) {
        try{
            Book book = bookService.getOne(bookId);
            return new ResponseEntity<>(book, HttpStatus.CREATED);
        } catch (BookNotFoundException e) {
            String errorMessage = e.getMessage();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }

    /**
     * Delete a Book by ID.
     *
     * @param bookId The ID of the Book to delete.
     * @return ResponseEntity with no content if successful, or error response if Book not found or invalid ID.
     */
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
