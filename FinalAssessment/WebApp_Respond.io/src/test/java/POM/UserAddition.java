package POM;

import MainClass.*;
import org.openqa.selenium.*;

public class UserAddition extends MainDriver_Class {

    public UserAddition(WebDriver driver) {
        this.driver = driver;
    }

    public By pageSettings() {
        return By.xpath("//div[contains(@class, 'hover:dls-bg-button-secondary-on-hover') and contains(@class, 'dls-items-center') and contains(@class, 'dls-flex')]\n");
    }

    public WebElement clickSettings() {
        return driver.findElement(By.xpath("//div[contains(@class, 'dls-w-[48px]') and contains(@class, 'dls-h-[36px]') and contains(@class, 'dls-items-center') and contains(@class, 'dls-justify-center') and contains(@class, 'dls-flex') and contains(@class, 'dls-mb-8')]//div[contains(@class, 'hover:dls-bg-button-secondary-on-hover') and contains(@class, 'hover:dls-scale-105') and contains(@class, 'dls-w-full')]//i[contains(@class, 'isax-setting-2') and contains(@class, 'dls-text-icon-primary')]"));
    }

    public By waitProfilePage() {
        return By.xpath("//a[@href='/space/252166/settings/users']/div/p/span[text()='Users']");
    }


    public WebElement navUsers() {
        return driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div/div/main/div/div[2]/div/div[2]/div/div[1]/div/div[2]/div/div/div[2]/a[2]"));
    }
    public By waitUsersPage() {
        return By.xpath("//span[@class='dls-txt-h5 dls-text-text-primary' and text()='Users']");
    }

    public By userModal() {
        return By.xpath("//span[@class='dls-txt-h5 dls-line-clamp-1 dls-break-all' and text()='Add User']");
    }

    public WebElement addUser() {
        return  driver.findElement(By.xpath("(//button[contains(@class, 'v-btn') and contains(@class, 'v-btn--elevated')]//span[text()='Add User'])[2]"));
    }

    public WebElement typeUserEmail() {
       return driver.findElement(By.xpath("//input[@name='field_13' and @placeholder='Email Address']"));
    }


    public WebElement openRestrictions() {
        return  driver.findElement(By.xpath("//button[contains(@class, 'v-expansion-panel-title') and contains(@class, 'dls-group')]//span[contains(text(),'Advanced Restrictions')]"));
    }
    public WebElement selectRestrictDataExport() {
        return driver.findElement(By.xpath("//div[@class='v-row v-row--no-gutters']//div[contains(text(), 'Restrict Data Export')]"));
    }
    public WebElement selectRestrictContactDeletion() {
        return driver.findElement(By.xpath("//div[@class='v-row v-row--no-gutters']//div[contains(text(), 'Restrict Contact Deletion')]"));
    }
    public WebElement clickAddBtn() {
        return driver.findElement(By.xpath("//div[contains(@class, 'dls-flex') and contains(@class, 'dls-items-center')]//button[contains(@class, 'v-btn') and contains(@class, 'v-btn--elevated')]//span[text()='Add']"));
    }

    public WebElement closeToastMsg() {
        return driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div/section/ol/li/div/div/div/div/div[2]/button"));
    }

    public WebElement getToastMsg() {
        return driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div/section/ol/li/div/div"));
    }

    public By toaster() {
        return By.xpath("//span[@class='dls-txt-h5 dls-line-clamp-1 dls-break-all' and text()='Add User']");
    }








    public WebElement formselect()
    {
        return driver.findElement(By.xpath(".//*[@id=\"navbar-brand-centered\"]/ul[1]/li[1]/ul/li[2]/a"));
    }

    public WebElement selectsinglecheckbox()
    {
        return driver.findElement(By.xpath("//*[@id='isAgeSelected']"));
    }

    public WebElement Option1()
    {
        return driver.findElement(By.xpath(".//*[@id='easycont']/div/div[2]/div[2]/div[2]/div[1]/label/input"));
    }
    public WebElement Option2()
    {
        return driver.findElement(By.xpath(".//*[@id='easycont']/div/div[2]/div[2]/div[2]/div[2]/label/input"));
    }
    public WebElement Option3()
    {
        return driver.findElement(By.xpath(".//*[@id='easycont']/div/div[2]/div[2]/div[2]/div[3]/label/input\n"));
    }




}
