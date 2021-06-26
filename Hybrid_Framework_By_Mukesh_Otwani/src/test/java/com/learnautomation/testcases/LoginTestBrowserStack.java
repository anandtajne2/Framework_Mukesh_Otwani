package com.learnautomation.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.learnautomation.pages.BaseClass;
import com.learnautomation.pages.LoginPage;

public class LoginTestBrowserStack extends BaseClass {

	@Test
	public void loginApp() {
		logger = report.createTest("Login to browser stack");
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		logger.info("starting application");
		loginPage.loginToBrowserStack(excelDataProvider.getStringData("login", 0, 0),
				excelDataProvider.getStringData("login", 0, 1));
		logger.pass("login done successfully ");

	}

}
