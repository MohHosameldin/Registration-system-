package com.example;
import java.sql.*;
import java.util.Scanner;
import java.io.Console;

public class Main {
    public static Scanner in= new Scanner(System.in);
     private static String readMaskedPassword(String prompt) {
        Console console = System.console();
        
        if (console != null) {
            char[] passwordChars = console.readPassword(prompt);
            String password = new String(passwordChars);
            java.util.Arrays.fill(passwordChars, ' '); 
            return password;
        } else {
            System.out.print(prompt + " (Note: Password visible in IDE): ");
            return in.nextLine();
        }
    }

    public static void main(String[] args) {
while (true) {
    Users num1 = new Users();

    String url = "jdbc:mysql://localhost:3306/java"; 
        String user = "root"; 
        String password = "cmpunk";

        try ( Connection conn = DriverManager.getConnection(url, user, password)) {


 System.out.println("Welcome to the User Registeration System");
System.out.println("Please enter your details to register: ");
System.out.print("First Name: ");
        String firstName = in.nextLine();
        num1.setFirstName(firstName);
        System.out.print("Last Name: ");
        String lastName = in.nextLine();
        num1.setLastName(lastName);
        System.out.print("Email: ");
        String email = in.nextLine();
         while(!num1.isValidEmail(email) || num1.isDuplicateEmail(email) ) {
          System.out.print("Email is invalid or used before, please enter a valid one");
            email = in.nextLine();
        } 
        num1.setEmail(email);

        System.out.print("Password: ");
        String pass =readMaskedPassword("");
        while (!num1.isValidPassword(pass)) {
            System.out.println("Password is not valid. It must contain at least 8 characters, including uppercase, lowercase, digit, and special character. ");
            pass = readMaskedPassword("Enter password again: ");
        }
        System.out.println("Confirm Password: ");
        String confirmPass = readMaskedPassword("");
        while (!pass.equals(confirmPass)) {
            System.out.println("Passwords do not match. Please re-enter your password: ");
            pass = readMaskedPassword("Confirm Password: "); }
        num1.setPassword(pass);
        System.out.println("Registration successful!");
        System.out.println("Your User ID is: " + num1.getUserId());
        System.out.println("Your First Name is: " + num1.getFirstName());
        System.out.println("Your Last Name is: " + num1.getLastName());
        System.out.println("Your Email is: " + num1.getEmail()); 
        


        num1.savetodatabase();
      
        }
         
            
        catch (SQLException e) {
            System.out.println("Connection error: " + e.getMessage());
        }
    }

   
}   
}
