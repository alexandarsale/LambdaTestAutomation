package com.pagefact.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.pagefact.waiter.Waiters.PAGE_LOAD_TIMEOUT;
import static com.pagefact.waiter.Waiters.waitForElementToBeDisplayed;

public class SignUpPage extends BasePage {

    /*There is only one method in this page class whose purpose is to check the web page’s title*/
    @FindBy(css = "p.termsAndService")
    private WebElement form_title;

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    /*returns true if the page title contains the string ‘or Sign up via email’*/
    @Override
    public boolean isOpened() {
        // return form_title.getText().contains("Already have an account?");
        return waitForElementToBeDisplayed(form_title, driver, PAGE_LOAD_TIMEOUT);
    }
}
