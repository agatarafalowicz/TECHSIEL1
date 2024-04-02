package edu.techsiel1.service;

import edu.techsiel1.entity.User;
import edu.techsiel1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public Iterable<User> getAll(){
        return userRepository.findAll();
    }

    public User getOne(Integer userId){
        return userRepository.findById(userId).orElseThrow(()
                -> new RuntimeException("User not found"));
    }

    public User create(User user){return userRepository.save(user);}

    public void delete(Integer userId) {
        userRepository.deleteById(userId);
    }

}
