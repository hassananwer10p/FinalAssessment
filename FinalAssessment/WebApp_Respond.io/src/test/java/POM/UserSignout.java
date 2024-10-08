package POM;

import MainClass.*;
import org.openqa.selenium.*;

public class UserSignout extends MainDriver_Class {

    public UserSignout(WebDriver driver)
    {
        this.driver = driver;
    }
    public By profileIcon(){
        return By.xpath("//*[@id=\"root\"]/div[1]/div/div/nav/div/div[2]/div[1]");

    }
    public WebElement profileImage(){
        return driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div/div/nav/div/div[2]/div[1]"));
    }

    public WebElement btnSignOut()
    {
        return driver.findElement(By.xpath("/html/body/div[7]/div/div/div/div/div[2]/div[4]"));
    }

    public By txtSignin()
    {
        return By.xpath("//*[@id=\"authContainer\"]/div[1]/div[2]/div/div/div[1]/span");
    }

}
