package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class ConnectionFactory {

   private static final String driver = "com.mysql.jdbc.Driver";
   private static final String banco = "jdbc:mysql://localhost:3036/catina_ifsc";
   private static final String usuario = "root";
   private static final String senha = "ifsc"; 

   public static Connection getConnection() {
    try {
        return DriverManager.getConnection(
            banco +
            "?verifyServerCertificate=false" +
            "&useSSL=false" +
            "&requireSSL=false" +
            "&USER=" + usuario +
            "&password=" + senha +
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
