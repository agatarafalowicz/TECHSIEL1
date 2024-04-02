package edu.techsiel1.entity;

import jakarta.persistence.*;


@Entity
@Table(name="book", schema = "library")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="bookId")
    private Integer bookId;

    @Basic
    @Column(name="isbn", unique = true)
    private String isbn;

    @Basic
    @Column(name="title")
    private String title;

    @Basic
    @Column(name="author")
    private String author;

    @Basic
    @Column(name="publisher")
    private String publisher;

    @Basic
    @Column(name="yearOfPublication")
    private Integer yearOfPublication;

    @Basic
    @Column(name="availableCopies")
    private Integer availableCopies;


    @ManyToOne
    @JoinColumn(name = "loanId")
    private Loan loanId;


    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Integer getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(Integer yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    public Integer getAvailableCopies() {
        return availableCopies;
    }

    public void setAvailableCopies(Integer availableCopies) {
        this.availableCopies = availableCopies;
    }

    public Loan getLoanId() {
        return loanId;
    }

    public void setLoanId(Loan loanId) {
        this.loanId = loanId;
    }
}
