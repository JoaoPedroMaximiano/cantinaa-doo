package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class ConnectionFactory {
   private static final String BANCO = "jdbc:mysql://127.0.0.1:3306/cantina";
   private static final String USUARIO = "root";
   private static final String SENHA = "ifsc"; 

   public static Connection getConnection() {
    try {
        return DriverManager.getConnection(
            BANCO +
            "?verifyServerCertificate=false" +
            "&useSSL=false" +
            "&requireSSL=false" +
            "&USER=" + USUARIO +
            "&password=" + SENHA +
            "&serverTimezone=UTC"
        );
    } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }   
    
    public static void closeConnection(Connection connection) {
       try {
           connection.close();
       } catch (SQLException ex) {
           ex.printStackTrace();
       }
    }
    
    public static void closeConnection(Connection connection, PreparedStatement statement) {
       try {
           statement.close();
           connection.close();
       } catch (SQLException ex) {
           ex.printStackTrace();
       }
    }   
    
    public static void closeConnection(Connection connection, PreparedStatement statement, ResultSet resultset) {
       try {
           statement.close();
           resultset.close();
           connection.close();
       } catch (SQLException ex) {
           ex.printStackTrace();
       }
    }
   
}
