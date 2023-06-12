package com.example.spedox_mobile.models;

/**
 * Represents a login model.
 * This class holds information about a user's login form.
 */
public class LoginModel {
    private String userName;
    private String password;

    /**
     * Constructs a new LoginModel object with the specified username and password.
     *
     * @param userName The username for the login.
     * @param password The password for the login.
     */
    public LoginModel(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    /**
     * Gets the username for the login.
     *
     * @return The username for the login.
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets the username for the login.
     *
     * @param userName The username for the login.
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Gets the password for the login.
     *
     * @return The password for the login.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password for the login.
     *
     * @param password The password for the login.
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
