package com.pagefact.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    /* Local Selenium Grid */
     private WebDriver driver;

    @FindBy(how = How.XPATH, using = "//a[.='Start Free Testing']")
    private WebElement StartTestingButton;

    /* Initializing WebElements in the cunstroctor */
    /* The URL is set to lambdatest.com HomePage so that further
     tests can be carried out on the web element variables of that page. */
    public HomePage(WebDriver driver){
        this.driver = driver;
        driver.get(Utils.HOME_PAGE_URL);
        PageFactory.initElements(driver, this);
    }


    public void clickOnStartTestingButton(){
        StartTestingButton.click();
    }


}
