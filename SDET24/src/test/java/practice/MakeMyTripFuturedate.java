package practice;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;


public class MakeMyTripFuturedate {
	@Test
	public void TripFuture() throws InterruptedException
	{
	Date dateobj=new Date();
	String date = dateobj.toString();
	
	String[] today = date.split(" ");
	
	String day=today[0];
	String month=today[1];
	String actdate=today[2];
	String year=today[5];
	String depdate=day+" "+month+" "+actdate+" "+year;
    
	 
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.get("https://www.makemytrip.com/");
	driver.findElement(By.xpath("//div[@data-cy='outsideModal']")).click();
	//from 
	WebElement src = driver.findElement(By.xpath("//span[.='From']"));
	src.click();
	driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("BLR");
	Thread.sleep(3000);
	
	driver.findElement(By.xpath("//div[.='BLR']")).click();
	//To
	WebElement desti = driver.findElement(By.xpath("//span[.='To']"));
	desti.click();
	driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys("GOI");
	Thread.sleep(3000);
	
	driver.findElement(By.xpath("//DIV[.='GOI']")).click();
	//Departure
	driver.findElement(By.xpath("//span[.='DEPARTURE']")).click();
	Thread.sleep(3000);
	
	
	
	driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
	//date
	driver.findElement(By.xpath("//div[@aria-label='Wed Jan 26 2022']")).click();
	//search
	driver.findElement(By.xpath("//a[.='Search']")).click();
	System.out.println("flight booked");
}
	
}
