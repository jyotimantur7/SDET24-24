package com.crm.genericfile;
/*
 * this class will implement retry analyzer which can be utilized for failed test cases
 */
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class ReTryAnalyzer implements IRetryAnalyzer {	

	int count=0;
	int retryCount=4;
	public boolean retry(ITestResult result) {
		while(count<retryCount)
		{
			count++;
			return true;
		}
		return false;
	}

	
}
