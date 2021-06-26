package com.learnautomation.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCaseWithoutFramework {

	WebDriver driver;

	@Test
	public void test1() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		 WebDriverManager.firefoxdriver().setup();
		 driver = new FirefoxDriver();

		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/automation-practice-form");
	}

}