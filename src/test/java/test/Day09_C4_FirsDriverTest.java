package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class Day09_C4_FirsDriverTest
{
    //Amazon'a git
    //    title'in 'Amazon'u icerdigini verify et-
    //utilities driver class calısacak
    @Test
    public void amazonTitleTest(){
        Driver.getDriver().get("https://www.amazon.com");

        String actualTitle=Driver.getDriver().getTitle();
        System.out.println(actualTitle);

        Assert.assertTrue(actualTitle.contains("Amazon"));

        Driver.closeDriver();
    }
}
