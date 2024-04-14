package edu.techsiel1.repository;

import edu.techsiel1.entity.Loan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for managing Loan entities in the database.
 * Extends Spring Data's CrudRepository to provide basic CRUD operations for Loan entities.
 */
@Repository
public interface LoanRepository extends CrudRepository<Loan, Integer> {
}
