package com.crm.comcast.organizationTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.comcast.OrganizationTestLib.HomePage;
import com.crm.comcast.OrganizationTestLib.LoginPage;
import com.crm.genericfile.ExcelFile;
import com.crm.genericfile.FileUtility;

public class Home {
	public static void main(String[] args) throws IOException, InterruptedException {
		FileUtility fiL = new FileUtility();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		ExcelFile exe = new ExcelFile();
		LoginPage logp = new LoginPage(driver);
		logp.LoginTOApp();
		HomePage hom = new HomePage(driver);
		hom.MouseOverAction();
		Thread.sleep(2000);
		hom.getSignout().click();

	}
}
