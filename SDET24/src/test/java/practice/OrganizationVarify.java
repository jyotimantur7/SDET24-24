package practice;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.genericfile.FileUtility;

public class OrganizationVarify {
	WebDriver driver;
	@Test
	public void WebTable() throws IOException, InterruptedException {
		FileUtility fLib=new FileUtility();
		String BROWSER = fLib.Generic1("browser");
		String URL = fLib.Generic1("url");
		String USERNAME = fLib.Generic1("username");
				String PASSWORD = fLib.Generic1("password");
				
				if(BROWSER.equalsIgnoreCase("chrome"))
				{
					driver=new ChromeDriver();
				}else if(BROWSER.equalsIgnoreCase("firefox"))
				{
					driver=new FirefoxDriver();
				}else
				{
					System.out.println("invalid browser");
				}
				
				driver.get(URL);
				driver.findElement(By.name("user_name")).sendKeys(USERNAME);
				driver.findElement(By.name("user_password")).sendKeys(USERNAME);
				driver.findElement(By.id("submitButton")).click();
				
			/*	driver.findElement(By.xpath("(//a[.='Organizations'])[1]")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
				driver.findElement(By.xpath("//input[@name='accountname']")).click();
				driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys("vtiger1");
				driver.findElement(By.xpath("(//input[@type='button'])[1]")).click();
				
				driver.findElement(By.xpath("(//a[.='Organizations'])[1]")).click();
				List<WebElement> list = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[9]/td[3]/a"));
		if(list.contains("vtiger1"))
		{
			System.out.println("organization name is matching");
			}else
			{
				System.out.println("delete");
			}
		((WebElement) driver.findElements(By.xpath("(//table[@class='lvt small']/tbody/tr[9]/td[8]/a)[2]"))).click();*/
				
				
				
				
				driver.findElement(By.xpath("(//a[.='Organizations'])[1]")).click();
				String organization="OrgJJJJ";
				List<WebElement> list = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[9]/td[3]/a"));
				for(int i=1;i<list.size();i++)
				{
					String actual=list.get(i).getText();
					if(actual.contains(organization))
					{
						System.out.println("org name is matching");
						driver.findElement(By.xpath("(//table[@class='lvt small']/tbody/tr[9]/td[8]/a)[2]")).click();
					}
				}
				
}
}