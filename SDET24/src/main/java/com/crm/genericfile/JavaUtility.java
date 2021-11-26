package com.crm.genericfile;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.util.Random;

public class JavaUtility {
	public int getRandomNumber()
	{
		Random ranDom=new Random();
		int ranDomNum = ranDom.nextInt(5000);
		return ranDomNum;
	}
	
	
	
	public int SysDate()
	{
		Date date=new Date(0);
		String systemDateAndTime = date.toString();
		return getRandomNumber();
	}
	public void pressVirtualEnterKey() throws AWTException
	{
		Robot rc=new Robot();
		rc.keyPress(KeyEvent.VK_ENTER);
		rc.keyRelease(KeyEvent.VK_ENTER);
		
	}
	
	

}
