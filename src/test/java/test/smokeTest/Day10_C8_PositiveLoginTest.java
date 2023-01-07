package test.smokeTest;

import com.pages.DefaultPage;
import com.pages.LoginPage;
import com.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class Day10_C8_PositiveLoginTest {
    @Test
    public void positiveLoginTest() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        //1. create page objects-MainPage, LoginPage - DONE
        /*2. create test class
        -Create Page Objects
            -create MainPage object
            -calling the page elements using that object
        */
        MainPage mainPage=new MainPage();
        mainPage.advancedLink.click();
        mainPage.proceedLink.click();
        Thread.sleep(4000);
        //At this point we are on the LoginPage
        //Create LoginPage object
        LoginPage loginPage = new LoginPage();
//        loginPage.username.sendKeys("manager");
//        loginPage.password.sendKeys("Manager1!");
        //or
        loginPage.userName.sendKeys(ConfigReader.getProperty("manager_username"));
        loginPage.password.sendKeys(ConfigReader.getProperty("manager_password"));

        loginPage.loginButton.click();

        //We need to automate the login success
        //We choose a CORE ELEMENT on the page
        //WE will use add user button to verify the login page
        //At this point, we are on the Default Page

        DefaultPage defaultPage = new DefaultPage();
        boolean isLoggeedIn = defaultPage.addUserButton.isDisplayed();
        Assert.assertTrue(isLoggeedIn);


    }

}
