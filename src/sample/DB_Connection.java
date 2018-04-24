package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DB_Connection {
    String url = "jdbc:mysql://127.0.0.1:3306/onlinedb?user=root&password=root";

    Statement statement;
    ResultSet rs;
    Connection c;

    Integer store_id = null;

    public DB_Connection() {
        try {
            c = DriverManager.getConnection(url);
            statement = c.createStatement();
            System.out.println("connection successful");
        } catch (SQLException ex) {
            System.err.println("the connection fails");
        }
    }

    public boolean login(String store, String name, String password) {

        Integer user_id;

        try {
            rs = statement.executeQuery("SELECT id FROM store WHERE name='" + store + "'");
            if (rs.next()) {
                store_id = rs.getInt(1);
            }

            rs = statement.executeQuery("SELECT id FROM user WHERE name='" + name + "' AND password='" + password + "'");
            if (rs.next()) {
                user_id = rs.getInt(1);
            } else {
                return false;
            }

            rs = statement.executeQuery("SELECT Store_id, User_id FROM store_has_user WHERE Store_id='" + store_id + "'AND User_id='" + user_id + "'");
            if (rs.next()) {
                System.out.println(name + " Welcome!");
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public ObservableList<Product> getProductList() {
        List<Product> results = new ArrayList<>();
        List<Integer> product_ids = new ArrayList<>();

        try {
            rs = statement.executeQuery("SELECT Product_id FROM store_has_product WHERE Store_id=" + store_id);
            while (rs.next()) {
                product_ids.add(rs.getInt(1));
            }

            for (int i = 0; i < product_ids.size(); i++) {
                rs = statement.executeQuery("SELECT * FROM product WHERE id=" + product_ids.get(i));
                if (rs.next()) {
                    Product product = new Product(rs.getInt("id"), rs.getString("name"), rs.getInt("quantity"));
                    results.add(product);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return FXCollections.observableArrayList(results);
    }

    public void decreaseProductQuantity(Product product){
        try {
            System.out.println(product.getName());
            PreparedStatement updateQuantity=c.prepareStatement("UPDATE product SET quantity=quantity-1 WHERE name='"+product.getName()+"'");
            updateQuantity.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
