package com.crm.comcast.OrganizationsTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.crm.comcast.OrganizationTestLib.HomePage;
import com.crm.comcast.OrganizationTestLib.LoginPage;
import com.crm.comcast.OrganizationTestLib.OrganizationPage;
import com.crm.genericfile.ExcelFile;
import com.crm.genericfile.FileUtility;

public class CreateOrganization {
@Test
 public void CreateOrga() throws Throwable {
	FileUtility fiL=new FileUtility();
	ExcelFile exe=new ExcelFile();
	WebDriver driver =new ChromeDriver();
	LoginPage lp=new LoginPage(driver);
	HomePage hp=new HomePage(driver);
	hp.getOrganizationLink();
	OrganizationPage op=new OrganizationPage(driver);
	op.getCreateOrganization().click();
	op.getOrganizationName().sendKeys(exe.getData("Sheet1", 1, 2));
	op.getSavebutton().click();
}

}
