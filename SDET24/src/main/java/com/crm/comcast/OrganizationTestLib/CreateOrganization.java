package com.crm.comcast.OrganizationTestLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.genericfile.ExcelFile;
import com.crm.genericfile.FileUtility;
import com.crm.genericfile.WebDriverUtility;

public class CreateOrganization {
	private static final String Industries = null;

	WebDriver driver;
	   public CreateOrganization(WebDriver driver)
	   {
		   this.driver=driver;
		   PageFactory.initElements(driver,this);
	   }
    @FindBy(linkText = "Organizations")
    private WebElement organization;
    
    @FindBy(xpath = "//img[@title='Create Organization...']")
    private WebElement createorganization;
    
    @FindBy(xpath = "//input[@name='accountname']")
    private WebElement organizationname;
    
    @FindBy(xpath = "//select[@name='industry']")
    private WebElement industrynamedropdown;
    
    @FindBy(xpath = "//select[@name='accounttype']")
    private WebElement type;
    
    @FindBy(xpath ="(//input[@title='Save [Alt+S]'])[1]")
    private WebElement savebutton;
    
    
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getOrganization() {
		return organization;
	}

	public WebElement getCreateorganization() {
		return createorganization;
	}

	public WebElement getOrganizationname() {
		return organizationname;
	}
    
	 
	public WebElement getIndustryname() {
		return industrynamedropdown;
	}
	
		

	public WebElement getSavebutton() {
		return savebutton;
	}
	
	   
	    

	public WebElement getType() {
		return type;
	}
	   
	  	   
}