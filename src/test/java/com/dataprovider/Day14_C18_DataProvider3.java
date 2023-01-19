package com.dataprovider;

import com.pages.LoginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExcelUtil;

import java.util.List;
import java.util.Map;

public class Day14_C18_DataProvider3 {

    ExcelUtil excelUtil;
    //List<Map<String, String>> data;
    @DataProvider
    public Object [][] getData(){
        String path="./src/test/java/resources/smoketestdata (1).xlsx";
        String sheetName="manager_login_info";
        excelUtil= new ExcelUtil(path,sheetName);
        //data=excelUtil.getDataList();
        //System.out.println(data);
        Object[][] managerProfile=excelUtil.getDataArrayWithoutFirstRow();
        //System.out.println(managerProfile.toString());

        return managerProfile;
    }
    LoginPage loginPage;
    public void setUp(){
        loginPage=new LoginPage();
        Driver.getDriver().get(ConfigReader.getProperty("app_url_login"));
        try{
            Thread.sleep(1000);
            loginPage.advancedLink.click();
            loginPage.proceedLink.click();
            Thread.sleep(1500);
        }catch (Exception e){
            System.out.println("Advanced Link gorunmedi");
        }
    }
    @Test(dataProvider="getData")
    public void  managerLoginTest(String kullaniciAdi, String sifre){
        setUp();
        loginPage.userName.sendKeys(kullaniciAdi);
        loginPage.password.sendKeys(sifre);
        loginPage.loginButton.click();

    }
    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }
}
