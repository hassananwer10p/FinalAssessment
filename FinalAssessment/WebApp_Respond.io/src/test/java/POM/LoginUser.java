package POM;

import MainClass.*;
import org.openqa.selenium.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class LoginUser extends MainDriver_Class {

    public LoginUser(WebDriver driver) {
        this.driver = driver;
    }


    public WebElement emailField() {
        return driver.findElement(By.id("input-7"));
    }

    public void enterEmail() {
        driver.findElement(By.id("input-7")).sendKeys("jasonb902024@gmail.com");
    }
    public WebElement passwordField() {
        return driver.findElement(By.id("input-9"));
    }

    public void enterPassword() {
        driver.findElement(By.id("input-9")).sendKeys("Cashout76!@123");
    }


    public WebElement signinBtn() {
        //return driver.findElement(By.xpath("//button[@type='submit']"));
      return  driver.findElement(By.cssSelector("button[data-pw='btn-signin']"));
    }


    public By dashboardLocator() {
        return By.xpath("//span[contains(@class, 'dls-txt-h5') and contains(@class, 'dls-text-text-primary') and contains(@class, 'truncate-max-content')]\n");
    }






    public WebElement buyMoisturizers() {
        return driver.findElement(By.xpath("//button[.='Buy moisturizers']"));
    }

    public WebElement buySunscreens() {
        return driver.findElement(By.xpath("//button[.='Buy sunscreens']"));
    }

    public String findMinmois()
    {
        List<WebElement> textDemo = driver.findElements(By.xpath("//div[contains(@class,'container')]/descendant::p[contains(text(),'Aloe')]//following-sibling::p"));
        List<String> all_elements_text=new ArrayList<>();
        for(int j =0;j<textDemo.size();j++) {
            all_elements_text.add(textDemo.get(j).getText().replaceAll("[^\\d]", ""));
        }
        Collections.sort(all_elements_text);
        System.out.println("Aloe products are:"+all_elements_text);
        String min = all_elements_text.get(0);
        System.out.println("Minimum is : " + min);
     //   driver.findElement(By.xpath("//p[.=' "+min+"']//following-sibling::button")).click();
        driver.findElement(By.xpath("//p[contains(text(),' "+min+"')]//following-sibling::button")).click();
        return all_elements_text.get(0);
    }

    public String findMinAlmondmois()
    {
        List<WebElement> textDemo = driver.findElements(By.xpath("//div[contains(@class,'container')]/descendant::p[contains(text(),'Almond')]//following-sibling::p"));
        List<String> all_elements_text=new ArrayList<>();
        for(int j =0;j<textDemo.size();j++) {
            all_elements_text.add(textDemo.get(j).getText().replaceAll("[^\\d]", ""));
        }
        Collections.sort(all_elements_text);
        System.out.println("Almond products are:"+all_elements_text);
        String min = all_elements_text.get(0);
        System.out.println("Minimum is : " + min);
        driver.findElement(By.xpath("//p[contains(text(),' "+min+"')]//following-sibling::button")).click();
        return all_elements_text.get(0);
    }

    public String findMinsuns()
    {
        List<WebElement> textDemo = driver.findElements(By.xpath("//div[contains(@class,'container')]/descendant::p[contains(text(),'SPF-50')]//following-sibling::p"));
        List<String> all_elements_text=new ArrayList<>();
        for(int j =0;j<textDemo.size();j++) {
            all_elements_text.add(textDemo.get(j).getText().replaceAll("[^\\d]", ""));
        }
        Collections.sort(all_elements_text);
        System.out.println("SPF-15 products are:"+all_elements_text);
        String min = all_elements_text.get(0);
        System.out.println("Minimum is : " + min);
       // return driver.findElement(By.xpath("//p[.='Price:'"+min+"']"));
       // driver.navigate().refresh();
       // driver.findElement(By.xpath("//p[.=' "+min+"']//following-sibling::button")).click(); ////p[.='Price: 222']
        driver.findElement(By.xpath("//p[contains(text(),' "+min+"')]//following-sibling::button")).click();
        return all_elements_text.get(0); //p[contains(text(),' 128' )]//following-sibling::button
    }

    public String findMinsunsSPF30()
    {
        List<WebElement> textDemo = driver.findElements(By.xpath("//div[contains(@class,'container')]/descendant::p[contains(text(),'SPF-30')]//following-sibling::p"));
        List<String> all_elements_text=new ArrayList<>();
        for(int j =0;j<textDemo.size();j++) {
            all_elements_text.add(textDemo.get(j).getText().replaceAll("[^\\d]", ""));
        }
        Collections.sort(all_elements_text);
        System.out.println("SPF-30 products are:"+all_elements_text);
        String min = all_elements_text.get(0);
        System.out.println("Minimum is : " + min);
        driver.findElement(By.xpath("//p[contains(text(),' "+min+"')]//following-sibling::button")).click();
        return all_elements_text.get(0); //p[contains(text(),' 128' )]//following-sibling::button
    }

    public void addedMoiProductsCart(){
        List<String> textDemo = Collections.singletonList(findMinmois());
        textDemo.addAll(Collections.singleton(findMinAlmondmois()));
        System.out.println("The added cart contain prices:"+textDemo);
    }

    public void addedSunProductsCart(){
        List<String> textDemo = Collections.singletonList(findMinsunsSPF30());
        textDemo.addAll(Collections.singleton(findMinsuns()));
        System.out.println("The added cart contain prices:"+textDemo);
    }

    public void clickCart() {
        driver.findElement(By.cssSelector(".thin-text")).click();
    }

    public void clickPaymentBtn() {
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    public void Paymentfields() throws InterruptedException {
        driver.switchTo().frame("stripe_checkout_app");
        TimeUnit.SECONDS.sleep(2);
        driver.findElement(By.id("email")).sendKeys("test@yopmail.com");
        TimeUnit.SECONDS.sleep(3);
        driver.findElement(By.id("card_number")).sendKeys("4242424242424242");
        driver.findElement(By.id("cc-exp")).sendKeys("0225");
        driver.findElement(By.id("cc-csc")).sendKeys("123");
        driver.findElement(By.id("billing-zip")).sendKeys("90001");
        driver.switchTo().defaultContent();
        driver.findElement(By.cssSelector(".iconTick")).click();
    }

    public List<String> checkoutPage(){
        List<WebElement> textDemo = driver.findElements(By.xpath("//table/tbody/tr/td[2]"));
        List<String> productPrices=new ArrayList<>();
        for(int j =0;j<textDemo.size();j++) {
            productPrices.add(textDemo.get(j).getText());
        }
        System.out.println("The checkout contain prices:"+productPrices);
        return productPrices;
    }

    public List<String> checkoutPageProducts(){
        List<WebElement> textDemo = driver.findElements(By.xpath("//table/tbody/tr/td[1]"));
        List<String> product=new ArrayList<>();
        for(int j =0;j<textDemo.size();j++) {
            product.add(textDemo.get(j).getText());
        }
        System.out.println("The checkout contain prices:"+product);
        return product;
    }

    public List<WebElement> getMoisturizersList() {
        return driver.findElements(By.xpath("//div[contains(@class,'container')]/descendant::p[contains(text(),'Price')]/preceding-sibling::p"));
    }

    public List<WebElement> getMoisturizersPrices() {
        return driver.findElements(By.xpath("//div[contains(@class,'container')]/descendant::p[contains(text(),'Price')]"));
    }

   /* public List<WebElement> getMoisturizersAndPricesList() {
        getMoisturizersAndPricesList().addAll(getMoisturizersList);
        return driver.findElements(By.xpath("//div[contains(@class,'container')]/descendant::p[contains(text(),'Price')]/preceding-sibling::p"));
    }*/

    public List<WebElement> getSunscreensList() {
        return driver.findElements(By.xpath("//div[contains(@class,'container')]/descendant::p[contains(text(),'Price')]/preceding-sibling::p"));
    }

    public WebElement simpleformdemo() {
        return driver.findElement(By.xpath("//*[@id='navbar-brand-centered']/ul[1]/li[1]/ul/li[1]/a"));
    }

    public WebElement randomstring() {
        return driver.findElement(By.id("user-message"));

    }

    public WebElement ShowMessagebutton()
    {
        return driver.findElement(By.xpath(".//*[@id='get-input']/button"));
    }

    public WebElement displayedmessage()
    {
        return driver.findElement(By.xpath("//*[@id='display']"));
    }

    public WebElement sumvalue1()
    {
        return driver.findElement(By.cssSelector("#sum1"));
    }

    public WebElement sumvalue2()
    {
        return driver.findElement(By.cssSelector("#sum2"));
    }

    public WebElement totalsum()
    {
        return driver.findElement(By.xpath(".//*[@id='gettotal']/button"));
    }

    public WebElement totaltext()
    {
        return driver.findElement(By.id("displayvalue"));
    }




}


