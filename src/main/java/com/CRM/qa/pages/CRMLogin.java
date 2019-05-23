package com.CRM.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.CRM.qa.base.Testbase;

public class CRMLogin extends Testbase{
	
	
	//object repo and page factory
	
	@FindBy (name ="username")
	WebElement Username_txtbx;
	
	@FindBy (name ="password")
	WebElement Password_txtbx;
	
	
	@FindBy (xpath ="//input[@type='submit']")
	WebElement submit_button;
	
	@FindBy (xpath ="//a[@class='navbar-brand']/img")
	WebElement logo_img;
	
	//PF initilization
	
	public CRMLogin()
	{
		PageFactory.initElements(wd, this);
	}

	//Actions and features
	
	public boolean verifyCRMlogo()
	{
		return logo_img.isDisplayed();
	}
	
	public String verifloginpagetitle()
	{
		return wd.getTitle();
	}
	public CRMLandingpage userlogin()
	{
		Username_txtbx.sendKeys(pr.getProperty("username"));
		Password_txtbx.sendKeys(pr.getProperty("pwd"));
		submit_button.submit();
		return new CRMLandingpage();
	}
	
}
