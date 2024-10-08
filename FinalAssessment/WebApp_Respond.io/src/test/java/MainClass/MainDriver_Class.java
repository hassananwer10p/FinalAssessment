package MainClass;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;


public class MainDriver_Class {
    public WebDriver driver;
    MainConfiguration objMain;

    public WebDriver driverinitiate() {
        try {
            objMain = new MainConfiguration();
            System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.navigate().to(objMain.getUrlValue());
        } catch (Exception ex) {
            ex.getMessage();
        }
        return driver;
    }
}