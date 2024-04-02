package edu.techsiel1.controller;
import edu.techsiel1.entity.Loan;
import edu.techsiel1.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("api/loan")
public class LoanController {
    private final LoanService loanService;
    @Autowired
    public LoanController(LoanService loanService){this.loanService = loanService;}

    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Loan addLoan(@RequestBody Loan loan){return loanService.create(loan);}

    @GetMapping("/getAll")
    public @ResponseBody Iterable<Loan> getAllLoans(){
        return loanService.getAll();
    }
    @GetMapping("/{loanId}")
    public Loan getOne(@PathVariable Integer loanId){return loanService.getOne(loanId);}
}
