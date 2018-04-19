package sample;

import org.junit.Assert;

import static org.junit.Assert.*;

/**
 * Created by Marcus DataSysUtv on 2018-04-19.
 */
public class ControllerTest {
    @org.junit.Test
    public void correctUser() throws Exception {
        String name = "Marcus";
        String password = "secret";
        String expectedName = "marcus";
        Assert.assertEquals(name,expectedName);
    }

}