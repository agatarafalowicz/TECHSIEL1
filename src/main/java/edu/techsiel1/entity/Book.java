package edu.techsiel1.entity;

import jakarta.persistence.*;

/**
 * Represents a book entity in the library system.
 */
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

    /**
     * Get the ID of the book.
     *
     * @return The book ID.
     */
    public Integer getBookId() {
        return bookId;
    }

    /**
     * Set the ID of the book.
     *
     * @param bookId The book ID to set.
     */
    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    /**
     * Get the ISBN of the book.
     *
     * @return The ISBN.
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Set the ISBN of the book.
     *
     * @param isbn The ISBN to set.
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * Get the title of the book.
     *
     * @return The title.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Set the title of the book.
     *
     * @param title The title to set.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Get the author of the book.
     *
     * @return The author.
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Set the author of the book.
     *
     * @param author The author to set.
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Get the publisher of the book.
     *
     * @return The publisher.
     */
    public String getPublisher() {
        return publisher;
    }

    /**
     * Set the publisher of the book.
     *
     * @param publisher The publisher to set.
     */
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    /**
     * Get the year of publication of the book.
     *
     * @return The year of publication.
     */
    public Integer getYearOfPublication() {
        return yearOfPublication;
    }

    /**
     * Set the year of publication of the book.
     *
     * @param yearOfPublication The year of publication to set.
     */
    public void setYearOfPublication(Integer yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    /**
     * Get the number of available copies of the book.
     *
     * @return The number of available copies.
     */
    public Integer getAvailableCopies() {
        return availableCopies;
    }

    /**
     * Set the number of available copies of the book.
     *
     * @param availableCopies The number of available copies to set.
     */
    public void setAvailableCopies(Integer availableCopies) {
        this.availableCopies = availableCopies;
    }

    /**
     * Get the loan associated with the book.
     *
     * @return The loan associated with the book.
     */
    public Loan getLoanId() {
        return loanId;
    }

    /**
     * Set the loan associated with the book.
     *
     * @param loanId The loan to associate with the book.
     */
    public void setLoanId(Loan loanId) {
        this.loanId = loanId;
    }
}
