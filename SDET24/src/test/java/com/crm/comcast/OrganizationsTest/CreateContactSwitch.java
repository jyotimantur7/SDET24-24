package com.crm.comcast.OrganizationsTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.crm.comcast.OrganizationTestLib.Contactinfo;
import com.crm.comcast.OrganizationTestLib.CreateContact;
import com.crm.comcast.OrganizationTestLib.CreateOrganization;
import com.crm.comcast.OrganizationTestLib.HomePage;
import com.crm.comcast.OrganizationTestLib.LoginPage;
import com.crm.genericfile.BaseClassAnnotation;
import com.crm.genericfile.ExcelFile;
import com.crm.genericfile.FileUtility;


	public class CreateContactSwitch  extends BaseClassAnnotation{
		@Test(groups={"smokeTest","regressionTest"})
		public void CreateCon() throws Throwable {
			
			int ranNum = jLib.getRandomNumber();
			String orgName = eLib.getData("Sheet1", 4, 2)+"_"+ranNum;
			String indus = eLib.getData("Sheet1", 4, 3);
			String type = eLib.getData("Sheet1", 4, 4);
		HomePage hp=new HomePage(driver);
		hp.getOrganizationLink().click();
		CreateOrganization corg=new CreateOrganization(driver);
		corg.getCreateorganization().click();
		corg.getOrganizationname().sendKeys(orgName);
			
		corg.getSavebutton().click();
		Contactinfo cc=new Contactinfo(driver);
		/*wLib.waitForElementVisibility(driver, cc.getContacts());*/
		Thread.sleep(5000);
			String LastName = eLib.getData("contact", 1, 3);
			
			
			cc.getContacts().click();
			cc.getClickonlookupicon().click();
			CreateContact createCon=new CreateContact(driver);
			createCon.getLastname().sendKeys(LastName);;
			createCon.getContacticon().click();
			createCon.switchToWindow();
			createCon.getSearchfield().sendKeys(orgName);
			createCon.getSearchNowButton().click();
			driver.findElement(By.xpath("//a[.='"+orgName+"']")).click();
			
			createCon.switchToWindow1();
			CreateOrganization cg=new CreateOrganization(driver);
			cg.getSavebutton().click();
			System.out.println("test case1");
			
		}
		}

