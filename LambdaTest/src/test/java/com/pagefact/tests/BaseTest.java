package com.pagefact.tests;

import com.pagefact.driver.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected BaseTest() {
    }

    //Calling methods initDriver and quitDriver from Driver class
    @BeforeMethod
    public void startUp() {
        Driver.initDriver();
    }

    @AfterMethod
    public void tearDown() {
        Driver.quitDriver();
    }
}
