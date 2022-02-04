package com.pagefact.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {

    /* Local Selenium Grid*/
    private WebDriver driver;

    /*There is only one method in this page class whose purpose is to check the web page’s title*/
    @FindBy(how = How.CSS, using = "p.termsAndService")
    private WebElement form_title;


    public SignUpPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /*returns true if the page title contains the string ‘or Sign up via email’*/
    public boolean isSignUpPageOpen() {
        return form_title.getText().contains("Already have an account?");
    }

}
