package edu.techsiel1.controller;

/**
 * Represents a login form containing user credentials (login and password).
 */
public class LoginForm {

    private String login;
    private String password;

    /**
     * Get the login (username) from the login form.
     *
     * @return The login (username) string.
     */
    public String getLogin() {
        return login;
    }

    /**
     * Set the login (username) for the login form.
     *
     * @param login The login (username) string to set.
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Get the password from the login form.
     *
     * @return The password string.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set the password for the login form.
     *
     * @param password The password string to set.
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
