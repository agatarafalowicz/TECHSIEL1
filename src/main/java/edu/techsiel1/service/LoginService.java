package edu.techsiel1.service;

import edu.techsiel1.controller.LoginForm;
import edu.techsiel1.entity.User;
import edu.techsiel1.repository.UserRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class LoginService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Value("${jwt.token.key}$")
    private String key;

    @Autowired
    public LoginService(PasswordEncoder passwordEncoder, UserRepository userRepository){
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    public String login(LoginForm loginForm){
        User user = userRepository.getUserByLogin(loginForm.getLogin());
        if (user != null && passwordEncoder.matches(loginForm.getPassword(), user.getUserPassword())){
            long timeMillis = System.currentTimeMillis();
            String token = Jwts.builder()
                    .issuedAt(new Date(timeMillis))
                    .expiration(new Date(timeMillis+5*60*1000))
                    .claim("id", user.getUserId())
                    .claim("role", user.getRole().toString())  // Użyj klucza "role" zamiast "userRole"
                    .signWith(SignatureAlgorithm.HS256, key)
                    .compact();

            return token;
        }
        else {
            return null;
        }
    }


}