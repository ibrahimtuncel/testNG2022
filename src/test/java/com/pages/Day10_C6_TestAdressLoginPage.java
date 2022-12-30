package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
    //https://www.testyou.in/Login.aspx
public class Day10_C6_TestAdressLoginPage {//bu sf page class
    //page objectleri ve ana metodları ekleris

    //1 consrtuctor olusturulur.
    //PageFactory.initElements(driver,this) bu page pbjectleri calıstırır
    public Day10_C6_TestAdressLoginPage(){//constructor

        PageFactory.initElements(Driver.getDriver(),this);
        }
        //2 page syf daki elementleri bul,olustur ve calstır
    //Note: 8 locator da kullanılabilir
    @FindBy(id="ctl00_CPHContainer_txtUserLogin")
    public WebElement email;

    @FindBy(id="ctl00_CPHContainer_txtPassword")
    public WebElement password;

    @FindBy(id="ctl00_CPHContainer_btnLoginn")
    public WebElement loginButton;
}
