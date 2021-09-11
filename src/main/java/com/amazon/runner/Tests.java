package com.amazon.runner;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.amazon.pageObjects.LoginPage;
import com.amazon.pageObjects.Search;
import com.amazon.reusableComponents.Drivers;
import com.amazon.utility.DataDriven;
import com.amazon.utility.PropertyFileReader;

public class Tests {

	Drivers d=new Drivers();
	WebDriver driver;
	
	@BeforeTest
	public void openbrowser() throws IOException
	{
		driver=d.initializedriver();
		//driver.get("https://www.amazon.com");		
	}
	
	
    @Test(dataProvider="getdata",priority=0)
	public void basenavigation(String username,String password) throws IOException
	{	
    	WebDriver driver =Drivers.initializedriver();
    	driver.get(PropertyFileReader.loadFile().getProperty("url"));
    	
	     LoginPage lp=new LoginPage();
	     
	     lp.loginpage(driver);
	     lp.login(driver,username,password);

	}

    
	@Test(dataProvider="getdata1")
	public void searchproduct(String name) throws IOException
	{
		//WebDriver driver =Drivers.initializedriver();
    	driver.get(PropertyFileReader.loadFile().getProperty("url"));
    	
		Search s=new Search();
		
	    s.loginpage(driver);
	    s.passproducts(driver, name);
	}
	
	@DataProvider
	public Object[][] getdata()
	{
		//array size from 0 but we have to give like below only while declaring array is size is 1
		Object[][] data=new Object[2][2];
		
		data[0][0]="9952180671";
		data[0][1]="vishnu";
		
		data[1][0]="priya@gmail.com";
		data[1][1]="vishnu";
		
		return data;
	}	
	
	@DataProvider
	public Object[][] getdata1()
	{
		
		Object[][] data=null;
		try
		{
			data=DataDriven.readExcel();
		}
		catch(Exception e)
		{
			System.out.println("cannot reach excel");
		}
		return data;
		
	}	
	
	@AfterTest
	public void closebrowser()
	{
		driver.quit();
		driver=null;//to avoid increase of memory while running
	}		
	
	
	public void getScreenshot(String name) throws IOException {
		// TODO Auto-generated method stub
		//File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//FilesUtils.copyFiles(src,new File("C:\\pics\\screenshot.png"));		
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("C:\\pics\\screenshot.png"));
	}
	
	
	
}
