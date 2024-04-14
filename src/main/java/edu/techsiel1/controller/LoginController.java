package edu.techsiel1.controller;

import edu.techsiel1.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class for handling user login functionality.
 */
@RestController
public class LoginController {

    private final LoginService loginService;

    /**
     * Constructor injection for LoginService.
     *
     * @param loginService The LoginService used to handle user authentication.
     */
    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    /**
     * Endpoint for user login.
     *
     * @param loginForm The LoginForm containing user credentials.
     * @return ResponseEntity containing a token if login is successful, or an error message if authentication fails.
     */
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginForm loginForm) {
        String token = loginService.login(loginForm);
        if (token == null) {
            return new ResponseEntity<>("Incorrect login or password", HttpStatus.UNAUTHORIZED);
        } else {
            return new ResponseEntity<>(token, HttpStatus.OK);
        }
    }
}
