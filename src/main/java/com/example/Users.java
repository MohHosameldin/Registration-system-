package com.example;
import java.util.regex.Pattern;
public class Users {
    private static int id= 2510001;
    private int UserId; 
    private String FirstName;
    private String LastName;
    private String Email;
    private String Password;
    private static final Pattern NAME_PATTERN = Pattern.compile("^[a-zA-Z]+$");
private static final Pattern EMAIL_PATTERN = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");

    public Users(String firstName, String lastName, String email, String password) {
        this.UserId = id;
        setFirstName(firstName);
        setLastName(lastName);
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
    if (firstName != null && NAME_PATTERN.matcher(firstName.trim()).matches() && !firstName.trim().isEmpty()) {
        FirstName = firstName.trim();
    } else {
        System.out.println("First name is not valid. It must contain only letters.");
    }
}

    public String getLastName() {
        return LastName;
    }
public void setLastName(String lastName) {
    if (lastName != null && NAME_PATTERN.matcher(lastName.trim()).matches() && !lastName.trim().isEmpty()) {
        LastName = lastName.trim();
    } else {
        System.out.println("Last name is not valid. It must contain only letters.");
    }
}

    public String getEmail() {
        return Email;
    }
    public void setEmail(String email) {
    if (email != null && EMAIL_PATTERN.matcher(email.trim()).matches()) {
        Email = email.trim().toLowerCase();
    } else {
        System.out.println("Email is not valid. Please provide a valid email format (example@domain.com).");
    }
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
public int getUserId() {
        return UserId;
    }

    @Override
    public String toString() {
        return "Users{" +
                "UserId=" + UserId +
                ", FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", Email='" + Email + '\'' +
                ", Password='" + Password + '\'' +
                '}';
    }
}
