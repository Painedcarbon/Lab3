package sample;

import java.sql.*;

public class DB_Connection {
    String url = "jdbc:mysql://127.0.0.1:3306/yattdb?user=root&password=root";

    Statement statement;

    public DB_Connection() {
        try {
            Connection c = DriverManager.getConnection(url);
            statement = c.createStatement();
            System.out.println("connection successful");
        } catch (SQLException ex) {
            System.err.println("the connection fails");
        }
    }

    public boolean loginWith(String name, String password) {
        try {
            ResultSet rs = statement.executeQuery("SELECT name, password From user WHERE name='" + name + "' AND password='" + password + "'");
            if (rs.next()) {
                System.out.println(name + password + " welcome!");
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
