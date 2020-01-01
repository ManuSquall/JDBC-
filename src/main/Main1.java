package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main1 {
    public static void main(String[] args) {
        try {
            // création d'une classe perso
            Class.forName("com.mysql.cj.jdbc.Driver");

            //db parameters
            String url = "jdbc:mysql://localhost:3306/mysqljdbc";
            String user = "root";
            String password = "";

            // create a connection to the database
            Connection conn = DriverManager. getConnection(url, user, password);


        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
