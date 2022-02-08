package com.pagefact.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.pagefact.waiter.Waiters.PAGE_LOAD_TIMEOUT;
import static com.pagefact.waiter.Waiters.waitForElementToBeDisplayed;

public class HomePage extends BasePage {

    /* Locating Start Testing Button on HomePage*/
    @FindBy(css = "#header a[href*='register']")
    private WebElement StartTestingButton;

    @FindBy(xpath = "//h1[contains(text(),'Cross Browser Testing Cloud')]")
    private WebElement home_page_text;

    /* Initializing WebElements in the cunstroctor */
    /* The URL is set to lambdatest.com HomePage so that further
     tests can be carried out on the web element variables of that page. */
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        return waitForElementToBeDisplayed(home_page_text, driver, PAGE_LOAD_TIMEOUT);
    }

    public void clickOnStartTestingButton() {
        click(StartTestingButton);
    }
}
