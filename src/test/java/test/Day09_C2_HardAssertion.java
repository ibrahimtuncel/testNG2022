package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Day09_C2_HardAssertion {
    /*
     * when user goes to the application home page
     * then verifies the title equals 'Caretta Hotel'
     * and clicks on login button
     * then verify the page title equals Caretta Hotel - Log in
     * */
    WebDriver driver;
    @BeforeMethod
        public void setUp(){

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @Test
    public void hardAssertTest() throws InterruptedException {
        driver.get("http://www.carettahotel.com/");
        Thread.sleep(3000);
        driver.findElement(By.id("details-button")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("proceed-link")).click();

        System.out.println(driver.getTitle());//Caretta Hotels - Home
        Assert.assertFalse(driver.getTitle().equals("Caretta Hotel"));
        driver.findElement(By.linkText("Log in")).click();

        System.out.println(driver.getTitle());
        Assert.assertTrue(driver.getTitle().equals("Caretta Hotels - Log in"));





    }


}
