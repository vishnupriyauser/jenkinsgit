package com.amazon.pageObjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.amazon.reusableComponents.Drivers;
import com.amazon.reusableComponents.Methods;
import com.amazon.uistore.LoginPageUI;

public class LoginPage extends Methods{

	Drivers d=new Drivers();
	WebDriver driver;
	
	public void loginpage(WebDriver driver) throws IOException
	{
		Methods.clicksign(LoginPageUI.clicksign,driver);
	}
	
	public void login(WebDriver driver,String name,String pass)
	{
		
		
		Methods.username(LoginPageUI.username, driver, name);
		
	}
	
	
}

