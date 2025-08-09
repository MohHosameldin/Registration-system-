package com.example;
import java.util.regex.Pattern;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
public class Users {
    private static Set<String> registeredEmails = new HashSet<>();
    private static List<Users> allUsers = new ArrayList<>();
    private static int id= 2510001;
    private int UserId; 
    private String FirstName;
    private String LastName;
    private String Email;
    private String Password;
    private static final Pattern NAME_PATTERN = Pattern.compile("^[a-zA-Z]+$");
private static final Pattern EMAIL_PATTERN = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
public Users() {
        this.UserId = id;
        id++;
    }
    public Users(String firstName, String lastName, String email, String password) {
        this.UserId = id;
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
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
        boolean hasSpecial = password.chars().anyMatch(ch ->"!@#$%^&*()_+-=[]{}|;:,.<>?".indexOf(ch) >= 0);
        
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
            String normalizedEmail = email.trim().toLowerCase();
            
            if (isDuplicateEmail(normalizedEmail)) {
                System.out.println("Email already exists! Please use a different email address.");
                return; 
            }
            this.Email = normalizedEmail;
            registeredEmails.add(normalizedEmail);
        } else {
            System.out.println("Email is not valid. Please provide a valid email format (example@domain.com).");
        }
    }
 public static boolean isDuplicateEmail(String email) {
        if (email == null) return false;
        return registeredEmails.contains(email.trim().toLowerCase());
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
public boolean isValidEmail(String email) {
    if (email == null || email.trim().isEmpty()|| !EMAIL_PATTERN.matcher(email.trim()).matches()) {
        return false;
    }
 
  else {
    return true;
  }  
  
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
    public void savetodatabase(){
  String url = "jdbc:mysql://localhost:3306/Users"; // Replace 'testdb' with your database name
        String user = "root"; // Replace with your MySQL username
        String password = "Mo4magic$"; // Replace with your MySQL password
        String insertSQL = "INSERT INTO users (id, First_name, Second_name, Email, Password) VALUES (?, ?, ?, ?, ?)";

        try ( Connection conn = DriverManager.getConnection(url, user, password) 
             PreparedStatement pstmt = conn.prepareStatement(insertSQL) 
        ) {
            pstmt.setInt(1, this.UserId);
            pstmt.setString(2, this.FirstName);
            pstmt.setString(3, this.LastName);
            pstmt.setString(4, this.Email);
            pstmt.setString(5, this.Password);
            pstmt.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println("Connection error: " + e.getMessage());
        }

    }

}
