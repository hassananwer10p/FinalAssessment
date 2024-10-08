package TestCase;

import MainClass.*;
import org.openqa.selenium.*;
import org.testng.annotations.*;
import BaseClass.*;
import utils.ExtentReports.*;

import java.lang.reflect.Method;


public class TestDriverClass extends MainDriver_Class {

    BaseDriverClass obj_BaseClass;


    public WebDriver getDriver() {
        return driver;
    }

    @BeforeTest
    public void testbefore() {
        driverinitiate();

    }

    @Test(priority = 1, description = "Login User with valid credentials")
    public void LoginUser(Method method) {
        ExtentTestManager.startTest(method.getName(), "Login User with valid credentials");
        obj_BaseClass = new BaseDriverClass(driver);
        obj_BaseClass.user_login();
    }

    @Test(priority = 2, description = "Adding a new user into workspace")
    public void AddNewUser(Method method) {
        ExtentTestManager.startTest(method.getName(), "Adding a new user into workspace");
        obj_BaseClass = new BaseDriverClass(driver);
        obj_BaseClass.Add_users();
    }

    @Test(priority = 3, description = "Deleting an existing user from workspace")
    public void DeleteUser(Method method) {

        ExtentTestManager.startTest(method.getName(), "Deleting an existing user");
        obj_BaseClass = new BaseDriverClass(driver);
        obj_BaseClass.Delete_user();
    }

    @Test(priority = 4, description = "User logout from the application")
    public void UserSignOut(Method method) {

        ExtentTestManager.startTest(method.getName(), "User Signing Out");
        obj_BaseClass = new BaseDriverClass(driver);
        obj_BaseClass.User_Logout();
    }

    @AfterTest
    public void DriveClose() {
        driver.close();
    }
}

