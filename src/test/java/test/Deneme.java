package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class Deneme {

    @Test
    public void denemeTest(){
        Driver.getDriver().get(ConfigReader.getProperty("amazon_url"));
        System.out.println(Driver.getDriver().getTitle());
        String acttitle=Driver.getDriver().getTitle();
        String ekstitle=ConfigReader.getProperty("amazon_title");
        Assert.assertTrue(acttitle.equals(ekstitle));
        Assert.assertEquals(acttitle,ekstitle);

    }
}
