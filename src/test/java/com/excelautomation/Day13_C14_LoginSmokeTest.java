package com.excelautomation;

import com.pages.DefaultPage;
import com.pages.LoginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExcelUtil;

import java.util.List;
import java.util.Map;

public class Day13_C14_LoginSmokeTest {
    ExcelUtil excelUtil;
    //datayı key-value pairs seklinde(username-password) olarak al
    //Map--> Map<String,String> :{manager,Manager1}
    //List Map--> List<Map<
    List<Map<String, String>> testData;

    //page object olustur
    LoginPage loginPage;
    DefaultPage defaultPage;

    public void setUp() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("app_url_login"));
        loginPage = new LoginPage();
        Thread.sleep(1000);
//        if (loginPage.advancedLink.isDisplayed()){
        try{
            Thread.sleep(1000);
            loginPage.advancedLink.click();
            Thread.sleep(1000);
            loginPage.proceedLink.click();
            Thread.sleep(1000);
        }catch (Exception e){
            System.out.println("Advanced Link gorunmedi");
        }
    }
    @Test
    public void adminLoginTest() throws InterruptedException {
        //1.yol
        //setUp();
        //        loginPage.userName.sendKeys(ConfigReader.getProperty("admin_username"));
        //        loginPage.password.sendKeys(ConfigReader.getProperty("admin_password"));
        //        loginPage.loginButton.click();

        //2.yol
        //setUp();
        //        loginPage.userName.sendKeys("manager");
        //        loginPage.password.sendKeys("manager1!");
        //        loginPage.loginButton.click();

        //3.yol excel den data al
        String path="./src/test/java/resources/smoketestdata (1).xlsx";
        String sheetName="admin_login_info";
        excelUtil=new ExcelUtil(path,sheetName);
        testData=excelUtil.getDataList();
        System.out.println(testData);//[{password=Arcane123!, username=admin}]

        for(Map<String,String>herData:testData){
            setUp();
            loginPage.userName.sendKeys(herData.get("username"));
            loginPage.password.sendKeys(herData.get("password"));
            loginPage.loginButton.click();

        }
    }

    @Test
    public void managerLoginTest() throws InterruptedException {

        String path="./src/test/java/resources/smoketestdata (1).xlsx";
        String sheetName="manager_login_info";
        excelUtil= new ExcelUtil(path,sheetName);

        testData=excelUtil.getDataList();
        System.out.println(testData);// [{password=Manager1!, username=manager}, {password=Manager5!, username=manager5}, {password=Manager12!, username=manager12}]

        for(Map<String,String> eachData : testData ){//herData bir username-password pairs temsil eder
            setUp();//login in each loop
            loginPage.userName.sendKeys(eachData.get("username"));
            loginPage.password.sendKeys(eachData.get("password"));
            loginPage.loginButton.click();
        }
    }

    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }

    }


