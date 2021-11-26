package com.crm.comcast.OrganizationTestLib;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.genericfile.FileUtility;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(name = "user_name")
	private WebElement username;

	@FindBy(name = "user_password")
	private WebElement password;

	@FindBy(id = "submitButton")
	private WebElement loginbutton;

	public WebElement getUsername() {
		return username;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLoginbutton() {
		return loginbutton;
	}

	FileUtility fiL = new FileUtility();

	public void LoginTOApp() throws IOException {

		driver.get(fiL.Generic1("url"));
		username.sendKeys(fiL.Generic1("username"));
		password.sendKeys(fiL.Generic1("password"));
		loginbutton.click();

	}

}
