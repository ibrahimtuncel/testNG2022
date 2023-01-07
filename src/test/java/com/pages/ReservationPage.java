package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ReservationPage {
    public  ReservationPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(css = ".hidden-480")
    public WebElement addReservationRoom;
    @FindBy(id = "IDUser")
    public WebElement IDHotelDropDown;
    @FindBy(id = "IDHotelRoom")
    public WebElement IDHotelRoomDropDown;
    @FindBy(id = "Price")
    public WebElement price;
    @FindBy(id = "DateStart")
    public WebElement dateStart;
    @FindBy(xpath = "//*[.=6]")
    public WebElement startDay;

    @FindBy(id="DateEnd")
    public WebElement dateEnd;
    @FindBy(xpath = "//*[.=10]")
    public WebElement endDay;
    @FindBy(id = "AdultAmount")
    public WebElement adultAmount;
    @FindBy(id = "ChildrenAmount")
    public WebElement childAmount;
    @FindBy(id = "ContactNameSurname")
    public WebElement nameSurname;
    @FindBy(id = "ContactPhone")
    public WebElement phone;
    @FindBy(id = "ContactEmail")
    public WebElement email;
    @FindBy(id = "Notes")
    public WebElement not;
    @FindBy(id = "Approved")
    public WebElement onay;
    @FindBy(id = "IsPaid")
    public  WebElement pay;
    @FindBy(id = "btnSubmit")
    public WebElement save;
    @FindBy(xpath ="//div[@class='bootbox-body']")
    public WebElement message;
    @FindBy(xpath = "//button[@data-bb-handler='ok']")
    public WebElement ok;

}
