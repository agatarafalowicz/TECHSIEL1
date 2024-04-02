package edu.techsiel1.service;

import edu.techsiel1.entity.Book;
import edu.techsiel1.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public Iterable<Book> getAll(){
        return bookRepository.findAll();
    }

    public Book getOne(Integer bookId){
        return bookRepository.findById(bookId).orElseThrow(() -> new RuntimeException("Book not found"));
    }

    public Book create(Book book){return bookRepository.save(book);}

}
