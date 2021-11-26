package practice;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ClearTrip {
	@Test
	public void trip() throws InterruptedException
	{
		Date dateobj=new Date();
		String date = dateobj.toString();
		System.out.println(date);
		String[] today = date.split(" ");
		
		String day=today[0];
		String month=today[1];
		String actdate=today[2];
		String year=today[5];
		String depdate=day+" "+month+" "+actdate+" "+year;
		System.out.println(depdate);
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.cleartrip.com");
		
		
		driver.findElement(By.xpath("(//input[@placeholder='Any worldwide city or airport'])[1]")).click();
		Thread.sleep(2000);
		 driver.findElement(By.xpath("(//P[@style='max-width: 337px;'])[1]")).click();
		
		
		driver.findElement(By.xpath("(//input[@placeholder='Any worldwide city or airport'])[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//p[@style='max-width: 337px;'])[2]")).click();
	//	driver.findElement(By.xpath("//button[@style='min-width: 185px;']")).click();
		Thread.sleep(2000);
		//driver.findElement(By.xpath("(//div[@role='gridcell' ])[1]")).click();
		driver.findElement(By.xpath("//h4[.='Departon']/../../following.sibling::div//button")).click();
		driver.findElement(By.xpath("//div[@aria-label='"+depdate+"']")).click();
		driver.findElement(By.xpath("//button[.='Search flights']")).click();
		
	}

}
