package com.pagefact.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class CreateAccountPage {

    /* Local Selenium Grid*/
     private WebDriver driver;


    @FindBy(how = How.XPATH, using = "//input[@name='name']")
    WebElement full_name;

    @FindBy(how = How.CSS, using = "[name = 'email']")
    WebElement org_email;

    @FindBy(how = How.XPATH, using = "//input[@id='userpassword']")
    WebElement acc_password;

    @FindBy(how = How.XPATH, using = "//input[@name='phone']")
    WebElement phone_number;

    @FindBy(how = How.CSS, using = "[name = 'designation']")
    WebElement designation;

    @FindBy(how = How.CSS, using = "[name = 'org_size']")
    WebElement org_size;

    @FindBy(how = How.XPATH, using = "//input[@id='organization_name']")
    WebElement company_name;

    @FindBy(how = How.XPATH, using = "//input[@id='i-agree']")
    WebElement check_box;

    @FindBy(how = How.XPATH, using = "//button[@id='signup-button']")
    WebElement create_account_button;

    @FindBy(how = How.CSS, using = "#recaptcha-verify-button")
    @CacheLookup
    WebElement recaptcha_button;


    public CreateAccountPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setFullName(){
        full_name.clear();
        full_name.sendKeys(Utils.FULL_NAME);
    }

    public void setEmail(){
        org_email.clear();
        org_email.sendKeys(Utils.EMAIL);
    }

    public void setAccountPassword(){
        acc_password.clear();
        acc_password.sendKeys(Utils.PASSWORD);
    }

    public void setCompanyName(){
        company_name.clear();
        company_name.sendKeys(Utils.COMPANY_NAME);
    }

    public void setDesignation(){
        Select dropdown;
        dropdown = new Select(designation);
        dropdown.selectByValue(Utils.DESIGNATION);
    }

    public void setCompanySize(){
        Select dropdown;
        dropdown = new Select(org_size);
        dropdown.selectByValue(Utils.COMPANY_SIZE);
    }

    public void setPhoneNumber(){
        phone_number.clear();
        phone_number.sendKeys(Utils.PHONE_NUMBER);
    }

    public void clickAcceptButton(){
        check_box.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        create_account_button.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    public void clickRecaptchaButton(){
        recaptcha_button.click();
    }

    public boolean isVerifyPageOpen(){
        String expected_title = "Verify Your Email Adress";
        String win_title = driver.getTitle();
        return win_title.contains(expected_title);
    }


}
