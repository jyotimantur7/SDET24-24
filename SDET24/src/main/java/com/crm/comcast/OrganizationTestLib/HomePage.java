package com.crm.comcast.OrganizationTestLib;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.genericfile.FileUtility;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(linkText = "Organizations")
	private WebElement organizationLink;
	
	@FindBy(linkText = "Contacts")
	private WebElement contactsLink;
	
	@FindBy(linkText = "Products")
	private WebElement productsLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']" )
	private WebElement administrationimg;
	

	
	@FindBy(linkText ="Sign Out")
	private WebElement signout;
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getOrganizationLink() {
		return organizationLink;
	}

	public WebElement getContactsLink() {
		return contactsLink;
	}

	public WebElement getProductsLink() {
		return productsLink;
	}

	public WebElement getAdministrationimg() {
		return administrationimg;
	}

	public WebElement getSignout() {
		return signout;
	}
	FileUtility fiL=new FileUtility();
	public void MouseOverAction() {
		Actions act=new Actions(driver);
		act.moveToElement(administrationimg).perform();
		
	}
		
	}
	

