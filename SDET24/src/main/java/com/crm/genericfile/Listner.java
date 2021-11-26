 package com.crm.genericfile;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.io.Files;

public class Listner implements ITestListener
{
  ExtentReports report;
   ExtentTest test;
	
	public void onTestStart(ITestResult result) {
		test=report.createTest(result.getMethod().getMethodName()+"test start");
		
	}

	
	public void onTestSuccess(ITestResult result) {
	test.log(Status.PASS,result.getMethod().getMethodName()+"test pass");
		
	}

	
	public void onTestFailure(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		Object obj = result.getInstance();
	WebDriver driver=null;
		try {
			 driver = (WebDriver)result.getTestClass().getRealClass().getSuperclass().getDeclaredField("driver").get(obj);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dst=new File("./screenshot/"+methodname+".PNG");
		//test.addScreenCaptureFromPath(dst.getAbsolutePath());
		try {
			Files.copy(src, dst);
		}catch(IOException e) {
			e.printStackTrace();
		}
		//ITestListener.super.onTestFailure(result);
	}

	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP,result.getMethod().getMethodName()+"test is skipped");
		test.log(Status.SKIP,result.getThrowable());
	}

	
	public void onStart(ITestContext context) {
 ExtentSparkReporter htmlReport = new ExtentSparkReporter(".\\ExtentReport\\report.html");
	htmlReport.config().setTheme(Theme.DARK);
	htmlReport.config().setDocumentTitle("ExtentReport");
	report=new ExtentReports();
	report.attachReporter(htmlReport);
	report.setSystemInfo("testurl", "http://localhost:8888");
	report.setSystemInfo("platform","Windows 11");
	report.setSystemInfo("Reporter name","jyoti");
	}

	
	public void onFinish(ITestContext context) {
		report.flush();
	
	}
	
}

	