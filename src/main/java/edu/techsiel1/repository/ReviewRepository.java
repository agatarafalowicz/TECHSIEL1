package edu.techsiel1.repository;

import edu.techsiel1.entity.Review;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for managing Review entities in the database.
 * Extends Spring Data's CrudRepository to provide basic CRUD operations for Review entities.
 */
@Repository
public interface ReviewRepository extends CrudRepository<Review, Integer> {
}
