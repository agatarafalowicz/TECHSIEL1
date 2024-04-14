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

/**
 * Service class for user login functionality.
 * This class provides methods to authenticate user credentials and generate JWT tokens.
 */
@Service
public class LoginService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Value("${jwt.token.key}")
    private String key;

    /**
     * Constructs a LoginService with the specified PasswordEncoder and UserRepository.
     *
     * @param passwordEncoder The password encoder used for password hashing and verification.
     * @param userRepository The repository used for accessing user data.
     */
    @Autowired
    public LoginService(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    /**
     * Performs user authentication based on the provided login credentials.
     * Generates a JWT token upon successful authentication.
     *
     * @param loginForm The login form containing user login and password.
     * @return A JWT token if authentication is successful, otherwise null.
     */
    public String login(LoginForm loginForm) {
        User user = userRepository.getUserByLogin(loginForm.getLogin());
        if (user != null && passwordEncoder.matches(loginForm.getPassword(), user.getUserPassword())) {
            long timeMillis = System.currentTimeMillis();
            String token = Jwts.builder()
                    .setIssuedAt(new Date(timeMillis))
                    .setExpiration(new Date(timeMillis + 5 * 60 * 1000))
                    .claim("id", user.getUserId())
                    .claim("role", user.getRole().toString())
                    .signWith(SignatureAlgorithm.HS256, key)
                    .compact();

            return token;
        } else {
            return null;
        }
    }
}
