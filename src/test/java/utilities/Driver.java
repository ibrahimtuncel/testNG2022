package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Driver {
    private static WebDriver driver;
    /*
    getDriver()
    1-setup driver
    2- driver olustur
    3- return driveri
    *** Driver.getDriver()
     */

    public static WebDriver getDriver(){
     if(driver==null){//driver aktif değilse, boşsa
         WebDriverManager.chromedriver().setup();
         driver=new ChromeDriver();
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
     }
     return driver;
    }
    public static void closeDriver(){
        if(driver!=null){//driver aktif ise, bir yeri işaret ediyorsa
            driver.close();
            driver=null;//null olunca yeniden baslatabiliris.
        }
    }
}
