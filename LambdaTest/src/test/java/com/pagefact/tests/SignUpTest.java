package com.pagefact.tests;

import com.pagefact.pages.CreateAccountPage;
import com.pagefact.pages.HomePage;
import com.pagefact.pages.SignUpPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;


public class SignUpTest {

    private static final WebDriver driver = new ChromeDriver();
    final static String CHROME_DRIVER_LOCATION = "chromedriver";

    @BeforeSuite
    public void startTestSuite() {
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_LOCATION);
    }

    @BeforeMethod
    public void startTest() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test(testName = "Fill up Sign in Form with valid credentials")
    public static void signUpTest() throws InterruptedException {
        /*first create an object of the HomePage page class*/
        /*The clickOnStartTestingButton() method of the HomePage class
         is invoked to perform a click on the ‘Start Free Testing’ button.*/
        HomePage home = new HomePage(driver);
        home.clickOnStartTestingButton();

        /* Create object of SignUpPage */
        SignUpPage signup = new SignUpPage(driver);

        /* Check if page is opened */
        Assert.assertTrue(signup.isSignUpPageOpen());

        /* Create object of CreateAccountPage */
        CreateAccountPage accountPage = new CreateAccountPage(driver);

        /* Fill up data */

        accountPage.setFullName();
        accountPage.setEmail();
        accountPage.setAccountPassword();
        accountPage.setPhoneNumber();
        accountPage.setCompanyName();
        accountPage.setDesignation();
      //  accountPage.setCompanySize();

        /* Click on Accept T&C and Create Account button */
        accountPage.clickAcceptButton();

        /* Wait for a few seconds */
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        /* Check if page is opened */
        if (accountPage.isVerifyPageOpen()){
            System.out.println("Email address verification page is open\n");
        }
        /* Wait for a few seconds */
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        System.out.println("SignUp demo process complete\n");

    }

    @AfterSuite
    public static void cleanUp(){
        driver.quit();
    }




}
