package com.learnautomation.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.learnautomation.utilities.BrowserFactory;

public class RegistrationTest {

	WebDriver driver;

	@Test
	public void RegistrationApp() {
		driver = BrowserFactory.startApplication("ie", "https://demoqa.com/automation-practice-form", driver);
		System.out.println("page title : " + driver.getTitle());
	}

}
