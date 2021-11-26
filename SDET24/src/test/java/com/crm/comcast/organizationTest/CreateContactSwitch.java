package com.crm.comcast.organizationTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.comcast.OrganizationTestLib.Contactinfo;
import com.crm.comcast.OrganizationTestLib.CreateContact;
import com.crm.comcast.OrganizationTestLib.HomePage;
import com.crm.comcast.OrganizationTestLib.LoginPage;
import com.crm.genericfile.ExcelFile;
import com.crm.genericfile.FileUtility;


	public class CreateContactSwitch {
		public  void  creta()throws Throwable {
			ExcelFile exe= new ExcelFile();
			FileUtility fiL=new FileUtility();
			WebDriver driver=new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			LoginPage lp=new LoginPage(driver);
			lp.LoginTOApp();
			Contactinfo cc=new Contactinfo(driver);
			cc.contactClick();
			cc.contactIcon();
			CreateContact createCon=new CreateContact(driver);
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			createCon.getLastname();
			createCon.getAccountname();
			//createCon.getClickOnIcon();
			createCon.switchToWindow();
			createCon.SearchOrgName();
			createCon.SearchButton();
			driver.findElement(By.xpath("//a[.='"+exe.getData("contact", 1, 2)+"']")).click();
			createCon.switchToWindow1();
			HomePage hp=new HomePage(driver);
			hp.MouseOverAction();
			hp.getSignout().clear();
		}
		}

