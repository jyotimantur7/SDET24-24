package com.crm.comcast.OrganizationsTest;

import org.testng.annotations.Test;

import com.crm.comcast.OrganizationTestLib.CreateOrganization;
import com.crm.comcast.OrganizationTestLib.HomePage;
import com.crm.comcast.OrganizationTestLib.Information;
import com.crm.genericfile.BaseClassAnnotation;

public class CreateOrgName extends BaseClassAnnotation
{
	@Test(groups={"smokeTest","regressionTest"})
	public  void createOrg() throws Throwable 
	{
	int ranNum = jLib.getRandomNumber();
	String orgName = eLib.getData("Sheet1", 4, 2)+"_"+ranNum;
	String indus = eLib.getData("Sheet1", 4, 3);
	String type = eLib.getData("Sheet1", 4, 4);
	
HomePage hp=new HomePage(driver);
hp.getOrganizationLink().click();
CreateOrganization corg=new CreateOrganization(driver);
corg.getCreateorganization().click();
corg.getOrganizationname().sendKeys(orgName);
wLib.select(corg.getIndustryname(), indus);
wLib.select(corg.getType(), type);
corg.getSavebutton().click();
Information info=new Information(driver);
String text = info.getOganamevarify().getText().trim();
if(text.contains(orgName))
	
{
	System.out.println("organization name is varified");
}
String text1 = info.getIndustrynamevarify().getText().trim();
if(text1.equals(indus))
{
	System.out.println("industry name is varified");
}
/*String text2= info.getTypenamevarify().getText().trim();
if(text2.contains(type))
{
	System.out.println("type is varified");
}*/
	System.out.println("test case 3");
	
}
}
