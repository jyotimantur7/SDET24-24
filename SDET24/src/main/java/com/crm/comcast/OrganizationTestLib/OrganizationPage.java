package com.crm.comcast.OrganizationTestLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.genericfile.ExcelFile;

public class OrganizationPage {
WebDriver driver;
@FindBy(xpath = "//img[@title='Create Organization...']")
private WebElement CreateOrganization;

@FindBy(name="accountname")
private WebElement OrganizationName;

@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
private WebElement savebutton;

public OrganizationPage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver,this);
}



public WebElement getCreateOrganization() {
	return CreateOrganization;
}
public WebElement getOrganizationName() {
	return OrganizationName;
}
public WebElement getSavebutton() {
	return savebutton;
}

}