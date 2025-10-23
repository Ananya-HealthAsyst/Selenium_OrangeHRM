package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	private WebDriver driver;

	@FindBy(name = "username")
	private WebElement userName;

	@FindBy(name = "password")
	private WebElement passWord;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement loginButton;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void open() {

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");

	}

	// username field

	public void fillUsername(String username) {
		userName.sendKeys(username);

	}

	// password field

	public void fillPassword(String password) {
		passWord.sendKeys(password);

	}

	// login button

	public void loginButtonClick() {
		loginButton.click();
	}

	// complete login

	public void loginComplete(String username, String password) {
		fillUsername(username);
		fillPassword(password);
		loginButtonClick();
	}

}
