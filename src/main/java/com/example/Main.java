package com.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.regex.Pattern;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.Scanner;

public class Main {
    public static Scanner in= new Scanner(System.in);
    public static void main(String[] args) {
Users num1 = new Users();
System.out.println("Welcome to the User Registeration System");
System.out.println("Please enter your details to register: ");
System.out.println("First Name: ");
        String firstName = in.nextLine();
        num1.setFirstName(firstName);
        System.out.println("Last Name: ");
        String lastName = in.nextLine();
        num1.setLastName(lastName);
        System.out.println("Email: ");
        String email = in.nextLine();
        num1.setEmail(email);
  while(!num1.isValidEmail(email)) {
            email = in.nextLine();
            num1.setEmail(email);
        } 
        System.out.println("Password: ");
        String pass = in.nextLine();
        while (!num1.isValidPassword(pass)) {
            System.out.println("Invalid password. Please enter a valid password: ");
            pass = in.nextLine();
        }
        System.out.println("Confirm Password: ");
        String confirmPass = in.nextLine();
        while (!pass.equals(confirmPass)) {
            System.out.println("Passwords do not match. Please re-enter your password: ");
            pass = in.nextLine(); }
        num1.setPassword(pass);
        System.out.println("Registration successful!");
        System.out.println("Your User ID is: " + num1.getUserId());
        System.out.println("Your First Name is: " + num1.getFirstName());
        System.out.println("Your Last Name is: " + num1.getLastName());
        System.out.println("Your Email is: " + num1.getEmail()); 

        String url = "jdbc:mysql://localhost:3306/Users"; // Replace 'testdb' with your database name
        String user = "root"; // Replace with your MySQL username
        String password = "Mo4magic$"; // Replace with your MySQL password

        try ( Connection conn = DriverManager.getConnection(url, user, password)
        
        
        ) {
            
        } catch (SQLException e) {
            System.out.println("Connection error: " + e.getMessage());
        }
    }



   
}
