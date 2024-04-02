package edu.techsiel1.entity;

import edu.techsiel1.commonTypes.UserRole;
import jakarta.persistence.*;


@Entity
@Table(name="user", schema = "library")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="userId")
    private Integer userId;

    @Basic
    @Column(name="login", unique = true, nullable = false)
    private String login;

    @Basic
    @Column(name="userPassword", nullable = false)
    private String userPassword;

    @Enumerated(EnumType.STRING)
    @Column(name="role", nullable = false)
    private UserRole role;

    @Basic
    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Basic
    @Column(name = "name", unique = false, nullable = false)
    private String name;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
