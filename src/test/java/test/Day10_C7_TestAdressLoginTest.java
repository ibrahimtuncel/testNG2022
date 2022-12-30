package test;

import com.pages.Day10_C6_TestAdressLoginPage;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class Day10_C7_TestAdressLoginTest {
    @Test
    public void testAdresssLogin(){
        //applicationa-adrese git //https://www.testyou.in/Login.aspx
        //Driver.getDriver().get("//https://www.testyou.in/Login.aspx");
        Driver.getDriver().get(ConfigReader.getProperty("test_address_url"));

        Day10_C6_TestAdressLoginPage testAdressLoginPage=new Day10_C6_TestAdressLoginPage();
        testAdressLoginPage.email.sendKeys(ConfigReader.getProperty("test_address_email"));
        testAdressLoginPage.password.sendKeys(ConfigReader.getProperty("test_address_password"));
        testAdressLoginPage.loginButton.click();

        Driver.closeDriver();

        //100 test case varken sifre değişirse config.properties e
        //gidip (key-valıe)sifreleri değiştirmek gerekir.aksi halde test casedeki
        //tüm şifreleri değiştirmek gerekir
    }
}
