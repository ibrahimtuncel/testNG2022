package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LoginPage {
    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
        }
        @FindBy(id="UserName")
    public WebElement userName;
    @FindBy(id="Password")
    public WebElement password;
    @FindBy(id="btnSubmit")
    public WebElement loginButton;
    @FindBy(id="divMessageResult")
    public WebElement errorMessage;

    @FindBy(id="details-button")
    public WebElement advancedLink;

    @FindBy(id="proceed-link")
    public WebElement proceedLink;
}
