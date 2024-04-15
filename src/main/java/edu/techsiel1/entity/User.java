package edu.techsiel1.entity;

import edu.techsiel1.commonTypes.UserRole;
import jakarta.persistence.*;

/**
 * Represents a user entity in the library system.
 */
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

    public User() {

    }

    /**
     * Get the ID of the user.
     *
     * @return The user ID.
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * Set the ID of the user.
     *
     * @param userId The user ID to set.
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * Get the login username of the user.
     *
     * @return The login username.
     */
    public String getLogin() {
        return login;
    }

    /**
     * Set the login username of the user.
     *
     * @param login The login username to set.
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Get the password of the user.
     *
     * @return The user's password.
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * Set the password of the user.
     *
     * @param userPassword The user's password to set.
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    /**
     * Get the role of the user.
     *
     * @return The user's role.
     */
    public UserRole getRole() {
        return role;
    }

    /**
     * Set the role of the user.
     *
     * @param role The user's role to set.
     */
    public void setRole(UserRole role) {
        this.role = role;
    }

    /**
     * Get the email address of the user.
     *
     * @return The user's email address.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set the email address of the user.
     *
     * @param email The user's email address to set.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Get the name of the user.
     *
     * @return The user's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the user.
     *
     * @param name The user's name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Constructs a new User with the specified user ID.
     *
     * @param userId The user ID to set.
     */
    public User(Integer userId) {
        this.userId = userId;
    }


}
