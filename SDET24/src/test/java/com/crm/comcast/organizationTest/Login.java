package com.crm.comcast.organizationTest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.comcast.OrganizationTestLib.LoginPage;
import com.crm.genericfile.ExcelFile;
import com.crm.genericfile.FileUtility;

public class Login 
{
	public static void main(String[] args) throws IOException 
	{
FileUtility fiL=new FileUtility();

WebDriver driver=new ChromeDriver();
ExcelFile exe=new ExcelFile();
LoginPage Lp=new LoginPage(driver);
Lp.LoginTOApp();





	
	
	
	}	
}
