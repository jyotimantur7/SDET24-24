package Properties;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.genericfile.FileUtility;

public class NotepadProperty {
	public static void main(String[] args) throws IOException
	
	
	{
		FileUtility fiss=new FileUtility();
		String BROWSER=fiss.Generic1("browser");
	String URL=fiss.Generic1("url");
	String USERNAME=fiss.Generic1("username");
	String PASSWORD=fiss.Generic1("password");
	System.setProperty("webdriver.chrome.driver", "./software/chromedriver.exe");
	
	WebDriver driver=null;
	if(BROWSER.equals("chrome"))
	{
		driver=new ChromeDriver();
	}
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get(URL);
	
	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	driver.findElement(By.id("submitButton")).click();
	} 

}
