package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class MainPage {
    public MainPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(linkText = "Log in")
    public WebElement mainPageLoginLink;

    @FindBy(id="details-button")
    public WebElement advancedLink;

    @FindBy(id="proceed-link")
    public WebElement proceedLink;

}
