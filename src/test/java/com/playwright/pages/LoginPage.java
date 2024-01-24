package com.playwright.pages;



import com.microsoft.playwright.Page;

public class LoginPage {
	
	public Page page;
	private final String loginText = "//a[text()='Log in']";
	private final String emailInput = "//input[@id='Email']";
	private final String passwordInput = "//input[@id='Password']";
	private final String loginButton = "//button[text()='Log in']";
	private final String logoutButton = "//a[text()='Log out']";
	
	
	public LoginPage(Page page) {
		this.page = page;
	}
	
	public void login() {
		page.locator(loginText).click();
		page.locator(emailInput).fill("sai@gmail.com");
		page.locator(passwordInput).fill("sai@123");
		page.locator(loginButton).click(); 
	}
	
	public boolean isLogoutDisplayed() {
		boolean element = page.locator(logoutButton).isVisible();
		return element;
	}
	
	public void logout() {
		page.locator(logoutButton).click();
	}
	
}

