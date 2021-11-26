package com.crm.comcast.organizationTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.comcast.OrganizationTestLib.CreateOrganization;
import com.crm.comcast.OrganizationTestLib.CreateOrganizationPage;
import com.crm.comcast.OrganizationTestLib.LoginPage;
import com.crm.genericfile.ExcelFile;
import com.crm.genericfile.FileUtility;

public class InduAndType {
	
		public static void main(String[] args) throws Throwable 
		{
	FileUtility fiL=new FileUtility();

	WebDriver driver=new ChromeDriver();
	ExcelFile exe=new ExcelFile();
	LoginPage Lp=new LoginPage(driver);
	Lp.LoginTOApp();
	CreateOrganizationPage crg=new CreateOrganizationPage(driver);
	
	Thread.sleep(2000);
	CreateOrganization crg1=new CreateOrganization(driver);
//	crg1.getCreateorganization();
//	crg1.getClicks();
//	crg1.getIndustry();
//	crg1.getIndustrydropdown();
//	crg1.getTypedropdown();
//	crg1.getSavebutton();

	}
	}

