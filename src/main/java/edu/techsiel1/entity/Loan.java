package edu.techsiel1.entity;

import jakarta.persistence.*;
import edu.techsiel1.entity.Book;
import edu.techsiel1.entity.User;

@Entity
@Table(name="loan", schema = "library")
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loanId")
    private Integer loanId;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User userId;

    @ManyToOne
    @JoinColumn(name = "bookId", nullable = false)
    private Book bookId;

    @Basic
    @Column(name="loanDate", nullable = false)
    private String loanDate;

    @Basic
    @Column(name="dueDate", nullable = false)
    private String dueDate;

    @Basic
    @Column(name="returnDate")
    private String returnDate;

    public Loan() {
    }
    public Loan(Integer loanId){this.loanId=loanId;}

    public String getLoanDate() {
        return loanDate;
    }

    public Integer getLoanId() {
        return loanId;
    }

    public void setLoanDate(String loanDate) {
        this.loanDate = loanDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public Loan(Book bookId) {
        this.bookId = bookId;
    }

    public Loan(User userId) {
        this.userId = userId;
    }

    public Book getBookId() {
        return bookId;
    }

    public Integer getBookAvailableCopies(){
        return bookId.getAvailableCopies();
    }

    public void setBookIdInt(Book bookId) {
        this.bookId = bookId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }
}
