package com.CRM.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.CRM.qa.utils.Testutil;
import com.CRM.qa.utils.WebEventListener;



public class Testbase {
	
	
	public static WebDriver wd;
	public static Properties pr;
	public static EventFiringWebDriver event;
	public static WebEventListener listner;
	
	
	public Testbase()
	{
		pr=new Properties();
		FileInputStream fr=null;
		try {
			fr = new FileInputStream("/Users/sachusunny/eclipse-workspace/CRMtest/src/main/java/com/CRM/qa/config/config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			pr.load(fr);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void initialization()
	{
		String browser=pr.getProperty("browser");
		if(browser.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","/Users/sachusunny/selenium/chromedriver 2");
			wd=new ChromeDriver();
		}
		if(browser.equals("FF"))
		{
			System.setProperty("webdriver.gecko.driver","/Users/sachusunny/selenium/geckodriver");
			wd=new FirefoxDriver();
		}
		
		/*event=new EventFiringWebDriver(wd);
		//To register Webeventlistner to Event firingwebriver
		
		listner=new WebEventListener();
		event.register(listner);
		wd=event; //assiging event driver to main driver*/
		
		
		wd.manage().window().maximize();
		wd.manage().deleteAllCookies();
		wd.manage().timeouts().pageLoadTimeout(Testutil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		wd.manage().timeouts().implicitlyWait(Testutil.IMPLICIT_WAIT_TIMEOUT, TimeUnit.SECONDS);
		wd.navigate().to(pr.getProperty("url"));
	}

}
