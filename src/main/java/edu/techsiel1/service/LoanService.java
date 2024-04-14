package edu.techsiel1.service;

import edu.techsiel1.entity.Loan;
import edu.techsiel1.repository.LoanRepository;
import edu.techsiel1.service.exception.LoanNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

@Service
public class LoanService {
    private final LoanRepository loanRepository;

    @Autowired
    public LoanService(LoanRepository loanRepository){
        this.loanRepository = loanRepository;
    }

    public Iterable<Loan> getAll(){
        return loanRepository.findAll();
    }

    public Loan getOne(Integer loanId) {
        if (loanId == null || loanId <= 0) {
            throw new IllegalArgumentException("Invalid loan ID. Loan ID must be a positive integer.");
        }
        return loanRepository.findById(loanId)
                .orElseThrow(() -> new LoanNotFoundException(String.format("User with id '%s' not found", loanId)));
    }

    public Loan create(Loan loan){
        String loanDateStr = loan.getLoanDate();
        String returnDateStr = loan.getReturnDate();
        String dueDateStr = loan.getDueDate();
        if (loanDateStr == null || returnDateStr == null || dueDateStr == null) {
            throw new IllegalArgumentException("Loan, return and due date are required.");
        }
        LocalDate loanDate;
        LocalDate returnDate;
        LocalDate dueDate;
        try {
            loanDate = LocalDate.parse(loanDateStr);
            returnDate = LocalDate.parse(returnDateStr);
            dueDate = LocalDate.parse(dueDateStr);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid date format. Please provide dates in yyyy-MM-dd format.");
        }
        if (returnDate.isBefore(loanDate)) {
            throw new IllegalArgumentException("Return date cannot be before loan date.");
        }
        if (dueDate.isBefore(loanDate)) {
            throw new IllegalArgumentException("Due date cannot be before loan date.");
        }
        return loanRepository.save(loan);
    }


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
