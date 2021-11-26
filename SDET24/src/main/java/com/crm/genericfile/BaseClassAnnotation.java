package com.crm.genericfile;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.crm.comcast.OrganizationTestLib.HomePage;
import com.crm.comcast.OrganizationTestLib.LoginPage;

public class BaseClassAnnotation {
public 	WebDriver driver;
/*object creation for Lib*/
	public FileUtility fLib=new FileUtility();
	public ExcelFile eLib=new ExcelFile();
	public JavaUtility jLib=new JavaUtility();
	public WebDriverUtility wLib=new WebDriverUtility();
	DataBaseUtility dbLib=new DataBaseUtility();
	
	@BeforeSuite(groups={"smokeTest","regressionTest"})
	public void configBS()
	{
		System.out.println("=====Connect to DB=====");
		dbLib.connectToDB();
	}
	//@Parameters(value="BROWSER")
	@BeforeClass(groups={"smokeTest","regressionTest"})
	public void configBC() throws IOException
	{
		System.out.println("=====To Launch the Browser====");
		//driver=new ChromeDriver();
		String BROWSER = fLib.Generic1("browser");
		 String URL=fLib.Generic1("url");
		if (BROWSER.equalsIgnoreCase("chrome")) {
		
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox")) {
	
		driver=new FirefoxDriver();
		}
		wLib.waitUntilPageLoad(driver);
		driver.manage().window().maximize();	
	}
	@BeforeMethod(groups={"smokeTest","regressionTest"})
	public void configBM() throws IOException
	{
		/* common data*/
		System.out.println("=====Login  to the Application====");
		//String BROWSER = fLib.Generic1("browser");
		String URL = fLib.Generic1("url");
		String USERNAME = fLib.Generic1("username");
		String PASSWORD= fLib.Generic1("password");
		/* navigate to app*/
		driver.get(URL);
		/*Login to app*/
		LoginPage lp=new LoginPage(driver);
		lp.LoginTOApp();
		
	}
	@AfterMethod(groups={"smokeTest","regressionTest"})
	public void configAM()
	{
		System.out.println("=====Logout the application===");
		HomePage hp=new HomePage(driver);
		wLib.waitForElementVisibility(driver, hp.getAdministrationimg());
		hp.MouseOverAction();
		hp.getSignout().click();
	}
	@AfterClass(groups={"smokeTest","regressionTest"})
   public void configAC()
   {
		System.out.println("======Close the browser=====");
		driver.quit();
   }
	@AfterSuite(groups={"smokeTest","regressionTest"})
	public void configAS() throws SQLException
	{
		System.out.println("=====Close DB======");
		dbLib.closeDB();
	}
			
	

}
