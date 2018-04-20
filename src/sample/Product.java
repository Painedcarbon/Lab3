package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Product {
    private final int id;
    private final StringProperty name;
    private int quantity;
    private final int Store_name;

    public Product(int id, String name, int quantity, int store_name) {
        this.id = id;
        this.name = new SimpleStringProperty(name);
        this.quantity = quantity;
        Store_name = store_name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name.get();
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
