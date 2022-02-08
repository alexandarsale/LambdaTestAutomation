package com.pagefact.tests;

import com.pagefact.driver.DriverManager;
import com.pagefact.pages.CreateAccountPage;
import com.pagefact.pages.HomePage;
import com.pagefact.pages.SignUpPage;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class SignUpTest extends BaseTest {

    @Test(testName = "Fill up Sign in Form with valid credentials")
    public static void signUpTest() {
        /*first create an object of the HomePage page class*/
        /*The clickOnStartTestingButton() method of the HomePage class
         is invoked to perform a click on the ‘Start Free Testing’ button.*/
        HomePage home = new HomePage(DriverManager.getDriver());

        assertTrue(home.isOpened());

        home.clickOnStartTestingButton();

        /* Create object of SignUpPage */
        SignUpPage signUpPage = new SignUpPage(DriverManager.getDriver());

        /* Check if page is opened */
        assertTrue(signUpPage.isOpened());

        /* Create object of CreateAccountPage */
        CreateAccountPage accountPage = new CreateAccountPage(DriverManager.getDriver());

        /* Fill up data */

        accountPage.setFullName();
        accountPage.setEmail();
        accountPage.setAccountPassword();
        accountPage.setPhoneNumber();
        accountPage.setCompanyName();
        accountPage.setDesignation();

        /* Click on Accept T&C and Create Account button */
        accountPage.clickAcceptButton();

        /* Wait for a few seconds */
        DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        /* Check if page is opened */
        assertTrue(accountPage.isOpened());

        System.out.println("SignUp demo process complete");
    }
}
