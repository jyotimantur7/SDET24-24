package com.crm.comcast.OrganizationTestLib;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.genericfile.ExcelFile;
import com.crm.genericfile.FileUtility;
import com.crm.genericfile.WebDriverUtility;

public class CreateContact {
	WebDriver driver;
	public CreateContact(WebDriver driver) {
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}
	
	@FindBy(name="lastname")
	private WebElement lastname;
	
	@FindBy(name="accountname")
	private WebElement accountname;
	
@FindBy(xpath = "(//img[@src='themes/softed/images/select.gif'])[1]")
private WebElement Contacticon;

@FindBy(id = "search_txt")
private WebElement Searchfield;

@FindBy(name = "search")
private WebElement searchNowButton;


public WebElement getLastname() {
	return lastname;
}


public WebElement getSearchfield() {
	return Searchfield;
}
public WebElement getSearchNowButton() {
	return searchNowButton;
}

public WebElement getContacticon() {
	return Contacticon;
}

		
public void switchToWindow()
{
	Set<String> window = driver.getWindowHandles();
	Iterator<String> itr = window.iterator();
	while(itr.hasNext())
	{
		String wind = itr.next();
		String title = driver.switchTo().window(wind).getTitle();
		if(title.contains("Actions&actions"))
		{
			break;
		}
	}
}
public void SearchOrgName() throws Throwable {
	ExcelFile exe=new ExcelFile();
	Searchfield.sendKeys(exe.getData("contact", 1, 2));
}

public void SearchButton() {
	searchNowButton.click();
}

public void switchToWindow1()
{
	Set<String> window = driver.getWindowHandles();
	Iterator<String> itr = window.iterator();
	while(itr.hasNext())
	{
		String wind = itr.next();
		String title = driver.switchTo().window(wind).getTitle();
		if(title.contains("Contacts&action"))
		{
			break;
		}
	}
}


public WebElement getAccountname() {
	return accountname;
}
 

}
