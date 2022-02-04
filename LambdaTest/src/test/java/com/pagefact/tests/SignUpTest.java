package com.pagefact.tests;

import com.pagefact.driver.Driver;
import com.pagefact.pages.CreateAccountPage;
import com.pagefact.pages.HomePage;
import com.pagefact.pages.SignUpPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;


public class SignUpTest extends BaseTest {


    @Test(testName = "Fill up Sign in Form with valid credentials")
    public static void signUpTest() {
        /*first create an object of the HomePage page class*/
        /*The clickOnStartTestingButton() method of the HomePage class
         is invoked to perform a click on the ‘Start Free Testing’ button.*/
        HomePage home = new HomePage(Driver.driver);
        home.clickOnStartTestingButton();

        /* Create object of SignUpPage */
        SignUpPage signup = new SignUpPage(Driver.driver);

        /* Check if page is opened */
        Assert.assertTrue(signup.isSignUpPageOpen());

        /* Create object of CreateAccountPage */
        CreateAccountPage accountPage = new CreateAccountPage(Driver.driver);

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
        Driver.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        /* Check if page is opened */
        accountPage.isVerifyPageOpen();

        System.out.println("SignUp demo process complete");

    }


}
