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
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.CRM.qa.base.Testbase;
import com.CRM.qa.pages.CRMContact;
import com.CRM.qa.pages.CRMDeals;
import com.CRM.qa.pages.CRMLandingpage;
import com.CRM.qa.pages.CRMLogin;
import com.CRM.qa.pages.CRMTask;
import com.CRM.qa.utils.Testutil;

public class CRMLandingpageTest extends Testbase{
	
	CRMLogin login;
	CRMLandingpage landing;
	CRMContact contact;
	CRMDeals deals;
	CRMTask task;
	
	
	public CRMLandingpageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		login =new CRMLogin();
		landing=login.userlogin();
		Testutil.switchtoframe();
	}

	
	@Test
	public void verifylandingpagetitleTest()
	{
		AssertJUnit.assertEquals(landing.verifylandingpagetitle(),Testutil.landing_title);
	}
	
	@Test
	public void verifyusernameTest()
	{
		AssertJUnit.assertTrue(landing.verifyusername());
	}
	
	@Test
	public void verifycontacttabTest()
	{
		AssertJUnit.assertTrue(landing.verifycontacttab());
	}
	
	
	@Test
	public void verifydealstabTest()
	{
		AssertJUnit.assertTrue(landing.verifydealstab());
	}
	
	
	@Test
	public void verifytasktabTest()
	{
		AssertJUnit.assertTrue(landing.verifytasktab());
	}
	
	
	@Test(dependsOnMethods="verifycontacttabTest")
	public void clickonconatcttabTest()
	{
		contact=landing.clickonconatcttab();
	}
	
	@Test(dependsOnMethods="verifydealstabTest")
	public void clickondealstabTest()
	{
		deals=landing.clickondealstab();
	}
	
	
	@Test(dependsOnMethods="verifytasktabTest")
	public void clickontasktabTest()
	{
		task=landing.clickontasktab();
	}
	
	@AfterMethod
	public void teardown()
	{
		wd.close();
	}
	
}
