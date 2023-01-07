package com.excelautomation;

import com.pages.DefaultPage;
import com.pages.LoginPage;
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
    List<Map<String,String> > testData;

    //page object olustur
     LoginPage loginPage;
    DefaultPage defaultPage;
    public void setUp(){
        Driver.getDriver().get(ConfigReader.getProperty("app_url_login"));
        loginPage=new LoginPage();
    }
}
