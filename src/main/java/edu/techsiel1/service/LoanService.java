package edu.techsiel1.service;

import edu.techsiel1.entity.Loan;
import edu.techsiel1.repository.LoanRepository;
import edu.techsiel1.service.exception.LoanNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

/**
 * Service class for managing Loan entities.
 * This class provides methods to perform CRUD operations on Loan entities.
 */
@Service
public class LoanService {

    private final LoanRepository loanRepository;

    /**
     * Constructs a LoanService with the specified LoanRepository.
     *
     * @param loanRepository The repository used for accessing and managing Loan entities.
     */
    @Autowired
    public LoanService(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    /**
     * Retrieves all loans from the database.
     *
     * @return An Iterable containing all loans in the database.
     */
    public Iterable<Loan> getAll() {
        return loanRepository.findAll();
    }

    /**
     * Retrieves a loan by its ID.
     *
     * @param loanId The ID of the loan to retrieve.
     * @return The Loan entity with the specified ID.
     * @throws IllegalArgumentException If the loanId is null or not a positive integer.
     * @throws LoanNotFoundException    If no loan with the specified ID is found.
     */
    public Loan getOne(Integer loanId) {
        if (loanId == null || loanId <= 0) {
            throw new IllegalArgumentException("Invalid loan ID. Loan ID must be a positive integer.");
        }
        return loanRepository.findById(loanId)
                .orElseThrow(() -> new LoanNotFoundException(String.format("Loan with id '%s' not found", loanId)));
    }

    /**
     * Creates a new loan entity.
     *
     * @param loan The loan entity to create.
     * @return The newly created Loan entity.
     * @throws IllegalArgumentException If loan, return, or due date is null or invalid.
     */
    public Loan create(Loan loan) {
        String loanDateStr = loan.getLoanDate();
        String dueDateStr = loan.getDueDate();
        if (loanDateStr == null || dueDateStr == null) {
            throw new IllegalArgumentException("Loan and due date are required.");
        }
        LocalDate loanDate;
        LocalDate returnDate;
        LocalDate dueDate;
        try {
            loanDate = LocalDate.parse(loanDateStr);
            dueDate = LocalDate.parse(dueDateStr);
            if (loan.getReturnDate() != null){
                String returnDateStr = loan.getReturnDate();
                returnDate = LocalDate.parse(returnDateStr);
                if (returnDate.isBefore(loanDate)) {
                    throw new IllegalArgumentException("Return date cannot be before loan date.");
                }
            }
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid date format. Please provide dates in yyyy-MM-dd format.");
        }
        if (dueDate.isBefore(loanDate)) {
            throw new IllegalArgumentException("Due date cannot be before loan date.");
        }
        return loanRepository.save(loan);
    }

    /**
     * Deletes a loan by its ID.
     *
     * @param loanId The ID of the loan to delete.
     * @throws IllegalArgumentException If the loanId is null or not a positive integer.
     * @throws LoanNotFoundException    If no loan with the specified ID is found.
     */
    public void delete(Integer loanId) {
        if (loanId == null || loanId <= 0) {
            throw new IllegalArgumentException("Invalid loan ID. Loan ID must be a positive integer.");
        }
        if (!loanRepository.existsById(loanId)) {
            throw new LoanNotFoundException(String.format("Loan with id '%s' not found", loanId));
        }
        loanRepository.deleteById(loanId);
    }
}
