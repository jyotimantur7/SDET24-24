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

public class HandlingDynamicWebTable {
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
				
				driver.findElement(By.xpath("(//a[.='Organizations'])[1]")).click();
			
			List<WebElement> list = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[1]/input"));
				for(int i=1;i<list.size()-1;i++)
				{
					list.get(i).click();
				}
				Thread.sleep(2000);
				//last checkbox
				list.get(list.size()-1).click();
				
				//5th checkbox
				driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[7]/td[1]/input")).click();
				
				List<WebElement> lst = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[3]/a"));
				/*for(int i=1;i<lst.size()-1;i++)
				{
					System.out.println(lst.get(i).getText());
	
				}*/
				String OrgName=lst.get(6).getText();
				System.out.println(OrgName);
				for(int i=1;i<list.size()-1;i++)
				{
					if(OrgName.equals(lst.get(i).getText()))
							{
						     driver.findElement(By.xpath("//a[.='"+OrgName+"']/../../td[8]/a[.='del']")).click();
							}
				}
	}
	

}
