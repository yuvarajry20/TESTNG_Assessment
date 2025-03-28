package com.Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	 @FindBy(id = "user-name")
	 WebElement usernameField;

	 @FindBy(id = "password")
	 WebElement passwordField;

	 @FindBy(id = "login-button")
	 WebElement loginButton;

	 @FindBy(css = "div.error-message-container")
	 WebElement errorMessage;
	 
	 public void login(String username, String password) {
	        usernameField.sendKeys(username);
	        passwordField.sendKeys(password);
	        loginButton.click();
	    }
	 public boolean ErrorMessage() {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 return wait.until(ExpectedConditions.visibilityOf(errorMessage)).isDisplayed();
	    }
  
}
