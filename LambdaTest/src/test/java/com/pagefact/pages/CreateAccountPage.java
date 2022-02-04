package com.pagefact.pages;

import com.pagefact.components.EmailRandomizer;
import com.pagefact.components.SignUpViaEmailComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CreateAccountPage {

    /* Local Selenium Grid*/
    private WebDriver driver;
    private final SignUpViaEmailComponent signUpViaEmailComponent;
    private final EmailRandomizer emailRandomizer;


    public CreateAccountPage(WebDriver driver) {
        this.driver = driver;
        signUpViaEmailComponent = new SignUpViaEmailComponent(driver);
        emailRandomizer = new EmailRandomizer();
        PageFactory.initElements(driver, this);
    }

    public void setFullName() {
        signUpViaEmailComponent.setFullName(Utils.FULL_NAME);
    }

    public void setEmail() {
        signUpViaEmailComponent.setEmail(emailRandomizer.emailRandomizer());
    }

    public void setAccountPassword() {
        signUpViaEmailComponent.setAccountPassword(Utils.PASSWORD);
    }

    public void setCompanyName() {
        signUpViaEmailComponent.setCompanyName(Utils.COMPANY_NAME);
    }

    public void setDesignation() {
        signUpViaEmailComponent.setDesignation(Utils.DESIGNATION);
    }

    public void setPhoneNumber() {
        signUpViaEmailComponent.setPhoneNumber(Utils.PHONE_NUMBER);
    }

    public void clickAcceptButton() {
        signUpViaEmailComponent.clickAcceptButton();
    }

    public void isVerifyPageOpen() {
        signUpViaEmailComponent.verifyPageTitle();
    }


}
