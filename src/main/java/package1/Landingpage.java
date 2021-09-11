package package1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Landingpage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		  System.setProperty("webdriver.chrome.driver",".\\chromedriver.exe");
	      WebDriver driver=new ChromeDriver();
		  driver.get("https://www.homedepot.com/");
		  
		  driver.findElement(By.id("headerSearch")).click();//click search
		  driver.findElement(By.id("headerSearch")).sendKeys("refrigrator");//sendkeys
		  driver.findElement(By.id("headerSearchButton")).click();//click go
		  driver.findElement(By.cssSelector("input(type='checkbox']")).click();//click checkbox
		  driver.findElement(By.cssSelector("input(type='checkbox']")).click();
		  //compare
	}

}
