package POM;

import MainClass.MainDriver_Class;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginUser extends MainDriver_Class {

    public LoginUser(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement emailField() {
        return driver.findElement(By.id("input-7"));
    }

    public WebElement passwordField() {
        return driver.findElement(By.id("input-9"));
    }

    public WebElement signinBtn() {
        return driver.findElement(By.cssSelector("button[data-pw='btn-signin']"));
    }

    public By dashboardLocator() {
        return By.xpath("//span[contains(@class, 'dls-txt-h5') and contains(@class, 'dls-text-text-primary') and contains(@class, 'truncate-max-content')]\n");
    }

}


