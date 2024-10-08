package BaseClass;

import MainClass.*;
import POM.*;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.util.*;
import java.util.concurrent.*;

// METHOD CLASS

public class BaseDriverClass extends MainDriver_Class {
    public WebDriverWait wait;


    public BaseDriverClass(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10); // 10 seconds wait

    }

    MainConfiguration objMain;
    LoginUser obj_UserLogin;
    UserAddition obj_AddUser;
    UserDeletion obj_DeleteUser;
    UserSignout obj_LogoutUser;

    String expectedTitle = "respond.io",
            actualTitle, toastMsg,
            addUserToast = "User has been invited to workspace",
            deleteUserToast = "User access has been revoked";


    public void user_login() {
        try {
            System.out.println("**Login User Test Started**");
            WebDriverWait wait = new WebDriverWait(driver, 15); // 15 seconds wait
            objMain = new MainConfiguration();
            obj_UserLogin = new LoginUser(driver);

            // Verify the page title
            actualTitle = driver.getTitle();
            Assert.assertEquals(actualTitle, expectedTitle, "respond.io");
            System.out.println("Title Matched Successfully");

            TimeUnit.SECONDS.sleep(5); // Just to slow things down for demo purposes

            // Check if email field is displayed and clickable
            Assert.assertTrue("Email field is not displayed!", obj_UserLogin.emailField().isDisplayed());
            obj_UserLogin.emailField().click();
            obj_UserLogin.emailField().sendKeys(objMain.getEmail());

            // Check if password field is displayed and clickable
            Assert.assertTrue("Password field is not displayed!", obj_UserLogin.passwordField().isDisplayed());
            obj_UserLogin.passwordField().click();
            obj_UserLogin.passwordField().sendKeys(objMain.getPassword());

            // Click on the Sign In button
            Assert.assertTrue("Sign In button is not displayed!", obj_UserLogin.signinBtn().isDisplayed());
            obj_UserLogin.signinBtn().click();

            // Verify the presence of an element on the dashboard after login
            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(obj_UserLogin.dashboardLocator()));
                System.out.println("User has been logged in successfully.");
                Assert.assertTrue("Dashboard element is not displayed after login!",
                        driver.findElement(obj_UserLogin.dashboardLocator()).isDisplayed());
                System.out.println("**Login User Test Ended**");

            } catch (Exception e) {
                // Handle the case where the element is not found within the timeout period
                System.out.println("Login failed. The element was not found within the timeout period.");
                Assert.fail("Login failed. Dashboard element not found.");
                System.out.println("**Login User Test Ended**");
            }

        } catch (Exception ex) {
            Assert.fail(ex.getMessage());
        }
    }

    public void Add_users() {
        try {
            System.out.println("**Add User Test Started**");
            obj_AddUser = new UserAddition(driver);
            WebDriverWait wait = new WebDriverWait(driver, 20); // 20 seconds wait

            // Retry mechanism in case of stale element reference
            int retries = 3; // Number of retries
            while (retries > 0) {
                try {
                    // Wait for and click on the Settings button
                    wait.until(ExpectedConditions.visibilityOfElementLocated(obj_AddUser.pageSettings()));
                    Assert.assertTrue("Settings button is not visible!", obj_AddUser.clickSettings().isDisplayed());
                    obj_AddUser.clickSettings().click();

                    // Wait for and navigate to Users screen
                    wait.until(ExpectedConditions.visibilityOfElementLocated(obj_AddUser.waitProfilePage()));
                    Assert.assertTrue("Users navigation button is not visible!", obj_AddUser.navUsers().isDisplayed());
                    obj_AddUser.navUsers().click();
                    System.out.println("Navigated to Users Screen");

                    // Wait for Users page to load
                    wait.until(ExpectedConditions.presenceOfElementLocated(obj_AddUser.waitUsersPage()));
                    Assert.assertTrue("Add User button is not visible!", obj_AddUser.addUser().isDisplayed());
                    //obj_AddUser.addUser().click();

                    // Retry clicking the add user button if it fails initially
                    try {
                        obj_AddUser.addUser().click();
                    } catch (Exception e) {
                        System.out.println("Users button not clicked yet");
                    }

                    // Wait for and fill the Add User modal
                    wait.until(ExpectedConditions.visibilityOfElementLocated(obj_AddUser.userModal()));

                    // Generate random email
                    Random randomGenerator = new Random();
                    int randomInt = randomGenerator.nextInt(1000);
                    String randomEmail = "username" + randomInt + "@gmail.com";

                    // Enter email and user restrictions
                    obj_AddUser.typeUserEmail().sendKeys(randomEmail);
                    obj_AddUser.openRestrictions().click();
                    obj_AddUser.selectRestrictDataExport().click();
                    obj_AddUser.selectRestrictContactDeletion().click();

                    // Click Add button
                    Assert.assertTrue("Add User button is not visible!", obj_AddUser.clickAddBtn().isDisplayed());
                    obj_AddUser.clickAddBtn().click();

                    // Wait for the toast message and verify user addition
                    wait.until(ExpectedConditions.visibilityOfElementLocated(obj_AddUser.toaster()));
                    TimeUnit.SECONDS.sleep(5); // Optional wait to allow toast message to fully appear

                    toastMsg = obj_AddUser.getToastMsg().getText();
                    Assert.assertEquals(toastMsg, addUserToast);

                    System.out.println("User Added: " + randomEmail);
                    obj_AddUser.closeToastMsg().click();
                    System.out.println("**Add User Test Ended**");

                    break; // If no exception, break out of the retry loop

                } catch (StaleElementReferenceException e) {
                    // Retry mechanism when stale element exception occurs
                    System.out.println("Caught stale element reference exception, retrying...");
                    retries--; // Decrease retry count
                    if (retries == 0) {
                        throw e; // After retries are exhausted, rethrow the exception
                    }
                }
            }

        } catch (Exception ex) {
            Assert.fail(ex.getMessage());
        }
    }



    public void Delete_user() {
        try {
            System.out.println("**Delete User Test Started**");
            obj_DeleteUser = new UserDeletion(driver);
            WebDriverWait wait = new WebDriverWait(driver, 20); // Adding explicit wait with timeout

            // Assert that search field is present and visible
            wait.until(ExpectedConditions.presenceOfElementLocated(obj_DeleteUser.searchField()));
            Assert.assertTrue("Search field is not visible!", obj_DeleteUser.searchUser().isDisplayed());

            // Search for the user
            obj_DeleteUser.searchUser().click();
            obj_DeleteUser.searchUser().sendKeys("username");

            // Assert that the revoke button is present and clickable
            Assert.assertTrue("Revoke button is not visible!", obj_DeleteUser.revokeButton().isDisplayed());
            obj_DeleteUser.revokeButton().click();

            // Assert that the confirm revoke button is present and clickable
            Assert.assertTrue("Confirm revoke button is not visible!", obj_DeleteUser.confirmRevokeBtn().isDisplayed());
            obj_DeleteUser.confirmRevokeBtn().click();

            // Wait for the toast message to appear
            TimeUnit.SECONDS.sleep(5); // Optionally wait for the toast message to fully appear
            toastMsg = obj_DeleteUser.getToastMsg().getText();

            // Assert that the toast message matches the expected result
            Assert.assertEquals(toastMsg, deleteUserToast);

            System.out.println("User Deleted");

            // Assert that toast message close button is visible and click it
            Assert.assertTrue("Toast close button is not visible!", obj_DeleteUser.closeToastMsg().isDisplayed());
            obj_DeleteUser.closeToastMsg().click();

            System.out.println("**Delete User Test Ended**");

        } catch (Exception ex) {
            Assert.fail(ex.getMessage()); // Fail the test if any exception occurs
        }
    }


    public void User_Logout() {
        try {
            System.out.println("**LogOut User Test Started**");
            obj_LogoutUser = new UserSignout(driver);
            WebDriverWait wait = new WebDriverWait(driver, 20); // Adding an explicit wait of 20 seconds

            // Assert that the profile icon is present and visible
            wait.until(ExpectedConditions.presenceOfElementLocated(obj_LogoutUser.profileIcon()));
            Assert.assertTrue("Profile icon is not visible!", obj_LogoutUser.profileImage().isDisplayed());

            // Click on the profile image
            obj_LogoutUser.profileImage().click();

            // Assert that the sign-out button is present and visible
            Assert.assertTrue("Sign Out button is not visible!", obj_LogoutUser.btnSignOut().isDisplayed());

            // Click the sign-out button
            obj_LogoutUser.btnSignOut().click();

            // Optionally wait until the login page or element appears after logging out
            wait.until(ExpectedConditions.presenceOfElementLocated(obj_LogoutUser.txtSignin()));
            Assert.assertTrue("User was not redirected to the login page after logout!", driver.getCurrentUrl().contains("login"));

            System.out.println("**LogOut User Test Ended Successfully**");

        } catch (Exception ex) {
            Assert.fail(ex.getMessage());
        }
    }

}




















