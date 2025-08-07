package com.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/Users"; // Replace 'testdb' with your database name
        String user = "root"; // Replace with your MySQL username
        String password = "Mo4magic$"; // Replace with your MySQL password

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            
        } catch (SQLException e) {
            System.out.println("Connection error: " + e.getMessage());
        }
    }
}
