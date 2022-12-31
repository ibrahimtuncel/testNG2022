package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HotelRoomPage {
    public HotelRoomPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(partialLinkText = "ADD HOTELROOM")
    public WebElement addHotelRoomLink;

    @FindBy(id = "IDHotel")
    public WebElement idDropdown;

    @FindBy(id="Code")
    public WebElement code;

    @FindBy(id="Name")
    public WebElement name;

    @FindBy(id="Location")
    public WebElement location;

    @FindBy(xpath="//textarea[@dir='ltr']")
    public WebElement description;

    @FindBy(id="Price")
    public WebElement price;
    @FindBy(id="data-id")
    public WebElement price600;

    @FindBy(id="IDGroupRoomType")
    public WebElement roomTypeDropdown;

    @FindBy(id="MaxAdultCount")
    public WebElement maxAdultCount;

    @FindBy(id="MaxChildCount")
    public WebElement maxChildrenCount;

    @FindBy(id="IsAvailable")
    public WebElement isApprovedCheckbox;

    @FindBy(id="btnSubmit")
    public WebElement saveButton;

    @FindBy(xpath="//div[@class='bootbox-body']")
    public WebElement popupMessage;

    @FindBy(xpath="//button[@data-bb-handler='ok']")
    public WebElement okButton;

    @FindBy(xpath = "//li[@data-id='700']")
    public WebElement price700;


}
