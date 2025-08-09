package com.example;
import java.sql.*;
import java.util.Scanner;

public class Main {
    public static Scanner in= new Scanner(System.in);
    public static void main(String[] args) {
Users num1 = new Users();
while (true) {
    String url = "jdbc:mysql://localhost:3306/java"; 
        String user = "root"; 
        String password = "cmpunk";

        try ( Connection conn = DriverManager.getConnection(url, user, password)) {


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
        while(!num1.isDuplicateEmail(email)) {
            System.out.println("Email already registered. Please enter a different email: ");
            email = in.nextLine();
            num1.setEmail(email);
        }
        System.out.println("Password: ");
        String pass = in.nextLine();
        while (!num1.isValidPassword(pass)) {
            System.out.println("Password is not valid. It must contain at least 8 characters, including uppercase, lowercase, digit, and special character. ");
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
        


        num1.savetodatabase();
      
        }
         
            
        catch (SQLException e) {
            System.out.println("Connection error: " + e.getMessage());
        }
    }

   
}   
}
