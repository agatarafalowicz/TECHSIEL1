package edu.techsiel1.entity;

import jakarta.persistence.*;

/**
 * Represents a loan entity in the library system.
 */
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

    /**
     * Get the ID of the loan.
     *
     * @return The loan ID.
     */
    public Integer getLoanId() {
        return loanId;
    }

    /**
     * Set the ID of the loan.
     *
     * @param loanId The loan ID to set.
     */
    public void setLoanId(Integer loanId) {
        this.loanId = loanId;
    }

    /**
     * Get the user associated with the loan.
     *
     * @return The User object representing the user associated with the loan.
     */
    public User getUserId() {
        return userId;
    }

    /**
     * Set the user associated with the loan.
     *
     * @param userId The User object representing the user to associate with the loan.
     */
    public void setUserId(User userId) {
        this.userId = userId;
    }

    /**
     * Get the loan date.
     *
     * @return The loan date as a string.
     */
    public String getLoanDate() {
        return loanDate;
    }

    /**
     * Set the loan date.
     *
     * @param loanDate The loan date to set.
     */
    public void setLoanDate(String loanDate) {
        this.loanDate = loanDate;
    }

    /**
     * Get the due date of the loan.
     *
     * @return The due date as a string.
     */
    public String getDueDate() {
        return dueDate;
    }

    /**
     * Set the due date of the loan.
     *
     * @param dueDate The due date to set.
     */
    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    /**
     * Get the return date of the loan.
     *
     * @return The return date as a string.
     */
    public String getReturnDate() {
        return returnDate;
    }

    /**
     * Set the return date of the loan.
     *
     * @param returnDate The return date to set.
     */
    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }
}
