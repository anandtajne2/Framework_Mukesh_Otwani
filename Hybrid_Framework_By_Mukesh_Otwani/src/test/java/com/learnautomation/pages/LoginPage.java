package com.learnautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	WebDriver driver;

	@FindBy(id = "user_email_login")
	WebElement username;

	@FindBy(id = "user_password")
	WebElement password;

	@FindBy(xpath = "//input[@value='Sign me in']")
	WebElement loginButton;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void loginToBrowserStack(String usernameApp, String passwordApp) {
		username.sendKeys(usernameApp);
		password.sendKeys(passwordApp);
		loginButton.click();
	}

}
