package Properties;

import java.io.IOException;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.genericfile.ExcelFile;
import com.crm.genericfile.FileUtility;

public class OrganizationGenericTest {
	public static void main(String[] args) throws Throwable {
		 Random ran=new Random();
			int ranNum = ran.nextInt();
			System.out.println(ranNum);
			FileUtility fiL=new FileUtility();
			String BROWSER=fiL.Generic1("browser");
			String URL=fiL.Generic1("url");
			String USERNAME=fiL.Generic1("username");
			String PASSWORD=fiL.Generic1("password");
			ExcelFile exe=new ExcelFile();
			String orgName=exe.getData("sheet1",4,2)+"_"+ranNum;
			String Industries=exe.getData("sheet1",4,3);
			String type=exe.getData("sheet1",4,4);
			String contactName=exe.getData("contact",1,3);
			
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
			
			WebDriverWait wait=new WebDriverWait(driver,20);
			//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[.='Contacts']"))));
			Thread.sleep(4000);
			driver.findElement(By.xpath("//a[.='Contacts']")).click();
			driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
			driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(contactName);
			driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
			Set<String> set1 = driver.getWindowHandles();
			Iterator<String> itr1= set1.iterator();
			while(itr1.hasNext())
			{
				String windowwid = itr1.next();
				driver.switchTo().window(windowwid);
				String title = driver.getTitle();
				if(title.contains("Accounts&action"))
				{
					break;
				}
			
			}
			
			
			driver.findElement(By.name("search_text")).sendKeys(orgName);
			driver.findElement(By.xpath("//input[@type='button']")).click();
			driver.findElement(By.xpath("//a[.='"+orgName+"']")).click();
			Set<String> set2 = driver.getWindowHandles();
				Iterator<String> itr2 = set2.iterator();
				while(itr2.hasNext())
				{
					String windowwid = itr2.next();
					driver.switchTo().window(windowwid);
					String title = driver.getTitle();
					if(title.contains("Contacts&action"))
					{
				break;
					}
	}
				Thread.sleep(5000);
				
driver.findElement(By.xpath("(//input[@name='button'])[1]")).click();
	wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[@class='dvHeaderText']"))));
	WebElement ele2=driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
	 String val3=ele2.getText();
	 if(val3.contains(contactName))
	 {
		 System.out.println("contact is created");
	 }else
	 {
		 System.out.println("contact is not created");
	 }
	 WebElement ele3=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	 Actions act=new Actions(driver);
	 wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))));
	 act.moveToElement(ele3).perform();
	 driver.findElement(By.xpath("//a[.='Sign Out']")).click();
	 driver.close();
	 
	}

}
