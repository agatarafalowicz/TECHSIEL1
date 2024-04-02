package edu.techsiel1.controller.Dto;

import edu.techsiel1.entity.Loan;

public class CreateBookDto {
    private Integer bookId;
    private String isbn;
    private String title;
    private String author;
    private String publisher;
    private Integer yearOfPublication;
    private Integer availableCopies;
    private Loan loanId;

    public CreateBookDto(Integer bookId, String isbn, String title, String author, String publisher,
                         Integer yearOfPublication, Integer availableCopies,
                         Loan loanId) {
        this.bookId = bookId;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.yearOfPublication = yearOfPublication;
        this.availableCopies = availableCopies;
        this.loanId = loanId;
    }

    public CreateBookDto(){

    }

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
