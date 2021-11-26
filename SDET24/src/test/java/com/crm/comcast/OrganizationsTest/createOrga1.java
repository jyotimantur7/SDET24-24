package com.crm.comcast.OrganizationsTest;

import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.crm.genericfile.BaseClassAnnotation;

public class createOrga1 extends BaseClassAnnotation {
@Test(retryAnalyzer=com.crm.genericfile.ReTryAnalyzer.class)
public void createOrga()
{
	Reporter.log("this is create org",true);
	Assert.fail();
}
}
