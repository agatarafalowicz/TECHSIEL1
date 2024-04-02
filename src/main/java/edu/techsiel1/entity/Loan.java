package edu.techsiel1.entity;

import jakarta.persistence.*;


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

    @Basic
    @Column(name="loanDate", nullable = false)
    private String loanDate;

    @Basic
    @Column(name="dueDate", nullable = false)
    private String dueDate;

    @Basic
    @Column(name="returnDate")
    private String returnDate;

    public Integer getLoanId() {
        return loanId;
    }

    public void setLoanId(Integer loanId) {
        this.loanId = loanId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }



    public String getLoanDate() {
        return loanDate;
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
}
