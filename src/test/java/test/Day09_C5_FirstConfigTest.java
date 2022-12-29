package test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class Day09_C5_FirstConfigTest {
    //   app_url  'e git
    //   Title'in' Caretta Hotel - Home oldugunu assert et
   @Test
           public void firstCongigTest() throws InterruptedException {
       //Driver.getDriver().get("http://www.carettahotel.com/");

       Driver.getDriver().get(ConfigReader.getProperty("app_url"));
       Thread.sleep(5000);
       //driver.findElement(By.id("details-button")).click();
       //driver.findElement(By.id("proceed-link")).click();

       //title kontrolu
       String actualTitle=Driver.getDriver().getTitle();
       String ekspectedTitle=ConfigReader.getProperty("app_title");
       Assert.assertEquals(actualTitle,ekspectedTitle);//Junitte
       //ekspected ilk sırada olurdu testNG de ikinci sırada

   }

}
