package test.smokeTest;

import com.pages.LoginPage;
import com.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class Day11_C9_NegativeLoginTest {

    /*
    invalidPassword()
    When Kullanıcı sadece yanlış password girer
    Then Kullanıcı ‘wrong password’ mesajını verify eder
    Test Data:
    Url: http://www.carettahotel.com/
    username : manager
    password  : Manage
     */
    @Test
    public void invalidPasswordTest() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("app_url_login"));

        MainPage mainPage=new MainPage();
        mainPage.advancedLink.click();
        mainPage.proceedLink.click();
        Thread.sleep(4000);

        LoginPage loginPage=new LoginPage();
        loginPage.userName.sendKeys(ConfigReader.getProperty("manager_username"));
        loginPage.password.sendKeys(ConfigReader.getProperty("wrong_manager_password"));
        loginPage.loginButton.click();
        System.out.println(loginPage.errorMessage.getText());
        Assert.assertTrue(loginPage.errorMessage.getText().contains("Wrong password"));

        Driver.closeDriver();
    }
    /*
    invalidID()
When Kullanıcı sadece yanlış username girer
Then Kullanıcı ‘Try again please’ mesajını verify eder
Test Data:
Url: http://www.carettahotel.com/
username : manager123
password  : Manager1!
     */
    @Test
    public void invaliduserNameTest() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("app_url_login"));

        MainPage mainPage=new MainPage();
        mainPage.advancedLink.click();
        mainPage.proceedLink.click();
        Thread.sleep(4000);

        LoginPage loginPage=new LoginPage();
        loginPage.userName.sendKeys(ConfigReader.getProperty("wrong_manager_username"));
        loginPage.password.sendKeys(ConfigReader.getProperty("manager_password"));
        loginPage.loginButton.click();
        System.out.println(loginPage.errorMessage.getText());
        Assert.assertTrue(loginPage.errorMessage.getText().contains("Try again please"));

        Driver.closeDriver();
    }
    /*
    invalidIDAndPassword()
When Kullanıcı hem yanlış username ve password girer
Then Kullanıcı ‘Username or password is incorrect, please correct them and try again’ mesajını verify eder
Test Data:
Url: http://www.carettahotel.com/
username : manager123
password  : Manage!

     */
    @Test
    public void invalidAllTest() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("app_url_login"));

        MainPage mainPage=new MainPage();
        mainPage.advancedLink.click();
        mainPage.proceedLink.click();
        Thread.sleep(4000);

        LoginPage loginPage=new LoginPage();
        loginPage.userName.sendKeys(ConfigReader.getProperty("wrong_manager_username"));
        loginPage.password.sendKeys(ConfigReader.getProperty("wrong_manager_password"));
        loginPage.loginButton.click();
        String message=loginPage.errorMessage.getText();
        System.out.println(message);
        Assert.assertTrue(message.contains("Username or password is incorrect, please correct them and try again"));

        Driver.closeDriver();
    }
    }

