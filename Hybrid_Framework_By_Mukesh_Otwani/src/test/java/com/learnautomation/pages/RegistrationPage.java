package com.learnautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {

	WebDriver driver;

	@FindBy(id = "firstName")
	WebElement firstName;

	@FindBy(id = "lastName")
	WebElement lastName;

	@FindBy(id = "userEmail")
	WebElement userEmail;

	@FindBy(id = "//input[@id='gender-radio-1']")
	WebElement maleRadioButton;

	@FindBy(id = "userNumber")
	WebElement phoneNumber;

	@FindBy(id = "dateOfBirthInput")
	WebElement dateOfBirthInput;

	@FindBy(xpath = "//select[@class='react-datepicker__month-select']")
	WebElement selectMonth;

	@FindBy(xpath = "//select[@class='react-datepicker__year-select']")
	WebElement selectYear;

	@FindBy(xpath = "//div[@class='react-datepicker__week']//div[starts-with(@class,'react-datepicker__day react-datepicker__day')]")
	WebElement selectDay;

	@FindBy(xpath = "//div[@class='subjects-auto-complete__control css-yk16xz-control']")
	WebElement subject;

	@FindBy(xpath = "//input[starts-with(@id,'hobbies-checkbox')]")
	WebElement hobbies;

	@FindBy(id = "uploadPicture")
	WebElement uploadPicture;

	@FindBy(id = "currentAddress")
	WebElement currentAddress;

	@FindBy(xpath = "//div[@class=' css-1wa3eu0-placeholder']")
	WebElement stateAndCityDropdown;
	
	
	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void registerToToolsQA(String firstName,String lastName,String username) {
		
	}

}
