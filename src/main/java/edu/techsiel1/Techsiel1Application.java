package edu.techsiel1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class Techsiel1Application {

    public static void main(String[] args) {
        SpringApplication.run(Techsiel1Application.class, args);
    }

}
