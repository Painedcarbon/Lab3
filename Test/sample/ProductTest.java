package sample;

import org.junit.Assert;
import org.junit.Test;

public class ProductTest {

    int id = 0, quantity = 100;
    String name = "panties";
    Product product = new Product(id, name, quantity);

    @Test
    public void getId() {
        Assert.assertEquals(id, product.getId());
    }

    @Test
    public void getName() {
        Assert.assertEquals(name, product.getName());
    }

    @Test
    public void getQuantity() {
        Assert.assertEquals(quantity, product.getQuantity());
    }

    @Test
    public void setQuantity() {
        int newQuantity = 50;
        product.setQuantity(50);
        Assert.assertEquals(newQuantity, product.getQuantity());
    }
}