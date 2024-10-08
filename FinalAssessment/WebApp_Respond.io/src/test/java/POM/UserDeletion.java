package POM;

import MainClass.*;
import org.openqa.selenium.*;

public class UserDeletion extends MainDriver_Class {

    public UserDeletion(WebDriver driver) {
        this.driver = driver;
    }

    public By searchField() {
        return By.xpath("//input[@placeholder='Search Users']");
    }

    public WebElement searchUser() {
        return driver.findElement(By.xpath("//input[@placeholder='Search Users']"));
    }

    public WebElement revokeButton() {
        return driver.findElement(By.xpath(".//span[text()='Revoke']"));
    }

    public WebElement confirmRevokeBtn() {
        return driver.findElement(By.xpath("/html/body/div[7]/div/div[2]/form/div/div[4]/div/button[2]"));
    }

    public WebElement getToastMsg() {
        return driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div/section/ol/li/div/div"));
    }

    public WebElement closeToastMsg() {
        return driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div/section/ol/li/div/div/div/div/div[2]/button"));
    }


}

