package com.pagefact.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public abstract class BasePage {

    final WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void sendKeys(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
        Assert.assertEquals(element.getAttribute("value"), text);
    }

    public void click(WebElement element) {
        element.click();
    }

    public void selectDropDown(WebElement dropdown, String value) {
        Select select = new Select(dropdown);
        select.selectByValue(value);
    }

    public String getText(WebElement element) {
        return element.getText();

    }

    public abstract boolean isOpened();
}
