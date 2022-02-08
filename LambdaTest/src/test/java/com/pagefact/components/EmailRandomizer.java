package com.pagefact.components;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;

public class EmailRandomizer {

    private WebDriver driver;

    //Method for creating random Emails
    public String emailRandomizer() {
        return RandomStringUtils.randomAlphabetic(8) + "@gmail.com";
    }
}
