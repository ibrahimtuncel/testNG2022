package com.dataprovider;

import com.pages.LoginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class Day14_C17_DataProvider2 {
    /*
     Manager kullanici bilgileri ile login fonksiyonunu test et
     getData method'unda 2D array donduren bir object olustur
     */
    @DataProvider (parallel=false)//true olursa paralel test kosar
    public Object [][] getData(){

        Object [][] managerProfile= {
                {"manager","Manager1!"},
                {"manager5","Manager5!"},
                {"manager12","Manager12!"}
        };
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
   @Test(dataProvider = "getData")
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
