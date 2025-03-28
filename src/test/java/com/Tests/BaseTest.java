package com.Tests;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
	public static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    @BeforeMethod
    public void setup() {
    	    driver.set(new ChromeDriver());
            driver.get().manage().window().maximize();
            driver.get().get("https://www.saucedemo.com/v1/index.html");
            driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
	public void tearDown() {
		driver.get().quit();
		
	}
	  public WebDriver getDriver() {
	      return driver.get();
	  }
}
