package edu.techsiel1.repository;

import edu.techsiel1.entity.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for managing Book entities in the database.
 * Extends Spring Data's CrudRepository to provide basic CRUD operations for Book entities.
 */
@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {
}
