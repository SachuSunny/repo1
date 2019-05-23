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
import org.testng.annotations.Test;

import com.CRM.qa.base.Testbase;
import com.CRM.qa.pages.CRMLandingpage;
import com.CRM.qa.pages.CRMLogin;
import com.CRM.qa.utils.Testutil;

public class CRMLoginTest extends Testbase {
	
	
	CRMLogin login;
	CRMLandingpage landing;
	
	public CRMLoginTest()
	{
		super();
	}
	
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		login=new CRMLogin();
	}
	
	@Test
	public void verifyCRMlogoTest()
	{
		AssertJUnit.assertTrue(login.verifyCRMlogo());
	}
	
	@Test
	public void verifloginpagetitleTest()
	{
		AssertJUnit.assertEquals(login.verifloginpagetitle(),Testutil.Login_title);

	}
	
	@Test
	public void userloginTest()
	{
		landing=login.userlogin();
	}
	
	@AfterMethod
	public void teardown()
	{
		wd.close();
	}
	

}
