package edu.techsiel1.controller;

import edu.techsiel1.entity.Loan;
import edu.techsiel1.service.LoanService;
import edu.techsiel1.service.exception.LoanNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller class for managing Loan entities via RESTful endpoints.
 */
@RestController
@RequestMapping("api/loan")
public class LoanController {

    private final LoanService loanService;

    /**
     * Constructor injection for LoanService.
     *
     * @param loanService The LoanService used to interact with Loan entities.
     */
    @Autowired
    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    /**
     * Add a new Loan.
     *
     * @param loan The Loan object to be added.
     * @return The created Loan object with a HTTP status of CREATED (201).
     */
    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Loan addLoan(@RequestBody Loan loan) {
        return loanService.create(loan);
    }

    /**
     * Retrieve all Loans.
     *
     * @return Iterable of all Loans.
     */
    @GetMapping("/getAll")
    public @ResponseBody Iterable<Loan> getAllLoans() {
        return loanService.getAll();
    }

    /**
     * Get a specific Loan by ID.
     *
     * @param loanId The ID of the Loan to retrieve.
     * @return ResponseEntity containing the retrieved Loan, or an error response if not found or invalid ID.
     */
    @GetMapping("/{loanId}")
    public ResponseEntity<?> getOne(@PathVariable Integer loanId) {
        try {
            Loan loan = loanService.getOne(loanId);
            return ResponseEntity.ok(loan);
        } catch (LoanNotFoundException e) {
            String errorMessage = e.getMessage();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        } catch (IllegalArgumentException e) {
            String errorMessage = e.getMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
        }
    }

    /**
     * Delete a Loan by ID.
     *
     * @param loanId The ID of the Loan to delete.
     * @return ResponseEntity with NO_CONTENT status if successful, or an error response if Loan not found or invalid ID.
     */
    @DeleteMapping("/{loanId}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public ResponseEntity<?> deleteLoan(@PathVariable Integer loanId) {
        try {
            loanService.delete(loanId);
            return ResponseEntity.noContent().build();
        } catch (LoanNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
