package main;

import java.sql.*;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        try {
            // création d'une classe perso
            Class.forName("com.mysql.cj.jdbc.Driver");

            //db parameters
            String url = "jdbc:mysql://localhost:3306/mysqljdbc?serverTimezone=UTC";
            String user = "root";
            String password = "";

            Scanner sc = new Scanner(System.in);
            String chaine;
            int id;

            // create a connection to the database
            Connection conn = DriverManager. getConnection(url, user, password);
            int rep;
            Statement stmt = conn.createStatement();
            String sql;
            do {
                do {
                    System.out.println("1: Ajouter \n 2: Lire \n 3: Modifier \n 4: Supprimer \n 0: Quitter\n\n\n");
                    rep = sc.nextInt();
                    sc.nextLine();
                } while (rep < 0 && rep > 4);
                switch (rep) {
                    case 0:
                        break;
                    case 1:
                        System.out.println("Saisir le nouveau nom de client à ajouter:\n");
                        chaine = sc.nextLine();
                        sql = "insert into client(nom) values('" + chaine + "');";
                        stmt.executeUpdate(sql);
                        break;
                    case 2:
                        sql = "select * from client;";
                        ResultSet rs = stmt.executeQuery(sql);
                        while (rs.next()) {
                            System.out.println(rs.getInt("id") + "\t |\t " + rs.getString("nom"));
                        }
                        break;
                    case 3:
                        System.out.println("Saisir l'id du client à modifier:\n");
                        id = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Saisir le  nom du client à modifier:\n");
                        chaine = sc.nextLine();
                        sql = "UPDATE client  SET nom = '"+ chaine +"'WHERE id = " + id;
                        stmt.executeUpdate(sql);
                        break;
                    case 4:
                        System.out.println("Saisir l'id du client à supprimer:\n");
                        id = sc.nextInt();
                        sc.nextLine();
                        sql = "delete from client where id = " + id ;
                        stmt.executeUpdate(sql);
                        break;
                }
            }while(rep!=0);





                System.out.println("Ca y est !");

            stmt.close();
            conn.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
