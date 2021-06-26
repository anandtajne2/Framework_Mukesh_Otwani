package com.learnautomation.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.learnautomation.utilities.BrowserFactory;
import com.learnautomation.utilities.ConfigDataProvider;
import com.learnautomation.utilities.ExcelDataProvider;
import com.learnautomation.utilities.Helper;

public class BaseClass {

	public WebDriver driver;
	public ExcelDataProvider excelDataProvider;
	public ConfigDataProvider configDataProvider;
	public ExtentReports report;
	public ExtentTest logger;

	@BeforeSuite
	public void setupSuite() {

		Reporter.log("Setting up reports and test getting ready.", true);

		excelDataProvider = new ExcelDataProvider();
		configDataProvider = new ConfigDataProvider();

		ExtentHtmlReporter extentHtmlReporter = new ExtentHtmlReporter(new File(
				System.getProperty("user.dir") + "/Reports/Browserstack_" + Helper.getCurrentDataTime() + ".html"));
		report = new ExtentReports();
		report.attachReporter(extentHtmlReporter);

		Reporter.log("Setting done - test can be started.", true);
	}

	@BeforeClass
	public void setup() {
		Reporter.log("Trying to start Browser and Getting application : ", true);
		driver = BrowserFactory.startApplication(configDataProvider.getBrowser(), configDataProvider.getStagingURL(),
				driver);
		Reporter.log("Browser and Getting application is up and running : ", true);
	}

	@AfterClass
	public void tearDown() {
		BrowserFactory.quiteBrowser(driver);
	}

	@AfterMethod
	public void tearDownMethod(ITestResult result) throws IOException {
		Reporter.log("Test is about to end : ", true);
		if (result.getStatus() == ITestResult.FAILURE) {
			logger.fail("test failed ",
					MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			logger.pass("test passed ",
					MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		} else if (result.getStatus() == ITestResult.SKIP) {
			logger.skip("test SKIPED ",
					MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		report.flush();
		Reporter.log("Test completed >>> Reports Generated : ", true);
	}

}
