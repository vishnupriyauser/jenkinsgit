package com.amazon.reusableComponents;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.amazon.utility.PropertyFileReader;

public class Drivers {
	
	public static WebDriver driver;//by declaring static each class uses respective driver
	private static Logger log=LogManager.getLogger( Drivers.class.getName()); 	
	
	public static WebDriver initializedriver() throws IOException
	{
		
		String bname=PropertyFileReader.loadFile().getProperty("browser");
		
		if(bname.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
			driver=new ChromeDriver();
			
			log.info("chrome driver invoked successfully");
		}
		else if(bname.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver","./drivers/geckodriver.exe");
			
		    driver=new FirefoxDriver();
		   log.info("firefox driver invoked successfully");
		}
		else
		{
			    System.setProperty("webdriver.edge.driver","./drivers/msedgedriver.exe");				
			    driver=new EdgeDriver();
			  log.info("edge driver invoked successfully");
		}	
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);	//implicit wait		
		return driver;	
	}
	
	
	public void getScreenshot(String name) throws IOException {
		// TODO Auto-generated method stub
		//File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//FilesUtils.copyFiles(src,new File("C:\\pics\\screenshot.png"));		
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("C:\\pics\\screenshot.png"));
	}
	
}
