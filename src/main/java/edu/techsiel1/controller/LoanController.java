package edu.techsiel1.controller;
import edu.techsiel1.entity.Loan;
import edu.techsiel1.entity.User;
import edu.techsiel1.service.LoanService;
import edu.techsiel1.service.exception.LoanNotFoundException;
import edu.techsiel1.service.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("api/loan")
public class LoanController {
    private final LoanService loanService;
    @Autowired
    public LoanController(LoanService loanService){this.loanService = loanService;}

    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Loan addLoan(@RequestBody Loan loan){
        return loanService.create(loan);}

    @GetMapping("/getAll")
    public @ResponseBody Iterable<Loan> getAllLoans(){
        return loanService.getAll();
    }
    @GetMapping("/{loanId}")
    public ResponseEntity<?> getOne(@PathVariable Integer loanId) {
        try{
            Loan loan = loanService.getOne(loanId);
            return ResponseEntity.ok(loan);
        } catch (LoanNotFoundException e) {
            String errorMessage = e.getMessage();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        } catch (IllegalArgumentException e){
            String errorMessage = e.getMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
        }
    }

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
