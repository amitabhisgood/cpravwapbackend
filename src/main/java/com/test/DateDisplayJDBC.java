/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.test;

/**
 *
 * @author Amitabh Choudhury
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DateDisplayJDBC {

//    private static final String DB_URL = "jdbc:mysql://localhost:3306/cprst";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/cprst?serverTimezone=Asia/Kolkata";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "acite1234";

    public static void main(String[] args) {
        String query = "SELECT date FROM d270924java";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                java.sql.Timestamp sqlTimestamp = rs.getTimestamp("date");
                System.out.println(sqlTimestamp.toLocalDateTime());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
