package com.pagefact.driver;

import com.pagefact.Utils.ReadPropertyFile;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Objects;


public final class Driver {

    private Driver() {
    }

    //First method which helps to initialize the driver
    //Also doing Null checks and nonNull checks for the driver
    public static void initDriver() {
        if (Objects.isNull(DriverManager.getDriver())) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/java/com/pagefact/resources/chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            DriverManager.setDriver(driver);
            DriverManager.getDriver().get(ReadPropertyFile.getValue("home_page_url"));
            DriverManager.getDriver().manage().window().maximize();
            DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        }
    }

    //This method helps to quit the driver
    //Driver quits only when there is a driver instance
    public static void quitDriver() {
        if (Objects.nonNull(DriverManager.getDriver())) {
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }
}
