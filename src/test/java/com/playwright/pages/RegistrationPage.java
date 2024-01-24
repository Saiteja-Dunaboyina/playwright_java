package com.playwright.pages;

import org.testng.SkipException;

import com.microsoft.playwright.Page;

public class RegistrationPage {
	
	private final String registrationText = "//a[text()='Register']";
	private final String genderRadioButton = "//label[text()='Male']";
	private final String firstNameInput = "//input[@id='FirstName']";
	private final String lastNameInput = "//input[@id='LastName']";
	private final String dayDropdown = "//select[@name='DateOfBirthDay']";
	private final String monthDropdown = "//select[@name='DateOfBirthMonth']";
	private final String yearDropdown = "//select[@name='DateOfBirthYear']";
	private final String emailInput = "//input[@id='Email']";
	private final String companyInput = "//input[@id='Company']";
	private final String passwordInput = "//input[@id='Password']";
	private final String confirmPasswordInput = "//input[@id='ConfirmPassword']";
	private final String registerButton = "//button[@id='register-button']";
	private final String continueButton = "//a[text()='Continue']";
	private final String errorMsg = "//li[text()='The specified email already exists']";
	public Page page;
	
	public RegistrationPage(Page page) {
		this.page = page;
	}
	
	public void register() {
		page.locator(registrationText).click();
		page.locator(genderRadioButton).click();
		page.locator(firstNameInput).fill("sai");
		page.locator(lastNameInput).fill("tharun");
		page.locator(dayDropdown).click();
		page.locator(dayDropdown).selectOption("12");
		page.locator(monthDropdown).click();
		page.locator(monthDropdown).selectOption("11");
		page.locator(yearDropdown).click();
		page.locator(yearDropdown).selectOption("2001");
		page.locator(emailInput).fill("sai@gmail.com");
		page.locator(companyInput).fill("abc");
		page.locator(passwordInput).fill("sai@123");
		page.locator(confirmPasswordInput).fill("sai@123");
		page.locator(registerButton).click();
		if(page.locator(errorMsg).isVisible()) {
			throw new SkipException("User is already registered");
		}
		page.locator(continueButton).click();
	}
}
