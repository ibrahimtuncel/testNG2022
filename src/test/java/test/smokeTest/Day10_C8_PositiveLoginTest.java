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
        Thread.sleep(4000);

        MainPage mainPage=new MainPage();
        mainPage.advancedLink.click();
        mainPage.proceedLink.click();
        mainPage.mainPageLoginLink.click();
        Thread.sleep(4000);

        LoginPage loginPage=new LoginPage();
        loginPage.userName.sendKeys(ConfigReader.getProperty("manager_username"));
        loginPage.password.sendKeys(ConfigReader.getProperty("manager_password"));
        loginPage.loginButton.click();

        DefaultPage defaultPage=new DefaultPage();
        Boolean sonuc=defaultPage.addUserButton.isDisplayed();
        Assert.assertTrue(sonuc);

        Driver.closeDriver();
    }

}
