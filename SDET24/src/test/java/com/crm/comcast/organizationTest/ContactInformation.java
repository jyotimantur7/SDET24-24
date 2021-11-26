package com.crm.comcast.organizationTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.comcast.OrganizationTestLib.Contactinfo;
import com.crm.comcast.OrganizationTestLib.HomePage;
import com.crm.comcast.OrganizationTestLib.LoginPage;
import com.crm.genericfile.ExcelFile;
import com.crm.genericfile.FileUtility;

public class ContactInformation {
	public static void main(String[] args) throws InterruptedException, IOException {
		
	
	FileUtility fiL=new FileUtility();
	Thread.sleep(2000);
    ExcelFile exe=new ExcelFile();
    WebDriver  driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    LoginPage lp=new LoginPage(driver);
    lp.LoginTOApp();
    Contactinfo con=new Contactinfo(driver);
    con.contactClick();
    con.contactIcon();
}
}