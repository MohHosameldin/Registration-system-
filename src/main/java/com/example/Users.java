package com.example;
import java.util.regex.Pattern;
public class Users {
    private static int id= 2510001;
    private int UserId; 
    private String FirstName;
    private String LastName;
    private String Email;
    private String Password;

    public Users(String firstName, String lastName, String email, String password) {
        this.UserId = id;
        this.FirstName = firstName;
        this.LastName = lastName;
        this.Email = email;
setPassword(password);
id++;
    }
    
    public boolean isValidPassword(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }
        
        boolean hasUpper = password.chars().anyMatch(Character::isUpperCase);
        boolean hasLower = password.chars().anyMatch(Character::isLowerCase);
        boolean hasDigit = password.chars().anyMatch(Character::isDigit);
        boolean hasSpecial = password.chars().anyMatch(ch -> 
            "!@#$%^&*()_+-=[]{}|;:,.<>?".indexOf(ch) >= 0);
        
        return hasUpper && hasLower && hasDigit && hasSpecial;
    }
    
    public String getFirstName() {
        return FirstName;
    }
    public void setFirstName(String firstName) {
        FirstName = firstName;
    }
    public String getLastName() {
        return LastName;
    }
    public void setLastName(String lastName) {
        LastName = lastName;
    }
    public String getEmail() {
        return Email;
    }
    public void setEmail(String email) {
        Email = email;
    }
    public String getPassword() {
        return Password;
    }
    public void setPassword(String password) {
    if (!isValidPassword(password)) {
        throw new IllegalArgumentException("Password is not valid. It must contain at least 8 characters, including uppercase, lowercase, digit, and special character.");
    }
    this.Password = password;
}
}
