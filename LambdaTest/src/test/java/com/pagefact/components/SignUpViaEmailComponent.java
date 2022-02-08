package com.pagefact.components;

import com.pagefact.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpViaEmailComponent extends BasePage {

    private WebDriver driver;

    @FindBy(css = "#name")
    private WebElement full_name;

    @FindBy(css = "#email")
    private WebElement org_email;

    @FindBy(css = "#userpassword")
    private WebElement acc_password;

    @FindBy(css = "#phone")
    private WebElement phone_number;

    @FindBy(css = "#designation")
    private WebElement designation;

    @FindBy(css = "#organization_name")
    private WebElement company_name;

    @FindBy(css = "#i-agree")
    private WebElement check_box;

    @FindBy(css = "#signup-button")
    private WebElement create_account_button;

    public SignUpViaEmailComponent(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        return false;
    }

    public void setFullName(String fullName) {
        sendKeys(full_name, fullName);
    }

    public void setEmail(String email) {
        sendKeys(org_email, email);
    }

    public void setAccountPassword(String password) {
        sendKeys(acc_password, password);
    }

    public void setCompanyName(String companyName) {
        sendKeys(company_name, companyName);
    }

    public void setDesignation(String desig) {
        selectDropDown(designation, desig);
    }

    public void setPhoneNumber(String phoneNumber) {
        sendKeys(phone_number, phoneNumber);
    }

    public void clickAcceptButton() {
        click(check_box);
        //    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        click(create_account_button);
        //    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
}
