package com.crm.comcast.OrganizationTestLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.genericfile.ExcelFile;
import com.crm.genericfile.FileUtility;

public class CreateOrganizationPage {
	WebDriver driver;
     public CreateOrganizationPage(WebDriver driver) 
     {
		this.driver = driver;
	PageFactory.initElements(driver, this);
     }

       @FindBy(linkText ="Organizations")
       private WebElement organization;
       
       
    public WebDriver getDriver() {
		return driver;
	}

	public WebElement getOrganization() {
		return organization;
	}
	
	public void organame() throws Throwable
	{
	 organization.click();
    }

}
