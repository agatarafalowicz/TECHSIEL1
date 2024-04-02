package edu.techsiel1.service;

import edu.techsiel1.entity.Loan;
import edu.techsiel1.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Loan getOne(Integer loanId){
        return loanRepository.findById(loanId).orElseThrow(()
                -> new RuntimeException("Loan not found"));
    }

    public Loan create(Loan loan){return loanRepository.save(loan);}

}
