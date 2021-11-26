package com.crm.comcast.OrganizationTestLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Information {
	WebDriver driver;
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement oganamevarify;
	
	@FindBy(xpath = "//span[@id='dtlview_Industry']")
	private WebElement  industrynamevarify;
	
	@FindBy(xpath ="//span[@id='dtlview_type']")
	private WebElement  typenamevarify;

	public WebElement getOganamevarify() {
		return oganamevarify;
	}

	public WebElement getIndustrynamevarify() {
		return industrynamevarify;
	}

	public WebElement getTypenamevarify() {
		return typenamevarify;
	}
	
	public Information(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements( driver,this);
	}
}
