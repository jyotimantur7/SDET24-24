package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BookTicket {
private static final String[][] objArr = null;
@Test(dataProvider = "dataProvider")
public  void bookTicketTest(String src,String dst) {
	System.out.println("book ticket from"+src+"to"+dst);
	
WebDriver driver=new ChromeDriver();
driver.get("https://www.redbus.com");
driver.findElement(By.xpath("//input[@id='src']")).sendKeys(src);
driver.findElement(By.xpath("(//input[@class='db'])[2]")).sendKeys(dst);
driver.findElement(By.xpath("//button[@id='search_btn']")).click();
}
@DataProvider
public Object[][] dataProvider()
{
	Object[][] objArr=new Object[3][2];
	objArr[0][0]="Bangalore";
	objArr[0][1]="Mangalore";
	
	objArr[1][0]="Bangalore";
	objArr[1][1]="Bijapur";
	
	objArr[2][0]="Bangalore";
	objArr[2][1]="mysore";
	return objArr;

}
}
