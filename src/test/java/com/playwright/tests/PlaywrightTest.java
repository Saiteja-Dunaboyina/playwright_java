package com.playwright.tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.playwright.pages.RegistrationPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PlaywrightTest {

	private Playwright playwright;
	private Browser browser;
	private Page page;
	private RegistrationPage registrationPage;

	@BeforeSuite
	public void getPage() {
		playwright = Playwright.create();
		browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		page = browser.newPage();
		registrationPage = new RegistrationPage(page);

	}

	@BeforeTest
	public void setup() {
		page.navigate("https://demo.nopcommerce.com");
	}

	@Test
	public void registration() {
		registrationPage.register();
	}

	@AfterSuite
	public void teardown() {
		page.close();
	}

}
