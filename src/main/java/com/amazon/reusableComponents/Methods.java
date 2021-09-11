package com.amazon.reusableComponents;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import com.amazon.utility.PropertyFileReader;

public class Methods {

	public static void loadURL(WebDriver driver) throws IOException {
		driver.get(PropertyFileReader.loadFile().getProperty("url"));
		timelapse(driver);
	}

	public static void timelapse(WebDriver driver) throws NumberFormatException, IOException {
		int wait = Integer.parseInt(PropertyFileReader.loadFile().getProperty("implicitWait"));
		driver.manage().timeouts().implicitlyWait(wait, TimeUnit.SECONDS);
	}

	
	
	public static void clicksign(By selector,WebDriver driver)
    {
		try
		{
    	    driver.findElement(selector).click();
		}
		catch(Exception e)
		{
			System.out.println("cannot able to clicksign");
			
		}
		
    }
	
	public static void username(By selector,WebDriver driver,String keys)
    {
    	try
		{
    		 driver.findElement(selector).click();
    		 driver.findElement(selector).sendKeys(keys);
		}
		catch(Exception e)
		{
			System.out.println("cannot able to enter username");
			
		}
    }
	
	
	 public static void con(By selector,WebDriver driver)
     {
		 try
		 {
			 driver.findElement(selector).click();
		 }
		 catch(Exception e)
		 {
			 System.out.println("cannot able to click continue");
			
		 }
		
		 
     }
     
	 public static void password(By selector,WebDriver driver,String keys)
	    {
	    	try
			{
	    		 driver.findElement(selector).click();
	    		 driver.findElement(selector).sendKeys(keys);
			}
			catch(Exception e)
			{
				System.out.println("cannot able to enter password");
				
			}
	    }
     
     public static void submit(By selector,WebDriver driver)
     {
    	 try
    	 {    
    		 driver.findElement(selector).click();
    	 }
     	
     	catch(Exception e)
		 {
     		
     		System.out.println("cannot able to click submit");
     		
		 }
     }
     
     public static void clicksearch(By selector,WebDriver driver)
     {
    	 try
    	 { 
    		 driver.findElement(selector).click();
    	 }
     	
     	catch(Exception e)
		 { 		
     		System.out.println("cannot able to click search");
   
     		
		 }
     }
     public static void passproduct(By selector,WebDriver driver,String name)
     {
    	 try
    	 { 
    		 driver.findElement(selector).sendKeys(name);
    		 driver.findElement(selector).sendKeys(Keys.ENTER);
    		 driver.findElement(selector).clear();
    	 }
     	
     	catch(Exception e)
		 { 		
     		System.out.println("cannot able to click search");
   
     		
		 }
     }
}
