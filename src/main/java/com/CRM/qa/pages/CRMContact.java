package com.CRM.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.CRM.qa.base.Testbase;

public class CRMContact extends Testbase{
	
	//Object repo or Page factory
	
	@FindBy (xpath="//td[contains(text(),'Contacts')]")
	@CacheLookup
	WebElement contact_section;
	
	@FindBy (id="first_name")
	WebElement contact_firstname;
	
	@FindBy (id="surname")
	WebElement contact_lastname;
	
	@FindBy (xpath="//input[@name='client_lookup']")
	WebElement contact_company;
	
	@FindBy (name="title")
	WebElement contact_title;
	
	@FindBy (xpath="//input[@value='Save and Create Another (same company)']//preceding-sibling::input[@value='Save']")
	WebElement conatct_save;
	
	@FindBy (xpath="//form[@id='vContactsForm']/table")
	WebElement contact_form;
	
	
	//initilization of PF
	
	public CRMContact()
	{
		PageFactory.initElements(wd, this);
	}
	
	//actions and features
	
	public boolean verifycontacttab()
	{
		return contact_section.isDisplayed();
	}
	
	public boolean checkboxverification(String name)
	{
		List<WebElement>li=contact_form.findElements(By.tagName("a"));
		for(int i=0;i<li.size();i++)
		{
			if((li.get(i).getText()).contains(name))
			{
				return true;
			}
		}
		return false;
		
	}
	
	public void clickoncheckbox(String name)
	{
		wd.findElement(By.xpath("//a[contains(text(),'"+name+"')]//..//parent::tr//input")).click();
	}
	
	public void createnewcontact(String title,String fname,String lname,String company)
	{
		Select s=new Select(contact_title);
		s.selectByVisibleText(title);
		contact_firstname.sendKeys(fname);
		contact_lastname.sendKeys(lname);
		contact_company.sendKeys(company);
		conatct_save.click();
		
	}
	
	public boolean checknewcontact(String fname)
	{
		return wd.findElement(By.xpath("//td[contains(text(),'"+fname+"') and @class='tabs_header']")).isDisplayed();
	}	
	
	public void enter_company()
	{
		contact_company.sendKeys("Test");		
	}
}
