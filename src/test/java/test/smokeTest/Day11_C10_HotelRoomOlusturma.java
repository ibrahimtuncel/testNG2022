package test.smokeTest;

import com.github.javafaker.Faker;
import com.pages.DefaultPage;
import com.pages.HotelRoomPage;
import com.pages.LoginPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class Day11_C10_HotelRoomOlusturma {
    LoginPage loginPage=new LoginPage();
    DefaultPage defaultPage=new DefaultPage();
    HotelRoomPage hotelRoomPage=new HotelRoomPage();
    Faker faker=new Faker();
    @BeforeMethod
            public void setUp() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("app_url_login"));
        loginPage.advancedLink.click();
        loginPage.proceedLink.click();
        loginPage.userName.sendKeys(ConfigReader.getProperty("manager_username"));
        loginPage.password.sendKeys(ConfigReader.getProperty("manager_password"));
        loginPage.loginButton.click();
        //sayfa değişti verify et
        Assert.assertTrue(defaultPage.addUserButton.isDisplayed());
        Thread.sleep(2000);

    }
    @Test
    public void hotelRoomOlusturma() throws InterruptedException {
        //hotel management tıkla
        defaultPage.hotelManagement.click();
        //hotel rooms a tıkla
        defaultPage.hotelRoomsTab.click();
        //add hotelroom a tıkla
        hotelRoomPage.addHotelRoomLink.click();
        Thread.sleep(2000);
        //zorunlu reservasyon alanları doldurulur
        //id hotel dropdown
        Select select=new Select(hotelRoomPage.idDropdown);
        select.selectByIndex(2);
        //code
        hotelRoomPage.code.sendKeys(faker.code().imei());
        //name
        hotelRoomPage.name.sendKeys(faker.gameOfThrones().character());
        //location
        hotelRoomPage.location.sendKeys(faker.address().fullAddress());
        //description
        hotelRoomPage.description.sendKeys(faker.howIMetYourMother().catchPhrase());
        //price
        //1.yol
        hotelRoomPage.price.sendKeys("500");
        //2.yol
        //Actions actions=new Actions(Driver.getDriver());
        //actions.dragAndDrop(hotelRoomPage.price600,hotelRoomPage.price).perform();
        //roomType sec
        Select roomType=new Select(hotelRoomPage.roomTypeDropdown);
        roomType.selectByVisibleText("Queen");
        //maks adult count
        hotelRoomPage.maxAdultCount.sendKeys("2");
        //maks children count-sayısı
        hotelRoomPage.maxChildrenCount.sendKeys("4");
        //approve
        hotelRoomPage.isApprovedCheckbox.click();
        //saved button-kayıt
        hotelRoomPage.saveButton.click();
        Thread.sleep(4000);
        //WebDriverWait wait=new WebDriverWait(Driver.getDriver(),5);
        //WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated())
        //reserve olustu mu test et
        System.out.println(hotelRoomPage.popupMessage.getText());
        Assert.assertTrue(hotelRoomPage.popupMessage.getText().contains("HotelRoom was inserted successfully"));

        hotelRoomPage.okButton.click();

        Driver.closeDriver();





    }
}
