package test.smokeTest;

import com.github.javafaker.Faker;
import com.pages.DefaultPage;
import com.pages.LoginPage;
import com.pages.ReservationPage;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class ReservationRoomTest {
    Faker faker=new Faker();
    LoginPage loginPage=new LoginPage();
    DefaultPage defaultPage=new DefaultPage();

    ReservationPage reservationPage=new ReservationPage();

    @BeforeMethod
    public void setUp() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("app_url_login"));
        loginPage.advancedLink.click();
        loginPage.proceedLink.click();
        loginPage.userName.sendKeys(ConfigReader.getProperty("manager_username"));
        loginPage.password.sendKeys(ConfigReader.getProperty("manager_password"));
        loginPage.loginButton.click();
        Thread.sleep(2000);
    }
    @Test
    public void reservationRoom() throws InterruptedException {
        defaultPage.hotelManagement.click();
        defaultPage.roomReservation.click();
        reservationPage.addReservationRoom.click();
        Thread.sleep(2000);
        Select select1=new Select(reservationPage.IDHotelDropDown);
        select1.selectByVisibleText("manager");
        Select select2=new Select(reservationPage.IDHotelRoomDropDown);
        select2.selectByIndex(15);
        reservationPage.price.sendKeys("500");
        reservationPage.dateStart.click();
        reservationPage.startDay.click();
        reservationPage.dateEnd.click();
        reservationPage.endDay.click();
        reservationPage.adultAmount.sendKeys("2");
        reservationPage.childAmount.sendKeys("3");
        reservationPage.nameSurname.sendKeys(faker.name().fullName());
        reservationPage.phone.sendKeys("1234500008");
        reservationPage.email.sendKeys(faker.internet().emailAddress());
        reservationPage.not.sendKeys(faker.ancient().hero());
        reservationPage.onay.click();
        reservationPage.pay.click();
        Thread.sleep(1000);
        reservationPage.save.click();
        Thread.sleep(1000);

        String mesaj=reservationPage.message.getText();
        System.out.println(reservationPage.message.getText());
        Assert.assertTrue(reservationPage.message.getText().contains("inserted successfully"));
        Assert.assertTrue(reservationPage.message.isDisplayed());

        reservationPage.ok.click();
        Thread.sleep(500);

        Driver.closeDriver();


    }


}
