package com.crm.genericfile;

import java.io.File;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {

	public void waitUntilPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	
	public void waitForElementVisibility(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(element));
	}	
	
		public void waitAndClick(WebElement element) throws InterruptedException
	{
			int count=0;
			while(count<20) {
			try{
				element.click();
				break;
			   }catch(Throwable e)
			   {
				   Thread.sleep(2000);
				   count++;
			   }
		
	 }
	}
			public void select(WebElement element,String option)
			{
				Select  select= new Select(element);
				select.selectByVisibleText(option);
			}
			
			public void Select(WebElement element,int index)
			{
				Select select1= new Select(element);
				select1.selectByIndex(index);
				
			}
			
			public void mouseOverAction(WebDriver driver,WebElement element)
			{
				Actions act=new Actions(driver);
				act.moveToElement(element).perform();
			}
			
			public void switchToWindow(WebDriver driver, String partialWinTitle)
			{
				Set<String> window = driver.getWindowHandles();
				Iterator<String> itr = window.iterator();
				while(itr.hasNext())
				{
					String wind = itr.next();
					String title = driver.switchTo().window(wind).getTitle();
					if(title.contains(partialWinTitle))
					{
						break;
					}
				}
			}
			
			
			public void rightClick(WebDriver driver,WebElement element) 
			{
				Actions act1=new Actions(driver);
				act1.contextClick(element).perform();
			}
			
			public void switchFrame(WebDriver driver,WebElement element)
			{
				driver.switchTo().frame(element);
			}
	        
			public void switchFrame(WebDriver driver,int index)
			{
				driver.switchTo().frame(index);
			}
			
			public void switchFrame(WebDriver driver,String idOrName)
			{
				driver.switchTo().frame(idOrName);
			}
			
			public void scrollToElement(WebDriver driver,WebElement element)
			{
				JavascriptExecutor js=(JavascriptExecutor)driver;
				int y=element.getLocation().getY();
				js.executeScript("window.scrollBy(0,"+y+")", element);
				
			}
			
			public void passEnterKey(WebDriver driver)
			{
				Actions act1=new Actions(driver);
				act1.sendKeys(Keys.ENTER).perform();
			}
}
