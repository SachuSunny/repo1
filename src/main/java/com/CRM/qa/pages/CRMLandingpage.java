package com.CRM.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.CRM.qa.base.Testbase;

public class CRMLandingpage extends Testbase {
	
	
	//objet repo and PF
	
	@FindBy(xpath ="//td[contains(text(),'User: Sachu Sunny')]")
	WebElement username_txt;
	
	@FindBy(xpath ="//a[contains(text(),'Contacts')]")
	WebElement contacts_link;
	
	@FindBy(xpath ="//a[contains(text(),'Deals')]")
	WebElement Deals_link;
	
	@FindBy(xpath ="//a[contains(text(),'Tasks')]")
	WebElement Tasks_link;
	
	@FindBy(xpath ="//a[@title='New Contact']")
	WebElement Newcontact_link;
	
	//PF initilization
	
	public CRMLandingpage() {
		
		PageFactory.initElements(wd, this);
	}
	
	
	//Actions and features
	
	public String verifylandingpagetitle()
	{
		return wd.getTitle();
	}
	
	public boolean verifyusername()
	{
		return username_txt.isDisplayed();
	}
	
	public boolean verifycontacttab()
	{
		return contacts_link.isDisplayed();
			}
	
	public boolean verifydealstab()
	{
		return Deals_link.isDisplayed();

	}
	
	public boolean verifytasktab()
	{
		return Tasks_link.isDisplayed();

	}
	
	public CRMContact clickonconatcttab()
	{
		contacts_link.click();
		return new CRMContact();
		
	}

	
	public CRMDeals clickondealstab()
	{
		Deals_link.click();
		return new CRMDeals();
		
	}
	
	
	public CRMTask clickontasktab()
	{
		Tasks_link.click();
		return new CRMTask();
		
	}
	
	public CRMContact clickonNewcontact()
	{
		Actions a=new Actions(wd);
		a.moveToElement(contacts_link).build().perform();
		a.moveToElement(Newcontact_link).click().build().perform();
		return new CRMContact();
	}
	
	
}


