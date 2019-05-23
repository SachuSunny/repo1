package com.CRM.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.CRM.qa.base.Testbase;

public class Testutil extends Testbase {
	
	public static long PAGE_LOAD_TIMEOUT=300;
	public static long IMPLICIT_WAIT_TIMEOUT=60;
	public static String Login_title="CRMPRO - CRM software for customer relationship management, sales, and support.";
	public static String landing_title="CRMPRO";
	public static String Contact_title="Jesna Joseph";
	public static Workbook wk;
	public static Sheet sheet;
	
	
	
	public static void switchtoframe()
	{
		wd.switchTo().frame("mainpanel");
	}

	
	
	public static Object[][] gettestdata(String sheetname,String Testdata_path) throws InvalidFormatException, EncryptedDocumentException, IOException
	{
		FileInputStream file=null;
		try {
			file=new FileInputStream(Testdata_path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		wk=(XSSFWorkbook) WorkbookFactory.create(file);
		
		
		sheet=wk.getSheet(sheetname);
		System.out.println(sheet.getLastRowNum());
		System.out.println(sheet.getRow(0).getLastCellNum());
		Object[][]data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0;i<sheet.getLastRowNum();i++)
		{
			for(int j=0;j<sheet.getRow(0).getLastCellNum();j++)
			{
				
				data[i][j]=sheet.getRow(i+1).getCell(j).toString();
				
				
				
				
			}
		}
		return data;
	}
	
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) wd).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}

}
