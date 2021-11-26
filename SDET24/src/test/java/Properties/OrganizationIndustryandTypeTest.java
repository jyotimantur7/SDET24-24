package Properties;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

import com.crm.genericfile.ExcelFile;
import com.crm.genericfile.FileUtility;

public class OrganizationIndustryandTypeTest {
	 @Test
	 public void Create(XmlTest xml) throws Throwable {
	 Random ran=new Random();
	int ranNum = ran.nextInt();
	System.out.println(ranNum);
	
	
		FileUtility fi=new FileUtility();
		ExcelFile exe =new ExcelFile();
		String BROWSER=xml.getParameter("browser");
		String URL=xml.getParameter("url");
		String USERNAME=xml.getParameter("username");
		String PASSWORD=xml.getParameter("password");
		String orgName=exe.getData("Sheet1",4,2)+"_"+ranNum;
		String Industries=exe.getData("Sheet1",4,3);
		String Type=exe.getData("Sheet1",4,4);
		
	
	
	
	
		
		//System.out.println(orgName+"*************************************************");
		System.out.println("*************************************************");
	
		
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	driver.get(URL);
	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	driver.findElement(By.id("submitButton")).click();
		driver.findElement( By.xpath("(//a[.='Organizations'])[1]")).click();
	driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgName);
	WebElement ele = driver.findElement(By.name("industry"));
	Select sc=new Select(ele);
	sc.selectByVisibleText("Energy");
	WebElement ele1 = driver.findElement(By.name("accounttype"));	Select sc1=new Select(ele1);
	sc1.selectByVisibleText("Press");
	driver.findElement(By.xpath("(//input[@name='button'])[1]")).click();
		
		
		
	}
	

}
