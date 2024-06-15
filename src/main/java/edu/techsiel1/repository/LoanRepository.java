package edu.techsiel1.repository;

import edu.techsiel1.entity.Loan;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoanRepository extends CrudRepository<Loan, Integer> {

    @Query("SELECT l FROM Loan l WHERE l.bookId = :bookId")
    Optional<Loan> findByBookId(@Param("bookId") Integer bookId);

    @Query("SELECT l FROM Loan l WHERE l.bookId = :bookId AND l.userId = :userId")
    Optional<Loan> findByBookIdAndUserId(@Param("bookId") Integer bookId, @Param("userId") Integer userId);
}
