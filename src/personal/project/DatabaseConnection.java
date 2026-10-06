package personal.project;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author titus
 */
public class DatabaseConnection{
    private static final String URL = "jdbc:mysql://localhost:3306/room_management";
    private static final String USER = "root";
    private static final String PASSWORD = "Titustrevor@22";
    
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}