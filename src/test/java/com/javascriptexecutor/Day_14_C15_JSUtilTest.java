package com.javascriptexecutor;

import com.pages.LoginPage;
import com.pages.MainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.JSUtils;
import utilities.ReusableMethots;

public class Day_14_C15_JSUtilTest {
    MainPage mainPage;
    LoginPage loginPage;
    @Test
    public void  scrollIntoView(){
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        mainPage=new MainPage();
        try{
            Thread.sleep(1000);
            mainPage.advancedLink.click();
            Thread.sleep(1000);
            mainPage.proceedLink.click();
            Thread.sleep(1000);
        }catch (Exception e){
            System.out.println("Advanced Link gorunmedi");
        }
        WebElement haveAQuestion=Driver.getDriver().findElement(By.xpath("//*[.='Have a Questions?']"));
        JSUtils.scrollIntoViewJS(haveAQuestion);
        ReusableMethots.waitFor(3);
        Assert.assertEquals(haveAQuestion.getText(),"Have a Questions?");
        Assert.assertTrue(haveAQuestion.isDisplayed());
        Driver.closeDriver();
    }

    @Test
    public void clickByJS(){
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        mainPage=new MainPage();
        try{
            Thread.sleep(1000);
            mainPage.advancedLink.click();
            Thread.sleep(1000);
            mainPage.proceedLink.click();
            Thread.sleep(1000);
        }catch (Exception e){
            System.out.println("Advanced Link gorunmedi");
        }
        //mainPage.mainPageLoginLink.click();
        loginPage=new LoginPage();
        //WebElement loginLink=Driver.getDriver().findElement(By.linkText("Log in"));
        //JSUtils.clickElementByJS(loginLink);
        WebElement checkAvailabilityButton = Driver.getDriver().findElement(By.xpath("//input[@type='submit']"));
        JSUtils.clickElementByJS(checkAvailabilityButton);
        Driver.closeDriver();

    }
    @Test
    public void flash(){
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        mainPage=new MainPage();
        try{
            Thread.sleep(1000);
            mainPage.advancedLink.click();
            Thread.sleep(1000);
            mainPage.proceedLink.click();
            Thread.sleep(1000);
        }catch (Exception e){
            System.out.println("Advanced Link gorunmedi");
        }
        WebElement checkAvailabilityButton = Driver.getDriver().findElement(By.xpath("//input[@type='submit']"));
        JSUtils.flash(checkAvailabilityButton);
        Driver.closeDriver();
    }
    @Test
    public void changeColor() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        mainPage=new MainPage();
        try{
            Thread.sleep(1000);
            mainPage.advancedLink.click();
            mainPage.proceedLink.click();
            Thread.sleep(1500);
        }catch (Exception e){
            System.out.println("Advanced Link gorunmedi");
        }
        WebElement checkAvailabilityButton = Driver.getDriver().findElement(By.xpath("//input[@type='submit']"));
        JSUtils.changeColor("red",checkAvailabilityButton);
        Thread.sleep(1000);
        JSUtils.scrollDownByJS();
        Thread.sleep(1000);
        JSUtils.generateAlert("Hello");
        ReusableMethots.waitFor(2);
    }
    @AfterMethod
    public void After(){

        Driver.closeDriver();
    }
}
