package sample;

import org.junit.Assert;
import org.junit.Test;

public class LoginControllerTest {

    @Test
    public void correctUser() {
        String name = "Marcus";
        String password = "secret";
        String expectedName = "marcus";
        Assert.assertEquals(name, expectedName);
    }
}