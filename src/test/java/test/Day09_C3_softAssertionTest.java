package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class Day09_C3_softAssertionTest {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @Test
    public void Test(){
        driver.get("http://www.carettahotel.com/");
        driver.findElement(By.id("details-button")).click();
        driver.findElement(By.id("proceed-link")).click();

        SoftAssert softAssert= new SoftAssert();
        System.out.println(driver.getTitle());
        softAssert.assertTrue(driver.getTitle().equals("Caretta Hotels - Home"));

        driver.findElement(By.linkText("Log in")).click();
        System.out.println(driver.getTitle());
        softAssert.assertTrue(driver.getTitle().equals("Caretta Hotels - Log in"));

        softAssert.assertAll();
    }



}
