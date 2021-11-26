package Properties;

import java.io.IOException;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

import com.crm.genericfile.ExcelFile;
import com.crm.genericfile.FileUtility;

public class OrganizationTest 
{
	@Test
	
	public void Orga(XmlTest xml) throws Throwable
	{
		Random ran=new Random();
		int ranNum = ran.nextInt();
		System.out.println(ranNum);
		
		FileUtility fi=new FileUtility();
		ExcelFile exe=new ExcelFile();
		String BROWSER=xml.getParameter("browser");
		String URL=xml.getParameter("url");
		String USERNAME=xml.getParameter("username");
		String PASSWORD=xml.getParameter("password");
		String orgName=exe.getData("sheet1",1,2)+"_"+ranNum;
		String Status=exe.getData("sheet1",1,3);
		WebDriver driver=new ChromeDriver();
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement( By.xpath("(//a[.='Organizations'])[1]")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgName);
		driver.findElement(By.xpath("(//input[@name='button'])[1]")).click();
	 WebElement ele = driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
		String val = ele.getText();
		if(val.contains(orgName))
		{
			System.out.println("org created");
		}

		System.out.println(val);
	}
	

}
