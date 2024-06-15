package edu.techsiel1.service;

import edu.techsiel1.entity.Book;
import edu.techsiel1.repository.BookRepository;
import edu.techsiel1.service.exception.BookAlreadyExistsException;
import edu.techsiel1.service.exception.BookNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service class for managing Book entities.
 * This class provides methods to perform CRUD operations on Book entities.
 */
@Service
public class BookService {

    private final BookRepository bookRepository;

    /**
     * Constructs a BookService with the specified BookRepository.
     *
     * @param bookRepository The repository used for accessing and managing Book entities.
     */
    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    /**
     * Retrieves all books from the database.
     *
     * @return An Iterable containing all books in the database.
     */
    public Iterable<Book> getAll() {
        return bookRepository.findAll();
    }

    /**
     * Retrieves a book by its ID.
     *
     * @param bookId The ID of the book to retrieve.
     * @return The Book entity with the specified ID.
     * @throws IllegalArgumentException If the bookId is null or not a positive integer.
     * @throws BookNotFoundException    If no book with the specified ID is found.
     */
    public Book getOne(Integer bookId) {
        if (bookId == null || bookId <= 0) {
            throw new IllegalArgumentException("Invalid book ID. Book ID must be a positive integer.");
        }
        return bookRepository.findById(bookId)
                .orElseThrow(() -> new BookNotFoundException(String.format("Book with id '%s' not found", bookId)));
    }

    /**
     * Creates a new book entity.
     *
     * @param book The book entity to create.
     * @return The newly created Book entity.
     * @throws BookAlreadyExistsException If a book with the same ID already exists.
     */
    public Book create(Book book) {
        if (book.getBookId() != null) {
            Optional<Book> existingBook = bookRepository.findById(book.getBookId());
            if (existingBook.isPresent()) {
                throw new BookAlreadyExistsException(String.format("Book with id '%s' already exists", book.getBookId()));
            }
        }
        return bookRepository.save(book);
    }

    /**
     * Deletes a book by its ID.
     *
     * @param bookId The ID of the book to delete.
     * @throws IllegalArgumentException If the bookId is null or not a positive integer.
     * @throws BookNotFoundException    If no book with the specified ID is found.
     */
    public void delete(Integer bookId) {
        if (bookId == null || bookId <= 0) {
            throw new IllegalArgumentException("Invalid book ID. Book ID must be a positive integer.");
        }
        if (!bookRepository.existsById(bookId)) {
            throw new BookNotFoundException(String.format("Book with id '%s' not found", bookId));
        }
        bookRepository.deleteById(bookId);
    }

    /**
     * Updates a book entity.
     *
     * @param book The book entity to update.
     * @return The updated Book entity.
     * @throws BookNotFoundException If no book with the specified ID is found.
     */
    public Book updateBook(Book book) {
        if (book.getBookId() == null || book.getBookId() <= 0) {
            throw new IllegalArgumentException("Invalid book ID. Book ID must be a positive integer.");
        }
        if (!bookRepository.existsById(book.getBookId())) {
            throw new BookNotFoundException(String.format("Book with id '%s' not found", book.getBookId()));
        }
        return bookRepository.save(book);
    }

    public Book findBookById(Integer bookId) {
        Optional<Book> optionalBook = bookRepository.findById(bookId);
        if (optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            throw new BookNotFoundException("Book not found with ID: " + bookId);
        }
    }

}
