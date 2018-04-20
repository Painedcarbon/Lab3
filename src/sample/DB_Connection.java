package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DB_Connection {
    String url = "jdbc:mysql://192.168.1.3:3306/yattdb?user=root&password=root";

    Statement statement;
    ResultSet rs;

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
            rs = statement.executeQuery("SELECT name, password From user WHERE name='" + name + "' AND password='" + password + "'");
            if (rs.next()) {
                System.out.println(name + password + " welcome!");
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public ObservableList<Product> getProductList() {
        List<Product> results = new ArrayList<>();
        try {
            rs = statement.executeQuery("SELECT * FROM product");
            while (rs.next()) {
                Product product = new Product(rs.getInt("id"), rs.getString("name"), rs.getInt("quantity"));
                results.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return FXCollections.observableArrayList(results);


    }
}
