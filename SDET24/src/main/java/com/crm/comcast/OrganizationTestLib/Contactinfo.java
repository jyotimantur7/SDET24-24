package com.crm.comcast.OrganizationTestLib;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Contactinfo {
WebDriver driver;
public Contactinfo(WebDriver driver) 
     {
	this.driver=driver;
	PageFactory.initElements(driver,this);
	
      }
@FindBy(linkText = "Contacts")
private WebElement Contactss;

@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
private WebElement clickonlookupicon;
public WebDriver getDriver() {
	return driver;
}

public WebElement getContacts() 
{
	return Contactss;
}

public WebElement getClickonlookupicon() 
{
	return clickonlookupicon;
}
 public void  contactClick() 
 {
	 Contactss.click();
 }
 public void contactIcon()
 {
	 clickonlookupicon.click(); 
 }
}
 


