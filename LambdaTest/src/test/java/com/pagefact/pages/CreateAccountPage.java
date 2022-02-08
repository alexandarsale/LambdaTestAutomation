package com.pagefact.pages;

import com.pagefact.Utils.ReadPropertyFile;
import com.pagefact.components.EmailRandomizer;
import com.pagefact.components.SignUpViaEmailComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.pagefact.waiter.Waiters.PAGE_LOAD_TIMEOUT;
import static com.pagefact.waiter.Waiters.waitForElementToBeDisplayed;

public class CreateAccountPage extends BasePage {

    private final SignUpViaEmailComponent signUpViaEmailComponent;
    private final EmailRandomizer emailRandomizer;

    public CreateAccountPage(WebDriver driver) {
        super(driver);
        signUpViaEmailComponent = new SignUpViaEmailComponent(driver);
        emailRandomizer = new EmailRandomizer();
    }

    @FindBy(css = "h1.verify_title")
    private WebElement verify_email_text;

    @Override
    public boolean isOpened() {
        return waitForElementToBeDisplayed(verify_email_text, driver, PAGE_LOAD_TIMEOUT);
    }

    public void setFullName() {
        signUpViaEmailComponent.setFullName(ReadPropertyFile.getValue("full_name"));
    }

    public void setEmail() {
        signUpViaEmailComponent.setEmail(emailRandomizer.emailRandomizer());
    }

    public void setAccountPassword() {
        signUpViaEmailComponent.setAccountPassword(ReadPropertyFile.getValue("password"));
    }

    public void setCompanyName() {
        signUpViaEmailComponent.setCompanyName(ReadPropertyFile.getValue("company_name"));
    }

    public void setDesignation() {
        signUpViaEmailComponent.setDesignation(ReadPropertyFile.getValue("designation"));
    }

    public void setPhoneNumber() {
        signUpViaEmailComponent.setPhoneNumber(ReadPropertyFile.getValue("phone_number"));
    }

    public void clickAcceptButton() {
        signUpViaEmailComponent.clickAcceptButton();
    }

  /*  public void isVerifyPageOpen() {
        signUpViaEmailComponent.verifyPageTitle();
    }
*/
}
