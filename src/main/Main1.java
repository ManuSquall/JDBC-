package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main1 {
    public static void main(String[] args) {
        try {
            // création d'une classe perso
            Class.forName("com.mysql.cj.jdbc.Driver");

            //db parameters
            String url = "jdbc:mysql://localhost:3306/mysqljdbc?serverTimezone=UTC";
            String user = "root";
            String password = "";

            // create a connection to the database
            Connection conn = DriverManager. getConnection(url, user, password);


            // création d'un objet statement pour préparer et envoyer des instructions SQL
            Statement stmt = conn.createStatement();

            // redaction de notre instruction sql
            String sql="insert into client(nom) values('squall');";
            //stmt.executeQuery(sql);

            stmt.executeUpdate(sql);

            stmt.close();
            conn.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
