package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class DefaultPage {
    public DefaultPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath ="//span[@class='hidden-480']")
    public WebElement addUserButton;
    @FindBy(xpath = "//span[.='Hotel Management']")
    public WebElement hotelManagement;

    @FindBy(partialLinkText = "Hotel Rooms")
    public WebElement hotelRoomsTab;

    @FindBy(xpath = "(//span)[contains(@class,'username')]")
    public WebElement userID;



}
