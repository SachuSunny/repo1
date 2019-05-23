package com.CRM.qa.tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.CRM.qa.base.Testbase;
import com.CRM.qa.pages.CRMContact;
import com.CRM.qa.pages.CRMLandingpage;
import com.CRM.qa.pages.CRMLogin;
import com.CRM.qa.utils.Testutil;

public class CRMContactTest extends Testbase {
	
	
	CRMLogin login;
	CRMLandingpage landing;
	CRMContact contact;
	String Sheetname="Sheet1";
	String location="/Users/sachusunny/eclipse-workspace/CRMtest/src/main/java/com/CRM/qa/testdata/CRMtestdata.xlsx";
	
	
	public CRMContactTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		login=new CRMLogin();
		landing=login.userlogin();
		Testutil.switchtoframe();
		contact=landing.clickonconatcttab();
		
	}
	
	@Test
	public void verifycontacttablabelTest()
	{
		AssertJUnit.assertTrue(contact.verifycontacttab());
	}
	@Test(dependsOnMethods="verifycontacttablabelTest")
	public void clickoncheckboxTest()
	{
	
		contact.clickoncheckbox(Testutil.Contact_title);
		AssertJUnit.assertTrue(contact.checkboxverification(Testutil.Contact_title));
	}
	
	@DataProvider
	public Object[][] getCRMtestdata() throws InvalidFormatException, EncryptedDocumentException, IOException
	{
	
	Object data[][]=Testutil.gettestdata(Sheetname,location);
	return data;
	}
	
	@Test(dataProvider="getCRMtestdata")
	public void verifycreatenewcontact(String title,String fname,String lname,String company)
	{
		contact=landing.clickonNewcontact();
		contact.createnewcontact(title,fname,lname,company);
	}
	@Test(dependsOnMethods="verifycreatenewcontact")
	public void verify_checknewcontact()
	{
		AssertJUnit.assertTrue(contact.checkboxverification("keerthi"));
	}
	
	
	@AfterMethod
	public void teardown()
	{
		wd.close();
	}
}
