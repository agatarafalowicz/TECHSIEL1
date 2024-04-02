package edu.techsiel1.repository;

import edu.techsiel1.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    User getUserByLogin(String login);

}
